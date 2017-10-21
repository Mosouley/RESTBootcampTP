
package com.bootcamp.jpa.enums;

/**
 *
 * @author soul
 */
public enum TypeDeBailleur {
     NONGOUV("Non gouvernementale"),
    PRIVE("Priv�"),
    GOVMENT("Gourvernement"),
    INTER("Partenaire International") ;
 
    private String typeBailleur;

    TypeDeBailleur(String typeBailleur) {
        this.typeBailleur = typeBailleur;
    }

    public String TypeDeBailleur() {
        return typeBailleur;
    }

    @Override
    public String toString() {
        return typeBailleur;
    }
}
