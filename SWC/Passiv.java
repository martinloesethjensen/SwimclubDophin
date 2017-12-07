/**
* @Martin.Valhalla
*/

public class Passiv extends Medlem  {
   
   public Passiv(){}   
   
   //polymorphisme
   public double getPris() { return super.getPris() + 500.0; } 
}