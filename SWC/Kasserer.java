import java.util.*; // for Scanner
import java.io.*; // for PrintStream

/**
* betalingsstatus()                                                linje 94
* visRestance()                                                    linje 123
* count(String fileName)                                           linje 166
* redigerKontigent(Scanner console)                                linje 180
* kontingentPris(Scanner console)                                  linje 255
* kontingentRead(Scanner console, ArrayList<Kasserer> kontingent)  linje 354
*/

public class Kasserer extends Ansat {
   
   protected int counter = 0; //brugt i redigerKontingent
   
   public Kasserer(){}
   
   public Kasserer(String fornavn, String efternavn, String restance){
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setRestance(restance);   
   }
   
   public Kasserer(String fornavn, String efternavn, int alder, String medlemsskab){
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setAlder(alder);
      setMedlemsskab(medlemsskab);
   }
   
   public Kasserer(String fornavn, String efternavn, int alder, String medlemsskab, String disciplin, double tid, String dato){ 
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setAlder(alder);
      setMedlemsskab(medlemsskab);
      setDisciplin(disciplin);
      setTid(tid);
      setDato(dato);
   }
   //Undermenu metode
	public void subMenu()throws Exception {
		Scanner console = new Scanner(System.in);
      int menu = -1;
      
      while(menu != 0){
         subMenuInfo(); //linje 74
         
         super.testConsoleInput(console); //linje 86 i Ansat klassen
         //Indhold af menu til kassér
         //"menu = 0" så submenuen kører indtil man selv
         //ber den om at returnere
         switch(this.menu){
            case 1: 
               visRestance(); //linje 112
               menu = 0;
               break;
            case 2:
               betalingsstatus(); //linje 84
               menu = 0;
               break;
            case 3:
               redigerKontigent(console); //linje 169
               menu = 0;   
               break;
            case 4:
               kontingentPris(console); //linje 244
               menu = 0;
               break;
            case 0: 
               this.menu = -1; //for at den ikke også hopper ud af ansats menu
               super.menu(); //menu hos ansat
               break;
            default: 
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST\n");
               subMenu();
         }
         break; //for kun at komme ud af dette loop
      }
	}
   
   public void subMenuInfo(){
      System.out.printf("%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n\n%-25s%s\n", "PRINT RESTANCELISTE", 
            "TAST 1", "PRINT BETALINGSSTATUS", "TAST 2", "REDIGER BETALINGSSTATUS","TAST 3","KONTINGENT FOR MEDLEM","TAST 4", "RETURNER", "TAST 0");
   }
   
   /**
   *Metode til print af fuld liste over medlemmers betalingsstatus,
   *scanner hele filen og printer hvert enkelt token ud til consollen.
   */
   
   public void betalingsstatus() throws Exception {
      Scanner status = new Scanner(new File("visRestance.txt"));
         System.out.printf("%-10s%-15s%-10s\n", "FORNAVN", "EFTERNAVN", "STATUS");
         System.out.printf("---------------------------------\n");
            while(status.hasNextLine()){ 
               String line = status.nextLine();
               Scanner token = new Scanner(line);
               
               String navn = token.next();
               setFornavn(navn);
               
               String enavn = token.next();
               setEfternavn(enavn);
               
               String rest = token.next();
               setRestance(rest); 
               
               System.out.printf("%-10s%-15s%-10s", getFornavn(),getEfternavn(),getRestance());
               System.out.println(); 
            }
            System.out.println(); 
            subMenu(); //linje 34
   }
  
   /**
   * Printer fra en fil og gemmer tokens i et objekt i arraylist
   */
   
   public void visRestance() throws Exception{
      Scanner RestanceKonti = new Scanner(new File("visRestance.txt"));
         System.out.printf("%-12s%-15s%-10s\n", "FORNAVN", "EFTERNAVN", "STATUS");
            System.out.printf("-----------------------------------\n");
            List<Kasserer> vis = new ArrayList<>();
            
            while(RestanceKonti.hasNextLine()){
               String line = RestanceKonti.nextLine();
               Scanner token = new Scanner(line);
               
               String navn = token.next();
               setFornavn(navn);
               
               String enavn = token.next();
               setEfternavn(enavn);
               
               String rest = token.next();
               setRestance(rest);
               
               if(rest.equals("Restance")){
                 
               System.out.printf("%-12s%-15s%-10s", getFornavn(),getEfternavn(),getRestance());
               System.out.println(); 
            } 
         
      Kasserer kas = new Kasserer(getFornavn(),getEfternavn(),getRestance());
      vis.add(kas);
           
      } 
      System.out.println();
      subMenu(); //linje 34
   }
   
