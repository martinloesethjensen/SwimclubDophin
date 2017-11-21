import java.util.*;
import java.io.*;

public class Formand extends Ansat {
   public Formand(String firstName, String lastName, int alder, String aktivitetsForm){
      super(firstName, lastName, alder, aktivitetsForm);
   }
   
   public Formand(){
   }
   
   public void saveMember(String fileName)throws Exception{
      PrintStream toFile = new PrintStream(new File(fileName));
      toFile.print(info());  
   }
   public String info(){
      return firstName + " " + lastName + " " + alder + " " + aktivitetsForm;
   }

	/**
	 * 
	 * @param title
	 */
	public void subMenu(String title) {
		
	}


}