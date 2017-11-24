import java.util.*;
import java.io.*;

public class Passiv extends Kontingent  {
   
   public Passiv(double pris){
      super((int)pris);
   }
   //getter and setters til pris 
   
   
   //polymorphisme
   //type caster
   public double getPris() { return (int)super.getPris() + 500.0; } 
}