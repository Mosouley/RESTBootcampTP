package com.bootcamp.jpa;

import com.bootcamp.jpa.repository.BailleurRepository;
import com.bootcamp.jpa.repository.Bailleur_ProgrammeRepository;
import com.bootcamp.jpa.repository.BeneficiaireRepository;
import com.bootcamp.jpa.repository.FournisseurRepository;
import com.bootcamp.jpa.repository.IndicateurPerformanceRepository;
import com.bootcamp.jpa.repository.ProgrammeRepository;
import com.bootcamp.jpa.repository.ProjetRepository;
import com.bootcamp.entity.Bailleur;
import com.bootcamp.entity.Bailleur_Programme;
import com.bootcamp.entity.Beneficiaire;
import com.bootcamp.entity.Fournisseur;
import com.bootcamp.entity.IndicateurPerformance;
import com.bootcamp.entity.Programme;
import com.bootcamp.entity.Projet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bootcamp.jpa.enums.TypeDeBailleur;

/**
 *
 * @author soul
 */
public class LoadTestData {

     
    String persisUnit="monPuWeb";
    Bailleur fmd = new Bailleur();
    Bailleur usaid = new Bailleur();
    Bailleur onusida = new Bailleur();
    Bailleur mef = new Bailleur();
    Bailleur pnls = new Bailleur();
    Bailleur fondZ = new Bailleur();
    //créer une liste des bailleurs de ce programme
    List<Bailleur> bailcadredevie = new ArrayList<>();

    //création des fournisseurs
    Fournisseur onasa = new Fournisseur();
    Fournisseur frs1 = new Fournisseur();
    Fournisseur frs2 = new Fournisseur();
    Fournisseur frs3 = new Fournisseur();
    //créer une liste des fournisseurs de ce progarmme
    List<Fournisseur> frscadredevie = new ArrayList<>();

    //creation des beneficiaires
    Beneficiaire benef1 = new Beneficiaire();
    Beneficiaire benef2 = new Beneficiaire();
    Beneficiaire benef3 = new Beneficiaire();
    Beneficiaire benef4 = new Beneficiaire();
    Beneficiaire benef5 = new Beneficiaire();
    //créer une liste des bénéficiaires de ce programmes
    List<Beneficiaire> benefcadredevie = new ArrayList<>();



    //indicateurs
    IndicateurPerformance indicateur1 = new IndicateurPerformance();
    IndicateurPerformance indicateur2 = new IndicateurPerformance();

    //créations de nouveaux projets
    Projet luttenutrition = new Projet();
    Projet emancipation = new Projet();
    Projet educationfille = new Projet();

    Projet amenagement = new Projet();
    Projet espacevert = new Projet();
    Projet eaupotable = new Projet();
    
     List<Projet> projetcadredevie = new ArrayList<>();
 //création de deux nouveaux programmes
//    Programme firstp = new Programme();

    //le second programme
    //création de deux nouveaux programmes
    Programme cadredevie = new Programme();

    public LoadTestData(String persisUnit) throws SQLException {
        this.persisUnit=persisUnit;

    }
     

