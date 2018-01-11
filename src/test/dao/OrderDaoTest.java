package test.dao;

import com.dao.OrderDao;
import com.dao.OrderInfoDao;
import com.google.gson.Gson;
import com.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoTest {

    @Resource
    private OrderDao orderDao;
    @Test
    void insertOrder() {
        orderDao = (OrderDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderDao");
        Order order=new Order();
        order.setCreateTime(System.currentTimeMillis());
        order.setOwnerId(11);
        order.setStatus(Order.STATUS_WAIT_CHECK);
        orderDao.insertOrder(order);
    }

    @Test
    void updateOrder() {
        orderDao = (OrderDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderDao");
        orderDao.updateOrder(3,Order.STATUS_IN_TRANSIT);
    }

    @Test
    void updateOrderById() {
        orderDao = (OrderDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderDao");
        orderDao.updateOrderById(3);
    }

    @Test
    void deleteOrder() {
        orderDao = (OrderDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderDao");
        orderDao.deleteOrder(3);
    }

    @Test
    void getOrder() {
        orderDao = (OrderDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderDao");
        System.out.println(orderDao.getOrder(Order.STATUS_WAIT_CHECK,0));
    }

    @Test
    void selectOrder() {
        orderDao = (OrderDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderDao");
        System.out.println(new Gson().toJson(orderDao.selectOrder(0)));
    }
    @Test
    void selectCarInfoForOrder(){
        orderDao = (OrderDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderDao");
        System.out.println(new Gson().toJson(orderDao.selectCarInfoForOrder(6)));
    }
    @Test
    void selectOrderInfoByCarId(){
        orderDao = (OrderDao) (new ClassPathXmlApplicationContext("classpath:config/spring-mybatis.xml")).getBean("orderDao");
        System.out.println(new Gson().toJson(orderDao.selectOrderInfoByCarId(16,4)));
    }
}