package com.alibaba.cloud.spring.boot.examples.compileflow.mock;

/**
 * @author yusu
 */
public class KtvService {

    public void sing(String name) {
        System.out.println(name + " is singing");
    }

    public void payMoney(int price) {
        System.out.println("actually paid money: " + price);
    }

}
