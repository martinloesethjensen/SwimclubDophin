import java.util.*;
import java.io.*;

public class Passiv extends Medlem  {
   
   // denne skal nok bare implementeres direkte i kontigent klassen
   
   public Passiv(){}   
   
   //polymorphisme
   //type casting to int because it might be lossy
   public double getPris() { return super.getPris() + 500.0; } 
}