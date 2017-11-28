import java.util.*; // for Scanner
import java.io.*; // for PrintStream


public class Kasserer extends Ansat {
   
   public Kasserer(){}
   
   public Kasserer(String fornavn, String efternavn, String restance){
      //statement
   
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
         String fornavn = token.next();
         String efternavn = token.next();
         String restance = token.next();
         
         Kasserer kas = new Kasserer(fornavn, efternavn, restance);
         vis.add(kas);
      }
      
      for(Kasserer visReastance : vis){
         for (int i = 0; i < vis.size(); i++){
            //if(vis.indexOf("Restance")){
               System.out.println(vis.get(i));
            //}
         }
      }
   }
   
   /**
   * Beskrivelse her
   */
   
   public void redigerKontigent(){
      System.out.println("Hej konit");
   }
}