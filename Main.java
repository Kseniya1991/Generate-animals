package TaskCatDog;

/**
 * Задача была такова: скрестить кошку и собаку, чтоб у гибрида были общие признаки
 * */

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("пушистый");
        Dog dog = new Dog("короткий");
        Hybrid hybrid = generate(cat, dog);
        System.out.println("У гибрида " + hybrid.tail + " хвост");
        System.out.println(hybrid.makeSound(cat, dog));
    }

    public static Hybrid generate(Animal a1, Animal a2) {
        return new Hybrid(a1.tail + " и " + a2.tail);
    }
}
 class Animal {

    String tail;

    public Animal(String tail){
        this.tail = tail;
    }

    public String makeSound(){
        return "Животное издает звук";
    }
}

class Cat extends Animal {

    public Cat(String tail) {
        super(tail);
    }

    @Override
    public String makeSound(){
        return "Мяу";
    }
}

class Dog extends Animal {
    public Dog(String tail) {
        super(tail);
    }

    @Override
    public String makeSound(){
        return "Гав";
    }
}

class Hybrid extends Animal{
    public Hybrid(String tail) {
        super(tail);
    }

    public String makeSound(Cat cat, Dog dog){

        return "Гибрид издает звук " + cat.makeSound() + " и " + dog.makeSound();
    }
}



