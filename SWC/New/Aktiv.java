import java.util.*;
import java.io.*;

public class Aktiv extends Kontingent {
   public Aktiv(double pris) {
      super((int)pris);
   } 
   
   public double getPris() { return (int)super.getPris(); }
}