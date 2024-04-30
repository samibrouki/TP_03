package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
    @Mock
    private OrderService orderServiceMock;
    @Mock
    private OrderDao orderDaoMock;
    @Test
    public void createOrderTest() {
        Order order = new Order();
        doNothing().when(orderServiceMock).createOrder(order);
        doNothing().when(orderDaoMock).saveOrder(order);
        OrderController orderController = new OrderController(orderServiceMock);
        OrderService orserv = new OrderService(orderDaoMock);
        OrderController orderController2 = new OrderController(orserv);
        orderController.createOrder(order);
        orderController2.createOrder(order);
        verify(orderServiceMock).createOrder(order);
        verify(orderDaoMock).saveOrder(order);
    }
}