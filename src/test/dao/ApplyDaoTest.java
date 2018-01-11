package test.dao;

import com.dao.ApplyDao;
import com.google.gson.Gson;
import com.model.Apply;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

class ApplyDaoTest {

    @Resource
    private ApplyDao applyDao;

    @Test
    void insertApply() {
        applyDao = (ApplyDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("applyDao");
        Apply apply=new Apply();
        apply.setCreateTime(System.currentTimeMillis());
        apply.setOrderId(3);
        apply.setCarId(4);
        apply.setStatus(false);
        applyDao.insertApply(apply);
    }

    @Test
    void queryById() {
        applyDao = (ApplyDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("applyDao");
       // System.out.println(new Gson().toJson(applyDao.queryById(1)));
    }

    @Test
    void queryApply() {
        applyDao = (ApplyDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("applyDao");
        System.out.println(new Gson().toJson(applyDao.queryApply(3,4)));
    }

    @Test
    void selectApplyCarInfoList() {

    }

    @Test
    void selectApplyInfo() {
    }

    @Test
    void updateApplyStatusById() {
    }

    @Test
    void updateApplyStatus() {
    }

    @Test
    void applyGetOrderID() {
    }
}