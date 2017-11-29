import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla
* @Casper.ortismal
* @Christian.C-Strunge
*/

public class Traener extends Ansat {

   protected int counter = 0; //Brugt i nyTid()

   //default constructor
	public Traener(){}
   
   
   //constructor der tager imod parametre  
   public Traener(String fornavn, String efternavn, int alder, String medlemsskab, String disciplin, double tid, String dato){
      super.setFornavn(fornavn);
      super.setEfternavn(efternavn);
      super.setAlder(alder);
      super.setMedlemsskab(medlemsskab);
      super.setDisciplin(disciplin);
      super.setTid(tid);
      super.setDato(dato);
   }
   
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
            case 1: printDisciplin(console); break; //tilføj switch
            case 2: printKandidater(); break; //tilføj switch
            case 3: printListe(); break; //printe fra konkurrencesvømmere fil
            case 4: registrerStaevne(console); break; //tilføjer navn + stævne til fil
            case 5: nyTid(console); break; //Ændrer tid og dato på medlem
            case 0: 
               this.menu = -1; //for at den ikke også hopper ud af ansats menu
               super.menu();  //menu hos ansat
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
   }
   
   /**
   * Metode der scanner fil og putter værdierne ind i et object hvor så dette obekt gemmes i en ArrayList
   */
   
	public void printDisciplin(Scanner console)throws Exception {
      Scanner scanKonkurrence = new Scanner(new File("konkurrenceSvoemmere.txt"));
      
      int count = -1; //en count der bruges i switch om hvilken disciplin der skal printes for 
       
      //initialisere et ArrayList med Traener objekt 
      List<Traener> print = new ArrayList<>();
      while(scanKonkurrence.hasNextLine()){
         String line = scanKonkurrence.nextLine();
         Scanner token = new Scanner(line);
         
         String fornavn = token.next();
         super.setFornavn(fornavn);
         
         String efternavn = token.next();
         super.setEfternavn(efternavn);
         
         int alder = token.nextInt();
         super.setAlder(alder);
         
         String medlemsskab = token.next();
         super.setMedlemsskab(medlemsskab);
         
         String disciplin = token.next();
         super.setDisciplin(disciplin);
         
         String tid = token.next();
         double tTid = Double.valueOf(tid); //returnere String repræsentationen af en double
         super.setTid(tTid);
         
         String dato = token.next();
         super.setDato(dato);
         
         //spørger om hvilken disciplin der skal printes
         if(count == -1){
            System.out.println("Vaelg discipling:\n\tTast 1 for crawl\n\tTast 2 for rygcrawl\n\tTast 3 for " 
                                  +"butterfly\n\tTast 4 for brystsvoemning\n\tTast 5 for hundesvoemning"); 
            super.testConsoleInput(console);
            count++;//increment
         }
         //sammenlign og print medlem hvis dette eksistere for det pågældende medlem 
         switch(this.menu){
            case 1: 
               if(disciplin.equals("Crawl")){
                  System.out.println(line.toString());
                  count++;
               }
               break;   
            case 2:
               if(disciplin.equals("Rygcrawl")){
                  System.out.println(line.toString());
                  count++;
               }
               break;
            case 3:
               if(disciplin.equals("Butterfly")){
                  System.out.println(line.toString());
                  count++;
               }
               break;
            case 4:
               if(disciplin.equals("Brystsvoemning")){
                  System.out.println(line.toString());
                  count++;
               }
               break;
            case 5:
               if(disciplin.equals("Hundesvoemning")){
                  System.out.println(line.toString());
                  count++;
               }
               break;
            default:
               System.out.println("Tast venligst et nummer der er fremvist");            
               printDisciplin(console); //den kører i infinite loop               
         }
         
         //tilføjer traener objekt til arraylist
         Traener traen = new Traener(super.getFornavn(),super.getEfternavn(),super.getAlder(),super.getMedlemsskab(),super.getDisciplin(),super.getTid(),super.getDato());
         print.add(traen);
      
      }
      
      if (count == 0)System.out.println("Ingen medlem(er) er tilknyttet disciplin");
     
      System.out.println();
      //prompter om fortsættelse
      fortsaettelse(console);
	}
   
   //tostring metode skal have printf så den efterligner et udprint der er formateret pænt
   @Override
   public String toString(){
      return super.getFornavn()+" "+super.getEfternavn()+" "+super.getAlder()+" "
                           +super.getMedlemsskab()+" "+super.getDisciplin()+" "+
                                         super.getTid()+" "+super.getDato();
   
   } 
   
   /**
   * prompter om fortsættelse
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
   * Bruges ikke, men pricinppet kan bruges i flere udprint metoder 
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
   * UC004 top 5
   */
   
   public void printKandidater(){
      System.out.println("<==|_Kom_ind_|==>");
   }

   /**
   * Printer liste over alle konkurrencesvoemmere
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

    } 
    
    /**
    * Beskrivelse her
    */
    
    public int count()throws Exception{
      Scanner scanFil = new Scanner(new File("konkurrenceSvoemmere.txt"));  
      //Printf så det ser pænt og formateret ud 
      while(scanFil.hasNextLine()){
         this.counter++;
         System.out.println(this.counter + " " + scanFil.nextLine());
      }
      return this.counter;
    }
    
    /**
    * Beskrivelse her
    */ 
    
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
      //returnere String repræsentationen af en double
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
   }     
    
   /**
   * Sætter input værdierne i setterne
   */
    
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
      
      System.out.println("...Medlem gemt i Staevneliste...\n\n");
      
      subMenu();
   }
   
   /**
   * gemmer oplysninger i fil
   */
   
   public void saveToFile(Formand refMetode)throws Exception{
      PrintStream nytMemberInfo = new PrintStream(new FileOutputStream("staevneliste.txt",true));
      nytMemberInfo.println(toStringStaevne());
      System.out.print("\n"); 
   }
   
   /**
   * En toString metodde for registrerStaevne metode
   */
   
   public String toStringStaevne(){
      return super.getFornavn()+" "+super.getEfternavn()+" "+super.getStaevneNavn()+" "+super.getStaevneTid()+" "+super.getPlacering();
   }
}