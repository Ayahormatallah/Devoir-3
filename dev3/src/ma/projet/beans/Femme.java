/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity

public class Femme  extends Personne {
    
    @OneToMany(mappedBy="femme",fetch = FetchType.EAGER)
    List<Mariage> mariages=new ArrayList<>();

    public List<Mariage> getMariages() {
        return mariages;
    }

    public void setMariages(List<Mariage> mariages) {
        this.mariages = mariages;
    }
    
    public Femme(){
        
    }
    public Femme(int id, String nom, String prenom, String telephone, String adresse, Date dateNaissance ){
        super(id,nom,prenom,telephone,adresse,dateNaissance);
        
    }
    public Femme( String nom, String prenom, String telephone, String adresse, Date dateNaissance ){
        super(nom,prenom,telephone,adresse,dateNaissance);
        
    }
    
}