   @Override
   public String toString() {
      return " ";
   }
   
   /**
   * Denne metode bruges i redierKontingent samt kontingentPris linje 235
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
   * metode der kan ændre placeholder på et 2d array der er for et medlem.
   * Pladsen overskrives og gemmes til txt filen
   */
   
   public void redigerKontigent(Scanner console)throws Exception{
      Scanner scanRest = new Scanner(new File("visRestance.txt")); 
      String fileName = "visRestance.txt";
      count(fileName); //linje 157
      String redigerRestance[][] = new String[this.counter][3];
      
      while(scanRest.hasNext()){
         for(int i = 0; i < this.counter; i++){
            for(int j = 0; j < 3; j++){
               String item = scanRest.next();
               redigerRestance[i][j] = item;
            }
         }
      }
      int dummy = 0;
      while(dummy == 0){
         System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT OPDATERE BETALING PAA");
         int num = console.nextInt(); //Check vaerdi?
         
         while (dummy == 0) {
            if (num <= 0 || num > this.counter) {
               System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT OPDATERE BETALING PAA");
               num = console.nextInt(); //Check vaerdi?
            }
            else if (num > 0 && num <= this.counter){
                  dummy = 1;
            }
         }
         System.out.println("HAR MEDLEMMET BETALT TAST 1\nMANGLER MEDLEMMET AT BETALE TAST 2");
         String input = console.next();
         if(input.equals("1")){
            setRestance("Betalt");
            redigerRestance[num-1][2] = getRestance();
            dummy = 1;
         }else if(input.equals("2")){
            setRestance("Restance");
            redigerRestance[num-1][2] = getRestance();
            dummy = 1; 
         }else { 
            System.out.println("UGYLDIGT INPUT\nTAST VENLIGST ET TAL DER ER FREMVIST"); 
            this.counter = 0;
            redigerKontigent(console); //linje 166
         }    
      }
      
      //Overskriver plads i eksisterende fil
      PrintStream addChange = new PrintStream(new File("visRestance.txt"));
      for(int i = 0; i < this.counter; i++){
         addChange.println(redigerRestance[i][0] + " " + redigerRestance[i][1] + " " 
            + redigerRestance[i][2]);
      }
      //clean up
      scanRest.close();
      this.counter = 0;
      
      System.out.println("...MEDLEMMETS BETALING ER NU BLEVET OPDATERET...\n");
      int dummy2 = 0;
      while(dummy2 == 0){
         System.out.println("FOR AT OPDATERE ENDNU ET MEDLEMS BETALING TAST 1\nRETUNER TAST 0");
         String fort = console.next();
         if(fort.equals("1")){
            redigerKontigent(console); //linje 166
            dummy2 = 1;
         }else if(fort.equals("0")){
            subMenu(); //linje 34
            dummy2 = 1;
         }else{  
            System.out.println("UGYLDIGT INPUT\nTAST VENLIGST ET TAL DER ER FREMVIST"); 
         }
      }
   }
   
   /**
   * læser fra txt fil og gemmer obejkt i arraylist
   */
   public void kontingentPris(Scanner console)throws Exception{
      Scanner scK = new Scanner(new File("konkurrenceSvoemmere.txt"));
      Scanner scM = new Scanner(new File("motionister.txt"));
      ArrayList<Kasserer> kontingent = new ArrayList<>();
      
      System.out.println("TAST 1 FOR MOTIONIST MEDLEM\nTAST 2 FOR KONKURRENCE MEDLEM");
      String num = console.next();
      
      if(num.equals("1")){
         String fileName = "motionister.txt";
         count(fileName); //linje 157
         
         while(scM.hasNextLine()){
               String line = scM.nextLine();
               Scanner token = new Scanner(line);
               
               String fornavn = token.next();
               setFornavn(fornavn);
               
               String efternavn = token.next();
               setEfternavn(efternavn);
               
               int alder = token.nextInt();
               setAlder(alder);
               
               String medlemsskab = token.next();
               setMedlemsskab(medlemsskab);
               
               Kasserer kas = new Kasserer(fornavn, efternavn, alder, medlemsskab);
               kontingent.add(kas);
         }
         
         kontingentRead(console, kontingent); //linje 337

      }else if(num.equals("2")){
         String fileName = "konkurrenceSvoemmere.txt";
         count(fileName); //linje 157
         while(scK.hasNextLine()){
               String line = scK.nextLine();
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
               double retTid = Double.valueOf(tid);
               setTid(retTid);
               
               String dato = token.next();
               setDato(dato);
               
               Kasserer kas = new Kasserer(fornavn, efternavn, alder, medlemsskab, disciplin, retTid, dato);
               kontingent.add(kas);
         }
         
         kontingentRead(console, kontingent); // linje 337

      }else{
         System.out.println("UGYLDIGT INPUT\nTAST VENLIGST ET TAL DER ER FREMVIST");
         kontingentPris(console); //linje 238
      }
      System.out.println();
      this.counter = 0;
      int dummyy = 0;
      while(dummyy == 0){   
         System.out.println("TAST 1 FOR AT SE KONTIGENTPRIS PAA ET ANDET MEDLEM\nTAST 0 FOR AT RETURNERE");
         super.testConsoleInput(console); //linje 86 i Ansat klassen
      
         switch(this.menu){
            case 1: 
               kontingentPris(console); //linje 238
               dummyy = 1;
               break;
            case 0:
               subMenu(); //linje 34
               dummyy = 1;
               break;
            default:
               System.out.println("UGYLDIGT INPUT\nTAST VENLIGST ET TAL DER ER FREMVIST");
         }
      }
   }
   
