package test.dao;

import com.dao.LogisticsDao;
import com.dao.OrderDao;
import com.model.Logistics;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class LogisticsDaoTest {

    @Resource
    private LogisticsDao logisticsDao;
    @Test
    void insertLogistics() {
        logisticsDao = (LogisticsDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("logisticsDao");
        Logistics logistics=new Logistics();
        logistics.setCreateTime(System.currentTimeMillis());
        logistics.setInfo("这是物流信息");
        logistics.setOrderId(3);
        logisticsDao.insertLogistics(logistics);
    }

    @Test
    void getLogistics() {
        logisticsDao = (LogisticsDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("logisticsDao");
        System.out.println(logisticsDao.getLogistics(3));
    }
}