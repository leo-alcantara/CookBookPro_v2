package se.cookBookProv2.entity;

public enum Measurement {

    GRAM(1),
    KILO(1000),
    MILLILITER(1),
    LITER(1000);


    private int value;


    Measurement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }




}
