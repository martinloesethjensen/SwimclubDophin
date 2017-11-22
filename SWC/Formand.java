import java.util.*;
import java.io.*;

/**
*
* @Martin.Valhalla 
* @Christian.C-Strunge
*/

public class Formand extends Ansat {
   
   public Formand(){}
   Scanner console = new Scanner(System.in);

   /*public Formand(String firstName, String lastName, int alder, String aktivitetsForm){
      super(firstName, lastName, alder, aktivitetsForm);
   }*/
     
   
	/**
	* 
	* beskrivelse her
	*/
   
	public void subMenu() {
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
   //Metod der samler den skrevne info i en string
   public String info(){
      return firstName + " " + lastName + " " + alder + " " + aktivitetsForm;
   }
   //Metode til at gemme til fil
   public void saveIt(String filNavn)throws Exception{
      PrintStream newMemberInfo = new PrintStream(new File(filNavn));
      newMemberInfo.print(info() + "/n");
         
   }
   /**
   *
   * Opretter og gemmer nyt medlem i en fil
   */
   public void opretMedlem(Scanner console)throws Exception{
      System.out.println("Indtast fornavn");
      firstName = console.next();
      System.out.println("Indtast efternavn");
      lastName = console.next();
      System.out.println("Indtast alder");
      alder = console.nextInt();
      System.out.println("Vælg aktivitetsform /nTast 1 for Motionist/nTast 2 for Konkurrence"); 
      //få input om medlems info her
       
   }
}