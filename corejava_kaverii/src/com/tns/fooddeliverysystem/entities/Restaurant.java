package com.tns.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<FoodItem> getMenu() { return menu; }

    public void addFoodItem(FoodItem item) {
        // If the item with same id exists, replace it; else add new
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getId() == item.getId()) {
                menu.set(i, item);
                return;
            }
        }
        menu.add(item);
    }

    public boolean removeFoodItem(int foodItemId) {
        return menu.removeIf(fi -> fi.getId() == foodItemId);
    }

    public FoodItem findFoodItemById(int foodItemId) {
        for (FoodItem fi : menu) {
            if (fi.getId() == foodItemId) return fi;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Restaurant ID: " + id + ", Name: " + name;
    }
    
    public FoodItem findFoodItemById1(int foodItemId) {
        FoodItem[] foodItems = null;
		for (FoodItem f : foodItems) {
            if (f.getFoodItemId() == foodItemId) return f;
        }
        return null;
    }
}