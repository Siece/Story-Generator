/**
 * Character.java
 * Assignment: Final Project
 * Purpose: To let us have some experience with actual coding, rather than
 * just systematically fulfilling assignments through which we are 
 * walked step by step.
 * @version 05/18/15
 * @author Sierramatice Karras
 */
 
import java.awt.*;
import java.io.*;
import java.util.*;

public class Character extends Story {
   private String gender;
   private int age;
   private String name;
   private String eyes;
   private String hair;
   private String skin;
   private String personality;
   private String job;
   private String height;
   private String genre;
   private String type;
   private String species;
   private String superpower;
   
   /* @param a String containing the gender of the character (e.g. male, female, either) 
   * @return nothing
   * constructs a Character with the given gender
   */
   public Character(String gender, String genre, String type) throws FileNotFoundException{
      this.gender = gender;
      this.genre = genre;
      this.type = type;
      name();
      age(genre);
      eyes();
      hair();
      height();
      skinTone();
      personality();
      occupation(genre);
      if (genre.equals("superhero")) {
         superpowers();
      }
   }
   
   public String superpowers() {
      Scanner superInfo = new Scanner(new File("superpowers.txt" ));
      ArrayList<String> powers = textToArray(superInfo);  
      this.superpower = randomize(powers);
      return this.superpower;
   }
   /* @param nothing
   * @return a String with a randomly selected skin tone from the text file
   * uses the textToArray and randomize methods to pick a random skin tone from the file
   */
   public String skinTone() throws FileNotFoundException {
      Scanner skinInfo = new Scanner(new File("SkinTone.txt" ));
      ArrayList<String> skin = textToArray(skinInfo);  
      this.skin = randomize(skin);
      return this.skin;
   }
   
   /* @param a String containing the genre
   * @return a randomly selected age
   * computes and returns a random number (based on the genre) for age
   */
   public int age(String genre) {
      if(genre.equals("sci-fi")) {
         this.age = (int)(Math.random() * 200);
      } 
      else if (genre.equals("historical")){
         this.age = (int) (Math.random() * 40);
      }
      else { 
         this.age = (int)(Math.random() * 90);
      }
      return age;
   }
   
   /* @param nothing
   * @return a randomly selected String for name (based on the gender)
   * picks the text file based on given gender, then picks and returns a random name from it,
   * uses the textToArray and randomize methods
   */
   public String name () throws FileNotFoundException {
      String file = "eitherGenderNames.txt";
      if (gender.equalsIgnoreCase("male")) {   
         file = "maleNames.txt";
      } 
      else if (gender.equalsIgnoreCase("female")) {
         file = "femaleNames.txt";
      }   
      String firstName = randomize(textToArray(new Scanner(new File(file))));
      //file has names all lower case
      firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
      String lastName = randomize(textToArray(new Scanner(new File("surnames.txt"))));
      //file has names all upper case
      lastName = lastName.substring(0, 1) + lastName.substring(1).toLowerCase();
      this.name = firstName + " " + lastName;
      return this.name;  
   }

   /* @param nothing
   * @return a String with the eye color of the character
   * uses the textToArray and randomize methods to pick a random eye color from the file
   */
   public String eyes() throws FileNotFoundException{
      Scanner eyesInfo = new Scanner(new File("EyeColors.txt" ));
      ArrayList<String> eyes = textToArray(eyesInfo); 
      this.eyes = randomize(eyes);
      return this.eyes;
   }
   
   /* @param nothing
   * @return a randomly selected String with the hair color of the character
   * uses the textToArray and randomize methods to pick a random hair color from the file
   */
   public String hair() throws FileNotFoundException {
      Scanner hairInfo = new Scanner(new File("HairColor.txt" ));
      ArrayList<String> hairs = textToArray(hairInfo); 
      this.hair = randomize(hairs);
      return this.hair;
   }
   
   /* @param nothing
   * @return a String with two randomly selected personality traits
   * uses textToArray and randomize methods to pick two random personality traits from the file
   */
   public String personality() throws FileNotFoundException{
      Scanner personality = new Scanner(new File("PersonalityTraits.txt" ));
      ArrayList<String> traits = textToArray(personality); 
      this.personality =  randomize(traits) + ", " + randomize(traits);
      return this.personality;
   }
   
   /* @param a String containing the genre
   * @return a String with a randomly selected occupation based off genre
   * uses textToArray and randomize methods to pick a random job from the file, with the file
   * decided based on the genre
   */
   public String occupation(String genre)throws FileNotFoundException {
      String txt;
      if(genre.equals("sci-fi")) {
         txt = "scifiJobs.txt";
      } 
      else if (genre.equals("fantasy")) {
         txt = "FantasyJobs.txt";
      } 
      else {
         txt = "occupations.txt";
      }
      Scanner input = new Scanner(new File(txt));
      if(age > 15) {   
         ArrayList<String> jobs = textToArray(input);
         this.job = randomize(jobs);
      } 
      else {
         this.job = "child - no job";   //what about historical, where children did work?
      }
      return this.job;
   }
   
   /* @param nothing
   * @return a randomly selected height in feet and inches (based on age)
   * computes height taking into account age ad returns it
   */
   public String height() {
      int feet = (int)(Math.random() * 3);
      if(age > 10) {    // maybe not as exact as it could be, if you have extra time
         feet += 4;
      } 
      else {
         feet += 2;
      }
      //if (feet =!) {    //whatever is going on here is pissing off the compiler!
      int inch = (int)(Math.random() * 11);
      this.height =  feet + "'" + inch + "\"";
      return this.height;
   }
   
   /* @param a String with the genre, a String with the type (human/creature)
   * @return the species of the character based on genre
   * uses the textToArray and randomize methods if genre is fantasy and the type creature, 
   * otherwise returns a basic species based on type and genre
   */
   public String species(String genre, String type) throws FileNotFoundException{
      if(genre.equals("fantasy") && type.equals("creature")){
         Scanner mythology = new Scanner(new File("creatures.txt" ));
         ArrayList<String> mythos = textToArray(mythology); 
         this.species = randomize(mythos);
      } 
      else if (genre.equals("sci-fi") && type.equals("creature")){
         this.species = "alien";   //how specific
      }
      else { 
         this.species = "human";
      }
      return this.species;
   }
   
   /* @param nothing
   * @return a String with a random mythological creature as the species
   * uses the textToArray and randomize methods to pick a random species, not based on anything
   */
   public String species() throws FileNotFoundException {
      Scanner mythology = new Scanner(new File("creatures.txt" ));
      ArrayList<String> mythos = textToArray(mythology); 
      return randomize(mythos);
   }
   
   /* @param nothing
   * @return a String with all the fields in it
   * turns all the fields and their names into a long String, which it returns
   */
   public String toString() {   
      String text =  "Name: " + this.name + "\n Age: " + this.age + "\n Appearance: " +
         "\n\t Eye Color: " + this.eyes + "\n\t Hair Color: " + this.hair + "\n\t Height: " 
         + this.height + "\n Personality: " + this.personality + "\n Occupation: " + 
         this.job + "\n Species: " + this.species;
      if(genre.equals("superhero")) {
         text += "\n Superpower: " + this.superpower;
      }
      return text;
   }
}