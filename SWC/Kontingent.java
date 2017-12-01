import java.util.*;
import java.io.*;

public class Kontingent {

   protected String fornavn;
   protected String efternavn;
   protected int alder;
   protected String medlemskab;
   protected String disciplin;
   protected double tid;
   protected String dato;
   
   /*public Kontingent(){}
      
   public Kontingent (int alder) { super(alder); }
   
   public Kontingent (int alder, double pris) { super(alder, pris); }
   */
   
   public String getFornavn() {return this.fornavn;}
   public void setFornavn(String fornavn) {this.fornavn = fornavn;}

   public String getEfternavn() {return this.efternavn;}
   public void setEfternavn(String efternavn) {this.efternavn = efternavn;}

   public int getAlder() {return this.alder;}
   public void setAlder(int alder) {this.alder = alder;}
   
   public String getMedlemskab() {return this.medlemskab;}
   public void setMedlemskab(String medlemskab) {this.medlemskab = medlemskab;}
   
   public String getDisciplin() {return this.disciplin;}
   public void setDisciplin(String disciplin) {this.disciplin = disciplin;}

   public double getTid() {return this.tid;}
   public void getTid(double tid) {this.tid = tid;}
   
   public String getDato() {return this.dato;}
   public void setDato(String dato) {this.dato = dato;}
}


