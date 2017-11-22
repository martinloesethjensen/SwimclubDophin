import java.util.*;

/**
* @Martin.Valhalla
*/

public class Ansat {

   //fields der også bruges af children
	private String firstName;
	private String lastName;
	//private String title; bruges ikke
   private int alder;
   private String aktivitetsform;
   protected int menu = -1; //denne field bruges i switch
   
   /**
   * Denne metode lader en vælge hvilke bruger 
   * man vælger at logge ind med.
   */
   
	public int menu()throws Exception{
		Scanner console = new Scanner(System.in);
      //initialiserer objekter
      Traener traenerLogin = new Traener();
      Kasserer kassererLogin = new Kasserer();
      Formand formandLogin = new Formand();
      
      //int menu = -1;
      while (this.menu != 0){
         menuInfo();
         
         // metode der tester input
         testConsoleInput(console);
         
         switch(this.menu){
            case 1: formandLogin.subMenu(); break;
            case 2: kassererLogin.subMenu(); break;
            case 3: traenerLogin.subMenu(); break;
            case 0: System.out.print("Logger af..."); this.menu = 0; break; //tilføj tid 
            default: 
               System.out.println("Tast venligst et nummer der er fremvist");
               menu();
         }
         this.menu = 0; // Denne springer ud af whileloop
                       // ellers vil den vise menu to gange efter at 
                      // man var kommet tilbage fra en submenu
      }
      return 0;
	}
   
   public void menuInfo(){
      System.out.println("Tast 1 for Formand");
      System.out.println("Tast 2 for Kasserer");
      System.out.println("Tast 3 for Traener");
      System.out.println("Tast 0 for at afslutte");
   }
   
   /**
   * Tester input fra console
   */
   
   public int testConsoleInput(Scanner console){
      this.menu = -1;
      int dum = 0;
      while(dum == 0){
         if(console.hasNextInt()){
            this.menu = console.nextInt(); 
            break;
         }else System.out.println("Ugyldigt input");
            this.menu = -1; //denne er placeret så når man i 
                           //formand undgår at den automatisk vælger 
                          //case 1 
            dum = 1; //hopper ud af loopet 
            //Denne skal rettes
      }
      return this.menu;
   } 

   /**
   * getters and setters
   */
   
	public String getFirstName() { return this.firstName; }

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return this.lastName; }

	public void setLastName(String lastName) { this.lastName = lastName; }

	//public String getTitle() { return this.title; }

	//public void setTitle(String title) { this.title = title; }
   
   public int getAlder() { return this.alder; }
   
   public void setAlder(int alder) { this.alder = alder; }
   
   public String getAktivitetsform() { return this.aktivitetsform; }
   
   public void setAktivitetsform(String aktivitetsform) { this.aktivitetsform = aktivitetsform; } 
}