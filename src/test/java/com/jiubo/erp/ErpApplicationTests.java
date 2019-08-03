package com.jiubo.erp;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.jiubo.erp.wzbg.dao.DimissionApplyDao;
import com.jiubo.erp.wzbg.service.DimissionApplyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErpApplicationTests {

	@Autowired
	private DimissionApplyDao dimissionApplyDao;

	@Autowired
	private DimissionApplyService dimissionApplyService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		//查询所有数据
//		List<DimissionApplyBean> dimissionApplyBeans = dimissionApplyDao.selectList(null);
//		dimissionApplyBeans.forEach(System.out::println);
		//断言
		//Assert.assertEquals(5, dimissionApplyBeans.size());

		//根据id查询
//		DimissionApplyBean dimissionApplyBean = dimissionApplyDao.selectById(7);
//		System.out.println(dimissionApplyBean);

		//分页查询
		Page<DimissionApplyBean> page = new Page<DimissionApplyBean>();
		page.setCurrent(0);
		page.setSize(2);
		//IPage<DimissionApplyBean> dimissionApplyBeanIPage = dimissionApplyDao.selectPage(page, null);
		//IPage<DimissionApplyBean> dimissionApplyBeanIPage =dimissionApplyDao.queryDimissionApplyByPage(page);
		//System.out.println(JSON.toJSONString(dimissionApplyDao.queryDimissionApplyByPage(page)));
	}

	@Test
	public void test2(){
	}
}
