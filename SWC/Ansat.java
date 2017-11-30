import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla
*/

public class Ansat {

   //fields der ogs� bruges af children
	protected String fornavn;
	protected String efternavn;
   protected int alder;
   protected String restance;
   protected String aktivitetsform;
   protected String medlemsskab;
   protected String disciplin;
   protected double tid;
   protected double staevneTid;
   protected String staevneNavn;
   protected int placering;
   public int menu = -1; //denne field bruges i switch
   protected int count = 0; //bruges nu i tr�ner til 2d array
   protected String dato; //Bruges til dato for bedste tid opn�et
   
   /** 
   * Denne metode lader en v�lge hvilke bruger 
   * man v�lger at logge ind med.
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
            case 0: System.out.print("...LOGGER AF...\n\n"); this.menu = 0; break; 
            default: 
               System.out.println("TAST VENLIGST ET NUMMER DER ER FREMVIST");
               menu();
         }
         this.menu = 0; // Denne springer ud af whileloop
                       // ellers vil den vise menu to gange efter at 
                      // man var kommet tilbage fra en submenu
      }
      return 0;
	}
   
   public void menuInfo()throws Exception {      
      System.out.println("VAELG BRUGER:");
      System.out.printf("%-15s%s\n", "FORMAND:", "TRYK 1");
      System.out.printf("%-15s%s\n", "KASSERER:", "TRYK 2");
      System.out.printf("%-15s%s\n", "TRAENER:", "TRYK 3");
      System.out.println();
      System.out.printf("%-15s%s\n", "LOG AF", "TRYK 0");
   }
   
   /**
   * Tester input fra console om det er tal.
   *
   * try/catch bruges til at h�ndtere Exceptions.
   * try indeholder den "normale" kode - den kode som vi forventer g�r godt.
   * Hvis alt g�r godt, s� k�rer den videre, men hvis ikke k�rer catch blocken. 
   * catch hvis der kastes en exception.
   * En finally block er clean-up. Denne k�rer lige meget om den f�r k�rt try eller catch. 
   * Vi bruger ikke finally block i vores kode her.  
   *
   * "Integer" er en klasse nedarvet fra "Numbers" klasse, der igen er nedarvet fra "Object" klassen
   * Integer har en masse fields og methoder i sig, som vi g�r brug af her.
   * Integer.parseInt(input) tager imod String variable fra consolen.
   * Den omdanner til int.  
   */
   
   public int testConsoleInput(Scanner console){
      while(true){
         String input = console.next();
         
         try{
            return this.menu = Integer.parseInt(input);
         }catch(Exception e){
            System.out.println("UGYLDIGT INPUT");
            this.menu = -1; //s�rger for at den ikke kan komme indi andre cases hvis den fejler
            break;//hopper ud
         }
      }
      return 0;//dummy eftersom vi har en break som afslutter i catch blocken
               //derfor skal der v�re en return. 
   } 
   
   public String toString(){ return " "; } 

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
   
   public String getDato() {return this.dato;}
   
   public void setDato(String dato){this.dato = dato;}
   
   public String getRestance() {return this.restance;}
   
   public void setRestance(String restance) {this.restance = restance;}
}