import java.util.*;
import java.io.*;

/**
*
* @Martin.Valhalla 
* @Christian.C-Strunge
*/

public class Formand extends Ansat {
   
   int subMenuValg = -1; //bruges i testerInput til aktivitetsform og medlemstype
   
   public Formand(){}

   /*public Formand(String firstName, String lastName, int alder, String aktivitetsForm){
      super(firstName, lastName, alder, aktivitetsForm);
   }*/
     
   
	/**
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
               subMenu();
         }
         break; //for kun at komme ud af dette loop
      }	
	}

   public void subMenuInfo(){
      System.out.println("Tast 1 for at oprette nyt medlem");
      System.out.print("Tast 0 for at gaa tilbage\n<==\n");
   }
      
   /**
   * Opretter og gemmer nyt medlem i en fil
   */
   
   public void opretMedlem(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
         System.out.println("Opret nyt medlem:\n\tTast 1 for at oprette" + 
               "medlem som motionist\n\tTast 2 for at oprette medlem som Konkurrence Svoemmer");
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1:
               System.out.println("Hej1"); 
               opretMotion(console);
               //metode her med valg
               break;
            case 2:
               System.out.println("Hej2");
               break;
            default:
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
      
      Medlem nytMedlem = new Medlem(super.getFornavn(),super.getEfternavn(),super.getAlder(),super.getMedlemsskab());
   }
   
   /**
   * Får user input
   */
   
   public void opretOplysninger(Scanner console){
      
      System.out.println("Indtast fornavn");
      super.setFornavn(console.next());
      System.out.println("Indtast efternavn");
      super.setEfternavn(console.next()); 
      System.out.println("Indtast alder");
      super.setAlder(testConsoleInput(console));
      
   }
   
   /**
   * Vælger medlemstypen
   */
   
   public void medlemsskab(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
         System.out.println("Vaelg medlemstype:\n\tTast 1 for aktiv\n\tTast 2 for passiv"); 
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               super.setMedlemsskab("Aktiv");
               //gem medlem i motionist fil
               System.out.println("Kom ind 1a"); 
               System.out.println(super.getMedlemsskab());  
               dummy = -1;
               break;
               
            case 2:
               super.setMedlemsskab("Passiv");
               //gem medlem i konkurrence svømmer fil
               System.out.println("Kom ind 2a");
               System.out.println(super.getMedlemsskab()); 
               dummy = -1;
               break;
            
            default:
               System.out.println("Tast venligst et nummer der er fremvist");  
               medlemsskab(console); //den kører i infinite loop               
         }
         dummy = -1;
      }    
   }
   
   /**
   * Opdeling i aktivitet.
   * Går i infinte loop hvis man skriver andet end tal***
   */
   
   public void aktivitet(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
         System.out.println("Vaelg aktivitetsform:\n\tTast 1 for Motionist\n\tTast 2 for Konkurrence"); 
         
         testerInput(console);
         
         switch(subMenuValg){
            case 1: 
               //super.setAktivitetsform("Motionist");
               //gem medlem i motionist fil
               System.out.println("Kom ind 1"); 
               //System.out.println(super.getAktivitetsform());  
               super.saveIt("motionister.txt");
               System.out.println("\t...Medlem er gemt...\n");
               dummy = -1;
               break;
               
            case 2:
               //super.setAktivitetsform("Konkurrence");
               //gem medlem i konkurrence svømmer fil
               //System.out.println(super.getAktivitetsform());              
               System.out.println("Kom ind 2");
               super.saveIt("konkurrenceSvoemmere.txt");
               System.out.println("\t...Medlem er gemt...\n");
               dummy = -1;
               break;
            
            default:
               System.out.println("Tast venligst et nummer der er fremvist");  
               aktivitet(console); //den kører i infinite loop               
         }
         subMenu(); //hvor bruges denne? //linje 26
         dummy = -1;
      }    
   }
   public void testerInput(Scanner console){
      int dum = 0;
      int count = 0;
      while(dum == 0){
         if(console.hasNextInt()){
            this.subMenuValg = console.nextInt();
            count++; 
            break;
         }else if(count > 0){
            this.subMenuValg = console.nextInt(); 
            break; 
         }else{ 
            System.out.println("Ugyldigt input");
            this.subMenuValg = -1; //denne er placeret så når man i 
                                  //formand undgår at den automatisk vælger 
                                 //case 1 
            dum = 1; //hopper ud af loopet 
         }          //Denne skal rettes
      }   
   }
}