package com.softwaremind;

public class MixingConstantsWithPatterns {
  public static void main(String[] args) {
    var inputs = new String[] {
        null, "y", "Y", "n", "N", "yes", "no", "yep", "nope", "yeah", "nah", "sure", "nuh-uh",
        "absolutely", "never", "definitely not", "certainly not", "potato"
    };
    for (String input : inputs) {
      try {
        boolean result = yesNoToBoolean(input);
        System.out.printf("Input: '%s' -> Result: %b%n", input, result);
      } catch (IllegalArgumentException e) {
        System.out.printf("Input: '%s' -> Exception: %s%n", input, e.getMessage());
      }
    }
  }

  private static final String[] YES_WORDS = {
      "yes", "yep", "yeah", "yup", "sure", "absolutely", "definitely", "for sure", "affirmative",
      "certainly", "indeed", "of course", "right on", "you bet", "roger that", "aye", "yass",
  };

  private static final String[] NO_WORDS = {
      "no", "nope", "nah", "nuh-uh", "never", "not at all", "negative", "no way", "absolutely not",
      "definitely not", "certainly not", "not a chance", "not on your life", "not in a million years",
      "no sir", "no ma'am", "no way jose",
  };

  private static boolean yesNoToBoolean(String input) {
    return switch (input) {
      case null -> false;
      case "y", "Y" -> true;
      case "n", "N" -> false;
      case String s
          when s.isBlank() -> false;
      case String s
        when isAlias(s, YES_WORDS) -> true;
      case String s
          when isAlias(s, NO_WORDS) -> false;
      case String _ -> throw new IllegalArgumentException("What??");
    };
  }

  private static boolean isAlias(String input, String[] aliases) {
    if (input == null || aliases == null) {
      return false;
    }
    for (String alias : aliases) {
      if (alias.equalsIgnoreCase(input)) {
        return true;
      }
    }
    return false;
  }
}
