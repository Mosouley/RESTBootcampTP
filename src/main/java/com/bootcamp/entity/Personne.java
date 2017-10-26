
package com.bootcamp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Link;

/**
 *
 * @author soul
 */
//Classe mere personne dont  vont heritez les trois classes filles
@Entity
@Table(name = "tp_personne")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PERSONNE")
@DiscriminatorValue("PERSONNE")
public class Personne implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @NotNull(message = "La colonne nom ne peut �tre vide")
    @Column(nullable = false,length = 45)
    protected String nom; //second champ commun � la hierarchie

    //Introduction d'un lien propre à chaque entite, et comme entite personne est la mere de 3 autres
    //l'insertion se fera à son niveau
    @Transient
    private Link self; // utilisant l'API JAX-RS 2

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
