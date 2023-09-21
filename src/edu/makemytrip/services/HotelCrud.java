/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.services;


import edu.makemytrip.entities.Chambre;
import edu.makemytrip.entities.Hotel;
import edu.makemytrip.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author siwar
 */
public class HotelCrud {
      public void ajouterHotel(){
        String requete ="INSERT INTO hotel(nom,description,adresse,categorie,nb_chDispo,email,telephone) VALUES ('rochelle','welcom','marsa','5 etoile',8,'larouchelle@gmail.com',50744654)";
        try {
            Statement st= MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Hotel Ajouteé !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public int ajouterHotel2(Hotel h){
            int st=0;
    String requete="INSERT INTO hotel(nom,description,adresse,categorie,nb_chDispo,email ,telephone) VALUES (?,?,?,?,?,?,?)";
        try {
           PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
             pst.setString(1, h.getNom());
             pst.setString(2, h.getDescription());
             pst.setString(3, h.getAdresse());
            pst.setString(4, h.getCategorie());
             pst.setInt(5, h.getNb_chDispo());
             pst.setString(6, h.getEmail());
              pst.setInt(7, h.getTelephone());
            st= pst.executeUpdate();
             System.out.println("element Ajouteé!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return st;
    }
      public List<Hotel> listerHoteles(){
          List<Hotel>myList= new ArrayList();
          try {
           String requete="SELECT * FROM hotel";
           Statement st = MyConnection.getInstance().getCnx().createStatement();
           ResultSet rs =st.executeQuery(requete);
           while(rs.next()){
               Hotel hot=new Hotel();
               hot.setId_hotel(rs.getInt(1));
               hot.setNom(rs.getString("nom"));
               hot.setDescription(rs.getString("description"));
               hot.setAdresse(rs.getString("adresse"));
               hot.setCategorie(rs.getString("categorie"));
               hot.setNb_chDispo(rs.getInt(6));
               hot.setEmail(rs.getString("email"));
               hot.setTelephone(rs.getInt(8));
               myList.add(hot);
           }
          } catch (SQLException ex) {
             System.out.println(ex.getMessage());
          }
       return myList;
      }
   public int supprimerHotel(int i){
          int st=0;
         
    String requete="DELETE FROM hotel WHERE id_hotel ="+i ;
        try {
           PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
         st=pst.executeUpdate();
             System.out.println("hotel supprimer!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return st;
    }
        public int modifierHotel(Hotel h, int i){
            int st=0;
         String requete="UPDATE hotel SET nom=?, description=?, adresse=? , categorie=? , nb_chDispo=? , email=? , telephone =?  WHERE id_hotel="+i;
          try {
              PreparedStatement ps= MyConnection.getInstance().getCnx().prepareStatement(requete);
               ps.setString(1, h.getNom());
               ps.setString(2, h.getDescription());
               ps.setString(3, h.getAdresse());
               ps.setString(4, h.getCategorie());
               ps.setInt(5, h.getNb_chDispo());
               ps.setString(6, h.getEmail());
               ps.setInt(7, h.getTelephone());
               
             st=  ps.executeUpdate();
                System.out.println("hotel Modifier!");
          } catch (SQLException ex) {
              
             System.out.println(ex.getMessage());
          }
          return st;
        }
       
      public void listerchm(int i){
           String requete ="SELECT ch.type,  COUNT(ch.type) AS nb_chambre   FROM chambre ch inner join hotel h on h.id_hotel = ch.id_hotel WHERE ch.id_hotel ="+i+" GROUP BY ch.type";
          
            
          try {
            PreparedStatement  ps = MyConnection.getInstance().getCnx().prepareStatement(requete);
              ResultSet rs =ps.executeQuery(requete);
              
              while(rs.next()){
              int nb=rs.getInt("nb_chambre");
              
              //System.out.println(nb);
              String nbb=rs.getString("type");
              System.out.println("le nombre des chambres du type "+nbb+" est :"+nb);
              }
           
          } catch (SQLException ex) {
          System.out.println(ex.getMessage());
          }
           
           
          }
      
      public int supprimerChambre(int i,Hotel h){
            int st=0;
    String requete="DELETE FROM chambre WHERE id_chambre ="+i;
         try {
             PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
           st=  pst.executeUpdate();
             System.out.println("chambre supprimer!");
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());}
         return st;
       }
       
      }

