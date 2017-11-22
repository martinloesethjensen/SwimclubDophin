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
   
	public void subMenu()throws Exception{
      Scanner console = new Scanner(System.in);
      int menu = -1;
      while(menu != 0){
         subMenuInfo();
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               opretMedlem(console);
               
               //if else 
               //om det er konkurrence svømmer eller motion
               //gem i fil dertil
               menu = 0;
               break;
            case 0: 
               this.menu = -1; //for at den ikke også hopper ud af ansats menu
               super.menu(); //menu hos ansat
               break;
            default: 
               System.out.println("Tast venligst et nummer der er fremvist");
               subMenu();
         }
         break; //for kun at komme ud af dette loop
      }	
	}

   public void subMenuInfo(){
      System.out.println("Tast 1 for at oprette nyt medlem");
      System.out.print("Tast 0 for at gaa tilbage\n<==\n");
   }
   //Metod der samler den skrevne info i en string
   /*public String info(){
      return super.firstName + " " + super.lastName + " " + super.alder + " " + super.aktivitetsform;
   }
   //Metode til at gemme til fil
   public void saveIt(String filNavn)throws Exception{
      PrintStream newMemberInfo = new PrintStream(new File(filNavn));
      newMemberInfo.print(info() + "/n");
         
   }*/
   
   /**
   * Opretter og gemmer nyt medlem i en fil
   */
   
   public void opretMedlem(Scanner console)throws Exception{
      System.out.println("Indtast fornavn");
      super.setFirstName(console.next());// = console.next();
      System.out.println("Indtast efternavn");
      super.setLastName(console.next()); //= console.next();
      System.out.println("Indtast alder");
      super.setAlder(console.nextInt()); //= console.nextInt();
      
      aktivitet(console);
        
   }
   
   /**
   * Opdeling i aktivitet.
   * Går i infinte loop hvis man skriver andet end tal
   */
   public void aktivitet(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
         System.out.println("Vaelg aktivitetsform:\n\tTast 1 for Motionist\n\tTast 2 for Konkurrence"); 
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               super.setAktivitetsform("Motionist");
               //gem medlem i motionist fil
               System.out.println("Kom ind 1"); 
               System.out.println(super.getAktivitetsform());  
               dummy = -1;
               break;
               
            case 2:
               super.setAktivitetsform("Konkurrence");
               //gem medlem i konkurrence svømmer fil
               System.out.println(super.getAktivitetsform());              
               System.out.println("Kom ind 2");
               dummy = -1;
               break;
            
            default:
               System.out.println("Tast venligst et nummer der er fremvist");  
               aktivitet(console); //den kører i infinite loop               
         }
         subMenu();
         dummy = -1;
      }    
   }
}