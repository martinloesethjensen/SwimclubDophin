import java.util.*;
import java.io.*;

public class Passiv extends Kontingent  {
   
   public Passiv(double pris){
      super(pris);
   }
   //getter and setters til pris 
   
   
   //polymorphisme
   public double getPris() { return super.getPris() + 500.0; } 
}