package org.example.app;

import org.example.dto.OrderDetails;
import org.example.model.Product;
import org.example.service.ShoppingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
        ShoppingService shoppingService = ctx.getBean(ShoppingService.class);

        /*Product product = new Product();
        product.setName("iPhone");
        product.setPrice(79000);
        product.setQuantity(99);
        shoppingService.addProduct(product);*/

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setProductId(1);
        orderDetails.setQuantity(5);
        shoppingService.placeOrder(orderDetails);
    }
}
