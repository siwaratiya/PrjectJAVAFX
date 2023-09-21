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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author siwar
 */
public class UpdateDeleteController implements Initializable {

    private TextField id;
    @FXML
    private TextArea desc;
    @FXML
    private TextField add;
    @FXML
    private TextField cat;
    @FXML
    private TextField nbr;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField nom;
    @FXML
    private Button btnmodif;
    @FXML
    private TextField i;
    @FXML
    private Button btndelete;
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
    private void update(ActionEvent event) {
        
        String ssid=i.getText();
        int idd=Integer.parseInt(ssid);
        String nom=this.nom.getText();
         String description=desc.getText();
        String adresse=add.getText();
        String categorie=cat.getText();
        String ch=nbr.getText();
        int nbchh=Integer.parseInt(ch);
        String eemail=email.getText();
        String t=tel.getText();
        int telephone=Integer.parseInt(t);
        Hotel h =new Hotel();
        h.setNom(nom);
        h.setDescription(description);
        h.setAdresse(adresse);
        h.setCategorie(categorie);
        h.setNb_chDispo(nbchh);
        h.setEmail(eemail);
        h.setTelephone(telephone);
        HotelCrud hc = new HotelCrud();
        int stats=hc.modifierHotel(h,idd);
        if(stats>0){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modifier Hotel");
            alert.setHeaderText("Information");
            alert.setContentText("Hotel bien modifier");
            alert.showAndWait();
        }
        else{
         Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("modifier Hotel");
            alert.setHeaderText("Information");
            alert.setContentText("Hotel non modifier");
            alert.showAndWait();
        }
    }

    @FXML
    private void Delete(ActionEvent event) {
        String ssid=i.getText();
        int idd=Integer.parseInt(ssid);
         HotelCrud hc = new HotelCrud();
        int stats=hc.supprimerHotel(idd);
         if(stats>0){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("delete hotel");
            alert.setHeaderText("Information");
            alert.setContentText("hotel est supprimer");
            alert.showAndWait();
        }
        else{
         Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("delete hotel");
            alert.setHeaderText("Information");
            alert.setContentText("hotel non supprimer");
            alert.showAndWait();
        }
        
    }   

    @FXML
    private void Accueil(ActionEvent event) {
         
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