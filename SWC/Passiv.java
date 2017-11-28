import java.util.*;
import java.io.*;

public class Passiv extends Kontingent  {
   
   public Passiv(double pris){ super((int)pris); }   
   
   //polymorphisme
   //type casting to int because it might be lossy
   public double getPris() { return (int)super.getPris() + 500.0; } 
}