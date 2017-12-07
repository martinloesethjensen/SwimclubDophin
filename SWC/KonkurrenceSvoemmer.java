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
      
      System.out.println("...MEDLEM GEM SOM KONKURRENCESVOEMMER...\n\n");
   }    
   
   //overskriver toString metoden i forældreklassen Medlem
   @Override
   public String toString(){
      return getFornavn()+" "+getEfternavn()+" "+getAlder()+" "
               +getMedlemsskab()+" "+getDisciplin()+" "+getTid()+" "+getDato();
   }
}