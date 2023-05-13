package org.example.repository;

import org.example.model.CarPart;

import java.util.List;

public interface CarPartsInventory {

    public void addNewPart(CarPart carPart);
    public List<CarPart> getAvailableParts();
}
