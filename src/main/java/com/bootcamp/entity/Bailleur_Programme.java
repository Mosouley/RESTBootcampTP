
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
 entite Bailleur_Programme
 ayant une cle prim id et un champ nom
 */
@Entity  
public class Bailleur_Programme implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(nullable = false,length = 45)
    private String capital;

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
   
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Programme programme;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Bailleur bailleur;

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
