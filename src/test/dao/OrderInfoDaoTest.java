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
    public void before() {

    }

    @Test
    public void insertOrderInfo() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(3);
        orderInfo.setDeliveryTime(System.currentTimeMillis() + 1000000000);
        orderInfo.setDeparture("1215");
        orderInfo.setGoods("测试");
        orderInfo.setTarget("重庆市");
        orderInfo.setType(1);
        orderInfo.setWeight(5f);
        orderInfoDao.insertOrderInfo(orderInfo);
    }

    @Test
    public void deleteOrderInfo() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");

        orderInfoDao.deleteOrderInfo(0);
    }

    @Test
    public void getOrderInfo() {
        System.out.println(System.currentTimeMillis());
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");
        System.out.println(orderInfoDao.getOrderInfo(0));

    }

    @Test
    public void selectOrderInfo() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");
        System.out.println(orderInfoDao.selectOrderInfo(1, 1215 + "", "重庆市", 0));
    }

    @Test
    public void selectOrderInfoExpType() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");
        System.out.println(orderInfoDao.selectOrderInfoExpType(1215+"","重庆市",0));
    }

    @Test
    public void selectOrderInfoExpDeparture() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");

        System.out.println(orderInfoDao.selectOrderInfoByDeparture(1215+"",0));
    }

    @Test
    public void selectOrderInfoExpTarget() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");

        System.out.println(orderInfoDao.selectOrderInfoExpTarget(1,1215+"",0));
    }

    @Test
    public void selectOrderInfoByTarget() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");
        System.out.println(orderInfoDao.selectOrderInfoByTarget("重庆市",0));
    }

    @Test
    public void selectOrderInfoByType() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");
        System.out.println(orderInfoDao.selectOrderInfoByType(1,0));
    }

    @Test
    public void selectOrderInfoByDeparture() {
        orderInfoDao = (OrderInfoDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderInfoDao");
        System.out.println(orderInfoDao.selectOrderInfoByDeparture(1215+"",0));
    }
}