import java.util.*; // for Scanner
import java.io.*; // for PrintStream

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
         traenerMenu(); //linje 63
         
         super.testConsoleInput(console); //metode i ansat               
         
         switch(this.menu){
            case 1: printDisciplin(console); break; //linje 79
            case 2: printKandidater(console); break; //linje 188
            case 3: printListe(); break; //linje 446
            case 4: registrerStaevne(console); break; //linje 543
            case 5: nyTid(console); break; //linje 488
            case 6: printStaevne(console); break; //linje 389
            case 7: juniorSenior(console); break; //linje 569
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
      System.out.printf("%-35s%s\n", "DISCIPLINLISTE M. MEDLEMMER", "TAST 1");
      System.out.printf("%-35s%s\n", "TOP 5 I VALGT DISCIPLIN", "TAST 2");
      System.out.printf("%-35s%s\n", "LISTE OVER KONKURRENCESVOEMMERE", "TAST 3");
      System.out.printf("%-35s%s\n", "OPRET NY STAEVNEDELTAGER", "TAST 4");
      System.out.printf("%-35s%s\n", "OPRET NY BEDSTE TID", "TAST 5");
      System.out.printf("%-35s%s\n", "PRINT STAEVNELISTE", "TAST 6");
      System.out.printf("%-35s%s\n", "PRINT JUNIOR/SENIOR-HOLD", "TAST 7");
      System.out.println();
      System.out.printf("%-35s%s\n", "RETURNER", "TAST 0");
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
            System.out.printf("%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n", "CRAWL", "TAST 1","RYGCRAWL","TAST 2","BUTTERLFY","TAST 3","BRYSTSVOEMNING","TAST 4","HUNDESVOEMNING","TAST 5");
            super.testConsoleInput(console); //metode i ansat
            count++;
            //increment
         }
         //sammenlign og print medlem hvis dette eksistere for det pågældende medlem 
         switch(this.menu){
            case 1:
               if(disciplin.equals("Crawl")){
                  if(count == 0){System.out.printf("%-20s%-20s%-10s%-20s%-20s%-15s%-15s\n","FORNAVN","EFTERNAVN","ALDER","MEDLEMSSKAB","DISCIPLIN","TID","DATO");
                  for(int i = 0; i < 113; i++){System.out.print("_");}}
                  System.out.println();
                  System.out.printf("%-20s%-20s%-10d%-20s%-20s%-15.2f%-15s",getFornavn(),getEfternavn(),getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
                  count++; //increment så den ikke printer at der ikke er nogen medlemmer
               }
               break;   
            case 2:
               if(disciplin.equals("Rygcrawl")){
                  if(count == 0){System.out.printf("%-20s%-20s%-10s%-20s%-20s%-15s%-15s\n\n","FORNAVN","EFTERNAVN","ALDER","MEDLEMSSKAB","DISCIPLIN","TID","DATO");}
                  System.out.printf("%-20s%-20s%-10d%-20s%-20s%-15.2f%-15s\n",getFornavn(),getEfternavn(),getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
                  count++;
               }
               break;
            case 3:
               if(disciplin.equals("Butterfly")){
                  if(count == 0){System.out.printf("%-20s%-20s%-10s%-20s%-20s%-15s%-15s\n\n","FORNAVN","EFTERNAVN","ALDER","MEDLEMSSKAB","DISCIPLIN","TID","DATO");}
                  System.out.printf("%-20s%-20s%-10d%-20s%-20s%-15.2f%-15s\n",getFornavn(),getEfternavn(),getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
                  count++;
               }
               break;
            case 4:
               if(disciplin.equals("Brystsvoemning")){
                  if(count == 0){System.out.printf("%-20s%-20s%-10s%-20s%-20s%-15s%-15s\n\n","FORNAVN","EFTERNAVN","ALDER","MEDLEMSSKAB","DISCIPLIN","TID","DATO");}
                  System.out.printf("%-20s%-20s%-10d%-20s%-20s%-15.2f%-15s\n",getFornavn(),getEfternavn(),getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
                  count++;
               }
               break;
            case 5:
               if(disciplin.equals("Hundesvoemning")){
                  if(count == 0){System.out.printf("%-20s%-20s%-10s%-20s%-20s%-15s%-15s\n\n","FORNAVN","EFTERNAVN","ALDER","MEDLEMSSKAB","DISCIPLIN","TID","DATO");}                  
                  System.out.printf("%-20s%-20s%-10d%-20s%-20s%-15.2f%-15s\n",getFornavn(),getEfternavn(),getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
                  count++;
               }
               break;
            default:
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");            
               printDisciplin(console); //den kører i infinite loop   linje 79            
         }
         
         //tilføjer traen objekt til arraylist
         Traener traen = new Traener(getFornavn(),getEfternavn(),getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());
         print.add(traen);
      
      }
      
      //hvis count er > 0 så går den ikke ind i if 
      if (count == 0)System.out.println("INGEN MEDLEM(ER) ER TILKNYTTET DISCIPLIN");
     
      System.out.println("\n");
      //prompter om fortsættelse
      fortsaettelse(console); //linje 411
   }
   
   /**
   * printer top 5 ved at gemme objekt i arraylist er 
   * sortere arraylist objekter med deres tider og printer højst 5 
   * i numerisk rækkefølge sortereret fra laveste til højeste.  
   */
   
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
            System.out.printf("%-25s\n%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n","VAELG DISCIPLIN:", "CRAWL", "TAST 1","RYGCRAWL","TAST 2","BUTTERLFY","TAST 3","BRYSTSVOEMNING","TAST 4","HUNDESVOEMNING","TAST 5"); 
            super.testConsoleInput(console); //metode i ansat
            count++;//increment
         }
         
         switch(this.menu){
            case 1: 
               if(disciplin.equals("Crawl") && getTid() > 0.0){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());                  
                  
                  crawlTop.add(traener);
                  
                  top = 1;
                  count++;
               }
               break;   
            case 2:
               if(disciplin.equals("Rygcrawl")&& getTid() > 0.0){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());                  
                  
                  rygCrawlTop.add(traener);
                  
                  top = 2;
                  count++;
               }
               break;
            case 3:
               if(disciplin.equals("Butterfly")&& getTid() > 0.0){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());                  
                  
                  butterflyTop.add(traener);
                  
                  top = 3; 
                  count++;
               }
               break;
            case 4:
               if(disciplin.equals("Brystsvoemning")&& getTid() > 0.0){
                  Traener traener = new Traener(getFornavn(),getEfternavn(),
                  getAlder(),getMedlemsskab(),getDisciplin(),getTid(),getDato());                  
                  
                  brystsvoemningTop.add(traener);
                  
                  top = 4;
                  count++;
               }
               break;
            case 5:
               if(disciplin.equals("Hundesvoemning")&& getTid() > 0.0){
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
         
         if(crawlTop.size() > 5){ 
            k = 5; 
         }else k = crawlTop.size();
         System.out.println("--------------------------------------------------------------------------------------");
         System.out.printf("%-5s%-10s%-12s%-7s%-15s%-17s%-10s%-6s\n","NR.", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("--------------------------------------------------------------------------------------");
         
         for(int i = 0; i < k; i++){ 
            System.out.printf("%-5d%-10s%-14s%-5d%-15s%-15s%-10.01f%-15s\n",i+1,crawlTop.get(i).getFornavn(),
               crawlTop.get(i).getEfternavn(),crawlTop.get(i).getAlder(),crawlTop.get(i).getMedlemsskab(),
               crawlTop.get(i).getDisciplin(),crawlTop.get(i).getTid(),crawlTop.get(i).getDato()); 
         }
      }else if(top == 2){
         Collections.sort(rygCrawlTop);
         
         if(rygCrawlTop.size() > 5){ 
            k = 5; 
         }else k = rygCrawlTop.size();
         System.out.println("--------------------------------------------------------------------------------------");
         System.out.printf("%-5s%-10s%-12s%-7s%-15s%-17s%-10s%-6s\n","NR.", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("--------------------------------------------------------------------------------------");
         
         for(int i = 0; i < k; i++){ 
            System.out.printf("%-5d%-10s%-14s%-5d%-15s%-15s%-10.01f%-15s\n",i+1,rygCrawlTop.get(i).getFornavn(),
               rygCrawlTop.get(i).getEfternavn(),rygCrawlTop.get(i).getAlder(),rygCrawlTop.get(i).getMedlemsskab(),
               rygCrawlTop.get(i).getDisciplin(),rygCrawlTop.get(i).getTid(),rygCrawlTop.get(i).getDato()); 
         }
      }else if(top == 3){
         Collections.sort(butterflyTop);
        
         if(butterflyTop.size() > 5){ 
            k = 5; 
         }else k = butterflyTop.size();
         System.out.println("--------------------------------------------------------------------------------------");
         System.out.printf("%-5s%-10s%-12s%-7s%-15s%-17s%-10s%-6s\n","NR.", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("--------------------------------------------------------------------------------------");

         for(int i = 0; i < k; i++){
            System.out.printf("%-5d%-10s%-14s%-5d%-15s%-15s%-10.01f%-15s\n",i+1,butterflyTop.get(i).getFornavn(),
               butterflyTop.get(i).getEfternavn(),butterflyTop.get(i).getAlder(),butterflyTop.get(i).getMedlemsskab(),
               butterflyTop.get(i).getDisciplin(),butterflyTop.get(i).getTid(),butterflyTop.get(i).getDato()); 
         }
      }else if(top == 4){
         Collections.sort(brystsvoemningTop);
        
         if(brystsvoemningTop.size() > 5){ 
            k = 5; 
         }else k = brystsvoemningTop.size();
         System.out.println("--------------------------------------------------------------------------------------");
         System.out.printf("%-5s%-10s%-12s%-7s%-15s%-17s%-10s%-6s\n","NR.", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("--------------------------------------------------------------------------------------");

         
         for(int i = 0; i < k; i++){ 
            System.out.printf("%-5d%-10s%-14s%-5d%-15s%-17s%-7.01f%-15s\n",i+1,brystsvoemningTop.get(i).getFornavn(),
               brystsvoemningTop.get(i).getEfternavn(),brystsvoemningTop.get(i).getAlder(),brystsvoemningTop.get(i).getMedlemsskab(),
               brystsvoemningTop.get(i).getDisciplin(),brystsvoemningTop.get(i).getTid(),brystsvoemningTop.get(i).getDato()); 
         }
      }else if(top == 5){
         Collections.sort(hundesvoemningTop);
         
         if(hundesvoemningTop.size() > 5){ 
            k = 5; 
         }else k = hundesvoemningTop.size();
         System.out.println("--------------------------------------------------------------------------------------");
         System.out.printf("%-5s%-10s%-12s%-7s%-15s%-17s%-10s%-6s\n","NR.", "FORNAVN", "EFTERNAVN", "ALDER", "MEDLEMSSKAB", "DISCIPLIN", "TID", "DATO");
         System.out.println("--------------------------------------------------------------------------------------");
         
         for(int i = 0; i < k; i++){ 
            System.out.printf("%-5d%-10s%-14s%-5d%-15s%-17s%-10.01f%-15s\n",i+1,hundesvoemningTop.get(i).getFornavn(),
               hundesvoemningTop.get(i).getEfternavn(),hundesvoemningTop.get(i).getAlder(),hundesvoemningTop.get(i).getMedlemsskab(),
               hundesvoemningTop.get(i).getDisciplin(),hundesvoemningTop.get(i).getTid(),hundesvoemningTop.get(i).getDato()); 
         }
      }  
      
      if (count == 0)System.out.println("INGEN MEDLEM(ER) ER TILKNYTTET DISCIPLIN");
      
      System.out.println();
      
      this.fort = 1;
      //prompter om fortsættelse
      fortsaettelse(console); //linje 411
   } 
  
   //meget vigtig fortæl om denne
   
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
   
   /**
   * spørger brugeren om at printe en ny liste ud. 
   * Metodekald til diverse metoder afhængig af hvad this.fort er  
   */
   
   public void fortsaettelse(Scanner console)throws Exception{
      int dummy = 0;
      
      while(dummy == 0){
         System.out.println("TAST 1 FOR AT PRINTE ENDNU EN LISTE\nTAST 0 FOR AT RETURNERE\n<==");
            
         super.testConsoleInput(console); //metode i ansat
            
         switch(this.menu){
            case 1:
               if(this.fort == 1){ 
                  printKandidater(console); 
               }else if(this.fort == 2){
                  juniorSenior(console); //linje 569
               }else printDisciplin(console);
               this.fort = 0;
               break;
            
            case 0:
               this.fort = 0;
               subMenu();
               break;
            
            default:
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");   
               fortsaettelse(console); //linje 411  
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
         String medlemsskab = konkurrence.next();
         String disciplin = konkurrence.next();
         String tid = konkurrence.next();
         String dato = konkurrence.next();
         
        
         System.out.printf("%-10s %-10s %-7d %-11s %-15s %-15s %-10s\n", fornavn, efternavn, alder, medlemsskab, disciplin, tid, dato);
         System.out.println(konkurrence.nextLine() + "  ");
      }
      System.out.println();
      subMenu();
   } 
    
   /**
   * Beskrivelse her
   */
    
   public int count(String fileName)throws Exception{
      Scanner scanFil = new Scanner(new File(fileName));  
      while(scanFil.hasNextLine()){
         this.counter++;
         System.out.printf("%-2d %-14s\n",this.counter, scanFil.nextLine());
      }
      return this.counter;
   }
    
   /**
   * Beskrivelse her
   */ 
    
   public void nyTid(Scanner console)throws Exception{
      Scanner scanKonk = new Scanner(new File("konkurrenceSvoemmere.txt"));  
      String fileName = "konkurrenceSvoemmere.txt";
      count(fileName);
      String konkurrenceArray[][] = new String[this.counter][7];
      
      while(scanKonk.hasNext()){
         for(int i = 0; i < this.counter; i++){
            for(int j = 0; j < 7; j++){
               String item = scanKonk.next();
               konkurrenceArray[i][j] = item;
            }
         }
      }
      System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT OPDATERE");
      int num = console.nextInt(); //Check vaerdi
      int dummy = 0;
      while (dummy == 0) {
            if (num <= 0 || num > this.counter) {
               System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT OPDATERE BETALING PAA");
               num = console.nextInt(); //Check vaerdi?
            }
            else if (num > 0 && num <= this.counter){
               dummy = 1;
            }
      }
      
      System.out.println("INDTAST NY TID (MM.SS)");
      setTid(console.nextDouble());
      double tidRet = getTid();
      //returnere String repræsentationen af en double
      String rettet = String.valueOf(tidRet);
      konkurrenceArray[num-1][5] = rettet;
      
      System.out.println("INDTAST NY DATO (DD/MM/YY)");
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
      System.out.println();
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
      System.out.println("INDTAST BEDSTE STAEVNETID (MM.SS)");
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
   public void juniorSenior(Scanner console) throws Exception {
      while(this.menu != 0){
         System.out.printf("%-25s%-5s\n%-25s%-5s\n","PRINT JUNIORHOLD", "TAST 1", "PRINT SENIORHOLD", "TAST 2");
         
         super.testConsoleInput(console); //metode i ansat
      
         switch(this.menu){
            
            case 1:
               junior(); //linje 600
               menu = 0;
               break;
            case 2:
               senior(); //linje 628
               menu = 0;
               break;
            default:
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST\n");
               juniorSenior(console); //linje 569          
            
            }
            this.menu = 0;   //exit loop
      }
      //spørger om ny udprint
      this.fort = 2;
      fortsaettelse(console); //linje 411
   }
   
   /*Junior og senior metoderne tjekker konkurrencesvømmere.txt for
   token "alder". I junior vil den returnere line hvis alder er < 18,
   og vice versa for senior*/
   public void junior() throws Exception {
      Scanner alder = new Scanner(new File("konkurrenceSvoemmere.txt"));
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
   }
    public void senior() throws Exception {
      Scanner alder = new Scanner(new File("konkurrenceSvoemmere.txt"));
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
   }

   
   /**
   * Gemmer oplysninger i fil
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
          
         System.out.printf("%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s\n", "CRAWL", "TAST 1", "RYGCRAWL",
          "TAST 2", "BRYSTSVOEMNING", "TAST 3",
           "BUTTERFLY", "TAST 4", "HUNDESVOEMNING", "TAST 5");
         super.testConsoleInput(console); //metode i ansat
         
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