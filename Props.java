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
   private String weapon;
   private String accessory;
   
   /* @param nothing
   * @return nothing
   * constructs a Props class, with blank strings for defaults 
   */
   public Props() {
      weapon = "";
      accessory = "";
   }
   
   /* @param a String containing the genre
   * @return a String containing a randomly selected weapon based on genre
   * picks a random weapon based on genre, using textToArray and randomize methods 
   */
   public String weapons(String genre) throws FileNotFoundException {
      if (genre.equalsIgnoreCase("Historical")) {
         this.weapon = randomize(textToArray(new Scanner(new File("oldWeapons.txt"))));
      } else {    //this file name is a guess, I'll change it once the file is done
         this.weapon = randomize(textToArray(new Scanner(new File("modernWeapons.txt"))));
      }
      return weapon;
   }
   
   /* @param nothing
   * @return a String containing a randomly selected accessory
   * picks a random accessory, using textToArray and randomize methods 
   */
   public String accessories() throws FileNotFoundException {
      this.accessory = randomize(textToArray(new Scanner(new File("accesories.txt"))));
      return accessory;
   }

   /* @param nothing
   * @return a String representation of the props
   * makes and returns a String version of the props contained in Prop 
   */
   public String toString() {
      String printVersion = weapon + accessory; //I'll add the new fields once we make them
      return printVersion; 
   }
   
}