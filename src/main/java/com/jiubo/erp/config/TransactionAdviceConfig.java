package com.jiubo.erp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

/**sqlserver好像不支持设置只读故设置只读不起作用
 * @desc:全局事务管理器 通过AOP切面设置全局事务，拦截service包下面所有方法
 * AOP术语：通知（Advice）、连接点（Joinpoint）、切入点（Pointcut)、切面（Aspect）、目标(Target)、代理(Proxy)、织入（Weaving）
 * @date: 2019-07-31 11:11
 * @author: dx
 * @version: 1.0
 */
//@Aspect
//@Configuration
public class TransactionAdviceConfig {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    javax.sql.DataSource dataSource;

    private Logger logger = LoggerFactory.getLogger(TransactionAdviceConfig.class);

    //定义切点变量：拦截xx.xxx.xxxxx.****.***.service包下所有类的所有方法,返回值类型任意的方法
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.jiubo.erp.*.service.impl.*.*(..))";

    private static final int TX_METHOD_TIMEOUT = 5;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {
        DefaultTransactionAttribute txAttr_REQUIRED = new DefaultTransactionAttribute();
        txAttr_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttr_REQUIRED.rollbackOn(new Throwable());
        txAttr_REQUIRED.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);

        DefaultTransactionAttribute txAttr_REQUIRED_READONLY = new DefaultTransactionAttribute();
        txAttr_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttr_REQUIRED_READONLY.setReadOnly(true);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*", txAttr_REQUIRED);
        source.addTransactionalMethod("save*", txAttr_REQUIRED);
        source.addTransactionalMethod("insert*", txAttr_REQUIRED);
        source.addTransactionalMethod("delete*", txAttr_REQUIRED);
        source.addTransactionalMethod("update*", txAttr_REQUIRED);
        source.addTransactionalMethod("exec*", txAttr_REQUIRED);
        source.addTransactionalMethod("set*", txAttr_REQUIRED);
        source.addTransactionalMethod("get*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("query*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("find*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("list*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("count*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("is*", txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("*", txAttr_REQUIRED_READONLY);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
         /* 声明切点的面
         * 切面（Aspect）：切面就是通知和切入点的结合。通知和切入点共同定义了关于切面的全部内容——它的功能、在何时和何地完成其功能。*/
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        //声明和设置需要拦截的方法,用切点语言描写
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        //设置切面=切点pointcut+通知TxAdvice
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}

//    @Bean
//    public TransactionInterceptor txAdvice() {
//        jdbcTemplate.setDataSource(dataSource);
//        DataSourceTransactionManager dstm = new DataSourceTransactionManager(dataSource);
//        System.out.println("################################## txAdvice run ##################################");
//        System.out.println("################################## dataSource  ##################################"+ dataSource);
//        System.out.println("################################## dstm  ##################################"+dstm);

//        DefaultTransactionAttribute txAttr_REQUIRED = new DefaultTransactionAttribute();
//        txAttr_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//
//        DefaultTransactionAttribute txAttr_REQUIRED_READONLY = new DefaultTransactionAttribute();
//        txAttr_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        txAttr_REQUIRED_READONLY.setReadOnly(true);

//事务管理规则，声明具备事务管理的方法名
//        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
//        source.addTransactionalMethod("save*", txAttr_REQUIRED);
//        source.addTransactionalMethod("delete*", txAttr_REQUIRED);
//        source.addTransactionalMethod("update*", txAttr_REQUIRED_READONLY);
////        source.addTransactionalMethod("update*", txAttr_REQUIRED);
//        source.addTransactionalMethod("exec*", txAttr_REQUIRED);
//        source.addTransactionalMethod("set*", txAttr_REQUIRED);
//        source.addTransactionalMethod("get*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("query*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("find*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("list*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("count*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("is*", txAttr_REQUIRED_READONLY);
//        source.addTransactionalMethod("*",txAttr_REQUIRED_READONLY);
//        return new TransactionInterceptor(transactionManager, source);

//--------------------------------------------------------------------------------------------------------------------
//事务管理规则，声明具备事务管理的方法名
//        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
//        只读事物、不做更新删除等
//        当前存在事务就用当前的事务，当前不存在事务就创建一个新的事务
//        RuleBasedTransactionAttribute readOnlyRule = new RuleBasedTransactionAttribute();
//        设置当前事务是否为只读事务，true为只读
//        readOnlyRule.setReadOnly(true);
//         transactiondefinition 定义事务的隔离级别；
//     * PROPAGATION_NOT_SUPPORTED事务传播级别5，以非事务运行，如果当前存在事务，则把当前事务挂起
//        readOnlyRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
//
//        RuleBasedTransactionAttribute requireRule = new RuleBasedTransactionAttribute();
//        抛出异常后执行切点回滚
//        requireRule.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
//        PROPAGATION_REQUIRED:事务隔离性为1，若当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
//        requireRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        设置事务失效时间，如果超过5秒，则回滚事务
//        requireRule.setTimeout(TX_METHOD_TIMEOUT);
//        Map<String, TransactionAttribute> txMap = new HashMap<>();
//
//        txMap.put("add*", requireRule);
//        txMap.put("save*", requireRule);
//        txMap.put("insert*", requireRule);
//        txMap.put("update*", readOnlyRule);
//        txMap.put("delete*", requireRule);
//        txMap.put("remove*", requireRule);
//
//        txMap.put("get*", readOnlyRule);
//        txMap.put("query*", readOnlyRule);
//        txMap.put("find*", readOnlyRule);
//        txMap.put("select*", readOnlyRule);
//        source.setNameMap(txMap);
//        return new TransactionInterceptor(transactionManager, source);

//--------------------------------------------------------------------------------------------------------------------
//        TransactionInterceptor tsi = new TransactionInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("get*", "PROPAGATION_SUPPORTS");
//        properties.setProperty("select*", "PROPAGATION_SUPPORTS");
//        properties.setProperty("load*", "PROPAGATION_SUPPORTS");
//        properties.setProperty("query*", "PROPAGATION_SUPPORTS");
//        properties.setProperty("list*", "PROPAGATION_SUPPORTS");
//        properties.setProperty("add*", "PROPAGATION_REQUIRED");
//        properties.setProperty("insert*", "PROPAGATION_REQUIRED");
//        properties.setProperty("save*", "PROPAGATION_REQUIRED");
//        properties.setProperty("update*", "readOnly");
//        properties.setProperty("modify*", "PROPAGATION_REQUIRED");
//        properties.setProperty("do*", "PROPAGATION_REQUIRED");
//        properties.setProperty("del*", "PROPAGATION_REQUIRED");
//        properties.setProperty("remove*", "PROPAGATION_REQUIRED");
//        properties.setProperty("process*", "PROPAGATION_REQUIRED");
//        properties.setProperty("create*", "PROPAGATION_REQUIRED");
//        properties.setProperty("valid*", "PROPAGATION_REQUIRED");
//        properties.setProperty("do*", "PROPAGATION_REQUIRED");
//        properties.setProperty("write*", "PROPAGATION_REQUIRED");
//        properties.setProperty("cancel*", "PROPAGATION_REQUIRED");
//        properties.setProperty("*", "readOnly");
//        tsi.setTransactionAttributes(properties);
//        tsi.setTransactionManager(transactionManager);
//        return tsi;
//    }
//--------------------------------------------------------------------------------------------------------------------
//当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务 {@link org.springframework.transaction.annotation.Propagation#REQUIRED}
//    private RuleBasedTransactionAttribute requiredTransactionRule() {
//        RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
//        //添加对所有EXCEPTON异常进行事务回滚
//        required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
//        //PROPAGATION_REQUIRED:事务隔离性为1，若当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
//        required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        //设置事务失效时间，如果超过5秒，则回滚事务
//        required.setTimeout(TransactionDefinition.TIMEOUT_DEFAULT);
//        return required;
//    }

//--------------------------------------------------------------------------------------------------------------------
/*只读事务 {@link org.springframework.transaction.annotation.Propagation#NOT_SUPPORTED}*/
//    private RuleBasedTransactionAttribute readOnlyTransactionRule() {
//        RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
//        //设置当前事务是否为只读事务，true为只读
//        readOnly.setReadOnly(true);
//        /*transactiondefinition 定义事务的隔离级别；
//        PROPAGATION_NOT_SUPPORTED事务传播级别5，以非事务运行，如果当前存在事务，则把当前事务挂起*/
//        readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
//        return readOnly;
//    }


