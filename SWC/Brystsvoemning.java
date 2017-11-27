import java.util.*;
import java.io.*;

public class Brystsvoemning extends Medlem{ 
   
   public Brystsvoemning(String fornavn, String efternavn, String staevneNavn, double staevneTid, int placering, String disciplin)throws Exception{
      super.setFornavn(fornavn);
      super.setEfternavn(efternavn);
      super.setStaevneNavn(staevneNavn);
      super.setStaevneTid(staevneTid);
      super.setPlacering(placering);
      super.setDisciplin(disciplin);
      
      //gemmer til fil
      super.saveIt("brystsvoemning.txt");
   }
   
   @Override   
   public String toString(){
      return super.getFornavn()+" "+super.getEfternavn()+" "+super.getStaevneNavn()+" "
               +super.getDisciplin()+" "+super.getStaevneTid()+" "+super.getPlacering();
   }
}