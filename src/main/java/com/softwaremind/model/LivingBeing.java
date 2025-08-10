package com.softwaremind.model;

public interface LivingBeing {
  default void metabolize() {
    System.out.println("Metabolizing!");
  }
}