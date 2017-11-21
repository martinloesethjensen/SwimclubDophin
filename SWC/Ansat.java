import java.util.*;

/**
*
* @Martin.Valhalla
*/

public class Ansat {

   //fields der også bruges af children
	private String firstName;
	private String lastName;
	private String title;
   private int alder;
   private String aktivitetsform;

   /**
   *
   * Beskrivelse her
   */
   
	public int menu() {
		Scanner console = new Scanner(System.in);
      //initialiserer objekter
      Traener traenerLogin = new Traener();
      Kasserer kassererLogin = new Kasserer();
      Formand formandLogin = new Formand();
      
      int menu = -1;
      while (menu != 0){
         menuInfo();
         
         int dum = 0;
         
         while(dum == 0){
            if(console.hasNextInt()){
               menu = console.nextInt(); 
               break;
            }else System.out.println("Ugyldigt input");
               dum = 1;
         }
         int count = 0;
         switch(menu){
            case 1: formandLogin.subMenu(); break;
            case 2: kassererLogin.subMenu(); break;
            case 3: traenerLogin.subMenu(); break;
            case 0: count++; return 0; 
            default: 
               System.out.println("Tast venligst et nummer der er fremvist");
               if (count > 0){
                  break;
               }else 
                  menu();
         }
      }
      return 0;
	}
   public void menuInfo(){
      System.out.println("Tast 1 for formand");
      System.out.println("Tast 2 for kasserer");
      System.out.println("Tast 3 for traener");
      System.out.println("Tast 0 for at afslutte");
   }

   /**
   *
   * getters and setters
   */
   
	public String getFirstName() { return this.firstName; }

	public void setFirstName(String firstName) { this.firstName = firstName; }

	public String getLastName() { return this.lastName; }

	public void setLastName(String lastName) { this.lastName = lastName; }

	public String getTitle() { return this.title; }

	public void setTitle(String title) { this.title = title; }
   
   public int getAlder() { return this.alder; }
   
   public void setAlder(int alder) { this.alder = alder; }
   
   public String getAktivitetsform() { return this.aktivitetsform; }
   
   public void setAktivitetsform(String aktivitetsform) { this.aktivitetsform = aktivitetsform; } 
}