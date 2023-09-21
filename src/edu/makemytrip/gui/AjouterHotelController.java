/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.gui;

import edu.makemytrip.entities.Hotel;
import edu.makemytrip.services.HotelCrud;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author siwar
 */
public class AjouterHotelController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextArea trDes;
    @FXML
    private TextField tfAdd;
    @FXML
    private TextField tfCat;
    @FXML
    private TextField tfNbr;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnValider;
    @FXML
    private Button btnVider;
    @FXML
    private Button acc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveHotel(ActionEvent event) {
         Hotel h =new Hotel();
        String nom=tfNom.getText();
        String description=trDes.getText();
        String adresse=tfAdd.getText();
        String categorie=tfCat.getText();
        String sid=tfNbr.getText();
        int nbch=Integer.parseInt(sid);
        String email=tfEmail.getText();
         String t=tfTel.getText();
        int tel=Integer.parseInt(t);
        if(nom.isEmpty()){
        tfNom.setText("Remplir votre nom");
        }
        else if(description.isEmpty()){
        trDes.setText("Remplir votre description");
        }
        
        else if(adresse.isEmpty()){
        tfAdd.setText("Remplir votre adresse");
        }
        else if(categorie.isEmpty()){
        tfCat.setText("Remplir votre categorie");
        }
        else if(sid.isEmpty()){
        tfNbr.setText("Remplir votre nombre");
        }
        else if(email.isEmpty()){
        tfEmail.setText("Remplir votre Email");
        }
         else if(t.isEmpty()){
        tfTel.setText("Remplir votre telephone");
        }
        else {
      
        h.setNom(nom);
      h.setDescription(description);
      h.setAdresse(adresse);
      h.setCategorie(categorie);
      h.setNb_chDispo(nbch);
      h.setEmail(email);
      h.setTelephone(tel);
         
      HotelCrud hc = new HotelCrud();
     int stats= hc.ajouterHotel2(h);
         
       if(stats>0){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("add personne");
            alert.setHeaderText("Information");
            alert.setContentText("person bien ajouter");
            alert.showAndWait();
        }
        else{
         Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("add personne");
            alert.setHeaderText("Information");
            alert.setContentText("person non ajouter");
            alert.showAndWait();
        }
         } 
    }

    @FXML
    private void Vider(ActionEvent event) {
       
    tfNom.clear();
    trDes.clear();
    tfAdd.clear();
    tfCat.clear();
    tfNbr.clear();
    tfEmail.clear();
    tfTel.clear();
    }

    @FXML
    private void aceuil(ActionEvent event) {
        
             try {
            Parent root= 
                    FXMLLoader.load(getClass().getResource("Menu.fxml"));
                    //FXMLLoader.load(getClass().getResource("Metiee.fxml"));
       Stage stage =new Stage();
            
            Scene scene = new Scene(root);
             
           stage.setTitle("Hello World!");
            stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
    }
    
    
    }
    
    

}