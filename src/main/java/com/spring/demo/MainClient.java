package com.spring.demo;

import com.spring.demo.Factory.Factory;
import com.spring.demo.domain.Fruit;

public class MainClient {
    public static void main(String[] args) {
        Fruit fruit = Factory.getInstance("com.spring.demo.domain.Apple");
        if(fruit != null){
            fruit.eat();
        }
    }
}
