/**
* @Martin.Valhalla
*/

public class Pensionist extends Medlem {
   
   public Pensionist(){}
   
   //polymorphisme
   @Override
   public double getPris() { return super.getPris() + (double)(1600.0 * 0.75); }
} 