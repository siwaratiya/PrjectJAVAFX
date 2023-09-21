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
public class Hotel {
    private int id_hotel;
    private String nom;
    private String description;
        private String adresse;
       private String categorie;
      private int nb_chDispo;
     private String email;
    private int telephone;

    public Hotel(int id_hotel, String nom, String description, String adresse, String categorie, int nb_chDispo, String email, int telephone) {
        this.id_hotel = id_hotel;
        this.nom = nom;
        this.description = description;
        this.adresse = adresse;
        this.categorie = categorie;
        this.nb_chDispo = nb_chDispo;
        this.email = email;
        this.telephone = telephone;
    }

    public Hotel(String nom) {
        this.nom = nom;
    }
   


    
    public Hotel() {
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getNb_chDispo() {
        return nb_chDispo;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setNb_chDispo(int nb_chDispo) {
        this.nb_chDispo = nb_chDispo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id_hotel=" + id_hotel + ", nom=" + nom + ", description=" + description + ", adresse=" + adresse + ", categorie=" + categorie + ", nb_chDispo=" + nb_chDispo + ", email=" + email + ", telephone=" + telephone + '}';
    }

   

    
    
  
    
}
