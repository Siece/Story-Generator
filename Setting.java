/**
 * Setting.java
 * Assignment: Final Project
 * Purpose: To let us have some experience with actual coding, rather than
 * just systematically fulfilling assignments through which we are 
 * walked step by step.
 * @version 05/13/15
 * @author Rachel Dell
 */
 
import java.awt.*;
import java.io.*;
import java.util.*;

public class Setting extends Story {
   private String genre;
   private String place;
   private String time;

   /* @param the genre of the stroy as a String
   * @return nothing
   * constructs the Setting class, puts genre in a field
   */
   public Setting(String genre) throws FileNotFoundException{
      this.genre = genre;
      location();
      timePeriod();
   }
   
   /* @param nothing
   * @return a String with the year and (B)CE 
   * picks a random year based on the genre and turns it into a phrase with (B)CE at the end, 
   * using textToArray and randomize methods 
   */
   public String timePeriod() {
      //finding a random year as an int based on genre
      int time = 0;
      Random years = new Random();
      if (genre.equalsIgnoreCase("Sci-fi")) {
         time = years.nextInt(7777) + 2015; //from present to far future
      } 
      else if (genre.equalsIgnoreCase("Historical")) {
         time = years.nextInt(4690) - 2700; //from ancient Egypt to 1990
      } 
      else { //normal
         time = years.nextInt(70) + 1950; //from 1950 to 2020
      }
      //turning it into a phrase rather than just a number
      String timePhrase = "";
      if (time < 0) {
         timePhrase = (int) Math.abs(time) + " BCE";
      } 
      else { 
         timePhrase = time + " CE";
      }
      this.time = timePhrase;
      return timePhrase;
   }
   
   /* @param nothing
   * @return a String with a random location picked based on genre
   * picks a random place based on genre, using textToArray and randomize methods 
   */
   public String location() throws FileNotFoundException {
      String place = "";
      //finding a random place based on genre
      if (genre.equalsIgnoreCase("Sci-fi")) {
         place = randomize(textToArray(new Scanner(new File("Sci-fiPlaces.txt"))));
      } 
      else if (genre.equalsIgnoreCase("Fantasy")) {
         place = randomize(textToArray(new Scanner(new File("FantasyPlaces.txt")))); 
      } 
      else { //normal
         place = randomize(textToArray(new Scanner(new File("countries.txt"))));
      }
      //fixing the capitalization of the name (inconsistant between the files)
      place = place.substring(0, 1).toUpperCase() + place.substring(1).toLowerCase();
      this.place = place;
      return place; 
   }
   
   /* @param nothing
   * @return a String version of the Setting w/ location and time period
   * makes headings for the information generated in the Setting class and prints the fields
   */
   public String toString() {
      return "Setting: \n " +  "\t Location: " + this.place + "\n\t Time period: " + this.time;
   }
   
}