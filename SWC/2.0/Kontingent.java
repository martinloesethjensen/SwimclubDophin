import java.util.*;
import java.io.*;

public class Kontingent {

   private int alder;
   private double pris;
   
   public Kontingent(){}
      
   public Kontingent (int alder) {}
   
   public Kontingent (int alder, double pris) {}
   
   
   
   //getters and setters
   public int getAlder() { return this.alder; }
   
   public void setAlder(int alder) { this.alder = alder; }
   
   public double getPris() { return this.pris; }
   
   public void setPris(double pris) { this.pris = pris; }
}