package com.day02.shoppingcart;

import java.util.*;

public class ShoppingCart {
    private Map<String, Integer> productPrices;
    private LinkedHashMap<String, Integer> cart;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();
    }

    public void addProduct(String product, int price) {
        productPrices.put(product, price);
        cart.put(product, price);
    }

    public void displayCart() {
        System.out.println("Items in Cart (Order Added): " + cart);
        TreeMap<String, Integer> sortedByPrice = new TreeMap<>(Comparator.comparingInt(productPrices::get));
        sortedByPrice.putAll(cart);
        System.out.println("Items Sorted by Price: " + sortedByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1000);
        cart.addProduct("Mouse", 20);
        cart.addProduct("Keyboard", 50);
        cart.addProduct("Monitor", 300);

        cart.displayCart();
    }
}


