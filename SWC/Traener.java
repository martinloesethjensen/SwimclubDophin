import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla
* @Casper.ortismal
* @Christian.C-Strunge
*/

//FORKLAR OM COMPARABLE
public class Traener extends Ansat implements Comparable<Traener>{

   protected int counter = 0; //Brugt i nyTid()
   protected int fort = 0; //bruges i forsættelse om top 5 udprint

   //default constructor
   public Traener(){}
   
   //constructor der tager imod parametre  
   public Traener(String fornavn, String efternavn, int alder, String medlemsskab, String disciplin, double tid, String dato){
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setAlder(alder);
      setMedlemsskab(medlemsskab);
      setDisciplin(disciplin);
      setTid(tid);
      setDato(dato);
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
            case 1: printDisciplin(console); break;
            case 2: printKandidater(console); break;
            case 3: printListe(); break; //printe fra konkurrencesvømmere fil
            case 4: registrerStaevne(console); break; //tilføjer navn + stævne til fil
            case 5: nyTid(console); break; //Ændrer tid og dato på medlem
            case 6: printStaevne(console); break;//Printer liste(Staevne)
            case 7: juniorSenior(); break;
            case 0: 
               this.menu = -1; //for at den ikke også hopper ud af ansats menu
               super.menu();  //menu hos ansat
               break;
            default: 
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");
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
      System.out.printf("%-35s%s\n", "OPRET NY STAEVNEDELTAGER", "TRYK 4");
      System.out.printf("%-35s%s\n", "OPRET NY BEDSTE TID", "TRYK 5");
      System.out.printf("%-35s%s\n", "PRINT STAEVNELISTE", "TRYK 6");
      System.out.printf("%-35s%s\n", "PRINT JUNIOR/SENIOR-HOLD", "TRYK 7");
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
         setFornavn(fornavn);
         
         String efternavn = token.next();
         setEfternavn(efternavn);
         
         int alder = token.nextInt();
         setAlder(alder);
         
         String medlemsskab = token.next();
         setMedlemsskab(medlemsskab);
         
         String disciplin = token.next();
         setDisciplin(disciplin);
         
         String tid = token.next();
         double tTid = Double.valueOf(tid); //returnere String repræsentationen af en double
         setTid(tTid);
         
         String dato = token.next();
         setDato(dato);
         
         //spørger om hvilken disciplin der skal printes
         if(count == -1){
            System.out.printf("%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n", "CRAWL", "TRYK 1","RYGCRAWL","TRYK 2","BUTTERLFY","TRYK 3","BRYSTSVOEMNING","TRYK 4","HUNDESVOEMNING","TRYK 5");
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
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");            
               printDisciplin(console); //den kører i infinite loop               
         }
         
         //tilføjer traen objekt til arraylist
         Traener traen = new Traener(getFornavn(),getEfternavn(),getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
         print.add(traen);
      
      }
      
      if (count == 0)System.out.println("INGEN MEDLEM(ER) ER TILKNYTTET DISCIPLIN");
     
      System.out.println();
      //prompter om fortsættelse
      fortsaettelse(console);
   }
   
   //tostring metode skal have printf så den efterligner et udprint der er formateret pænt
   @Override
   public String toString(){
      return getFornavn()+" "+getEfternavn()+" "+getAlder()+" "
                           +getMedlemsskab()+" "+getDisciplin()+" "+
                                         getTid()+" "+getDato();
   
   } 
   
   //beskrivelse her
   public int countThis()throws Exception{
      Scanner scanFil = new Scanner(new File("konkurrenceSvoemmere.txt"));  
      while(scanFil.hasNextLine()){
         this.counter++;
         if (scanFil.nextLine() == null) break;
      }
      scanFil.close();
      return this.counter;
   }
   
