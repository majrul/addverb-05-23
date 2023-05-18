package org.example.service;

import org.example.dto.OrderDetails;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service //@Component
@Transactional
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void placeOrder(OrderDetails orderDetails) {
        Optional<Product> optionalProduct = productRepository.findById(orderDetails.getProductId());
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            if(product.getQuantity() >= orderDetails.getQuantity()) {
                product.setQuantity(product.getQuantity() - orderDetails.getQuantity());
                productRepository.save(product);
                Order order = new Order();
                order.setOrderDate(LocalDate.now());
                order.setProduct(product);
                orderRepository.save(order);
            }
            //else
                //throw new OrderException("")
        }

    }
}
