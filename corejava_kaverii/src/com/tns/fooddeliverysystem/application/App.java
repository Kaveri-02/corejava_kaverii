package com.tns.fooddeliverysystem.application;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.tns.fooddeliverysystem.entities.Customer;
import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Order;
import com.tns.fooddeliverysystem.entities.Restaurant;
import com.tns.fooddeliverysystem.services.CustomerService;
import com.tns.fooddeliverysystem.services.FoodService;
import com.tns.fooddeliverysystem.services.OrderService;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FoodService foodService = new FoodService();
        CustomerService customerService = new CustomerService(foodService);
        OrderService orderService = new OrderService();

        while (true) {
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int mainChoice = readInt();

            switch (mainChoice) {
                case 1:
                    adminMenu(foodService, orderService);
                    break;
                case 2:
                    customerMenu(foodService, customerService, orderService);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Admin Menu
    private static void adminMenu(FoodService foodService, OrderService orderService) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int rId = readInt();
                    System.out.print("Enter Restaurant Name: ");
                    String rName = readLine();
                    boolean added = foodService.addRestaurant(rId, rName);
                    if (added) System.out.println("Restaurant added successfully!");
                    else System.out.println("Restaurant ID already exists!");
                    break;

                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int rId2 = readInt();
                    System.out.print("Enter Food Item ID: ");
                    int fId = readInt();
                    System.out.print("Enter Food Item Name: ");
                    String fName = readLine();
                    System.out.print("Enter Food Item Price: ");
                    double fPrice = readDouble();
                    boolean fiAdded = foodService.addFoodItemToRestaurant(rId2, new FoodItem(fId, fName, fPrice));
                    if (fiAdded) System.out.println("Food item added successfully!");
                    else System.out.println("Restaurant not found!");
                    break;

                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    int rId3 = readInt();
                    System.out.print("Enter Food Item ID: ");
                    int fId2 = readInt();
                    boolean removed = foodService.removeFoodItemFromRestaurant(rId3, fId2);
                    if (removed) System.out.println("Food item removed successfully!");
                    else System.out.println("Restaurant or Food Item not found!");
                    break;

                case 4:
                    printRestaurantsAndMenus(foodService);
                    break;

                case 5:
                    printAllOrders(orderService);
                    break;

                case 6:
                    System.out.print("Enter Delivery Person ID: ");
                    int dpId = readInt();
                    System.out.print("Enter Delivery Person Name: ");
                    String dpName = readLine();
                    System.out.print("Enter Contact No.: ");
                    long dpContact = readLong();
                    boolean dpAdded = orderService.addDeliveryPerson(dpId, dpName, dpContact);
                    if (dpAdded) System.out.println("Delivery person added successfully!");
                    else System.out.println("Delivery Person ID already exists!");
                    break;

                case 7:
                    System.out.print("Enter Order ID: ");
                    int oId = readInt();
                    System.out.print("Enter Delivery Person ID: ");
                    int dpId2 = readInt();
                    boolean assigned = orderService.assignDeliveryPersonToOrder(oId, dpId2);
                    if (assigned) System.out.println("Delivery person assigned to order successfully!");
                    else System.out.println("Order or Delivery Person not found!");
                    break;

                case 8:
                    System.out.println("Exiting Admin Module");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Customer Menu
    private static void customerMenu(FoodService foodService, CustomerService customerService, OrderService orderService) {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int uId = readInt();
                    System.out.print("Enter Username: ");
                    String uName = readLine();
                    System.out.print("Enter Contact No.: ");
                    long contact = readLong();
                    boolean created = customerService.addCustomer(uId, uName, contact);
                    if (created) System.out.println("Customer created successfully!");
                    else System.out.println("Customer ID already exists!");
                    break;

                case 2:
                    printRestaurantsAndMenus(foodService);
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int cId = readInt();
                    System.out.print("Enter Restaurant ID: ");
                    int rId = readInt();
                    System.out.print("Enter Food Item ID: ");
                    int fId = readInt();
                    System.out.print("Enter Quantity: ");
                    int qty = readInt();
                    boolean addedToCart = customerService.addFoodToCart(cId, rId, fId, qty);
                    if (addedToCart) System.out.println("Food item added to cart!");
                    else System.out.println("Failed to add item. Check Customer/Restaurant/Food Item IDs.");
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    int custIdForCart = readInt();
                    Customer c = customerService.getCustomerById(custIdForCart);
                    if (c == null) {
                        System.out.println("Customer not found!");
                        break;
                    }
                    printCart(c);
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int custIdForOrder = readInt();
                    Customer c2 = customerService.getCustomerById(custIdForOrder);
                    if (c2 == null) {
                        System.out.println("Customer not found!");
                        break;
                    }
                    int orderId = orderService.placeOrder(c2);
                    if (orderId > 0) System.out.println("Order placed successfully! Your order ID is: " + orderId);
                    else System.out.println("Cart is empty or order failed.");
                    break;

                case 6:
                    System.out.print("Enter Customer ID: ");
                    int custIdForView = readInt();
                    List<Order> orders = orderService.getOrdersByCustomerId(custIdForView);
                    System.out.println("Orders:");
                    if (orders.isEmpty()) {
                        System.out.println("(No orders found)");
                    } else {
                        for (Order o : orders) {
                            System.out.println(o);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting Customer Module");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Helpers
    private static void printRestaurantsAndMenus(FoodService foodService) {
        System.out.println("Restaurants and Menus:");
        List<Restaurant> list = foodService.getAllRestaurants();
        if (list.isEmpty()) {
            System.out.println("(No restaurants found)");
            return;
        }
        for (Restaurant r : list) {
            System.out.println(r.toString());
            if (r.getMenu().isEmpty()) continue;
            for (FoodItem fi : r.getMenu()) {
                System.out.println("- Food Item ID: " + fi.getId() + ", Name: " + fi.getName() + ", Price: Rs. " + fi.getPrice());
            }
        }
    }

    private static void printAllOrders(OrderService orderService) {
        List<Order> all = orderService.getAllOrders();
        if (all.isEmpty()) {
            System.out.println("(No orders found)");
            return;
        }
        System.out.println("Orders:");
        for (Order o : all) System.out.println(o);
    }

    private static void printCart(Customer c) {
        System.out.println("Cart:");
        Map<FoodItem, Integer> items = c.getCart().getItems();
        if (items.isEmpty()) {
            System.out.println("(Cart is empty)");
            return;
        }
        double total = 0.0;
        for (Map.Entry<FoodItem, Integer> e : items.entrySet()) {
            FoodItem fi = e.getKey();
            int qty = e.getValue();
            double cost = qty * fi.getPrice();
            total += cost;
            System.out.println("Food Item: " + fi.getName() + ", Quantity: " + qty + ", Cost: Rs. " + cost);
        }
        System.out.println("Total Cost: Rs. " + total);
    }

    // Safe input readers
    private static int readInt() {
        while (true) {
            try {
                String s = scanner.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static long readLong() {
        while (true) {
            try {
                String s = scanner.nextLine().trim();
                return Long.parseLong(s);
            } catch (Exception e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                String s = scanner.nextLine().trim();
                return Double.parseDouble(s);
            } catch (Exception e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static String readLine() {
        String s = scanner.nextLine();
        if (s == null) return "";
        return s.trim();
    }
}