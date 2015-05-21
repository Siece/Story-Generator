/**
 * Props.java
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

public class Props extends Story {
   private String item;
   private String personality;
   private String type;
   private String person;
   /* @param nothing
   * @return nothing
   * constructs a Props class, with blank strings for defaults 
   */
   public Props(String genre, String type, String sentience) throws FileNotFoundException{
      this.type = type;
      this.person = sentience;
      if(type.equals("weapon")) {
         weapons(genre);
      } 
      else if(type.equals("accessory")) {
         accessories();
      } 
      else if(type.equals("pet")){
         pet();
      } else {
         random();
      }
      if(sentience.equals("yes")){
         personality = super.personality();
      }
      else {
         personality = "";
      }
   }
   
   /* @param a String containing the genre
   * @return a String containing a randomly selected weapon based on genre
   * picks a random weapon based on genre, using textToArray and randomize methods 
   */
   public String weapons(String genre) throws FileNotFoundException {
      if (genre.equalsIgnoreCase("Historical")) {
         this.item = randomize(textToArray(new Scanner(new File("oldWeapons.txt"))));
      } 
      else { 
         this.item = randomize(textToArray(new Scanner(new File("ModernWeapons.txt"))));
      }
      return this.item;
   }
   
   public String random() throws FileNotFoundException {
      ArrayList<String> stuff = textToArray(new Scanner(new File("accesories.txt")));
      addToArray(new Scanner(new File("oldWeapons.txt")), stuff);
      addToArray(new Scanner(new File("ModernWeapons.txt")), stuff);
      addToArray(new Scanner(new File("RandomProps.txt")), stuff);
      addToArray(new Scanner(new File("animals.txt")), stuff);
      this.item = randomize(stuff);
      return this.item;
   }
   /* @param nothing
   * @return a String containing a randomly selected accessory
   * picks a random accessory, using textToArray and randomize methods 
   */
   public String accessories() throws FileNotFoundException {
      this.item = randomize(textToArray(new Scanner(new File("accesories.txt"))));
      return this.item;
   }
   
   public String pet() throws FileNotFoundException{
      this.item = randomize(textToArray(new Scanner(new File("animals.txt"))));
      return this.item;
   }
   
   /* @param nothing
   * @return a String representation of the props
   * makes and returns a String version of the props contained in Prop 
   */
   public String toString() {
      String text = "";
      if(type.equals("pet")) {
         text += "Pet: ";
      } 
      else {
         text += "Item: ";
      }
      text += item;
      if(person.equals("yes")){
         text += "\n   Personality: " + personality;
      }
      return text;
   }
   
}