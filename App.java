package org.example.app;

import org.example.model.CarPart;
import org.example.repository.CarPartsInventory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
        CarPartsInventory cpInv = ctx.getBean("carPartsInv2", CarPartsInventory.class);

        CarPart carPart = new CarPart();
        carPart.setPartNo(103);
        carPart.setPartName("Seat Belt");
        carPart.setCarModel("Maruti 800");
        carPart.setPrice(2600);
        carPart.setQuantity(99);

        long ms1 = System.currentTimeMillis();
        cpInv.addNewPart(carPart);
        long ms2 = System.currentTimeMillis();
        System.out.println("Approx time taken " + (ms2 - ms1) + " ms");
    }
}
