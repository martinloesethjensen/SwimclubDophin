import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla
* @Casper.ortismal
* @Christian.C-Strunge
*/

public class Traener extends Ansat {
<<<<<<< HEAD
   
   protected int counter = 0;
   
=======

   protected int counter = 0; //Brugt i nyTid()

>>>>>>> 855b50ed3e36437b0dc9bd9b46305ab016a839dd
   /**
   * Beskrivelse her
   */
   
	public int subMenu()throws Exception{
		Scanner console = new Scanner(System.in);
      int menu = -1;
      while (menu != 0){
         traenerMenu();
         
         super.testConsoleInput(console);               
         
         switch(this.menu){
            case 1: printDisciplin(console); break; //tilføj switch
            case 2: printKandidater(); break; //tilføj switch
            case 3: printListe(); break; //printe fra konkurrencesvømmere fil
<<<<<<< HEAD
            //case 4: registrerStaevne(console); break; //tilføjer navn + stævne til fil
=======
            case 4: registrerStaevne(console); break; //tilføjer navn + stævne til fil
>>>>>>> 855b50ed3e36437b0dc9bd9b46305ab016a839dd
            case 5: nyTid(console); break; //Ændrer tid og dato på medlem
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
      
      System.out.printf("%-35s%s\n", "DISCIPLINLISTE M. MEDLEMMER", "TRYK 1");
      System.out.printf("%-35s%s\n", "TOP 5 I VALGT DISCIPLIN", "TRYK 2");
      System.out.printf("%-35s%s\n", "LISTE OVER KONKURRENCESVØMMERE", "TRYK 3");
      System.out.printf("%-35s%s\n", "REDIGER STAEVNEDELTAGERE", "TRYK 4");
      System.out.printf("%-35s%s\n", "OPRET NY BEDSTE TID", "TRYK 5");
      System.out.println();
      System.out.printf("%-35s%s\n", "RETURNER", "TRYK 0");


      
      /*System.out.println("Tast 1 for disciplinliste med tilknyttede medlemmer");
      System.out.println("Tast 2 for top 5 liste over disciplin"); //ændres
      System.out.println("Tast 3 for liste over konkurrencesvoemmere");
      System.out.println("Tast 4 for at registrere deltagelse i staevne");
      System.out.println("Tast 0 for at returnere\n<==");*/ 
   }
   
   /**
   * Beskrivelse her
   */
   
	public void printDisciplin(Scanner console)throws Exception {
      int dummy = 0;
      while(dummy == 0){
         System.out.println("Vaelg discipling:\n\tTast 1 for crawl\n\tTast 2 for rygcrawl\n\tTast 3 for " 
                                  +"butterfly\n\tTast 4 for brystsvoemning\n\tTast 5 for hundesvoemning"); 
         
         super.testConsoleInput(console);
         
         String fileName;
         
         switch(this.menu){
            case 1: 
               super.setDisciplin("Crawl");
               fileName = "crawl.txt";
               openFile(fileName);               
               break;   
            case 2:
               super.setDisciplin("Rygcrawl");
               fileName = "rygcrawl.txt";
               openFile(fileName);
               break;
            case 3:
               super.setDisciplin("Butterfly");
               fileName = "butterfly.txt";
               openFile(fileName);
               break;
            case 4:
               super.setDisciplin("Brystsvoemning");
               fileName = "brystsvoemning.txt";
               openFile(fileName);
               break;
            case 5:
               super.setDisciplin("Hundesvoemning");
               fileName = "hundesvoemning.txt";
               openFile(fileName);
               break;
            default:
               System.out.println("Tast venligst et nummer der er fremvist");            
               printDisciplin(console); //den kører i infinite loop               
         }
         
         //prompter om forsættelse
         fortsaettelse(console);
                  
         dummy = -1;//kommer ud af whileloop 
      }     
	}
   
   /**
   * prompter om fortsættelse her
   */
   
   public void fortsaettelse(Scanner console)throws Exception{
      int dummy = 0;
      
      while(dummy == 0){
         System.out.println("Tast 1 for at print endnu en liste\nTast 0 for at returnere\n<==");
            
         super.testConsoleInput(console);
            
         switch(this.menu){
            case 1:
               printDisciplin(console);
               break;
            
            case 0:
               subMenu();
               break;
            
            default:
               System.out.println("Tast venligst et nummer der er fremvist");   
               fortsaettelse(console);   
         }
         dummy = -1;
      }
   }
   
   /**
   * Beskrivelse her
   */
   
   public void openFile(String fileName)throws Exception{
      Scanner scanFile = new Scanner(new File(fileName));
      
      System.out.printf("%-10s %-10s %-7s %-11s %-15s %-11s %-10s\n", "Fornavn", "Efternavn", "Alder", "Medlemsskab", "Disciplin", "Tid", "Dato");
      System.out.println("------------------------------------------------------------------");
      
      while(scanFile.hasNextLine()){
         
         String fornavn = scanFile.next();
         String efternavn = scanFile.next();
         int alder = scanFile.nextInt();
         String medlemsskab = scanFile.next();
         String disciplin = scanFile.next();
         String tid = scanFile.next();
         String dato = scanFile.next();
         
         System.out.printf("%-10s %-10s %-7d %-11s %-11s %s %s\n", fornavn, efternavn, alder, medlemsskab, disciplin, tid, dato);
         System.out.println(scanFile.nextLine() + "  ");
         
      }
      System.out.println();
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
       Scanner konkurrence = new Scanner(new File("konkurrenceSvoemmere.txt")); 
      
       System.out.printf("%-10s %-10s %-7s %-11s %-15s %-15s %-10s\n", "Fornavn", "Efternavn", "Alder", "Medlemskab", "Disciplin", "Tid", "Dato");
       System.out.println("----------------------------------------------------------------------------------");
      
       while(konkurrence.hasNextLine()){
         
          String fornavn = konkurrence.next();
          String efternavn = konkurrence.next();
          int alder = konkurrence.nextInt();
          String medlemskab = konkurrence.next();
          String disciplin = konkurrence.next();
          String tid = konkurrence.next();
          String dato = konkurrence.next();
         
          System.out.printf("%-10s %-10s %-7d %-11s %-15s %-15s %-10s\n", fornavn, efternavn, alder, medlemskab, disciplin, tid, dato);
          System.out.println(konkurrence.nextLine() + "  ");
         
       }
       System.out.println();
       subMenu();
<<<<<<< HEAD
    } 
=======
    }
>>>>>>> 855b50ed3e36437b0dc9bd9b46305ab016a839dd
    
    public int count()throws Exception{
      Scanner scanFil = new Scanner(new File("konkurrenceSvoemmere.txt"));  
      //Printf
      while(scanFil.hasNextLine()){
         this.counter++;
         System.out.println(this.counter + " " + scanFil.nextLine());
      }
      return this.counter;
    }
    
    public void nyTid(Scanner console)throws Exception{
      Scanner scanKonk = new Scanner(new File("konkurrenceSvoemmere.txt"));  
      count();
      String konkurrenceArray[][] = new String[this.counter][7];
      
      while(scanKonk.hasNext()){
         for(int i = 0; i < this.counter; i++){
            for(int j = 0; j < 7; j++){
            String item = scanKonk.next();
            konkurrenceArray[i][j] = item;
            }
         }
      }
      System.out.println("TAST NUMMER PAA MEDLEM DU OENSKER AT OPDATERE");
      int num = console.nextInt(); //Check vaerdi
      
      System.out.println("INDTAST NY TID");
      super.setTid(console.nextDouble());
      double tidRet = super.getTid();
      String rettet = String.valueOf(tidRet);
      konkurrenceArray[num-1][5] = rettet;
      
      System.out.println("INDTAST NY DATO");
      super.setDato(console.next());
      konkurrenceArray[num-1][6] = super.getDato();
      
      //Overskriver plads i eksisterende fil
      PrintStream addChange = new PrintStream(new File("konkurrenceSvoemmere.txt"));
      for(int i = 0; i < this.counter; i++){
         addChange.println(konkurrenceArray[i][0] + " " + konkurrenceArray[i][1] + " " 
         + konkurrenceArray[i][2] + " " + konkurrenceArray[i][3] + " " 
         + konkurrenceArray[i][4] + " " + konkurrenceArray[i][5] + " " 
         + konkurrenceArray[i][6]);
      }
      //clean up
      scanKonk.close();
      subMenu();
<<<<<<< HEAD
   }     
=======
   }   
  
>>>>>>> 855b50ed3e36437b0dc9bd9b46305ab016a839dd
    
