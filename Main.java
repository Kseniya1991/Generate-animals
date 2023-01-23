import java.util.*;

/**
 * Задача была такова: скрестить кошку и собаку, чтоб у гибрида были общие признаки
 */

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Hybrid hybrid = new Hybrid(cat, dog);
        System.out.println(String.format("Тип: %s", hybrid.type));
        System.out.println(String.format("Гибрид издает звук: %s", hybrid.makeSound()));
    }
}

abstract class Animal {

    String voice;
    String type = "Animal";

    public abstract String makeSound();
}

class Cat extends Animal {

    public Cat() {
        this.type = "Cat";
        this.voice = "Meow";
    }

    @Override
    public String makeSound() {
        return voice;
    }
}

class Dog extends Animal {

    public Dog() {
        this.type = "Dog";
        this.voice = "Woof";
    }

    @Override
    public String makeSound() {
        return voice;
    }
}

class Hybrid extends Animal {

    public Hybrid(Animal a1, Animal a2) {
        this.type = a1.type + "&" + a2.type;
        this.voice = Utils.shuffleString(a1.voice, a2.voice).toLowerCase();
        this.voice = Utils.firstLetterUpCase(voice);
    }


    public String makeSound() {
        return voice;
    }
}

class Utils {
    public static String shuffleString(String... strings) {
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            String[] splitLine = new String[string.length()];
            for (int i = 0; i < splitLine.length; i++) {
                splitLine[i] = String.valueOf(string.charAt(i));
            }
            List<String> list2 = Arrays.asList(splitLine);
            list.addAll(list2);

            //list.addAll(Arrays.asList(string.split(""))
        }
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (String letter : list) {
            sb.append(letter);
        }

        return sb.toString();
    }

    public static String firstLetterUpCase(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
