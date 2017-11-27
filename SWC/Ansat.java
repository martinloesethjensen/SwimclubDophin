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
   private double tid;
   private double staevneTid;
   private String staevneNavn;
   private int placering;
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
      
      while (this.menu != 0){
         menuInfo();
         
         // metode der tester input
         testConsoleInput(console);
         
         switch(this.menu){
            case 1: formandLogin.subMenu(); break;
            case 2: kassererLogin.subMenu(); break;
            case 3: traenerLogin.subMenu(); break;
            case 0: System.out.print("Logger af...\n\n"); this.menu = 0; break; 
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
   
   public void menuInfo()throws Exception {
      /*System.out.println("Tast 1 for Formand");
      System.out.println("Tast 2 for Kasserer");
      System.out.println("Tast 3 for Traener");
      System.out.println("Tast 0 for at afslutte");*/
      
      System.out.println("VÆLG BRUGER:");
      System.out.printf("%-15s%s\n", ">FORMAND:", "Tryk 1");
      System.out.printf("%-15s%s\n", ">KASSERER:", "Tryk 2");
      System.out.printf("%-15s%s\n", ">TRAENER:", "Tryk 3");
      System.out.println();
      System.out.printf("%-15s%s\n", ">LOG AF", "TRYK 0");
   }
   
   /**
   * Tester input fra console om det er tal.
   *
   * try/catch bruges til at håndtere Exceptions.
   * try indeholder den "normale" kode - den kode som vi forventer går godt.
   * Hvis alt går godt, så kører den videre, men hvis ikke kører catch blocken. 
   * catch hvis der kastes en exception.
   * En finally block er clean-up. Denne kører lige meget om den får kørt try eller catch. 
   * Vi bruger ikke finally block i vores kode her.  
   *
   * "Integer" er en klasse nedarvet fra "Numbers" klasse, der igen er nedarvet fra "Object" klassen
   * Integer har en masse fields og methoder i sig, som vi gør brug af her.
   * Integer.parseInt(input) tager imod String variable fra consolen.
   * Den omdanner til int.  
   */
   
   public int testConsoleInput(Scanner console){
      while(true){
         String input = console.next();
         
         try{
            return this.menu = Integer.parseInt(input);
         }catch(Exception e){
            System.out.println("Ugyldigt input");
            this.menu = -1; //sørger for at den ikke kan komme indi andre cases hvis den fejler
            break;//hopper ud
         }
      }
      return 0;//dummy eftersom vi har en break som afslutter i catch blocken
               //derfor skal der være en return. 
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
   
   public double getTid() {return this.tid;}
   
   public void setTid(double tid) {this.tid = tid;}
   
   public String getMedlemsskab() { return this.medlemsskab; }
   
   public void setMedlemsskab(String medlemsskab){ this.medlemsskab = medlemsskab; }
   
   public String getDisciplin(){return this.disciplin;}
   
   public void setDisciplin(String disciplin) {this.disciplin = disciplin;}
   
   public int getPlacering(){return this.placering;}
   
   public void setPlacering(int placering) {this.placering = placering;}
   
   public String getStaevneNavn() {return this.staevneNavn;}
   
   public void setStaevneNavn(String staevneNavn){this.staevneNavn = staevneNavn;}
   
   public double getStaevneTid() {return this.staevneTid;}
   
   public void setStaevneTid(double staevneTid) {this.staevneTid = staevneTid;}
}