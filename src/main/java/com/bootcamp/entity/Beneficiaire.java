package com.bootcamp.entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author soul entite Beneficiaire ayant une cle prim id et un champ nom
 */
@Entity //(name = "tp_beneficiaire")
@DiscriminatorValue("BENEFICIAIRE")
public class Beneficiaire extends Personne {


    @ManyToMany
    private List<Projet> projets;

    @ManyToMany
    private List<Programme> programmes;


    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public List<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }
}