   /**
   *Beskrivelse
   */
    
   /*public void registrerStaevne(Scanner console)throws Exception{
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
   
   /*public void saveToFile(Formand refMetode)throws Exception{
      switch(refMetode.getDisciplin()){
         case "Crawl":
            Crawl gemCrawl = new Crawl(super.getFornavn(),super.getEfternavn(), super.getStaevneNavn(), super.getStaevneTid(), super.getPlacering(), refMetode.getDisciplin());
            break;
         case "Brystsvoemning":
            Brystsvoemning gemBrystsvoemning = new Brystsvoemning(super.getFornavn(),super.getEfternavn(), super.getStaevneNavn(), super.getStaevneTid(), super.getPlacering(), refMetode.getDisciplin());
            break;
         case "Rygcrawl":
            Rygcrawl gemRygcrawl = new Rygcrawl(super.getFornavn(),super.getEfternavn(), super.getStaevneNavn(), super.getStaevneTid(), super.getPlacering(), refMetode.getDisciplin());
            break;
         case "Butterfly":
            Butterfly gemButterfly = new Butterfly(super.getFornavn(),super.getEfternavn(), super.getStaevneNavn(), super.getStaevneTid(), super.getPlacering(), refMetode.getDisciplin());
            break;
         case "Hundesvoemning":
            Hundesvoemning geHundesvoemning = new Hundesvoemning(super.getFornavn(),super.getEfternavn(), super.getStaevneNavn(), super.getStaevneTid(), super.getPlacering(), refMetode.getDisciplin());
            break;   
         default:
            break;
      }
   }*/
}