package org.example.app;

import org.example.model.CarPart;
import org.example.repository.CarPartsInventory;
import org.example.repository.CarPartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App2 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
        CarPartsRepository cpInv = ctx.getBean(CarPartsRepository.class);


        List<CarPart> list = cpInv.findAll();
        for(CarPart cp : list)
            System.out.println(cp);
    }
}
