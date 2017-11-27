import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla 
* @Christian.C-Strunge
*/

public class Formand extends Ansat {
     
   //default constructor
   public Formand(){}
   
	/**
	* sub menu hvor man kan oprette et nyt medlem eller retunere til menu
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
               subMenu();
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
      System.out.printf("%-30s%s\n", "OPRET NYT MEDLEM", "TRYK 1");
      System.out.printf("%-30s%s\n", "RETURNER TIL MENU", "TRYK 0");
   }
      
   /**
   * Opretter og gemmer nyt medlem i en fil
   */
   
   public void opretMedlem(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
         System.out.printf("%-30s%s\n%-30s%s", "OPRET MOTIONIST", "TRYK 1", "OPRET KONKURRENCESVOEMMER", "TRYK 2\n");
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1:
               opretMotion(console);
               break;
            case 2:
               opretKonkurrenceSvoemmer(console);
               break;
            default:
               System.out.println("Tast venligst et nummer der er fremvist");
               opretMedlem(console);
         }
         dummy = 1;   
      }      
   }
   
   /**
   * Opretter motionist medlem
   */
   
   public void opretMotion(Scanner console)throws Exception{
      opretOplysninger(console);
      
      medlemsskab(console);
      
      //opretter et objekt med parameter
      Motionist nytMedlem = new Motionist(super.getFornavn(),super.getEfternavn(),super.getAlder(),super.getMedlemsskab());
   }
   
   /**
   * Opretter motionist medlem
   */
   
   public void opretKonkurrenceSvoemmer(Scanner console)throws Exception{
      opretOplysninger(console);
      
      medlemsskab(console);
      
      vaelgDisciplin(console);
      
      
      //tid i min?
      
      //set tid til 0.0, da det er et nyt medlem og har derfor ikke nogle 
      //tider på disciplinen
      setTid(0.0);
      
      //switch med gem til flere filer (disciplin)
      
      
      KonkurrenceSvoemmer nytMedlem = new KonkurrenceSvoemmer(super.getFornavn(),super.getEfternavn(),super.getAlder(),super.getMedlemsskab(), super.getDisciplin(), super.getTid());
   
   }
   
   /**
   * Får user input
   */
   
   public void opretOplysninger(Scanner console){
      
      System.out.println("INDTAST FORNAVN:");
      super.setFornavn(console.next());
      System.out.println("INDTAST EFTERNAVN");
      super.setEfternavn(console.next()); 
      System.out.println("INDTAST ALDER");
      
      /*super.testConsoleInput(console);
      
      while(true){
         if (this.menu > 0)
            this.alder
            
      }*/
      super.setAlder(super.testConsoleInput(console));
      
   }
   
   public void vaelgDisciplin(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
          
         System.out.printf("%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s\n", "CRAWL", "TRYK 1", "RYGCRAWL",
          "TRYK 2", "BRYSTSVØMNING", "TAST 3",
           "BUTTERFLY", "TAST 4", "HUNDESVØMNING", "TAST 5");
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               super.setDisciplin("Crawl");
               break;   
            case 2:
               super.setDisciplin("Rygcrawl");
               break;
            case 3:
               super.setDisciplin("Butterfly");
               break;
            case 4:
               super.setDisciplin("Brystsvoemning");
               break;
            case 5:
               super.setDisciplin("Hundesvoemning");
               break;
            default:
               System.out.println("Tast venligst et nummer der er fremvist");            
               vaelgDisciplin(console); //den kører i infinite loop               
         }
         dummy = -1;//kommer ud af whileloop 
      }    
   }
   
   /**
   * Vælger medlemstypen
   */
   
   public void medlemsskab(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
         System.out.printf("%s\n%-30s%s\n%-30s%s", "VAELG MEDLEMSTYPE", "AKTIV", "TRYK 1", "PASSIV", "TRYK 2\n"); 
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               super.setMedlemsskab("Aktiv");
               break;
            case 2:
               super.setMedlemsskab("Passiv");
               break;
            default:
               System.out.println("Tast venligst et nummer der er fremvist");  
               medlemsskab(console); //den kører i infinite loop               
         }
         dummy = -1;
      }    
   }
}