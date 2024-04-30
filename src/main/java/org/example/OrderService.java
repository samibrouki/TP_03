package org.example;

public class OrderService {

    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order order) {
        // Business logic for creating order
        orderDao.saveOrder(order);
    }
}

