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
     
      int pass = 0;
      
         while (pass != 1) {
             
            System.out.println("Velkommen til svoemmeklubben Delfinen. Indtast kode:\n");           
            Scanner console = new Scanner(System.in);
            String input;
            input = console.next();
            
            switch(input) {
            
            case "Delfin": 
            System.out.println("Korrekt password.\n");
            Thread.sleep(2000);
            login();
            break;
            
            default:
            System.out.println("Ugyldigt password. Proev igen");
            break;
            
            }
         
         pass = 1;
         }
           
      
   }
	
   /**
   * Denne metode opretter et objekt og laver et 
   * metodekald, hvor man kan vælge hvilken slags ansat 
   * man er. 
   */
   
	public static void login()throws Exception{
      Ansat login = new Ansat();
		login.menu(); //valg af ansat
            
	}
}