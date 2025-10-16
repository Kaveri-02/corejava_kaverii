package com.tns.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Restaurant;

public class FoodService {
    private Map<Integer, Restaurant> restaurants = new LinkedHashMap<>();

    public boolean addRestaurant(int id, String name) {
        if (restaurants.containsKey(id)) return false;
        restaurants.put(id, new Restaurant(id, name));
        return true;
    }

    public boolean addFoodItemToRestaurant(int restaurantId, FoodItem item) {
        Restaurant r = restaurants.get(restaurantId);
        if (r == null) return false;
        r.addFoodItem(item);
        return true;
    }

    public boolean removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        Restaurant r = restaurants.get(restaurantId);
        if (r == null) return false;
        return r.removeFoodItem(foodItemId);
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurants.values());
    }

    public Restaurant getRestaurantById(int id) {
        return restaurants.get(id);
    }

    public FoodItem findFoodItem(int restaurantId, int foodItemId) {
        Restaurant r = restaurants.get(restaurantId);
        if (r == null) return null;
        return r.findFoodItemById(foodItemId);
    }
}