package Novi.Backend.Java.FamilyTree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person jaap = new Person("Jaap", "Ligthart", "male", 55);
    Person thea = new Person("thea", "aapjes", "female", 88);
    Person thea2 = new Person("thea2", "aapjes", "female", 88);
    Pet pet = new Pet("pet", 55, "bulldog");

    @Test
    @DisplayName(" Declaring person with second constructor")

    void declarePerson(){
        Person arie = new Person ("arie", "van", "boven", "male", 45);
    }
    @Test
    @DisplayName(" If male is added, Father is added")
    void addParent() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        camiel.addParent(jaap);
        assertEquals(jaap, camiel.getFather());
    }

    @Test
    @DisplayName(" If female is added, mother is added")
    void addParent2() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        camiel.addParent(thea);
        assertEquals(thea, camiel.getMother());
    }

    @Test
    @DisplayName("If sex is spelled wrong, fail to set parent")
    void addParent3() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Person camielsFather = new Person("camielsFather", "villa rikkers", "malef", 32);
        camiel.addParent(camielsFather);
        assertEquals(null, camiel.getFather());
    }


    @Test
    @DisplayName("If thea is added as a child it should return thea")
    void addChild() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Person[] expected = {thea};
        camiel.addChild(thea);
        assertArrayEquals(expected, camiel.getChildren().toArray());
    }


    @Test
    @DisplayName("If two children are added, list should contain both children")
    void addChild2() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Person[] expected = {thea, jaap};
        camiel.addChild(thea);
        camiel.addChild(jaap);
        assertArrayEquals(expected, camiel.getChildren().toArray());
    }

    @Test
    @DisplayName("If two children are added, list size should be 2")
    void addChild3() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        List<Person> expected = Arrays.asList(thea, jaap);
        camiel.addChild(thea);
        camiel.addChild(jaap);
        assertEquals(expected.size(), camiel.getChildren().size());
    }

    @Test
    @DisplayName("Pet added should ad pet to petlist")
    void addPet() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Pet [] expected = {pet};
        camiel.addPet(pet);
        assertArrayEquals(expected, camiel.getPets().toArray());
    }

    @Test
    @DisplayName("thea and jaap should be siblings")
    void addSibling() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Person [] expected = {thea, jaap};
        camiel.addSibling(thea);
        camiel.addSibling(jaap);
        assertArrayEquals(expected, camiel.getSiblings().toArray());
    }

    @Test
    @DisplayName("Son of a daughter should be a grandchild")
    void getGrandChildren() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Person [] expected = {thea2};
        jaap.addChild(thea2);
        camiel.addChild(jaap);
        assertArrayEquals(expected, camiel.getGrandChildren().toArray());
    }

    @Test
    @DisplayName("If father is known, new child is fathers grandchild")
    void getGrandChildren2() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Person [] expected = {jaap};
        thea.addParent(camiel);
        thea.addChild(jaap);
        assertArrayEquals(expected, camiel.getGrandChildren().toArray());
    }

    @Test
    @DisplayName("If mother is known, new child is mothers grandchild")
    void getGrandChildren3() {
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Person [] expected = {jaap};
        camiel.addParent(thea);
        camiel.addChild(jaap);
        assertArrayEquals(expected, thea.getGrandChildren().toArray());
    }

    @Test
    @DisplayName("If parent is not known, there is no grandchild")
    void getGrandChildren4(){
        Person camiel = new Person("camiel", "villa rikkers", "male", 32);
        Person [] expected = {};
        camiel.addChild(thea);
        assertArrayEquals(expected, camiel.getGrandChildren().toArray());
    }

}