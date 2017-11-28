import java.util.*;
import java.io.*;

public class Passiv extends Kontingent  {
   
   // denne skal nok bare implementeres direkte i kontigent klassen
   
   public Passiv(double pris){ super(pris); }   
   
   //polymorphisme
   //type casting to int because it might be lossy
   public double getPris() { return super.getPris() + 500.0; } 
}