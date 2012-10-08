package com.unicornlabs.kabouter.historian.data_objects;
// Generated 08/10/2012 4:04:03 PM by Hibernate Tools 3.2.1.GA



/**
 * Automationrule generated by hbm2java
 */
public class Automationrule  implements java.io.Serializable {


     private int id;
     private String sourceId;
     private String sourceIoName;
     private String sourceFunction;
     private Double sourceValue;
     private String targetId;
     private String targetIoName;
     private Double targetValue;

    public Automationrule() {
    }

	
    public Automationrule(int id) {
        this.id = id;
    }
    public Automationrule(int id, String sourceId, String sourceIoName, String sourceFunction, Double sourceValue, String targetId, String targetIoName, Double targetValue) {
       this.id = id;
       this.sourceId = sourceId;
       this.sourceIoName = sourceIoName;
       this.sourceFunction = sourceFunction;
       this.sourceValue = sourceValue;
       this.targetId = targetId;
       this.targetIoName = targetIoName;
       this.targetValue = targetValue;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getSourceId() {
        return this.sourceId;
    }
    
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
    public String getSourceIoName() {
        return this.sourceIoName;
    }
    
    public void setSourceIoName(String sourceIoName) {
        this.sourceIoName = sourceIoName;
    }
    public String getSourceFunction() {
        return this.sourceFunction;
    }
    
    public void setSourceFunction(String sourceFunction) {
        this.sourceFunction = sourceFunction;
    }
    public Double getSourceValue() {
        return this.sourceValue;
    }
    
    public void setSourceValue(Double sourceValue) {
        this.sourceValue = sourceValue;
    }
    public String getTargetId() {
        return this.targetId;
    }
    
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
    public String getTargetIoName() {
        return this.targetIoName;
    }
    
    public void setTargetIoName(String targetIoName) {
        this.targetIoName = targetIoName;
    }
    public Double getTargetValue() {
        return this.targetValue;
    }
    
    public void setTargetValue(Double targetValue) {
        this.targetValue = targetValue;
    }




}

