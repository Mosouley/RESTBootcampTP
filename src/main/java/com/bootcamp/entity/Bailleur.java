
package com.bootcamp.entity;

import com.bootcamp.jpa.enums.TypeDeBailleur;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/**
 *
 * @author soul
 * entite Bailleur
 * ayant une cle prim id et un champ nom
 */
@Entity  
@DiscriminatorValue("BAILLEUR")
public class Bailleur extends Personne {
 
    @Enumerated(EnumType.STRING)
    @Lob
    private TypeDeBailleur typeDeBailleur;
    
    @OneToMany
    private List<Bailleur_Programme> bailleur_programme;
    
    @ManyToMany
    private List<Projet> projets;


    public TypeDeBailleur getTypeDeBailleur() {
        return typeDeBailleur;
    }

    public void setTypeDeBailleur(TypeDeBailleur typeDeBailleur) {
        this.typeDeBailleur = typeDeBailleur;
    }

   
    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public List<Bailleur_Programme> getBailleur_programme() {
        return bailleur_programme;
    }

    public void setBailleur_programme(List<Bailleur_Programme> bailleur_programme) {
        this.bailleur_programme = bailleur_programme;
    }
    
}
