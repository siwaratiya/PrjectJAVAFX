/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.entities;

/**
 *
 * @author siwar
 */
public class Chambre {
  private int id_chambre;
  private Type.Types type;
  private Vue.Veus vue;
  private Double prix_nuitee;
  private int id_hotel;

    public Chambre(int id_chambre, Type.Types type, Vue.Veus vue, Double prix_nuitee, int id_hotel) {
        this.id_chambre = id_chambre;
        this.type = type;
        this.vue = vue;
        this.prix_nuitee = prix_nuitee;
        this.id_hotel = id_hotel;
    }
    
public Chambre() {
            }

    
    public int getId_chambre() {
        return id_chambre;
    }

    public Type.Types getType() {
        return type;
    }

   

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public Vue.Veus getVue() {
        return vue;
    }


    public Double getPrix_nuitee() {
        return prix_nuitee;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public void setType(Type.Types type) {
        this.type = type;
    }

    public void setVue(Vue.Veus vue) {
        this.vue = vue;
    }

   

   

    public void setPrix_nuitee(Double prix_nuitee) {
        this.prix_nuitee = prix_nuitee;
    }

 

    @Override
    public String toString() {
        return "Chambre{" + "id_chambre=" + id_chambre + ", type=" + type + ", vue=" + vue + ", prix_nuitee=" + prix_nuitee + ", id_hotel=" + id_hotel + '}';
    }
   

 

  


  

}
