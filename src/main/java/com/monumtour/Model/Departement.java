package com.monumtour.Model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Departement implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1464564L;

    @Id
    private String numDep;
    @Column(name = "nomDep", length = 255)
    private String nomDep;
    @Column(name = "chefLieu", length = 255)
    private String chefLieu;
    @OneToMany(mappedBy = "dep", fetch = FetchType.LAZY)
    private Collection<Lieu> lieux;

    public Departement() {
        super();
    }

    public Departement(String numDep, String chefLieu, String nomDep) {
        super();
        this.numDep = numDep;
        this.nomDep = nomDep;
        this.chefLieu = chefLieu;

    }

    public String getNumDep() {
        return numDep;
    }

    public void setNumDep(String numDep) {
        this.numDep = numDep;
    }

    public String getChefLieu() {
        return chefLieu;
    }

    public void setChefLieu(String chefLieu) {
        this.chefLieu = chefLieu;
    }

    public String getNomDep() {
        return nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public Collection<Lieu> getLieux() {
        return lieux;
    }

    public void setLieux(Collection<Lieu> lieux) {
        this.lieux = lieux;
    }

}
