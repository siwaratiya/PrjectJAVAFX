/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.gui;

import com.sun.glass.events.MouseEvent;
import edu.makemytrip.entities.Hotel;
import edu.makemytrip.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author siwar
 */
public class DetailsWindowController implements Initializable {

    private TextField TextNom;
    private TextArea TextDes;
    private TextField TextAdd;
    private TextField TextCat;
    private TextField TextNbr;
    private TextField TextTel;
    private TextField TextEmail;
   @FXML
    
   private TableColumn<Hotel, Integer> id;
    @FXML
    private TableColumn<Hotel, String> nom;
    @FXML
    private TableColumn<Hotel, String> desciption;
    @FXML
    private TableColumn<Hotel, String> addresse;
    @FXML
    private TableColumn<Hotel, String> categorie;
    @FXML
    private TableColumn<Hotel, Integer> nbrch;
    @FXML
    private TableColumn<Hotel, String> email;
    @FXML
    private TableColumn<Hotel, Integer> tel;
    public ObservableList<Hotel> data=FXCollections.observableArrayList();
    
   
    @FXML
    private Button btnAfficheHotels;
    @FXML
    private TableView<Hotel> table;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnupdel;
    @FXML
    private Button log;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button clc;
   
 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void ViewHotels(ActionEvent event) {
                  try {
            String requete="SELECT * FROM hotel"; 
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
 //             data.add(new Hotel(rs.getString(1)));

               
                data.add(new Hotel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8)));
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                 id.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("id_hotel"));
                 nom.setCellValueFactory(new PropertyValueFactory<Hotel, String>("nom")); 
                desciption.setCellValueFactory(new PropertyValueFactory<Hotel, String>("description"));
                 addresse.setCellValueFactory(new PropertyValueFactory<Hotel, String>("adresse"));
                 categorie.setCellValueFactory(new PropertyValueFactory<Hotel, String>("categorie"));
                 nbrch.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("nb_chDispo"));
                email.setCellValueFactory(new PropertyValueFactory<Hotel, String>("email"));
                tel.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("telephone"));
                 table.setItems(data);
    }

    @FXML
    private void ajouterhotel(ActionEvent event) {
        
             Stage stage =new Stage();
         try {
            Parent root=
                   FXMLLoader.load(getClass().getResource("AjouterHotel.fxml"));
            
            Scene scene = new Scene(root);
             
           stage.setTitle("Hello World!");
            stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
    }
}

    @FXML
    private void updatdelete(ActionEvent event) {
        
             Stage stage =new Stage();
         try {
            Parent root=
                   FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
            
            Scene scene = new Scene(root);
             
           stage.setTitle("Hello World!");
            stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
    }
    }
Stage stage;
    @FXML
    private void logout(ActionEvent event) {
        /*Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("logout");
            alert.setHeaderText("do you want to save befor exiting");
            if(alert.showAndWait().get()==ButtonType.OK){
        stage=(Stage) scenePane.getScene().getWindow();
        System.out.println("succeé");
        stage.close();}*/
    }

    @FXML
    private void Calculerrr(ActionEvent event) {
        
                     Stage stage =new Stage();
         try {
            Parent root=
                   FXMLLoader.load(getClass().getResource("Calculchambre.fxml"));
            
            Scene scene = new Scene(root);
             
           stage.setTitle("Hello World!");
            stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
    }
    }

}

   
