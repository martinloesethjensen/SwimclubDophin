import java.util.*;
import java.io.*;

/**               << 1. semester pr�ve eksamen >> 
*
*                          | Projekt |
*                           
* Lavet af:            Sv�mmeklub Delfinen
* @Martin.Valhalla
* @Casper.ortismal
* @Christian.C-Strunge
* @Rasmus.RasmusSadurski
*/

public class SwimClubMain {
   public static void main(String[] args)throws Exception{
     
      int pass = 0;
      
         while (pass != 1) {
             
            System.out.println("Velkommen til svoemmeklubben Delfinen.\n");
            System.out.println("Tast password for at logge ind.\nEllers tast \"exit\" for at afslutte.\nPassword:");           
            Scanner console = new Scanner(System.in);
            String input;
            input = console.next();
            
            switch(input.toUpperCase()) {
            
            case "DELFIN": 
            System.out.println("Korrekt password.\n");
            Thread.sleep(1000);
            login();
            break;
            
            case "EXIT":
            System.out.println("Lukker programmet. Tak for denne gang.");
            Thread.sleep(1000);
            pass = 1;
            break;
            
            default:
            System.out.println("Ugyldigt password. Proev igen.");
            break;
            
            }
         
         
         }
           
      
   }
	
   /**
   * Denne metode opretter et objekt og laver et 
   * metodekald, hvor man kan v�lge hvilken slags ansat 
   * man er. 
   */
   
	public static void login()throws Exception{
      Ansat login = new Ansat();
		login.menu(); //valg af ansat
            
	}
}