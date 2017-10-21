
package com.bootcamp.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author soul
 */
@Entity
public class Fournisseur_Programme implements Serializable {
    
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(nullable = false,length = 45)
    private String compteBancaire;
        @ManyToOne(cascade = CascadeType.PERSIST)
    private Programme programme;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Fournisseur fournisseur;

    public String getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(String compteBancaire) {
        this.compteBancaire = compteBancaire;
    }




    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
