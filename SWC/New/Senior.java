import java.util.*;
import java.io.*;

public class Senior extends Aktiv {

   public Senior(double pris){ super(pris); }
   
   public double getPris() { return super.getPris() + 1600.0; }
}