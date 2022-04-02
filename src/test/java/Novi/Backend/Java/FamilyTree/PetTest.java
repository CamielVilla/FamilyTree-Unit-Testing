package Novi.Backend.Java.FamilyTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    Person jaap = new Person("Jaap", "Ligthart", "male", 55);
    Person thea = new Person("thea", "aapjes", "female", 88);

    @Test
    void ifJaapIsAddedAsOwnerIsJaapTheNewOwner() {
        Pet pet = new Pet("pet", 55, "bulldog");
        pet.addOwner(jaap);
        assertEquals(jaap, pet.getOwner());
    }
}