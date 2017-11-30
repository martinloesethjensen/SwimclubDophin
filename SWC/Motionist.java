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
      
      System.out.println("...Medlem gemt som motionist...\n\nVil du oprette endnu et medlem?\n");
   }
   
   //***her skal der være en printf***
   //overskriver toString metoden i forældreklassen
   @Override
   public String toString(){
      return getFornavn()+" "+getEfternavn()+" "+getAlder()+" "+getMedlemsskab();
   } 
} 