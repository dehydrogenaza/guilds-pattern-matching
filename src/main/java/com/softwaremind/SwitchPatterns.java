package com.softwaremind;

import java.util.ArrayList;
import java.util.List;

import com.softwaremind.model.living.Animal;
import com.softwaremind.model.living.LivingBeing;
import com.softwaremind.model.living.Plant;

public class SwitchPatterns {
  public static void main(String[] args) {
    Animal dog = new Animal("woof");
    Plant tree = new Plant();
    LivingBeing mushroom = new LivingBeing() {};
    Integer numberOne = 1;
    Object pencil = new Object();

    List<Object> stuff = new ArrayList<>();
    stuff.add(dog);
    stuff.add(tree);
    stuff.add(mushroom);
    stuff.add(numberOne);
    stuff.add(pencil);
    stuff.add(null);

    for (int i = 0; i < stuff.size(); i++) {
      System.out.println("Processing item with index [" + i + "]");
      Object item = stuff.get(i);
      processWithPattern(item); //Java 21+
      processWithGuardedPattern(item); //Java 21+
      System.out.println("\n");
    }
  }

  private static void processWithPattern(Object item) {
    switch (item) {
      case Animal animal -> animal.move();
      case Plant plant -> plant.photosynthesize();
      case LivingBeing being -> being.metabolize(); //this has to be after Animal/Plant due to case dominance
      case null -> System.out.println("I'm null 👻"); //without this case, switch(null) throws a NullPointerException
      default -> System.out.println("Look mom, I'm an " + item.getClass().getSimpleName() + "!");
    }
  }

  private static void processWithGuardedPattern(Object item) {
    switch (item) {
      case Animal a
          when "woof".equalsIgnoreCase(a.getSound()) -> System.out.println("It's a dog!");
      case Animal a
          when "meow".equalsIgnoreCase(a.getSound()) -> System.out.println("It's a cat!");
      case Animal _ -> System.out.println("It's an animal, but not a dog or a cat!");
      case null -> System.out.println("I'm null 👻"); //without this case, switch(null) throws a NullPointerException
      default -> System.out.println("Not an animal!");
    }
  }
}
