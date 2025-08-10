package com.softwaremind.model;

public class Animal implements LivingBeing {
  private final String sound;

  public Animal(String sound) {
    this.sound = sound;
  }

  public String getSound() {
    return sound;
  }

  public void move() {
    System.out.println("Moving!");
  }
}
