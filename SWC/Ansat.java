import java.util.*;
/**
*
* @Martin Valhalla
*/
public class Ansat {

	private String firstName;
	private String lastName;
	private String title;
   private int alder;
   private String aktivitetsform;

	public int menu() {
		Scanner console = new Scanner(System.in);
      //initialize objekter
      Traener traenerLogin = new Traener();
      Kasserer kassererLogin = new Kasserer();
      Formand formandLogin = new Formand();
      
      int menu = -1;
      while (menu != 0){
         menuInfo();
         this = console.nextInt(); 
         
         switch(menu){
            case 1: formandLogin.subMenu(); break;
            case 2: kassererLogin.subMenu(); break;
            case 3: //traenerLogin.subMenu(); break;
            case 0: return 0; 
         }
      }
      
      
      return 0;
	}
   public void menuInfo(){
      System.out.println("Tast 1 for formand");
      System.out.println("Tast 2 for kasserer");
      System.out.println("Tast 3 for træner");
      System.out.println("Tast 0 for at afslutte");
   }

/**
*
* getters and setters
*/

	public String getFirstName() {
		return this.firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}