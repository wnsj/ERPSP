package com.jiubo.erp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiubo.erp.wzbg.bean.DimissionApplyBean;
import com.jiubo.erp.wzbg.dao.DimissionApplyDao;
import com.jiubo.erp.wzbg.service.DimissionApplyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ErpApplicationTests {

    @Autowired
    private DimissionApplyDao dimissionApplyDao;

    @Autowired
    private DimissionApplyService dimissionApplyService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
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
//        IPage<DimissionApplyBean> dimissionApplyBeanIPage = dimissionApplyDao.selectPage(page, null);
        //IPage<DimissionApplyBean> dimissionApplyBeanIPage =dimissionApplyDao.queryDimissionApplyByPage(page);
        //System.out.println(JSON.toJSONString(dimissionApplyDao.queryDimissionApplyByPage(page)));
//		DimissionApplyBean bean = new DimissionApplyBean();
//		bean.setId("7");
//		bean.setDaResaon("456");
//		dimissionApplyDao.updateById(bean);
    }

    @Test
    public void test2() {
        //dimissionApplyService.queryDimissionApply(null);
        String Account_Name = "";
        //部门
        int cmb_Department = 0;
        //职位
        int cmb_Position = -1;
        //离职类型
        String cmb_type = "";
        //日期类型
        int cmb_type_time = 0;
        //申请人姓名
        String txt_name = "";
        //意见
        String cmb_advice = "";

        String start_time = "";
        String end_time = "";

        StringBuilder sql = new StringBuilder();
        sql.append("    SELECT DA.ID as id  ,AD1.Account_Name as name1,TD.Name as tname,JobNum, ");
        sql.append("    PD.Position_Name as pname,DA_Entry_Time  ,");
        sql.append("    DA_Apply_Time ,DA_Leave_Time ,DA_Resaon ,DA_Minister_Remark, ");
        sql.append("    DA_Department_ID, ");
        sql.append("    AD2.Account_Name as name2, ");
        sql.append("    CASE WHEN DA_Charge_Advice IS null OR DA_Charge_Advice = 1 THEN '未审核' ");
        sql.append("    WHEN DA_Charge_Advice = 2 THEN '同意' ");
        sql.append("    WHEN DA_Charge_Advice = 3 THEN '不同意' ");
        sql.append("    END AS DA_Charge_Advice, ");

        sql.append("    AD3.Account_Name as name3, ");
        sql.append("    CASE WHEN DA_Minister_Advice IS null  OR DA_Minister_Advice = 1 THEN '未审核' ");
        sql.append("    WHEN DA_Minister_Advice = 2 THEN '同意' ");
        sql.append("    WHEN DA_Minister_Advice = 3 THEN '不同意' ");
        sql.append("    END AS DA_Minister_Advice , ");

        sql.append("    AD4.Account_Name as name4, ");
        sql.append("    CASE WHEN DA_Connect_Advice  IS null OR DA_Connect_Advice = 1 THEN '未审核' ");
        sql.append("    WHEN DA_Connect_Advice = 2 THEN '同意' ");
        sql.append("    WHEN DA_Connect_Advice = 3 THEN '不同意' ");
        sql.append("    END AS DA_Connect_Advice, ");

        sql.append("    AD5.Account_Name as name5,  ");
        sql.append("    CASE WHEN DA_Personnel_Office_Advice  IS null OR DA_Personnel_Office_Advice = 1 THEN '未审核' ");
        sql.append("    WHEN DA_Personnel_Office_Advice = 2 THEN '同意' ");
        sql.append("    WHEN DA_Personnel_Office_Advice = 3 THEN '不同意' ");
        sql.append("    END AS DA_Personnel_Office_Advice, ");

        sql.append("    CASE WHEN DA_Type = 1 THEN '辞职' ");
        sql.append("    WHEN DA_Type = 2 THEN '辞退' ");
        sql.append("    WHEN DA_Type = 3 THEN '其他' ");
        sql.append("    END AS DA_Type ");

        sql.append("    FROM  Dimission_Apply DA ");
        sql.append("    LEFT JOIN Account_Data AD1 ON DA.DA_ID = AD1.Account_ID  ");
        sql.append("    LEFT JOIN Account_Data AD2 ON DA.DA_Charge_ID = AD2.Account_ID  ");
        sql.append("    LEFT JOIN Account_Data AD3 ON DA.DA_Minister_ID = AD3.Account_ID  ");
        sql.append("    LEFT JOIN Account_Data AD4 ON DA.DA_Connect_ID = AD4.Account_ID  ");
        sql.append("    LEFT JOIN Account_Data AD5 ON DA.DA_Personnel_Office_ID = AD5.Account_ID  ");
        sql.append("    LEFT JOIN T_Department TD ON DA.DA_Department_ID = TD.ID  ");
        sql.append("    LEFT JOIN Position_Data PD ON DA.DA_Position_ID = PD.Position_ID  ");
        sql.append("    LEFT JOIN T_Employee_Basic TB ON DA.DA_ID = TB.Account  ");
        sql.append("    WHERE 1 = 1");
        if (false) {
            sql.append("    and (AD1.Account_Name = '" + Account_Name + "' ");
            sql.append("      or AD2.Account_Name = '" + Account_Name + "' ");
            sql.append("      or AD3.Account_Name = '" + Account_Name + "' ");
            sql.append("      or AD4.Account_Name = '" + Account_Name + "' ");
            sql.append("      or AD5.Account_Name = '" + Account_Name + "') ");
        }
        if (cmb_Department != 0) {
            sql.append("    AND DA_Department_ID = '" + cmb_Department + "' ");
        }
        if (cmb_Position != -1) {
            sql.append("   AND PD.Position_ID = '" + cmb_Position + "' ");
        }
        if (cmb_type == "辞职") {
            sql.append("    AND DA.DA_Type = 1 ");
        } else if (cmb_type == "辞退") {
            sql.append("    AND DA.DA_Type = 2 ");
        } else if (cmb_type == "其他") {
            sql.append("    AND DA.DA_Type = 3 ");
        }
        if (cmb_type_time == 1) {
            sql.append("    and DA_Entry_Time >= '" + start_time + "' ");
            sql.append("    and DA_Entry_Time <= '" + end_time + "' ");
        } else if (cmb_type_time == 2) {
            sql.append("    and DA_Apply_Time >= '" + start_time + "' ");
            sql.append("    and DA_Apply_Time <= '" + end_time + "' ");
        } else if (cmb_type_time == 3) {
            sql.append("    and DA_Leave_Time >= '" + start_time + "' ");
            sql.append("    and DA_Leave_Time <= '" + end_time + "' ");
        }
        if (txt_name != "") {
            sql.append("    and AD1.Account_Name like '" + txt_name + "%'");
        }
        if (cmb_advice == "未审核") {
            sql.append("    and (DA_Charge_Advice IS null OR DA_Charge_Advice = 1 ");
            sql.append("    or DA_Minister_Advice IS null  OR DA_Minister_Advice = 1 ");
            sql.append("    or DA_Connect_Advice  IS null OR DA_Connect_Advice = 1 ");
            sql.append("    or DA_Personnel_Office_Advice  IS null OR DA_Personnel_Office_Advice = 1) ");
        } else if (cmb_advice == "同意") {
            sql.append("    and (DA_Charge_Advice = 2 ");
            sql.append("    or DA_Minister_Advice = 2 ");
            sql.append("    or DA_Connect_Advice = 2 ");
            sql.append("    or DA_Personnel_Office_Advice = 2) ");
        } else if (cmb_advice == "不同意") {
            sql.append("    and (DA_Charge_Advice = 3 ");
            sql.append("    or DA_Minister_Advice = 3 ");
            sql.append("    or DA_Connect_Advice = 3 ");
            sql.append("    or DA_Personnel_Office_Advice = 3) ");
        }

        System.out.println(sql.toString());


    }

    @Test
    public void test3() {
        String Department_ID = "##";
        String Position_ID = "##";
        String Other_Position_ID = "##";
        StringBuilder sql = new StringBuilder();
//        sql.append("    SELECT Emp_name, Account_ID, Position_Name, Name, PositionType_Name ");
//        sql.append("    FROM V_AccountData ");
//        sql.append("    LEFT JOIN Position_Data ");
//        sql.append("    ON Position_Data.Position_ID = V_AccountData.Position_ID ");
//        sql.append("    LEFT ");
//        sql.append("    JOIN T_Department ");
//        sql.append("    ON T_Department.ID = V_AccountData.Department_ID ");
//        sql.append("    LEFT ");
//        sql.append("    JOIN Position_Type ");
//        sql.append("    ON Position_Data.PositionType_ID = Position_Type.PositionType_ID ");
//        sql.append("    WHERE Account_State = '在用' AND Position_Type.PositionType_ID = 6  ");
//        sql.append("   AND Department_ID = 39 ");

//        sql.append("    SELECT Emp_name,V.Account_ID,Position_Name,Name ");
//        sql.append("    FROM V_AccountData V ");
//        sql.append("    LEFT JOIN Position_Data PD ");
//        sql.append("    ON PD.Position_ID = V.Position_ID ");
//        sql.append("    LEFT JOIN T_Department TD ");
//        sql.append("    ON TD.ID = V.Department_ID ");
//        sql.append("    LEFT JOIN Account_Rule_Data ARD ");
//        sql.append("    ON V.Account_ID  = ARD.Account_ID ");
//        sql.append("    WHERE Account_State = '在用' AND ARD.Rule_ID = 76 ");


//        sql.append("    SELECT Emp_name, Account_ID, Position_Name, Name, PositionType_Name ");
//        sql.append("    FROM V_AccountData ");
//        sql.append("    LEFT JOIN Position_Data ");
//        sql.append("    ON Position_Data.Position_ID = V_AccountData.Position_ID ");
//        sql.append("    LEFT ");
//        sql.append("    JOIN T_Department ");
//        sql.append("    ON T_Department.ID = V_AccountData.Department_ID ");
//        sql.append("    LEFT ");
//        sql.append("    JOIN Position_Type ");
//        sql.append("    ON Position_Data.PositionType_ID = Position_Type.PositionType_ID ");
//        sql.append("    WHERE Account_State = '在用' AND Position_Type.PositionType_ID = 6  ");
//        sql.append("   AND Department_ID = 39 ");

//        sql.append("    SELECT Emp_name,Account_ID,Position_Name,Name,PositionType_Name ");
//        sql.append("    FROM V_AccountData ");
//        sql.append("    LEFT JOIN Position_Data ");
//        sql.append("    ON Position_Data.Position_ID = V_AccountData.Position_ID ");
//        sql.append("    LEFT ");
//        sql.append("    JOIN T_Department ");
//        sql.append("    ON T_Department.ID = V_AccountData.Department_ID ");
//        sql.append("    LEFT ");
//        sql.append("    JOIN Position_Type ");
//        sql.append("    ON Position_Data.PositionType_ID = Position_Type.PositionType_ID ");
//        sql.append("    WHERE Account_State = '在用' AND Department_ID = 50 ");

//        sql.append("    SELECT G.ID AS id ");
//        sql.append("    ,G.Go_Out_Apply_Time AS apply_time ");
//        sql.append("    ,T.Name AS name ");
//        sql.append("    ,Go_Out_Name ");
//        sql.append("    ,A2.Account_Name AS a2name ");
//        sql.append("    ,G.Go_Out_Address AS address ");
//        sql.append("    ,G.Go_Out_Region AS region ");
//        sql.append("    ,G.Go_Out_Go_Time AS gotime ");
//        sql.append("    ,A3.Account_Name AS a3name ");
//        sql.append("    ,Go_Out_Come_Time ");
//        sql.append("    ,CASE WHEN Go_Out_OtherType = 1 THEN '班中外出' ");
//        sql.append("    WHEN Go_Out_OtherType = 2 THEN '班前外出' ");
//        sql.append("    END AS Go_Out_OtherType ");
//
//        sql.append("    ,CASE WHEN Go_Out_Type = 1 THEN '是' ");
//        sql.append("    WHEN Go_Out_Type = 2 THEN '否' ");
//        sql.append("    END AS Go_Out_Type ");
//
//        sql.append("    ,CASE WHEN Go_Out_Delete IS NULL THEN '点击取消' ");
//        sql.append("    WHEN Go_Out_Delete = 1 THEN '已取消' ");
//        sql.append("    END AS Go_Out_Delete ");
//
//        sql.append("    FROM Go_Out_Register G ");
//        sql.append("    LEFT JOIN Account_Data A2 ON A2.Account_ID = G.Go_Out_Apply_ID  ");
//        sql.append("    LEFT JOIN T_Department T ON T.ID = G.Go_Out_Department_ID  ");
//        sql.append("    LEFT JOIN Account_Data A3 ON A3.Account_ID = G.Go_Out_Tongzhi_ID ");

        sql.append("    SELECT Account_Name, Account_ID ");
        sql.append("    FROM V_AccountData ");
        sql.append("    LEFT JOIN Position_Data");
        sql.append("    ON V_AccountData .Position_ID = Position_Data .Position_ID ");
        sql.append("    WHERE Position_Data.Position_Name = '副总经理' ");
        sql.append("    AND state = 1 ");
        System.out.println(sql.toString());
    }

    @Test
    public void test4() throws UnknownHostException {
        //publishEvent.send();
        ArrayList<Integer> objects = new ArrayList<Integer>();
        objects.add(70);
        int i = objects.indexOf(700);
        System.out.println("i:" + i);

        IdentityHashMap<String, Object> identityMap = new IdentityHashMap<>();
        identityMap.put("1044", new String("1111"));
        identityMap.put("1044", "2222");
        System.out.println(identityMap.get("1044"));


        String ip = InetAddress.getLocalHost().getHostAddress();//获得本机IP
        String relativelyPath = System.getProperty("user.dir");
        System.out.println("ip:" + ip);
        System.out.println("relativelyPath:" + relativelyPath);
    }
}
