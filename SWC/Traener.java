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
            case 4: registrerStaevne(console); break; //tilføjer navn + stævne til fil
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
      System.out.println("Tast 4 for at registrere deltagelse i stævne");
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
      subMenu();
   }
   
   //Beskrivelse
   
   public void registrerStaevne(Scanner console)throws Exception{
      System.out.println("Indtast fornavn");
      super.setFornavn(console.next());
      System.out.println("Indtast efternavn");
      super.setEfternavn(console.next());
      System.out.println("Indtast staevnenavn");
      super.setStaevneNavn(console.next());
      System.out.println("Indtast bedste staevnetid");
      super.setStaevneTid(console.nextDouble());
      System.out.println("Indtast placering");
      super.setPlacering(console.nextInt());
      
      //valg af disciplin
      Formand refMetode = new Formand();
      refMetode.vaelgDisciplin(console);
      
      saveToFile(refMetode);
      
      subMenu();
   }
   
   /**
   * Den laver et metodekald på vaelgDisciplin i formand klasse
   * og sammenligner Disciplin.
   * Udføre den pågælende case for disciplinen.
   */
   
   public void saveToFile(Formand refMetode)throws Exception{
      switch(refMetode.getDisciplin()){
         case "Crawl":
            Crawl save = new Crawl(super.getFornavn(),super.getEfternavn(), super.getStaevneNavn(), super.getStaevneTid(), super.getPlacering(), refMetode.getDisciplin());
            break;
         default:
            break;
      }
   }
   
   /**
   * Læser fra fil ... Tilføj når metode er færdig 
   * Ikke færdig
   */
   public void transferToList(String fileName)throws Exception{
      Scanner oldFile = new Scanner(new File(fileName));
      
      while(oldFile.hasNextLine()){
         this.count++;
         if(oldFile.nextLine() == null)
            break;
      } 
      
      System.out.println(this.count);
      
      
      String medlemmer[][] = new String[this.count][5];
      
      //skal initialisere ny scanner fordi får kørt et while loop til at counte
      //så den skal have initialiseret en ny scanner til samme fil.
      Scanner oF = new Scanner(new File(fileName));
      while(oF.hasNext()){
         for(int i = 0; i < this.count; i++){
            for(int j = 0; j < 5; j++){
               String item = oF.next();
               medlemmer[i][j] = item;
            } 
         }
         break;
      }
      for(int i = 0; i < this.count; i++){
         
      }
   }
}