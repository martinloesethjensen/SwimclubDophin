import java.util.*;
import java.io.*;

/**
*
* @Martin.Valhalla 
* @Christian.C-Strunge
*/

public class Formand extends Ansat {
   
   public Formand(){}
   
   /*public Formand(String firstName, String lastName, int alder, String aktivitetsForm){
      super(firstName, lastName, alder, aktivitetsForm);
   }*/
     
   
	/**
	* 
	* beskrivelse her
	*/
   
	public void subMenu() {
	   Scanner console = new Scanner(System.in);
      int menu = -1;
      while(menu != 0){
         subMenuInfo();
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               //if else 
               //om det er konkurrence svømmer eller motion
               //gem i fil dertil
               //... break;
            case 0: 
               Ansat a = new Ansat();
               a.menu();
               break;
            default: 
               System.out.println("Tast venligst et nummer der er fremvist");
               subMenu();
         }
      }	
	}

   public void subMenuInfo(){
      System.out.println("Tast 1 for at oprette nyt medlem");
      System.out.print("Tast 0 for at gaa tilbage\n<==");
   }
   
   /**
   *
   * Opretter og gemmer nyt medlem i en fil
   */
   public void opretMedlem(String fileName)throws Exception{
      //få input om medlems info her
      PrintStream toFile = new PrintStream(new File(fileName));
      //toFile.print(info());  
   }
   /*public String info(){
      return firstName + " " + lastName + " " + alder + " " + aktivitetsForm;
   }*/

}