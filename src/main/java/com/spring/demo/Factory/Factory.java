package com.spring.demo.Factory;

import com.spring.demo.domain.Fruit;

public class Factory {
    public static Fruit getInstance(String ClassName){
        Fruit f = null;
        try {
           f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
