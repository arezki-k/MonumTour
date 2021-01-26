package com.monumtour.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Monument implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String codeM;
    private String nomM;
    private String proprietaire;
    private String typeMonument;
    private float latitude;
    private float longitude;
    @ManyToOne
    @JoinColumn(name="FK_CodeInsee")
    private Lieu localite;
    //creer une variable de type
    @ManyToMany //possibilte de plusieurs associations de monuments vers une celebrite
    @JoinTable(name="AssocieA",joinColumns= @JoinColumn(name="codeM"),
            inverseJoinColumns=@JoinColumn(name="codeCelebrites"))
    private Collection<Celebrite> celebrites;


    public Monument() {
        super();
    }
    public Monument(String codeM, String nomM, String propritaire, String typeMonument, float latitude,
                    float longitude,Lieu localite) {
        super();
        this.codeM = codeM;
        this.nomM = nomM;
        this.proprietaire = propritaire;
        this.typeMonument = typeMonument;
        this.latitude = latitude;
        this.longitude = longitude;
        this.localite=localite;
    }
    public String getCodeM() {
        return codeM;
    }
    public void setCodeM(String codeM) {
        this.codeM = codeM;
    }
    public String getNomM() {
        return nomM;
    }
    public void setNomM(String nomM) {
        this.nomM = nomM;
    }
    public String getProprietaire() {
        return proprietaire;
    }
    public void setProprietaire(String propritaire) {
        this.proprietaire = propritaire;
    }
    public String getTypeMonument() {
        return typeMonument;
    }
    public void setTypeMonument(String typeMonument) {
        this.typeMonument = typeMonument;
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
    public Lieu getLocalite() {
        return localite;
    }
    public void setLocalite(Lieu localite) {
        this.localite = localite;
    }
    public Collection<Celebrite> getCelebrites() {
        return celebrites;
    }
    public void setCelebrites(List<Celebrite> celebrites) {
        this.celebrites = celebrites;
    }




}

