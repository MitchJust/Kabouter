package com.unicornlabs.kabouter.historian.data_objects;
// Generated 03/07/2012 7:11:29 PM by Hibernate Tools 3.2.1.GA



/**
 * Powerlog generated by hbm2java
 */
public class Powerlog  implements java.io.Serializable {


     private PowerlogId id;
     private Double power;

    public Powerlog() {
    }

	
    public Powerlog(PowerlogId id) {
        this.id = id;
    }
    public Powerlog(PowerlogId id, Double power) {
       this.id = id;
       this.power = power;
    }
   
    public PowerlogId getId() {
        return this.id;
    }
    
    public void setId(PowerlogId id) {
        this.id = id;
    }
    public Double getPower() {
        return this.power;
    }
    
    public void setPower(Double power) {
        this.power = power;
    }




}


