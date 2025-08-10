package com.softwaremind;

import java.util.List;

import com.softwaremind.model.Animal;
import com.softwaremind.model.LivingBeing;
import com.softwaremind.model.Plant;

public class InstanceofTypePatterns {
  public static void main(String[] args) {
    Animal dog = new Animal("woof");
    Animal cat = new Animal("meow");
    Plant grass = new Plant();
    Plant tree = new Plant();

    List<LivingBeing> livingBeings = List.of(dog, cat, grass, tree);

    dog.move(); //fine - dog is assigned to Animal and Animal has move()

    var firstLivingBeing = livingBeings.getFirst();

    System.out.println("dog and firstLivingBeing are the same: " + (firstLivingBeing == dog));
//    firstLivingBeing.move(); //compile error - firstLivingBeing is of type LivingBeing, which does not have move()

    //pre Java 17
    if (firstLivingBeing instanceof Animal) {
      Animal animal1 = (Animal) firstLivingBeing;
      animal1.move();
      animal1.metabolize();
    }

    //unsafe
    Animal animal2 = (Animal) firstLivingBeing;
    animal2.move();
    animal2.metabolize();

    //TYPE PATTERNS

    //Java 17+
    if (firstLivingBeing instanceof Animal animal3) {
      animal3.move();
      animal3.metabolize();
    }

    CharSequence text = "Hello";
//    text.toLowerCase(); //CharSequence does not have toLowerCase() method
    if (text instanceof String str && "hello".equals(str.toLowerCase())) {
      System.out.println("Hello indeed!");
    } else {
//      str.toLowerCase(); //compile error - str is not in scope here
      System.out.println("Not hello )-:<");
    }
//    if (text instanceof String str || "hello".equals(str.toLowerCase())) { //compile error - str is not in scope here
//      System.out.println("Hello or not");
//      str.toLowerCase(); //compile error - str is not in scope here
//    }
  }
}