   /**
   * læser kontingent arraylist og ser om medlems medlemsskab er enten 
   * passiv eller aktiv og printer formateret ud derfra.
   */
   public void kontingentRead(Scanner console, ArrayList<Kasserer> kontingent){
      int dummy = 0;
         while(dummy == 0){
            System.out.println("\nTAST NUMMER PAA MEDLEM DU OENSKER AT SE KONTINGENTPRIS PAA");
            int number = console.nextInt(); //Check vaerdi?
            
            // ser om det tal man taster er et tal der er fremvist
            while (dummy == 0) {
               if (number <= 0 || number > this.counter) {
                  System.out.println("\nUGYLDIGT INPUT\nTAST VENLIGST ET NUMMER DER ER FREMVIST");
                  number = console.nextInt(); //Check vaerdi?
               }
               else if (number > 0 && number <= this.counter){
                  dummy = 1;
               }
            }
            
            if(kontingent.get(number-1).getMedlemsskab().equals("Passiv")){
               Passiv pas = new Passiv();
               System.out.printf("%-10s%-15s%-15s%-25s\n", "FORNAVN","EFTERNAVN","MEDLEMSSKAB","KONTINGENTSPRIS" );
               System.out.println("-------------------------------------------------------");
               System.out.printf("%-10s%-15s%-15s%-25.2f\n", kontingent.get(number-1).getFornavn(),kontingent.get(number-1).getEfternavn(),kontingent.get(number-1).getMedlemsskab(),pas.getPris());
            }else if(kontingent.get(number-1).getAlder() < 18){
               Junior ju = new Junior();
               System.out.printf("%-10s%-15s%-15s%-25s\n", "FORNAVN","EFTERNAVN","MEDLEMSSKAB","KONTINGENTSPRIS" );
               System.out.println("-------------------------------------------------------");
               System.out.printf("%-10s%-15s%-15s%-25.2f\n", kontingent.get(number-1).getFornavn(),kontingent.get(number-1).getEfternavn(),kontingent.get(number-1).getMedlemsskab(),ju.getPris());
            }else if(kontingent.get(number-1).getAlder() >= 18 && kontingent.get(number-1).getAlder() < 60){
               Senior se = new Senior();
               System.out.printf("%-10s%-15s%-15s%-25s\n", "FORNAVN","EFTERNAVN","MEDLEMSSKAB","KONTINGENTSPRIS" );
               System.out.println("-------------------------------------------------------");
               System.out.printf("%-10s%-15s%-15s%-25.2f\n", kontingent.get(number-1).getFornavn(),kontingent.get(number-1).getEfternavn(),kontingent.get(number-1).getMedlemsskab(),se.getPris());
            }else{ 
               Pensionist pension = new Pensionist();
               System.out.printf("%-10s%-15s%-15s%-25s\n", "FORNAVN","EFTERNAVN","MEDLEMSSKAB","KONTINGENTSPRIS" );
               System.out.println("-------------------------------------------------------");
               System.out.printf("%-10s%-15s%-15s%-25.2f\n", kontingent.get(number-1).getFornavn(),kontingent.get(number-1).getEfternavn(),kontingent.get(number-1).getMedlemsskab(),pension.getPris());
            }
         } 
   }
}