    public void loadDataSample() throws SQLException {
        //Chargement de Bailleurs

        fmd.setNom("Fonds Mondial");
        fmd.setTypeDeBailleur(TypeDeBailleur.INTER);

        usaid.setNom("USAID");
        usaid.setTypeDeBailleur(TypeDeBailleur.INTER);

        onusida.setNom("ONU SIDA");
        onusida.setTypeDeBailleur(TypeDeBailleur.INTER);

        mef.setNom("Ministere de l'économie et des finances");
        mef.setTypeDeBailleur(TypeDeBailleur.GOVMENT);

        pnls.setNom("PNLS");
        pnls.setTypeDeBailleur(TypeDeBailleur.INTER);

        fondZ.setNom("Fondation ZZZ");
        fondZ.setTypeDeBailleur(TypeDeBailleur.PRIVE);
        
            //définir les indicateurs de performance
        indicateur1.setLibelle("Performance Financiere");
        indicateur1.setNature("Quantité");
        indicateur1.setValeur("Valeur de l'indicateur");
        indicateur2.setLibelle("Performance Managériale");
        indicateur2.setNature("Cervelle");
        indicateur2.setValeur("Valeur de l'indicateur");

        IndicateurPerformanceRepository donIndicateurs = new IndicateurPerformanceRepository(persisUnit);

        donIndicateurs.create(indicateur1);
        donIndicateurs.create(indicateur2);
        
        cadredevie.setBudgetEffectif(50000);
        cadredevie.setBudgetPrevisionnel(60000);
        cadredevie.setDateDeDebut(java.sql.Date.valueOf("2017-01-01"));
        cadredevie.setDateDeFin(java.sql.Date.valueOf("2017-12-01"));
        cadredevie.setNom("Projet Cadre de vie");
        cadredevie.setObjectif("Améliorer la condition de la femme");
        cadredevie.setIndicateurPerformance(indicateur2);
        
        
        ProgrammeRepository donneesProgrammes = new ProgrammeRepository(persisUnit);

        donneesProgrammes.create(cadredevie);
        
     
        
        
        BailleurRepository donneesBailleurs = new BailleurRepository(persisUnit);

        donneesBailleurs.create(fmd);
        donneesBailleurs.create(usaid);
        donneesBailleurs.create(onusida);
        donneesBailleurs.create(pnls);
        donneesBailleurs.create(fondZ);
              
        Bailleur_Programme bp1=new Bailleur_Programme();
        bp1.setBailleur(usaid);
        bp1.setProgramme(cadredevie);
        bp1.setCapital("Valeur du Capital");
        
        Bailleur_Programme bp2=new Bailleur_Programme();
        bp2.setBailleur(onusida);
        bp2.setProgramme(cadredevie);
        bp2.setCapital("Valeur du Capital 2");
        
        Bailleur_Programme bp3=new Bailleur_Programme();
        bp3.setBailleur(fmd);
        bp3.setProgramme(cadredevie);
        bp3.setCapital("Valeur du Capital 3");
       
        Bailleur_ProgrammeRepository donneesBP=new Bailleur_ProgrammeRepository(persisUnit);
        
        donneesBP.create(bp1);
        donneesBP.create(bp2);
        donneesBP.create(bp3);
        
        //Chargement de fournisseurs
        onasa.setNom("ONASA");
        frs1.setNom("FOURNISSEUR 1");
        frs2.setNom("FOURNISSEUR 2");
        frs3.setNom("FOURNISSEUR 3");
        FournisseurRepository donFournisseur = new FournisseurRepository(persisUnit);
        donFournisseur.create(onasa);
        donFournisseur.create(frs1);
        donFournisseur.create(frs2);
        donFournisseur.create(frs3);

        
        //Chargement de Bénificiaire
        benef1.setNom("Commune du Zou");
        benef2.setNom("Commune du Littoral");
        benef3.setNom("Commune du Borgou");
        benef4.setNom("Commune de l'ATLTANTIQUE");//
        benef5.setNom("Commune du MONO");
        BeneficiaireRepository donBeneficiaires = new BeneficiaireRepository(persisUnit);

        donBeneficiaires.create(benef1);
        donBeneficiaires.create(benef2);
        donBeneficiaires.create(benef3);
        donBeneficiaires.create(benef4);
        donBeneficiaires.create(benef5);
        
       
        

        
        //créations de nouveaux projets
        amenagement.setDateDeDebut(java.sql.Date.valueOf("2017-06-01"));
        amenagement.setDateDeFin(java.sql.Date.valueOf("2017-09-31"));
        amenagement.setNom("Aménager le cadre de vie");
        amenagement.setObjectif("100% de rues balayées");
        amenagement.setBudgetEffectif(100000);
        amenagement.setBudgetPrevisionnel(150000);
        amenagement.setIndicateurPerformance(indicateur2);

        amenagement.setProgramme(cadredevie);
       

        espacevert.setDateDeDebut(java.sql.Date.valueOf("2016-01-01"));
        espacevert.setDateDeFin(java.sql.Date.valueOf("2017-09-31"));
        espacevert.setNom("Espace vert pour l'ozone");
        espacevert.setObjectif("100% des espaces non habités verts");
        espacevert.setBudgetEffectif(100000);
        espacevert.setBudgetPrevisionnel(150000);
        espacevert.setIndicateurPerformance(indicateur2);
         espacevert.setProgramme(cadredevie);
        

        eaupotable.setDateDeDebut(java.sql.Date.valueOf("2017-02-01"));
        eaupotable.setDateDeFin(java.sql.Date.valueOf("2017-12-31"));
        eaupotable.setNom("Eau potable pour tous");
        eaupotable.setObjectif("100% des villages alimentés en eau potable");
        eaupotable.setBudgetEffectif(100000);
        eaupotable.setBudgetPrevisionnel(150000);
        eaupotable.setIndicateurPerformance(indicateur1);
        eaupotable.setProgramme(cadredevie);

        ProjetRepository donProjets = new ProjetRepository(persisUnit);

        donProjets.create(amenagement);
        donProjets.create(espacevert);
        donProjets.create(eaupotable);
        
        //////////////////////******************second programme////////////////////////
        bailcadredevie.add(fondZ);
        bailcadredevie.add(pnls);
        bailcadredevie.add(usaid);
//        cadredevie.bailcadredevie);

        benefcadredevie.add(benef2);
        benefcadredevie.add(benef4);
        benefcadredevie.add(benef5);
//        cadredevie.setBeneficiaires(benefcadredevie);

        frscadredevie.add(frs1);
        frscadredevie.add(frs2);
//        cadredevie.setFournisseurs(frscadredevie);
        
          
       
        //ajouter la liste des projets de ce programme
        projetcadredevie.add(amenagement);
        projetcadredevie.add(espacevert);
        projetcadredevie.add(eaupotable);
        cadredevie.setProjets(projetcadredevie);
       
    }

  
      
//        ProjetRepository donProjet2=new ProjetRepository();
//        try {
//            donProjet2.addProjet(emancipation);
//            donProjet2.addProjet(luttenutrition);
//            donProjet2.addProjet(educationfille);
//        } catch (Exception ex) {
//            Logger.getLogger(LoadTestData.class.getName()).log(Level.SEVERE, null, ex);
//        }
   
      
 
    }
 
