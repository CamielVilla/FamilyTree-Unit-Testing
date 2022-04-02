package Novi.Backend.Java.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String middelName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;
    private List<Person> grandChildren;



    public Person(String name, String lastName, String sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        siblings = new ArrayList<>();
        children = new ArrayList<>();
        pets = new ArrayList<>();
        grandChildren = new ArrayList<>();
    }

    public Person(String name, String middelName, String lastName, String sex, int age) {
        this.name = name;
        this.middelName = middelName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        siblings = new ArrayList<>();
        children = new ArrayList<>();
        pets = new ArrayList<>();
        grandChildren = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddelName() {
        return middelName;
    }

    public void setMiddelName(String middelName) {
        this.middelName = middelName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }


    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Person> getGrandChildren() {
        return grandChildren;
    }

    public void setGrandChildren(List<Person> grandChildren) {
        this.grandChildren = grandChildren;
    }

    public void addParent(Person parent){
    if (parent.getSex() == "male"){
      setFather(parent);
    }else if (parent.getSex() == "female"){
        setMother(parent);
    }else {
        System.out.println("Parent not set, make sure sex is male or female");
        }
    }

    public void addChild(Person child) {
        children.add(child);

        Person father = getFather();
        Person mother = getMother();
        if(mother != null){
            mother.addGrandChild(child);
        }else if (father  != null){
            father.addGrandChild(child);
        }

        if (child.getChildren().size() > 0 ){
            for (Person c : child.getChildren()){
                addGrandChild(c);
            }
        }
    }
    public void addPet(Pet pet){
        pets.add(pet);
}

    public void addSibling(Person sibling){
        siblings.add(sibling);
    }

    public void addGrandChild (Person grandchild) {
    grandChildren.add(grandchild);
}


    }

