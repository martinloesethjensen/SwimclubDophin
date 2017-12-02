import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla
*/

public class Motionist extends Medlem {

   public Motionist(String fornavn, String efternavn, int alder, String medlemsskab)throws Exception{
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setAlder(alder);
      setMedlemsskab(medlemsskab);
      
      //gemmer til fil
      super.saveIt("motionister.txt");
      
      System.out.println("...MEDLEM GEMT SOM MOTIONIST...\n\nVIL DU OPRETTE ENDNU ET MEDLEM?\n");
   }
   
   //overskriver toString metoden i forældreklassen Medlem
   @Override
   public String toString(){
      return getFornavn()+" "+getEfternavn()+" "+getAlder()+" "+getMedlemsskab();
   } 
} 