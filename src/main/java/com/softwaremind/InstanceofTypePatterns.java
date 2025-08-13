package com.softwaremind;

import java.util.List;

import com.softwaremind.model.living.Animal;
import com.softwaremind.model.living.LivingBeing;
import com.softwaremind.model.living.Plant;

public class InstanceofTypePatterns {

  public static void main(String[] args) {
    Animal dog = new Animal("woof");
    Animal cat = new Animal("meow");
    Plant grass = new Plant();
    Plant tree = new Plant();

    List<LivingBeing> livingBeings = List.of(dog, cat, grass, tree);

    dog.move(); //fine - dog is assigned to Animal and Animal has move()

    var firstBeing = livingBeings.getFirst();

    System.out.println("dog and firstBeing are the same: " + (firstBeing == dog));
    //    firstBeing.move(); //compile error - someBeing is of type LivingBeing, which does not have move()

    for (LivingBeing someBeing : livingBeings) {
      System.out.println("Processing: " + someBeing.getClass().getSimpleName());
      processWithoutPattern(someBeing);
      processWithPattern(someBeing);
      System.out.println("=====================================\n");
    }

    Object obj = List.of("a", "b", "c");
//    if (obj instanceof List<?> objects) {
//      //we have to use wildcard type List<?>, due to type erasure
//    }
//    if (obj instanceof List<String> strings) {
//      //will not compile, the generic type is not available at runtime and therefore cannot be safely cast
//    }
  }

  private static void processWithoutPattern(LivingBeing someBeing) {
    System.out.println("* Without pattern matching (pre Java 17) *");

    System.out.println("* Unsafe cast *");
    Animal hardCastAnimal = (Animal) someBeing;
    hardCastAnimal.move();

    if (someBeing instanceof Animal) {
      System.out.println("* Safe(r) cast *");
      Animal animal = (Animal) someBeing;
      animal.move();
    }

    //can't do this:
    //    if (someBeing instanceof Animal && "woof".equals(someBeing).getSound()) {
    //      System.out.println("It's a dog!");
    //      Animal animal1 = (Animal) someBeing;
    //      animal1.move();
    //      animal1.metabolize();
    //    }
  }

  private static void processWithPattern(LivingBeing someBeing) {
    System.out.println("* With pattern matching (Java 17+) *");

    if (someBeing instanceof Animal animal) {
      System.out.println("* Type check + cast + assignment to local variable *");
      animal.move();
    }

    if (someBeing instanceof Animal animal && "woof".equals(animal.getSound())) {
      System.out.println("* Typecast variable is immediately available in scope *");
      System.out.println("It's a dog!");
      animal.move();
    }

    //    if (someBeing instanceof Animal animal || "woof".equals(animal.getSound())) {
    //      System.out.println("It might be a dog 🤔");
    //      animal.move();
    //      animal.metabolize();
    //    }
  }
}
