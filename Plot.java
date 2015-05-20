/**
 * Plot.java
 * Assignment: Final Project
 * Purpose: To let us have some experience with actual coding, rather than
 * just systematically fulfilling assignments through which we are 
 * walked step by step.
 * @version 05/18/15
 * @author Luia Menchhofer
 */
 
import java.awt.*;
import java.io.*;
import java.util.*;
public class Plot extends Story {
   private String firstSent;
   private String story;
    
   /* @param nothing
   * @return nothing
   * constructor method for Plot
   */
   public Plot () throws FileNotFoundException{
   firstSentence(); 
   plotLine();
   }
   
   /*@param nothing
   * @return a String with a random first sentence 
   * picks a random first sentence by using randomize method
   */
   public String firstSentence ()throws FileNotFoundException {
      Scanner sentence = new Scanner(new File("randomSentences.txt"));
      ArrayList<String> data = textToArray(sentence);
      firstSent = randomize(data);
      return firstSent;
   }
   
   /*@param nothing
   * @return a String with a random plotline 
   * picks the plotline by using randomize method
   */
   public String plotLine () throws FileNotFoundException {
      Scanner plotIdeas = new Scanner(new File("storylines.txt"));
      ArrayList<String> data = textToArray(plotIdeas);
      story = randomize(data);
      return story;
   }

   /* @param nothing
   * @return a String version of the first sentence and plotline
   * makes headings for the information generated in the Plot class and prints the fields
   */
   public String toString() {
      return "Plot: \n " + "\t First Sentence: " + this.firstSent + "\n\t Basic Storyline: " + this.story;
   }
}