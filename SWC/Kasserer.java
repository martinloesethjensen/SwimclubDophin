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
               visRestance();
               
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
               System.out.println("Tast venligst et nummer der er fremvist");
               subMenu();
         }
         break; //for kun at komme ud af dette loop
      }
	}
   
   public void subMenuInfo(){
      System.out.println("Tast 1 for at printe liste");
      System.out.print("Tast 0 for at gaa tilbage\n<==\n");
   }

   
   /**
   * Beskrivelse her
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
         
         Kasserer kas = new Kasserer(super.getFornavn(), super.getEfternavn(), super.getRestance());
         vis.add(kas);
         
         }
               System.out.println(vis.toString());
      
       
   }
   
   public String toString() {
      
      return super.getFornavn()+" "+super.getEfternavn()+" "+ super.getRestance();
   }
   
   
   
   
   public void redigerKontigent(){
      System.out.println("Hej konti");
   }
}