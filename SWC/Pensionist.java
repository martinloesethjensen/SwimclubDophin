import java.util.*;
import java.io.*;

public class Pensionist extends Aktiv {
   
   public Pensionist(double pris){ super(pris); }
   
   @Override
   public double getPris() { return super.getPris() + (double)(1600.0 * 0.75); }
} 