   public void printKandidater(Scanner console)throws Exception{
      Scanner scanKonkurrence = new Scanner(new File("konkurrenceSvoemmere.txt"));
      ArrayList<Traener> crawlTop = new ArrayList<>();
      ArrayList<Traener> rygCrawlTop = new ArrayList<>();
      ArrayList<Traener> butterflyTop = new ArrayList<>();
      ArrayList<Traener> brystsvoemningTop = new ArrayList<>();
      ArrayList<Traener> hundesvoemningTop = new ArrayList<>();
      
      int count = -1; //en count der bruges i switch om hvilken disciplin der skal printes for 
      int top = 0; //til at udskrive arraylist 
       
      //initialisere et ArrayList med Traener objekt 
      List<Traener> print = new ArrayList<>();
      while(scanKonkurrence.hasNextLine()){
         String line = scanKonkurrence.nextLine();
         Scanner token = new Scanner(line);
         
         String fornavn = token.next();
         setFornavn(fornavn);
         
         String efternavn = token.next();
         setEfternavn(efternavn);
         
         int alder = token.nextInt();
         setAlder(alder);
         
         String medlemsskab = token.next();
         setMedlemsskab(medlemsskab);
         
         String disciplin = token.next();
         setDisciplin(disciplin);
         
         String tid = token.next();
         double tTid = Double.valueOf(tid); //returnere String repræsentationen af en double
         setTid(tTid);
         
         String dato = token.next();
         setDato(dato);
         
         //spørger om hvilken disciplin der skal printes
         if(count == -1){
            System.out.printf("%-25s\n%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n","VAELG DISCIPLIN:", "CRAWL", "TRYK 1","RYGCRAWL","TRYK 2","BUTTERLFY","TRYK 3","BRYSTSVOEMNING","TRYK 4","HUNDESVOEMNING","TRYK 5"); 
            super.testConsoleInput(console);
            count++;//increment
         }
         
         switch(this.menu){
            case 1: 
               if(disciplin.equals("Crawl")){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());                  
                  
                  crawlTop.add(traener);
                  
                  top = 1;
                  count++;
               }
               break;   
            case 2:
               if(disciplin.equals("Rygcrawl")){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());                  
                  
                  rygCrawlTop.add(traener);
                  
                  top = 2;
                  count++;
               }
               break;
            case 3:
               if(disciplin.equals("Butterfly")){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());                  
                  
                  butterflyTop.add(traener);
                  
                  top = 3; 
                  count++;
               }
               break;
            case 4:
               if(disciplin.equals("Brystsvoemning")){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());                  
                  
                  brystsvoemningTop.add(traener);
                  
