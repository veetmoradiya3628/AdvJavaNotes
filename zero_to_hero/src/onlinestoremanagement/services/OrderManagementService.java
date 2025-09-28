package onlinestoremanagement.services;

import onlinestoremanagement.entities.Order;

public interface OrderManagementService {
    void addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();
}
