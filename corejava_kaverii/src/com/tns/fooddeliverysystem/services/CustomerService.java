package com.tns.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.FoodItem;

public class CustomerService {
    private Map<Integer, Customer> customers = new LinkedHashMap<>();
    private final FoodService foodService;

    public CustomerService(FoodService foodService) {
        this.foodService = foodService;
    }

    public boolean addCustomer(int userId, String username, long contactNo) {
        if (customers.containsKey(userId)) return false;
        customers.put(userId, new Customer(userId, username, contactNo));
        return true;
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public boolean addFoodToCart(int customerId, int restaurantId, int foodItemId, int quantity) {
        Customer c = customers.get(customerId);
        if (c == null) return false;
        FoodItem item = foodService.findFoodItem(restaurantId, foodItemId);
        if (item == null) return false;
        c.getCart().addItem(item, quantity);
        return true;
    }
}