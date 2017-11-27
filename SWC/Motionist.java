import java.util.*;
import java.io.*;

public class Motionist extends Medlem {

   public Motionist(String fornavn, String efternavn, int alder, String medlemsskab)throws Exception{
      super.setFornavn(fornavn);
      super.setEfternavn(efternavn);
      super.setAlder(alder);
      super.setMedlemsskab(medlemsskab);
      
      //gemmer til fil
      super.saveIt("motionister.txt");
      
      System.out.println("...Medlem gemt som motionist...\n\nVil du oprette endnu et medlem?\n");
   }
   
   //overskriver toString metoden i forældreklassen
   @Override
   public String toString(){
      return super.getFornavn()+" "+super.getEfternavn()+" "+super.getAlder()+" "+super.getMedlemsskab();
   } 
} 