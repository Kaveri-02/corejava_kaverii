package com.tns.fooddeliverysystem.services;

import java.util.*;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.DeliveryPerson;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;

public class OrderService {
    private Map<Integer, Order> orders = new LinkedHashMap<>();
    private Map<Integer, List<Order>> ordersByCustomer = new HashMap<>();
    private Map<Integer, DeliveryPerson> deliveryPersons = new LinkedHashMap<>();
    private int nextOrderId = 1;

    public int placeOrder(Customer customer) {
        if (customer == null) return -1;
        Map<FoodItem, Integer> cartItems = customer.getCart().getItems();
        if (cartItems.isEmpty()) return -1;

        int id = nextOrderId++;
        Order order = new Order(id, customer);

        for (Map.Entry<FoodItem, Integer> e : cartItems.entrySet()) {
            order.addItem(e.getKey(), e.getValue());
        }

        orders.put(id, order);
        ordersByCustomer.computeIfAbsent(customer.getUserId(), k -> new ArrayList<>()).add(order);

        // Clear the cart after placing order
        cartItems.clear();

        return id;
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return new ArrayList<>(ordersByCustomer.getOrDefault(customerId, Collections.emptyList()));
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    // Delivery Person management
    public boolean addDeliveryPerson(int id, String name, long contactNo) {
        if (deliveryPersons.containsKey(id)) return false;
        deliveryPersons.put(id, new DeliveryPerson(id, name, contactNo));
        return true;
    }

    public DeliveryPerson getDeliveryPersonById(int id) {
        return deliveryPersons.get(id);
    }

    public boolean assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
        Order order = orders.get(orderId);
        DeliveryPerson dp = deliveryPersons.get(deliveryPersonId);
        if (order == null || dp == null) return false;
        order.setDeliveryPerson(dp);
        return true;
    }
}