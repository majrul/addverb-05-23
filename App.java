package org.example.app;

import org.example.model.CarPart;
import org.example.repository.CarPartsInventory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
        CarPartsInventory cpInv = ctx.getBean("carPartsInv1", CarPartsInventory.class);

        CarPart carPart = new CarPart();
        carPart.setPartNo(101);
        carPart.setPartName("Nut & Bolt");
        carPart.setCarModel("Maruti 800");
        carPart.setPrice(500);
        carPart.setQuantity(99);

        cpInv.addNewPart(carPart);
    }
}
