package com.example.car2;

import java.util.List;

public class Car {

    private String brand;
    private String type;
    private int age;
    private Condition condition;

    private List<KmState> kmState;

    public Car(String brand, String type, int age, Condition condition, List<KmState> kmState) {
        this.brand = brand;
        this.type = type;
        this.age = age;
        this.condition = condition;
        this.kmState = kmState;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public Condition getCondition() {
        return condition;
    }

    public List<KmState> getKmState() {
        return kmState;
    }
}
