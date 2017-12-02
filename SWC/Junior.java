public class Junior extends Medlem {
   
   public Junior(){}
   
   //polymorphisme
   @Override
   public double getPris() { return super.getPris() + 1000.0; }
}