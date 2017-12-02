public class Senior extends Medlem {
   
   public Senior(){}
   
   //polymorphisme
   @Override
   public double getPris() { return super.getPris() + 1600.0; }
}