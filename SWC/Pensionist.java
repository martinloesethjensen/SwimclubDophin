import java.util.*;
import java.io.*;

public class Pensionist extends Kontingent {
   
   public Pensionist(){}
   
   @Override
   public double getPris() { return super.getPris() + (double)(1600.0 * 0.75); }
} 