/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.gui;

import edu.makemytrip.utils.MyConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author siwar
 */
public class CalculchambreController implements Initializable {

    @FXML
    private Button tfc;
    @FXML
    private TextArea txt;
    @FXML
    private TextField id;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    private void calculerch(ActionEvent event) {
       
    
         String ssid=id.getText();
        int idd=Integer.parseInt(ssid);
     String requete ="SELECT ch.type,  COUNT(ch.type) AS nb_chambre   FROM chambre ch inner join hotel h on h.id_hotel = ch.id_hotel WHERE ch.id_hotel ="+idd+" GROUP BY ch.type";
          
            
          try {
            PreparedStatement  ps = MyConnection.getInstance().getCnx().prepareStatement(requete);
              ResultSet rs =ps.executeQuery(requete);
              
              while(rs.next()){
              int nb=rs.getInt("nb_chambre");
              
              //System.out.println(nb);
              String nbb=rs.getString("type");
              txt.setText("le nombre des chambres du type "+nbb+" est :"+nb);
              }
           
          } catch (SQLException ex) {
          System.out.println(ex.getMessage());
          }
           
    }
    
}
