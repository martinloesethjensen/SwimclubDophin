import java.util.*;
import java.io.*;

public class Medlem {
   
   private String fornavn;
   private String efternavn;
   private String medlemsskab;
   private String disciplin;
   private String staevneNavn;
   private int alder;
   private int tid;
   private int staevneTid;
   private int placering;
   
      
   //default constructor
   public Medlem(){}
   
   //motionist
   public Medlem(String fornavn, String efternavn, int alder, String medlemsskab){
      this.fornavn = fornavn;
      this.efternavn = efternavn;
      this.alder = alder;
      this.medlemsskab = medlemsskab;
   }
   
   //konkurrence
   public Medlem(String fornavn, String efternavn, int alder, String medlemsskab, String disciplin, int tid){
      this.fornavn = fornavn;
      this.efternavn = efternavn;
      this.alder = alder;
      this.medlemsskab = medlemsskab;
      this.disciplin = disciplin;
      this.tid = tid;
   }


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

public int getTid() {return this.tid;}
public void setTid(int tid) {this.tid = tid;}

public String getStaevneNavn() {return this.staevneNavn;}
public void setStaevneNavn(String staevneNavn){this.staevneNavn = staevneNavn;}

public int getStaevneTid() {return this.staevneTid;}
public void setStaevneTid(int staevneTid) {this.staevneTid = staevneTid;}

public int getplacering(){return this.staevneTid;}
public void setplacering(int placering) {this.placering = placering;}

}