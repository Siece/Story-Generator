/**
 * Story.java
 * Assignment: Final Project
 * Purpose: To let us have some experience with actual coding, rather than
 * just systematically fulfilling assignments through which we are 
 * walked step by step.
 * @version 05/20/15
 * @author Rachel Dell
 */
import java.awt.*;
import java.io.*;
import java.util.*;

public abstract class Story {

   /* @param a Scanner with the text which ones wishes to change to an ArrayList
   * @return an ArrayList with each line stored seperately
   * takes a Scanner containing text and stores each line seperately into one ArrayList
   */
   public ArrayList<String> textToArray(Scanner text){
      ArrayList<String> data = new ArrayList<String>();
      while(text.hasNext()){
         data.add(text.nextLine());
      }
      return data; 
   }
   
   /* @param an ArrayList of Strings
   * @return a random String from the ArrayList
   * finds a random index, and returns the String in the ArrayList at that index
   */
   public String randomize(ArrayList<String> data){
      int numb = (int)(Math.random() * data.size());
      return data.get(numb);
   }
   
   /* @param nothing
   * @return a String representation of the information of the class
   * takes the information stored in or passed to the class, turns it into a String version,
   * and returns that String  
   */
   public abstract String toString();
}