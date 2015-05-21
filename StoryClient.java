/**
 * StoryClient.java
 * Assignment: Final Project
 * Purpose: To let us have some experience with actual coding, rather than
 * just systematically fulfilling assignments through which we are 
 * walked step by step.
 * @version 05/15/15
 * @author Sierramatice Karras
 */

import java.awt.*;
import java.io.*;
import java.util.*;

public class StoryClient {

   public static void main (String [] args)throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      ArrayList<Story> storyInfo = new ArrayList<Story>();
      System.out.println("What genre of story do you want? \n(sci-fi/mystery/fantasy/realistic/historical/superhero/any)");
      String genre = console.next();
      boolean more = true;
      while(more){
         userInput(console, storyInfo, genre);
         System.out.println("Do you want more information? (yes/no)");
         String answer = console.next();
         if(answer.charAt(0) != 'y') {
            more = false;
         }
      }
      output(storyInfo, genre);  
   } 
   
   /* @param nothing
   * @return an ArrayList with data given by user in order [genre, inforamtion requseted, character type, gender]
   * takes basic information about what information the user wants and stores it in an ArrayList
   Internal ArrayList infomation:
   0: inforamtion requseted
   1: type of character/ item
   2: gender/ sentiance
   */
   public static void userInput(Scanner console, ArrayList<Story> storyInfo, String genre)throws FileNotFoundException{
      ArrayList<String> userData = new ArrayList<String>(4);
      System.out.println("What infomation do you want? (character/setting/plot/item)");
      userData.add(console.next());
      if(userData.get(0).equals("character")){
         System.out.println("Type? (human/creature)");
         userData.add(console.next());
         System.out.println("Gender? (male/female/either)");
         userData.add(console.next());
      }
      if(userData.get(0).equals("item")){
         System.out.println("What type? (weapon/accessory/pet/random)");
         userData.add(console.next());
         System.out.println("Sentiance? (yes/no)");
         userData.add(console.next());
      }
      System.out.println();
      if(userData.get(0).equals("character")){
         Character a = new Character(userData.get(2), genre, userData.get(1));
         storyInfo.add(a); 
      } 
      else if (userData.get(0).equals("setting")){
         Setting local = new Setting (genre);
         storyInfo.add(local);
      }
      else if (userData.get(0).equals("plot")){
         Plot tale = new Plot ();    
         storyInfo.add(tale);                
      } else if (userData.get(0).equals("item")) {
         Props thing = new Props(genre, userData.get(1), userData.get(2));
         storyInfo.add(thing);
      }
   }
   
   
   
   /* @param the ArrayList of userData containing [genre, info type, type, gender]
   * @return nothing
   * @see prints out heading for all the info collected based on the user input in the ArrayList
   * prints the headings for the info and calls seperate methods to print off the collected data,
   * depending on the category of the information sought
   */
   
   public static void output (ArrayList<Story> info, String genre) {
      System.out.println("Genre: " + genre);
      System.out.println();
      for(int i = 0; i < info.size(); i++) {
         System.out.println(info.get(i));
         System.out.println();
      }
   }
}