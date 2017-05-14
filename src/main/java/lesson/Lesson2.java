package lesson;
/**
 * Copyright � 2016, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Speakjava (Simon Ritter)
 */
public class Lesson2 {
  private static final String WORD_REGEXP = "[- .:,]+";

  /**
   * Run the exercises to ensure we got the right answers
   *
   * @throws java.io.IOException
   */
  public void runExercises() throws IOException {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
    System.out.println("Running exercise 6 solution...");
    exercise6();
    System.out.println("Running exercise 7 solution...");
    exercise7();
  }

  /**
   * Exercise 1
   *
   * Create a new list with all the strings from original list converted to 
   * lower case and print them out.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    
    list.stream().map( s-> s.toLowerCase()).collect(Collectors.toList()).forEach((s)->{System.out.println(s);});
  }

  /**
   * Exercise 2
   *
   * Modify exercise 1 so that the new list only contains strings that have an
   * odd length
   */
  private void exercise2() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    list.stream().filter(s -> (s.length() % 2) != 0).collect(Collectors.toList()).forEach((s)-> {System.out.println(s);});
  }

  /**
   * Exercise 3
   *
   * Join the second, third and forth strings of the list into a single string,
   * where each word is separated by a hyphen (-). Print the resulting string.
   */
  private void exercise3() {
    List<String> list = Arrays.asList(
        "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    /* YOUR CODE HERE */
   String result = list.stream().skip(1).limit(3).collect(Collectors.joining("-"));
   System.out.println(result);
  }

  /**
   * Count the number of lines in the file using the BufferedReader provided
   */
  private void exercise4() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get(".", "src","main","resources", "SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    	long numberOfLines = reader.lines().count();
    	System.out.println(numberOfLines);
    }
  }
  
  /**
   * Using the BufferedReader to access the file, create a list of words with
   * no duplicates contained in the file.  Print the words.
   * 
   * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
   */
  private void exercise5() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get(".", "src","main","resources","SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    	List<String> list = reader.lines().flatMap( line -> Stream.of(line.split(WORD_REGEXP))).distinct().collect(Collectors.toList());
    	list.forEach(s -> System.out.println(s));
    }
  }
  
  /**
   * Using the BufferedReader to access the file create a list of words from 
   * the file, converted to lower-case and with duplicates removed, which is
   * sorted by natural order.  Print the contents of the list.
   */
  private void exercise6() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get(".", "src","main","resources","SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    	List<String> list = reader.lines().flatMap( line -> Stream.of(line.split(WORD_REGEXP))).map(s -> s.toLowerCase()).distinct().sorted().collect(Collectors.toList());
    	list.forEach(s -> System.out.println(s));
    }
  }
  
  /**
   * Modify exercise6 so that the words are sorted by length
   */
  private void exercise7() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get(".", "src","main","resources","SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    	List<String> list = reader.lines().flatMap( line -> Stream.of(line.split(WORD_REGEXP))).map(s -> s.toLowerCase()).distinct().sorted((String s1, String s2)-> s1.length() - s2.length()).collect(Collectors.toList());
    	list.forEach(s -> System.out.println(s));
    }
  }

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   * @throws IOException If file access does not work
   */
  public static void main(String[] args) throws IOException {
    Lesson2 lesson = new Lesson2();
    lesson.runExercises();
  }
}
