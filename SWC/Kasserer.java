import java.util.*; // for Scanner
import java.io.*; // for PrintStream


public class Kasserer extends Ansat {
   
   public Kasserer(){}
   
   public Kasserer(String fornavn, String efternavn, String restance){
      super.setFornavn(fornavn);
      super.setEfternavn(efternavn);
      super.setRestance(restance);   
      
      
   }

	public void subMenu()throws Exception {
		Scanner console = new Scanner(System.in);
      int menu = -1;
      while(menu != 0){
         subMenuInfo();
         
         super.testConsoleInput(console);
         
         switch(this.menu){
            case 1: 
               betalingsstatus();
               
               menu = 0;
               break;
            case 2:
               
               visRestance();
               menu = 0;
               break;
            case 0: 
               this.menu = -1; //for at den ikke også hopper ud af ansats menu
               super.menu(); //menu hos ansat
               break;
            default: 
               System.out.println("Tast venligst et nummer der er fremvist\n");
               subMenu();
         }
         break; //for kun at komme ud af dette loop
      }
	}
   
   public void subMenuInfo(){

      System.out.printf("%-25s%s\n%-25s%s\n%-25s%s\n", "PRINT BETALINGSSTATUS", "TRYK 1", "PRINT RESTANCELISTE", "TRYK 2", "RETURNER", "TAST 0");

   }

   
   /**
   * Beskrivelse her
   */
   public void betalingsstatus() throws Exception {
      Scanner status = new Scanner(new File("visRestance.txt"));
      while(status.hasNextLine()){
            
            String sline = status.nextLine();
               System.out.println(sline.toString());
             }
      System.out.println();
      subMenu();
   }
   
   /* Denne funktion laver først en ny scanner ved navn RestanceKonti, som læser fra visRestance.txt filen.
      Dernæst laver den et nyt objekt i form af en ArrayList kaldet vis.
      While-loopet beder vi køre så længe, der er indhold på næste linje i filen.
      Vi initialiserer en String line til at være den næste linje i filen hver gang loopet gentager sig.
      Efterfølgende laver vi et Scanner objekt kaldet token, som indeholder vores String line
      Vi setter tokens til navn, enavn og rest
      Hvis token rest = restance (i stedet for betalt), printer vi den linje i txt filen til konsollen.
      Når while-loopet afslutter, vender programmet tilbage til submenu'en.
   
   */
   public void visRestance() throws Exception{
      Scanner RestanceKonti = new Scanner(new File("visRestance.txt"));
      
      List<Kasserer> vis = new ArrayList<>();
      while(RestanceKonti.hasNextLine()){
         String line = RestanceKonti.nextLine();
         Scanner token = new Scanner(line);
         
         String navn = token.next();
         super.setFornavn(navn);
         
         String enavn = token.next();
         super.setEfternavn(enavn);
         
         String rest = token.next();
         super.setRestance(rest);
         
            if(rest.equals("Restance")){
           
            System.out.println(line.toString()); 
            }         
         
         } 
         System.out.println();
         subMenu(); 
   }
   
   public String toString() {
      return super.getFornavn()+" "+super.getEfternavn()+" "+ super.getRestance();
   }
   
   public void redigerKontigent(){
      System.out.println("Hej konti");
   }
}