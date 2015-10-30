package org.arquillian.example.rest;

public class VolumeUnitsConverter {

    private static final double CONVERSION_RATIO = 29.5735296d;

    public Double convertToMilliliters(Double amount) {
        return amount * CONVERSION_RATIO;
    }

    public Double convertToFlouidOunces(Double amount) {
        return amount / CONVERSION_RATIO;
    }

}
