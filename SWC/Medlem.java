import java.util.*;
import java.io.*;

/**
* @Martin.Valhalla
*/

public class Medlem {
   
   //fields
   protected String fornavn;
   protected String efternavn;
   protected String medlemsskab;
   protected String disciplin;
   protected String staevneNavn;
   protected int alder;
   protected double tid;
   protected double staevneTid;
   protected int placering;
   protected double pris;
   protected String dato;
   
   //default constructor
   public Medlem(){}
      
   public String toString(){ return " "; }
   
   //Metode til at gemme til fil
   
   
   public void saveIt(String filNavn)throws Exception{
      PrintStream nytMemberInfo = new PrintStream(new FileOutputStream(filNavn,true));
      nytMemberInfo.println(toString());
      System.out.print("\n");      
   }
   
   /**
   *getters og setters
   */
   
   public String getFornavn() {return this.fornavn;}
   public void setFornavn(String fornavn) {this.fornavn = fornavn;}
   
   public String getEfternavn() {return this.efternavn;}
   public void setEfternavn(String efternavn) {this.efternavn = efternavn;}
   
   public String getMedlemsskab() {return this.medlemsskab;}
   public void setMedlemsskab(String medlemsskab) {this.medlemsskab = medlemsskab;}
   
   public String getDisciplin(){return this.disciplin;}
   public void setDisciplin(String disciplin) {this.disciplin = disciplin;}
   
   public int getAlder() {return this.alder;}
   public void setAlder(int alder){this.alder = alder;}
   
   public double getTid() {return this.tid;}
   public void setTid(double tid) {this.tid = tid;}
   
   public String getStaevneNavn() {return this.staevneNavn;}
   public void setStaevneNavn(String staevneNavn){this.staevneNavn = staevneNavn;}
   
   public double getStaevneTid() {return this.staevneTid;}
   public void setStaevneTid(double staevneTid) {this.staevneTid = staevneTid;}
   
   public int getPlacering(){return this.placering;}
   public void setPlacering(int placering) {this.placering = placering;}

   public double getPris() { return this.pris; }
   public void setPris(double pris) { this.pris = pris; }
      
   public String getDato() {return this.dato;}
   public void setDato(String dato){this.dato = dato;}

}