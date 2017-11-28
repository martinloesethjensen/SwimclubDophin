import java.util.*;
import java.io.*;

public class Junior extends Kontingent {
   
   public Junior(){}
   
   @Override
   public double getPris() { return super.getPris() + 1000.0; }
}