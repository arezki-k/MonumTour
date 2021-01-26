package com.monumtour.Model;


import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.transaction.annotation.Transactional;

@Entity

public class Lieu implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1457852374L;

    @Id
    private String codeInsee;
    private String nomCom;
    private float latitude;
    private float longitude;
    //la cascade va permettre de d'appliquer les operations en cascade
    @OneToMany(mappedBy="localite",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Collection<Monument> monuments;

    @ManyToOne
    @JoinColumn(name="Fk_Dep")
    private Departement dep;

    public Lieu() {
    }

    public Lieu(String codeInsee, String nomCom, float latitude, float longitude,Departement dep) {
        super();
        this.codeInsee = codeInsee;
        this.nomCom = nomCom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dep=dep;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getNomCom() {
        return nomCom;
    }

    public void setNomCom(String nomCom) {
        this.nomCom = nomCom;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Collection<Monument> getMonuments() {
        return monuments;
    }

    public void setMonuments(Collection<Monument> monuments) {
        this.monuments = monuments;
    }

    public Departement getDep() {
        return dep;
    }


    public void setDep(Departement dep) {
        this.dep = dep;
    }






}
