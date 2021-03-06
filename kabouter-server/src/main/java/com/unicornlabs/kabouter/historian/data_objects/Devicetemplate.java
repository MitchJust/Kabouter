package com.unicornlabs.kabouter.historian.data_objects;
// Generated 03/07/2012 7:11:29 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.List;

/**
 * Devicetemplate generated by hbm2java
 */
public class Devicetemplate  implements Serializable {


     private String templatename;
     private int numio;
     private List<String> ionames;
     private List<String> iotypes;
     private List<String> iodirections;

    public Devicetemplate() {
    }

	
    public Devicetemplate(String templatename, int numio) {
        this.templatename = templatename;
        this.numio = numio;
    }
    public Devicetemplate(String templatename, int numio, List<String> ionames, List<String> iotypes, List<String> iodirections) {
       this.templatename = templatename;
       this.numio = numio;
       this.ionames = ionames;
       this.iotypes = iotypes;
       this.iodirections = iodirections;
    }
   
    public String getTemplatename() {
        return this.templatename;
    }
    
    public void setTemplatename(String templatename) {
        this.templatename = templatename;
    }
    public int getNumio() {
        return this.numio;
    }
    
    public void setNumio(int numio) {
        this.numio = numio;
    }
    public List<String> getIonames() {
        return this.ionames;
    }
    
    public void setIonames(List<String> ionames) {
        this.ionames = ionames;
    }
    public List<String> getIotypes() {
        return this.iotypes;
    }
    
    public void setIotypes(List<String> iotypes) {
        this.iotypes = iotypes;
    }
    public List<String> getIodirections() {
        return this.iodirections;
    }
    
    public void setIodirections(List<String> iodirections) {
        this.iodirections = iodirections;
    }




}


