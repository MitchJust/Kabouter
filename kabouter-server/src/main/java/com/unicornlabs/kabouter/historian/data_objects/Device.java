package com.unicornlabs.kabouter.historian.data_objects;
// Generated 25/06/2012 2:06:16 PM by Hibernate Tools 3.2.1.GA

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Device generated by hbm2java
 */
@Entity
@Table(name = "device", schema = "kabouterserver")
public class Device implements java.io.Serializable {

    private String id;
    private String ipaddress;
    private String type;
    private Boolean haspowerlogging;
    private Integer numio;
    private List<String> ionames;
    private String displayname;

    public Device() {
    }

    public Device(String id, String ipaddress) {
        this.id = id;
        this.ipaddress = ipaddress;
    }

    public Device(String id, String ipaddress, String type, Boolean haspowerlogging, Integer numio, List<String> ionames, String displayname) {
        this.id = id;
        this.ipaddress = ipaddress;
        this.type = type;
        this.haspowerlogging = haspowerlogging;
        this.numio = numio;
        this.ionames = ionames;
        this.displayname = displayname;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "ipaddress", nullable = false)
    public String getIpaddress() {
        return this.ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Column(name = "type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "haspowerlogging")
    public Boolean getHaspowerlogging() {
        return this.haspowerlogging;
    }

    public void setHaspowerlogging(Boolean haspowerlogging) {
        this.haspowerlogging = haspowerlogging;
    }

    @Column(name = "numio")
    public Integer getNumio() {
        return this.numio;
    }

    public void setNumio(Integer numio) {
        this.numio = numio;
    }

    @Column(name = "ionames")
    public List<String> getIonames() {
        return this.ionames;
    }

    public void setIonames(List<String> ionames) {
        this.ionames = ionames;
    }

    @Column(name = "displayname")
    public String getDisplayname() {
        return this.displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
}