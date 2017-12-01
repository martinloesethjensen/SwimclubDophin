import java.util.*; // for Scanner
import java.io.*; // for PrintStream


public class Kasserer extends Ansat {
   
   protected int counter = 0; //brugt i redigerKontingent
   
   public Kasserer(){}
   
   public Kasserer(String fornavn, String efternavn, String restance){
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setRestance(restance);   
   }

   public void subMenu()throws Exception {
      Scanner console = new Scanner(System.in);
      int menu = -1;
      
      while(menu != 0){
         subMenuInfo();
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               visRestance();
               menu = 0;
               break;
            case 2:
               betalingsstatus();
               menu = 0;
               break;
            case 3:
               redigerKontigent(console);
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
      System.out.printf("%-25s%s\n%-25s%s\n%-25s%s\n%-25s%s\n", "PRINT RESTANCELISTE", 
            "TRYK 1", "PRINT BETALINGSSTATUS", "TRYK 2", "REDIGER BETALING","TAST 3", "RETURNER", "TAST 0");
   }

   
   /**
   * Beskrivelse her
   */
   public void betalingsstatus() throws Exception {
      Scanner status = new Scanner(new File("visRestance.txt"));
      System.out.printf("%-10s%-15s%-10s\n", "FORNAVN", "EFTERNAVN", "STATUS");
      System.out.printf("---------------------------------\n");
      List<Kasserer> vis = new ArrayList<>();
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
      subMenu();
   }
  
   /**
   * Beskrivelse her
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
      subMenu(); 
   }
   
   @Override
   public String toString() {
      return " ";
   }
   
   public int count()throws Exception{
      Scanner scanFil = new Scanner(new File("visRestance.txt"));  
      //Printf så det ser pænt og formateret ud 
      while(scanFil.hasNextLine()){
         this.counter++;
         System.out.println(this.counter + " " + scanFil.nextLine());
      }
      return this.counter;
   }
   
   public void redigerKontigent(Scanner console)throws Exception{
      Scanner scanRest = new Scanner(new File("visRestance.txt")); 
      count();
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
            redigerKontigent(console);
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
            redigerKontigent(console);
            dummy2 = 1;
         }else if(fort.equals("0")){
            subMenu();
            dummy2 = 1;
         }else{  
            System.out.println("UGYLDIGT INPUT\nTAST VENLIGST ET TAL DER ER FREMVIST"); 
         }
      }
   }
}