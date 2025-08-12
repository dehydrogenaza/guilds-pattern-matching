package com.softwaremind.model.living;

public interface LivingBeing {
  default void metabolize() {
    System.out.println("Metabolizing!");
  }
}