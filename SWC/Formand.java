import java.util.*;
import java.io.*;

/**
*
* @Martin.Valhalla 
* @Christian.C-Strunge
*/

public class Formand extends Ansat {
   
   public Formand(){}
   
   /*public Formand(String firstName, String lastName, int alder, String aktivitetsForm){
      super(firstName, lastName, alder, aktivitetsForm);
   }*/
     
   
	/**
	* 
	* beskrivelse her
	*/
   
	public void subMenu() {
	   Scanner console = new Scanner(System.in);
      int menu = -1;
      while(menu != 0){
         //menuInfo
         
         
      }	
	}

   public void saveMember(String fileName)throws Exception{
      PrintStream toFile = new PrintStream(new File(fileName));
      //toFile.print(info());  
   }
   /*public String info(){
      return firstName + " " + lastName + " " + alder + " " + aktivitetsForm;
   }*/

}