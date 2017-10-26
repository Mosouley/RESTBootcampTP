
package com.bootcamp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Link;


/**
 *
 * @author soul
 * entite Projet
 * ayant une cle prim id et un champ nom
 */
@Entity
@Table(name = "tp_projet")
public class Projet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //idem introduction d'un attribut link pour JAX-RS2
    @Transient //car ce n'est pas nécessaire de sauvegarder
    private Link self;

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }
    
    @NotNull(message = "le nom du projet est obligatoire et ne peut �tre vide")
    @Column( nullable = false,length=45)
    private String nom;
    
    @NotNull(message = "l'objectif du projet est obligatoire et ne peut �tre vide")
    @Column( nullable = false,length=45)
    private String objectif;
    
    @NotNull(message = "la date de d�but ne peut �tre vide")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeDebut;
    
    @NotNull(message = "la date de fin ne peut �tre vide")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeFin;
    
    @NotNull(message = "le budget pr�visionnel ne peut �tre vide")
    @Column(nullable = false)
    private int budgetPrevisionnel;
    
    @NotNull(message = "le budget effectitf du projet est obligatoire et ne peut �tre vide")
    @Column(nullable = false)
    private int budgetEffectif;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Programme programme;
    
    @OneToMany   //(mappedBy = "projet")
    private List<Livrable> livrables;
    
     @ManyToMany
    private List<Beneficiaire> beneficiaires;
    
    @ManyToMany
    private List<Fournisseur> fournisseurs;
    
      
    @ManyToMany
    private List<Bailleur_Programme> bailleurs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public Date getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public int getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    public void setBudgetPrevisionnel(int budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    public int getBudgetEffectif() {
        return budgetEffectif;
    }

    public void setBudgetEffectif(int budgetEffectif) {
        this.budgetEffectif = budgetEffectif;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private IndicateurPerformance indicateurPerformance;

    public List<Beneficiaire> getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public List<Bailleur_Programme> getBailleurs() {
        return bailleurs;
    }

    public void setBailleurs(List<Bailleur_Programme> bailleurs) {
        this.bailleurs = bailleurs;
    }

    public List<Livrable> getLivrables() {
        return livrables;
    }

    public void setLivrables(List<Livrable> livrables) {
        this.livrables = livrables;
    }
    
}
