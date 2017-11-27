import java.util.*;
import java.io.*;

/**               << 1. semester prøve eksamen >> 
*
*                          | Projekt |
*                           
* Lavet af:            Svømmeklub Delfinen
* @Martin.Valhalla
* @Casper.ortismal
* @Christian.C-Strunge
* @Rasmus.RasmusSadurski
*/

public class SwimClubMain {
   public static void main(String[] args)throws Exception{
      
      logon();     
      
   }
   
   public static void logon()throws Exception{
      Scanner console = new Scanner(System.in);
      int pass = 0;
      
      System.out.println("Velkommen til svoemmeklubben Delfinen.\n");
      
      while (pass != 1) {
             
         System.out.println("Tast password for at logge ind.\nEllers tast \"exit\" for at afslutte.\nPassword:");           
         
         String input = console.next().toUpperCase();
            
         switch(input) {
            case "DELFIN": 
               System.out.println("Korrekt password.\n");
               Thread.sleep(1000);
               bruger();
               break;
            
            case "EXIT":
               System.out.println("Lukker programmet. Tak for denne gang.");
               Thread.sleep(1000);
               pass = 1;
               break;
            
            default:
               System.out.println("Ugyldigt password. Proev igen.\n");
               logon(); 
         }
         pass = 1;
      }
   }
	
   /**
   * Denne metode opretter et objekt og laver et 
   * metodekald, hvor man kan vælge hvilken slags ansat 
   * man er. 
   */
   
	public static void bruger()throws Exception{
      Ansat login = new Ansat();
		login.menu(); //valg af ansat
            
	}
}