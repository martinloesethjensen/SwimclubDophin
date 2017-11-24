import java.util.*;
import java.io.*;

/**
*
* @Martin.Valhalla
* @Casper.ortismal
*/

public class Traener extends Ansat {

	/**
   * beskrivelse her
   */
	public int subMenu()throws Exception{
		Scanner console = new Scanner(System.in);
      int menu = -1;
      while (menu != 0){
         traenerMenu();
         
         super.testConsoleInput(console);               
         
         switch(this.menu){
            case 1: printDisciplin(); break; //tilføj switch
            case 2: printKandidater(); break; //tilføj switch
            case 3: printListe(); break; //printe fra konkurrencesvømmere fil
            case 0: 
               this.menu = -1; //for at den ikke også hopper ud af ansats menu
               super.menu(); //menu hos ansat
               break;
            default: 
               System.out.println("Tast venligst et nummer der er fremvist");
               subMenu();
         }
         break;
      }
      return 0;            
	}
   
   public void traenerMenu(){
      System.out.println("Tast 1 for disciplinliste med tilknyttede medlemmer");
      System.out.println("Tast 2 for top 5 liste over disciplin"); //ændres
      System.out.println("Tast 3 for liste over konkurrencesvoemmere");
      System.out.println("Tast 0 for at gaa tilbage\n<=="); 
   }
   
   /**
   * Beskrivelse her
   */
   
	public void printDisciplin(){
		System.out.println("<==|_Kom_ind_|==>");
      //switch
	}
   
   /**
   * Beskrivelse her
   */
   
   public void printKandidater(){
      System.out.println("<==|_Kom_ind_|==>");
      //switch
   }

   /**
   * Beskrivelse her
   */  
    
   public void printListe()throws Exception{
      System.out.println("<==|_Kom_ind_|==>");
      transferToList("konkurrenceSvoemmere.txt");
   }
   
   /**
   * Læser fra fil ... Tilføj når metode er færdig 
   * Ikke færdig
   */
   public void transferToList(String fileName)throws Exception{
      Scanner oldFile = new Scanner(new File(fileName));
      ArrayList<String> liste = new ArrayList<>(); 
      int i = 0;
      while(oldFile.hasNextLine()){
         while(oldFile.hasNext()){
            liste.add(oldFile.next());
            System.out.println("kom ind her arr");
            System.out.println(liste.get(i));
            i++;
         }
      }
      //clean-up
      oldFile.close();
      
      System.out.println(liste);
   }
}