package Novi.Backend.Java.FamilyTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person jaap = new Person("jaap", "ligthart", "male", 55);
        Person anja = new Person("anja", "anjer", "female", 80 );
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);

        anja.setSex("female");
        jaap.addParent(anja);
        System.out.println(jaap.getMother().getName());

        jaap.addChild(anja);
        jaap.addChild(camiel);
    System.out.println(jaap.getChildren().size());


    }
}