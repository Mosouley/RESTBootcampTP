package com.bootcamp.entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author soul entite fournisseur ayant une cle prim id et un champ nom
 */
@Entity
@DiscriminatorValue("FOURNISSEUR")
public class Fournisseur extends Personne {

    @ManyToMany
    private List<Programme> programmes;

    @ManyToMany
    private List<Projet> projets;


    public List<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
}
