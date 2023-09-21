/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.services;

import edu.makemytrip.entities.Chambre;
import edu.makemytrip.entities.Type;
import edu.makemytrip.entities.Vue;
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
public class ChambreCrud {
     public int ajouterChambre(Chambre ch){
         int st=0;
             String requete ="INSERT INTO chambre(type,vue,prix_nuitee,id_hotel) VALUES (?, ?,?,?)";
         try {
             PreparedStatement pst= MyConnection.getInstance().getCnx().prepareStatement(requete);
                 if(ch.getType().toString().compareTo("Single")==0){
              pst.setString(1, "Single");}
              else{
                pst.setString(1 ,"Double");      
                      }
               if(ch.getVue().toString().compareTo("Sur_mer")==0){
              pst.setString(2, "Sur_mer");}
               else if(ch.getVue().toString().compareTo("Sur_piscine")==0){
                pst.setString(2 ,"Sur_piscine");      
                      }
               else{
                pst.setString(2 ,"Normale");      
                      }
               pst.setDouble(3, ch.getPrix_nuitee());
               pst.setInt(4, ch.getId_hotel());
               
             st= pst.executeUpdate();
             System.out.println("Chambre Ajouteé!");
         } catch (SQLException ex) {
          System.out.println(ex.getMessage());
         }
         return st;
             }
     
  
      public List<Chambre> listerChambres(){
      
      List<Chambre>myList= new ArrayList();
      
         try {
             String requete="SELECT * FROM chambre";
             Statement st= MyConnection.getInstance().getCnx().createStatement();
             ResultSet rs = st.executeQuery(requete);
              while(rs.next()){
              Chambre ch = new Chambre();
              ch.setId_chambre(rs.getInt(1));
              
              if(rs.getString("type").toString().compareTo("Single")==0){
              ch.setType(Type.Types.Single);}
              else{
                ch.setType(Type.Types.Double);      
                      }
              if(rs.getString("vue").toString().compareTo("Sur_mer")==0){
              ch.setVue(Vue.Veus.Sur_mer);}
              else if(rs.getString("vue").toString().compareTo("Sur_piscine")==0){
                ch.setVue(Vue.Veus.Sur_piscine);  
              }
              else{
                ch.setVue(Vue.Veus.Normale);      
                      }
              ch.setPrix_nuitee(rs.getDouble(4));
              ch.setId_hotel(rs.getInt(5));
              myList.add(ch);
              }
             
         } catch (SQLException ex) {
              System.out.println(ex.getMessage());
         }
       return myList;
      }
        public int modifierChambre(Chambre ch, int i){
             int st=0;
         String requete="UPDATE Chambre SET type=?, vue=?, prix_nuitee=?, id_hotel=?  WHERE id_chambre="+i;
         try {
             PreparedStatement ps= MyConnection.getInstance().getCnx().prepareStatement(requete);
              //ps.setInt(1, ch.getId_chambre());
               if(ch.getType().toString().compareTo("Single")==0){
              ps.setString(1, "Single");}
              else{
                ps.setString(1 ,"Double");      
                      }
               if(ch.getVue().toString().compareTo("Sur_mer")==0){
              ps.setString(2, "Sur_mer");}
               else if(ch.getVue().toString().compareTo("Sur_piscine")==0){
                ps.setString(2 ,"Sur_piscine");      
                      }
               else{
                ps.setString(2 ,"Normale");      
                      }
               ps.setDouble(3, ch.getPrix_nuitee());
               ps.setInt(4, ch.getId_hotel());
              
              st= ps.executeUpdate();
               System.out.println("Chambre Modifier!");
         } catch (SQLException ex) {
                    System.out.println(ex.getMessage());}   
         return st;

       }
         
}
