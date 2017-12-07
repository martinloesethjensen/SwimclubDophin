    import java.util.*;

/**
* @Martin.Valhalla 
* @Christian.C-Strunge
*
* subMenu()                  linje 27
* subMenuInfo()              linje 52
* opretMedlem()              linje 61
* opretMotion()              linje 87
* opretKonkurrenceSvoemmer() linje 100
* opretOplysninger           linje 119
* vaelgDisciplin()           linje 136
* medlemsskab()              linje 173
* 
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
         
         super.testConsoleInput(console); //metode i ansat
         
         switch(this.menu){
            case 1: 
               opretMedlem(console); //linje 61
               subMenu();
               break;
            case 0: 
               this.menu = -1; //for at den ikke også hopper ud af ansats menu
               super.menu(); //menu hos ansat
               break;
            default: 
               System.out.println("Tast venligst et nummer der er fremvist");
               subMenu(); //linje 27
         }
         break; //for kun at komme ud af dette loop
      }	
	}

   public void subMenuInfo(){
      System.out.printf("%-30s%s\n", "OPRET NYT MEDLEM", "TAST 1");
      System.out.printf("%-30s%s\n", "RETURNER TIL MENU", "TAST 0");
   }
      
   /**
   * Opretter og gemmer nyt medlem i en fil
   */
   
   public void opretMedlem(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
         System.out.printf("%-30s%s\n%-30s%s", "OPRET MOTIONIST", "TAST 1", "OPRET KONKURRENCESVOEMMER", "TAST 2\n");
         
         super.testConsoleInput(console); //metode i ansat linje 86
         
         switch(this.menu){
            case 1:
               opretMotion(console); //linje 87
               break;
            case 2:
               opretKonkurrenceSvoemmer(console); //linje 100
               break;
            default:
               System.out.println("Tast venligst et nummer der er fremvist");
               opretMedlem(console); //linje 61
         }
         dummy = 1;   
      }      
   }
   
   /**
   * Opretter motionist medlem
   */
   
   public void opretMotion(Scanner console)throws Exception{
      opretOplysninger(console); //linje 119
      
      medlemsskab(console); //linje 163
      
      //opretter et objekt med parameter
      Motionist nytMedlem = new Motionist(getFornavn(),getEfternavn(),getAlder(),getMedlemsskab());
   }
   
   /**
   * Opretter konkurrence medlem
   */
   
   public void opretKonkurrenceSvoemmer(Scanner console)throws Exception{
      opretOplysninger(console); //linje 119
      
      medlemsskab(console); //linje 163
      
      //udfylder nogle placholdere der bl.a. ændres i traener i nyTid()
      setTid(0.0);
      setDato("00/00/00");
      
      vaelgDisciplin(console); //linje 126
      
      KonkurrenceSvoemmer nytMedlem = new KonkurrenceSvoemmer(getFornavn(),getEfternavn(),
                           getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
   }
   
   /**
   * Får user input
   */
   
   public void opretOplysninger(Scanner console){
      
      System.out.println("INDTAST FORNAVN:");
      setFornavn(console.next());
      System.out.println("INDTAST EFTERNAVN");
      setEfternavn(console.next()); 
      System.out.println("INDTAST ALDER");
      
      //tester om den alder alder man indtaster er et tal
      setAlder(super.testConsoleInput(console));
      
   }
   
   /**
   * metode der lader brugeren vælge disciplin
   */
   
   public void vaelgDisciplin(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
          
         System.out.printf("%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s\n", "CRAWL", "TAST 1", "RYGCRAWL",
          "TAST 2", "BRYSTSVOEMNING", "TAST 3",
           "BUTTERFLY", "TAST 4", "HUNDESVOEMNING", "TAST 5");
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               setDisciplin("Crawl");
               break;   
            case 2:
               setDisciplin("Rygcrawl");
               break;
            case 3:
               setDisciplin("Butterfly");
               break;
            case 4:
               setDisciplin("Brystsvoemning");
               break;
            case 5:
               setDisciplin("Hundesvoemning");
               break;
            default:
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");            
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
         System.out.printf("%s\n%-30s%s\n%-30s%s", "VAELG MEDLEMSTYPE", "AKTIV", "TAST 1", "PASSIV", "TAST 2\n"); 
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               setMedlemsskab("Aktiv");
               break;
            case 2:
               setMedlemsskab("Passiv");
               break;
            default:
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");            
               medlemsskab(console); //den kører i infinite loop               
         }
         dummy = -1;
      }    
   }
}