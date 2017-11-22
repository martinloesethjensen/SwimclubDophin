import java.util.*;

/**
*
* @Martin.Valhalla
* @Casper.ortismal
*/

public class Traener extends Ansat {

	
	public int subMenu()throws Exception{
		Scanner console = new Scanner(System.in);
      int menu = -1;
      while (menu != 0){
         traenerMenu();
         
         super.testConsoleInput(console);               
         
         switch(this.menu){
            case 1: printDisciplin(); break;
            case 2: printKandidater(); break;
            case 3: printListe(); break;
            case 0: 
               this.menu = -1; //for at den ikke også hopper ud af ansats menu
               super.menu(); //menu hos ansat
               break;
            default: 
               System.out.println("Tast venligst et nummer der er fremvist");
               subMenu();
         }
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
    
   public void printListe(){
      System.out.println("<==|_Kom_ind_|==>");
   }
}