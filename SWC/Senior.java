import java.util.*;
import java.io.*;

public class Senior extends Medlem {
   
   public Senior(){}
   
   @Override
   public double getPris() { return super.getPris() + 1600.0; }
}