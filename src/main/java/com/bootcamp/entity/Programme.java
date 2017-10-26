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
 * @author soul entite Beneficiaire ayant une cle prim id et un champ nom
 */
@Entity             //(name = "tp_programme")
@Table(name = "tp_programme")
public class Programme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //idem introduction d'un attribut link pour JAX-RS2
    @Transient
    private Link self;

    @NotNull(message = "le nom du projet est obligatoire et ne peut �tre vide")
    @Column(nullable = false, length = 45)
    private String nom;

    @NotNull(message = "l'objectif du projet est obligatoire et ne peut �tre vide")
    @Column(nullable = false, length = 45)
    private String objectif;

    @NotNull(message = "la date de d�but du projet est obligatoire et ne peut �tre vide")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeDebut;

    @NotNull(message = "la date de fin du projet est obligatoire et ne peut �tre vide")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeFin;

    @NotNull(message = "le budget pr�visionnel du projet est obligatoire et ne peut �tre vide")
    @Column(nullable = false)
    private int budgetPrevisionnel;

    @NotNull(message = "le budget effectif du projet est obligatoire et ne peut �tre vide")
    @Column(nullable = false)
    private int budgetEffectif;

    @OneToOne(cascade = CascadeType.PERSIST)
    private IndicateurPerformance indicateurPerformance;

    @ManyToMany
    private List<Beneficiaire> beneficiaires;

    @ManyToMany
    private List<Fournisseur> fournisseurs;

     @OneToMany
    private List<Fournisseur_Programme> fournisseur_programmes;
      @OneToMany
    private List<Beneficiaire_Programme> beneficiaire_programmes;
    @OneToMany
    private List<Bailleur_Programme> bailleur_programmes;

    @OneToMany     //(mappedBy = "programme", cascade = CascadeType.PERSIST)
    private List<Projet> projets;

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }


    public List<Fournisseur_Programme> getFournisseur_programmes() {
        return fournisseur_programmes;
    }

    public void setFournisseur_programmes(List<Fournisseur_Programme> fournisseur_programmes) {
        this.fournisseur_programmes = fournisseur_programmes;
    }

    public List<Beneficiaire_Programme> getBeneficiaire_programmes() {
        return beneficiaire_programmes;
    }

    public void setBeneficiaire_programmes(List<Beneficiaire_Programme> beneficiaire_programmes) {
        this.beneficiaire_programmes = beneficiaire_programmes;
    }

    
    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

 

    public Integer getId() {
        return id;
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

    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }

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

    public List<Bailleur_Programme> getBailleur_programmes() {
        return bailleur_programmes;
    }

    public void setBailleur_programmes(List<Bailleur_Programme> bailleur_programmes) {
        this.bailleur_programmes = bailleur_programmes;
    }

}
