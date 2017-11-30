import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla
*/

public class KonkurrenceSvoemmer extends Medlem {
   
   public KonkurrenceSvoemmer(String fornavn, String efternavn, int alder, String medlemsskab, String disciplin, double tid, String dato)throws Exception{
      setFornavn(fornavn);
      setEfternavn(efternavn);
      setAlder(alder);
      setMedlemsskab(medlemsskab);
      setDisciplin(disciplin);
      setTid(tid);
      setDato(dato);
      
      //gemmer til fil
      super.saveIt("konkurrenceSvoemmere.txt");
      
      System.out.println("...Medlem gemt som konkurrencesvoemmer...\n\nVil du oprette endnu et medlem?\n");
   }    
   
   //***her skal der være en printf***
   //overskriver toString metoden i forældreklassen
   @Override
   public String toString(){
      return getFornavn()+" "+getEfternavn()+" "+getAlder()+" "
               +getMedlemsskab()+" "+getDisciplin()+" "+getTid()+" "+getDato();
   }
}