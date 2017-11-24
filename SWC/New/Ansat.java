import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla
*/

public class Ansat {

   //fields der også bruges af children
	private String fornavn;
	private String efternavn;
   private int alder;
   private String aktivitetsform;
   private String medlemsskab;
   private String disciplin;
   private int tid;
   public int menu = -1; //denne field bruges i switch
   protected int count = 0; //bruges nu i træner til 2d array
   
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
               //System.out.println("Tast venligst et nummer der er fremvist");
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
   * Tester input fra console om det er tal 
   */
   
   public int testConsoleInput(Scanner console){
      while(true){
         String input = console.next();
         
         try{
            return this.menu = Integer.parseInt(input);
         }catch(Exception e){
            System.out.println("Ugyldigt input\nTast venligst kun tal");
         }
      }
   } 

   /**
   * getters and setters
   */
   
	public String getFornavn() { return this.fornavn; }

	public void setFornavn(String fornavn) { this.fornavn = fornavn; }

	public String getEfternavn() { return this.efternavn; }

	public void setEfternavn(String efternavn) { this.efternavn = efternavn; }
   
   public int getAlder() { return this.alder; }
   
   public void setAlder(int alder) { this.alder = alder; }
   
   public int getTid() {return this.tid;}
   
   public void setTid(int tid) {this.tid = tid;}
   
   public String getMedlemsskab() { return this.medlemsskab; }
   
   public void setMedlemsskab(String medlemsskab){ this.medlemsskab = medlemsskab; }
   
   public String getDisciplin(){return this.disciplin;}
   
   public void setDisciplin(String disciplin) {this.disciplin = disciplin;}
}