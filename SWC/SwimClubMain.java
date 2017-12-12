import java.util.*;

/**               << 1. semester prøve eksamen >> 
*
*                         DAT17C - KEA
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
   
   /*
   * Når programmet startes prompter systemet for et korrekt password.
   * Hvis dette bliver indtastet, vil systemet fortsaette til de ansattes login-side.
   */
   
   public static void logon()throws Exception{
      Scanner console = new Scanner(System.in);
      int pass = 0;
      
      System.out.println("VELKOMMEN TIL SVOEMMEKLUBBEN DELFINEN\n");
      
      while (pass != 1) {
             
         System.out.print("TAST PASSWORD FOR AT LOGGE IND\nELLERS TAST \"EXIT\" FOR AT AFSLUTTE\nPASSWORD:\t");           
         
         String input = console.next().toUpperCase();
         
         System.out.println(); 
            
         switch(input) {
            case "DELFIN": 
               System.out.println("KORREKT PASSWORD\n");
               Thread.sleep(500); //en timer .5 sek
               bruger();
               break;
            
            case "EXIT":
               System.out.println("LUKKER PROGRAMMET\n\nTAK FOR DENNE GANG");
               Thread.sleep(500);
               pass = 1;
               break;
            
            default:
               System.out.println("UGYLDIGT PASSWORD\nPROEV IGEN\n");
               logon();
               pass = 1;
         }
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