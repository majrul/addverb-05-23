package org.example.service;

import org.example.dto.OrderDetails;
import org.example.model.Product;

public interface ShoppingService {

    public void addProduct(Product product);

    public void placeOrder(OrderDetails orderDetails);
}
