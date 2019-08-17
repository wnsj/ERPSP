package com.jiubo.erp.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @desc:
 * @date: 2019-08-14 17:21
 * @author: dx
 * @version: 1.0
 */
@Configuration
//开启定时任务
@EnableScheduling
//开启异步并行定时任务
@EnableAsync
public class ScheduleConfig implements SchedulingConfigurer, AsyncConfigurer {

    public static Logger log = LoggerFactory.getLogger(ScheduleConfig.class);

    private ThreadPoolTaskScheduler tpts = null;

    private static Map<String, ScheduledFuture<?>> scheduledFutureMap = new ConcurrentHashMap<String, ScheduledFuture<?>>();

    //配置任务调度线程池
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setTaskScheduler(tpts);
        //动态任务优点是灵活可拓展，缺点是不能与异步调用相结合，例如@Async注解
        //动态添加任务（方式1）
        //scheduledTaskRegistrar.addCronTask(new Runnable() {}, new CronTrigger("0/3 * * * * ?"));
        //动态添加任务（方式2）
        //scheduledTaskRegistrar.getScheduler().schedule(new Runnable() {}, new CronTrigger("0/3 * * * * ?"));
        //动态添加任务（方式3）
        String cls = "com.jiubo.erp.webSocket.service.CustomWebSocketService";
        String method = "checkState";
        String taskExpr = "0/15 * * * * ?";
        Map<String, Object> params = new HashMap<String, Object>();
        //addCornTaskInstance(cls,method,taskExpr, params);
    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        tpts = new ThreadPoolTaskScheduler();
        tpts.setPoolSize(10);// 配置线程池大小，根据任务数量定制
        tpts.setThreadNamePrefix("spring-task-scheduler-thread-");// 线程名称前缀
        tpts.setAwaitTerminationSeconds(60);// 线程池关闭前最大等待时间，确保最后一定关闭
        tpts.setWaitForTasksToCompleteOnShutdown(true);// 线程池关闭时等待所有任务完成
        tpts.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());// 任务丢弃策略
        return tpts;
    }

    //自定义异步调用线程池
    @Override
    public Executor getAsyncExecutor() {
        return taskExecutor();
    }

    @Bean
    public Executor taskExecutor() {
        //线程池配置
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);// 配置核心线程数
        executor.setMaxPoolSize(50);// 配置最大线程数
        executor.setQueueCapacity(100);// 配置缓存队列大小
        executor.setKeepAliveSeconds(15);// 空闲线程存活时间
        executor.setThreadNamePrefix("spring-task-executor-thread-");
        // 线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在execute方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());// AbortPolicy()
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是被没有完成的任务阻塞
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SpringAsyncExceptionHandler();
    }

    class SpringAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
            System.out.println("Exception occurs in async method" + arg0);
        }
    }

    //创建周期执行CornTask对象
    private void addCornTaskInstance(final String cls, final String method, final String taskExpr, final Map<String, Object> params) {
        ScheduledFuture<?> scheduledFuture = tpts.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Class clazz = Class.forName(cls);
                    Object object = clazz.newInstance();
                    Method m = clazz.getDeclaredMethod(method, Map.class);
                    m.invoke(object, params);
                } catch (Exception e) {
                    log.error("系统错误", e);
                }
            }
        }, new CronTrigger(taskExpr));
        scheduledFutureMap.put("1", scheduledFuture);
    }
}

//--------------------------------------------------------------------------------------------------------------
/*@Configuration
@EnableAsync
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer, AsyncConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskScheduler());
    }

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);// 配置线程池大小，根据任务数量定制
        taskScheduler.setThreadNamePrefix("spring-task-scheduler-thread-");// 线程名称前缀
        taskScheduler.setAwaitTerminationSeconds(60);// 线程池关闭前最大等待时间，确保最后一定关闭
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);// 线程池关闭时等待所有任务完成
        taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());// 任务丢弃策略
        return taskScheduler;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);// 配置核心线程数
        executor.setMaxPoolSize(50);// 配置最大线程数
        executor.setQueueCapacity(100);// 配置缓存队列大小
        executor.setKeepAliveSeconds(15);// 空闲线程存活时间
        executor.setThreadNamePrefix("spring-task-executor-thread-");
        // 线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在execute方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());// AbortPolicy()
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是被没有完成的任务阻塞
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }

    *//**
 * 处理异步方法的异常
 *//*
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SpringAsyncExceptionHandler();
    }

    class SpringAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
            System.out.println("Exception occurs in async method" + arg0);
        }
    }
}*/