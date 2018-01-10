package test.dao;

import com.dao.OrderInfoDao;
import com.model.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;


public class OrderInfoDaoTest {

    @Resource
    OrderInfoDao orderInfoDao;
    @Test
    public void before(){

    }
    @Test
    public void insertOrderInfo() {
        orderInfoDao=(OrderInfoDao)(new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setDeliveryTime(System.currentTimeMillis()+100000);
        orderInfo.setDeparture("重庆市");
        orderInfo.setGoods("测试");
        orderInfo.setTarget("重庆市");
        orderInfo.setType(1);
        orderInfo.setWeight(5f);
        orderInfoDao.insertOrderInfo(orderInfo);
    }

    @Test
    public void deleteOrderInfo() {
    }

    @Test
    public void getOrderInfo() {
    }

    @Test
    public void selectOrderInfo() {
    }

    @Test
    public void selectOrderInfoExpType() {
    }

    @Test
    public void selectOrderInfoExpDeparture() {
    }

    @Test
    public void selectOrderInfoExpTarget() {
    }

    @Test
    public void selectOrderInfoByTarget() {
    }

    @Test
    public void selectOrderInfoByType() {
    }

    @Test
    public void selectOrderInfoByDeparture() {
    }
}