/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;

/**
 *
 * @author Aya
 * * 
public class Personne {
 *
 *
 * private int id; private String nom; private String prenom; private String
 * telephone; private String adresse;
 * @Temporal(javax.persistence.TemporalType.DATE)
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mariage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(javax.persistence.TemporalType.DATE)

    private Date dateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)

    private Date dateFin;
    
    private int nbrEnfant;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Homme homme;
    @ManyToOne(fetch = FetchType.EAGER)
    private Femme femme;

    public Mariage(Date date, Object object, int id, Homme h1, Femme f1) {
        
        this.femme=femme;
        this.homme=homme;
        this.dateFin=dateFin;
        this.dateDebut=dateDebut;
        this.id=id;
    }

    public Homme getHomme() {
        return homme;
    }

    public void setHomme(Homme homme) {
        this.homme = homme;
    }

    public Femme getFemme() {
        return femme;
    }

    public void setFemme(Femme femme) {
        this.femme = femme;
    }

    public Mariage() {
    }

    public Mariage(Date dateDebut, Date dateFin, int nbrEnfant, Homme homme, Femme femme) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        this.homme = homme;
        this.femme = femme;
    }

    public Mariage(int id, Date dateDebut, Date dateFin, int nbrEnfant, Homme homme, Femme femme) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        this.homme = homme;
        this.femme = femme;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }
    
    
    
 
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
     @Override
    public String toString() {
        return "Mariage{" + "id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }
    
    

}