                  top = 4;
                  count++;
               }
               break;
            case 5:
               if(disciplin.equals("Hundesvoemning")){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
                  
                  hundesvoemningTop.add(traener);
                  
                  top = 5;
                  count++;
               }
               break;
            default:
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");            
               printDisciplin(console); //den kører i infinite loop               
         }      
      }
      int k = 0; //bruges til at holde styr på,hvor mange gange der skal printes ud 
      if(top == 1){
         Collections.sort(crawlTop);
         System.out.printf("%s %s %s %s %s %s %s\n\n","","","","","","","");
         
         if(crawlTop.size() > 5){ 
            k = 5; 
         }else k = crawlTop.size();
         System.out.println("----------------------------------------------------------------------------------");
         System.out.printf("%-10s%-12s%-7s%-15s%-15s%-10s%-6s\n", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("----------------------------------------------------------------------------------");
         
         for(int i = 0; i < k; i++){ 
            System.out.printf("%-10s%-14s%-5d%-15s%-15s%-10.01f%-15s\n\n",crawlTop.get(i).getFornavn(),
               crawlTop.get(i).getEfternavn(),crawlTop.get(i).getAlder(),crawlTop.get(i).getMedlemsskab(),
               crawlTop.get(i).getDisciplin(),crawlTop.get(i).getTid(),crawlTop.get(i).getDato()); 
         }
      }else if(top == 2){
         Collections.sort(rygCrawlTop);
         System.out.printf("%s %s %s %s %s %s %s\n\n","","","","","","","");
         
         if(rygCrawlTop.size() > 5){ 
            k = 5; 
         }else k = rygCrawlTop.size();
         System.out.println("----------------------------------------------------------------------------------");
         System.out.printf("%-10s%-12s%-7s%-15s%-15s%-10s%-6s\n", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("----------------------------------------------------------------------------------");
         
         for(int i = 0; i < k; i++){ 
            System.out.printf("%-10s%-14s%-5d%-15s%-15s%-10.01f%-15s\n\n",rygCrawlTop.get(i).getFornavn(),
               rygCrawlTop.get(i).getEfternavn(),rygCrawlTop.get(i).getAlder(),rygCrawlTop.get(i).getMedlemsskab(),
               rygCrawlTop.get(i).getDisciplin(),rygCrawlTop.get(i).getTid(),rygCrawlTop.get(i).getDato()); 
         }
      }else if(top == 3){
         Collections.sort(butterflyTop);
         System.out.printf("%s %s %s %s %s %s %s\n\n","","","","","","","");
         
         if(butterflyTop.size() > 5){ 
            k = 5; 
         }else k = butterflyTop.size();
         System.out.println("----------------------------------------------------------------------------------");
         System.out.printf("%-10s%-12s%-7s%-15s%-15s%-10s%-6s\n", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("----------------------------------------------------------------------------------");
         for(int i = 0; i < k; i++){
            
            System.out.printf("%-10s%-14s%-5d%-15s%-15s%-10.01f%-15s\n\n",butterflyTop.get(i).getFornavn(),
               butterflyTop.get(i).getEfternavn(),butterflyTop.get(i).getAlder(),butterflyTop.get(i).getMedlemsskab(),
               butterflyTop.get(i).getDisciplin(),butterflyTop.get(i).getTid(),butterflyTop.get(i).getDato()); 
         }
      }else if(top == 4){
         Collections.sort(brystsvoemningTop);
         System.out.printf("%s %s %s %s %s %s %s\n\n","","","","","","","");
         
         if(brystsvoemningTop.size() > 5){ 
            k = 5; 
         }else k = brystsvoemningTop.size();
         System.out.println("----------------------------------------------------------------------------------");
         System.out.printf("%-10s%-12s%-7s%-15s%-17s%-7s%-6s\n", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("----------------------------------------------------------------------------------");
         
         for(int i = 0; i < k; i++){ 
            System.out.printf("%-10s%-14s%-5d%-15s%-17s%-7.01f%-15s\n\n",brystsvoemningTop.get(i).getFornavn(),
               brystsvoemningTop.get(i).getEfternavn(),brystsvoemningTop.get(i).getAlder(),brystsvoemningTop.get(i).getMedlemsskab(),
               brystsvoemningTop.get(i).getDisciplin(),brystsvoemningTop.get(i).getTid(),brystsvoemningTop.get(i).getDato()); 
         }
      }else if(top == 5){
         Collections.sort(hundesvoemningTop);
         System.out.printf("%s %s %s %s %s %s %s\n\n","","","","","","","");
         
         if(hundesvoemningTop.size() > 5){ 
            k = 5; 
         }else k = hundesvoemningTop.size();
         System.out.println("----------------------------------------------------------------------------------");
         System.out.printf("%-10s%-12s%-7s%-15s%-17s%-10s%-6s\n", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("----------------------------------------------------------------------------------");
         
         for(int i = 0; i < k; i++){ 
            System.out.printf("%-10s%-14s%-5d%-15s%-17s%-10.01f%-15s\n\n",hundesvoemningTop.get(i).getFornavn(),
               hundesvoemningTop.get(i).getEfternavn(),hundesvoemningTop.get(i).getAlder(),hundesvoemningTop.get(i).getMedlemsskab(),
               hundesvoemningTop.get(i).getDisciplin(),hundesvoemningTop.get(i).getTid(),hundesvoemningTop.get(i).getDato()); 
         }
      }  
      
      if (count == 0)System.out.println("INGEN MEDLEM(ER) ER TILKNYTTET DISCIPLIN");
      
      System.out.println();
      
      this.fort = 1;
      //prompter om fortsættelse
      fortsaettelse(console);
   } 
  
   //meget vigtig
   
   public int compareTo(Traener other){
      return new Double(getTid()).compareTo(other.getTid());
   }  
   //Metode for at printe staevneliste
   public void printStaevne(Scanner console)throws Exception{
      Scanner scanStaevne = new Scanner(new File("staevneliste.txt"));
      System.out.printf("%-10s %-13s %-15s %-11s %-15s %-15s\n", "FORNAVN", "EFTERNAVN", "STAEVNE", "TID", "PLACERING", "DISCIPLIN");
      System.out.println("-----------------------------------------------------------------------------");;
      while (scanStaevne.hasNext()){
         String fornavn = scanStaevne.next();
         String efternavn = scanStaevne.next();
         String staevne = scanStaevne.next();
         String tid = scanStaevne.next();
         String placering = scanStaevne.next();
         String disciplin = scanStaevne.next();
         
        
         System.out.printf("%-10s %-13s %-15s %-11s %-15s %-15s\n", fornavn, efternavn, staevne, tid, placering, disciplin);
         System.out.println(scanStaevne.nextLine() + "  ");
      }
      System.out.println();
      subMenu(); 
   }
   
   //skal rettes
   
   public void fortsaettelse(Scanner console)throws Exception{
      int dummy = 0;
      
      while(dummy == 0){
         System.out.println("TAST 1 FOR AT PRINTE ENDNU EN LISTE\nTAST 0 FOR AT RETURNERE\n<==");
            
         super.testConsoleInput(console);
            
         switch(this.menu){
            case 1:
               if(this.fort == 1){ 
                  printKandidater(console); 
               }else printDisciplin(console);
               this.fort = 0;
               break;
            
            case 0:
               this.fort = 0;
               subMenu();
               break;
            
            default:
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");   
               fortsaettelse(console);   
         }
         dummy = -1;
      }
   }

   /**
   * Printer liste over alle konkurrencesvoemmere
   */  
    
   public void printListe()throws Exception{
      Scanner konkurrence = new Scanner(new File("konkurrenceSvoemmere.txt")); 
      
      System.out.printf("%-10s %-10s %-7s %-11s %-15s %-15s %-10s\n", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
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
      setTid(console.nextDouble());
      double tidRet = getTid();
      //returnere String repræsentationen af en double
      String rettet = String.valueOf(tidRet);
      konkurrenceArray[num-1][5] = rettet;
      
      System.out.println("INDTAST NY DATO");
      setDato(console.next());
      konkurrenceArray[num-1][6] = getDato();
      
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
      System.out.println("INDTAST FORNAVN");
      setFornavn(console.next());
      System.out.println("INDTAST EFTERNAVN");
      setEfternavn(console.next());
      System.out.println("INDTAST STAEVNENAVN");
      setStaevneNavn(console.next());
      System.out.println("INDTAST BEDSTE STAEVNETID");
      setStaevneTid(console.nextDouble());
      System.out.println("INDTAST PLACERING");
      setPlacering(console.nextInt());
      
      //valg af disciplin
      //Formand refMetode = new Formand();
      vaelgDisciplin(console);
      
      saveToFile();
      
      System.out.println("...MEDLEM GEMT I STAEVNELISTE...\n\n");
      
      subMenu();
   }
   /*
   Denne metode beder brugeren vælge,
   om der skal printes et juniorhold eller seniorhold.
   */
   public void juniorSenior() throws Exception {
      Scanner console = new Scanner(System.in);
      int menu = -1;
      
      while(menu != 0){
         System.out.printf("%-25s%-5s\n%-25s%-5s\n","PRINT JUNIORHOLD", "TRYK 1", "PRINT SENIORHOLD", "TRYK 2");
      super.testConsoleInput(console);
      
      switch(this.menu){
         
         case 1:
            junior();
            menu = 0;
            break;
         case 2:
            senior();
            menu = 0;
         default:
            System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST\n");
            juniorSenior();           
         
         }
         break;   //exit loop
      }
   
   }
   
   /*Junior og senior metoderne tjekker konkurrencesvømmere.txt for
   token "alder". I junior vil den returnere line hvis alder er < 18,
   og vice versa for senior*/
   public void junior() throws Exception {
      Scanner alder = new Scanner(new File("Konkurrencesvoemmere.txt"));
         System.out.printf("%-12s%-15s%-10s\n", "FORNAVN", "EFTERNAVN", "ALDER");
         System.out.println("--------------------------------");
         
         List<Traener>junior = new ArrayList<>();
         
            while(alder.hasNextLine()){
               String line = alder.nextLine();
               Scanner token = new Scanner(line);
               
               String jFornavn = token.next();
               setFornavn(jFornavn);
               
               String jEfternavn = token.next();
               setEfternavn(jEfternavn);
               
               int jAlder = token.nextInt();
               setAlder(jAlder);
               
               if(jAlder < 18) {
               
                  System.out.printf("%-12s%-15s%-10s", getFornavn(), getEfternavn(), getAlder());
                  System.out.println();
               }
            }
         System.out.println();
         subMenu();
   }
    public void senior() throws Exception {
      Scanner alder = new Scanner(new File("Konkurrencesvoemmere.txt"));
         System.out.printf("%-12s%-15s%-10s\n", "FORNAVN", "EFTERNAVN", "ALDER");
         System.out.println("--------------------------------");
         
         List<Traener>senior = new ArrayList<>();
         
            while(alder.hasNextLine()){
               String line = alder.nextLine();
               Scanner token = new Scanner(line);
               
               String sFornavn = token.next();
               setFornavn(sFornavn);
               
               String sEfternavn = token.next();
               setEfternavn(sEfternavn);
               
               int sAlder = token.nextInt();
               setAlder(sAlder);
               
               if(sAlder > 18) {
               
                  System.out.printf("%-12s%-15s%-10s", getFornavn(), getEfternavn(), getAlder());
                  System.out.println();
               }
               
            }
         System.out.println();
         subMenu();
   }

   
   /**
   * gemmer oplysninger i fil
   */
   
   public void saveToFile()throws Exception{
      PrintStream nytMemberInfo = new PrintStream(new FileOutputStream("staevneliste.txt",true));
      nytMemberInfo.println(toStringStaevne());
      System.out.print("\n"); 
   }
   
   /**
   * En toString metodde for registrerStaevne metode
   */
   
   public String toStringStaevne(){
      return getFornavn()+" "+getEfternavn()+" "+getStaevneNavn()+" "+getStaevneTid()+" "+getPlacering()+ " "+getDisciplin();
   }
   
   public void vaelgDisciplin(Scanner console)throws Exception{
      int dummy = 0;
      while(dummy == 0){
          
         System.out.printf("%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s\n", "CRAWL", "TRYK 1", "RYGCRAWL",
          "TRYK 2", "BRYSTSVOEMNING", "TAST 3",
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

}