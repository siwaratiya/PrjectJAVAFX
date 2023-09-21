/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.guiChambre;

import edu.makemytrip.entities.Chambre;
import edu.makemytrip.entities.Hotel;
import edu.makemytrip.entities.Type;
import edu.makemytrip.entities.Vue;
import edu.makemytrip.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author siwar
 */
public class DetailsChambresController implements Initializable {

    @FXML
    private TableView<Chambre> table;
    @FXML
    private TableColumn<Chambre, Integer> idc;
    @FXML
    private TableColumn<Chambre, Type> type;
    @FXML
    private TableColumn<Chambre, Vue> vue;
    @FXML
    private TableColumn<Chambre, Double> prix;
     public ObservableList<Chambre> data=FXCollections.observableArrayList();
    @FXML
    private Button btnaffich;
    @FXML
    private TableColumn<Chambre, Integer> id_hotell;
    @FXML
    private Button bttn;
    @FXML
    private Button iih;
   
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AffichHotels(ActionEvent event) {
     
       
     //  Type h=Type.valueOf(p)
       //Type chh= ch.getType().Double;
       
       
       try { 
            String requete="SELECT * FROM chambre";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
               
                data.add(new Chambre(rs.getInt(1),Type.find(rs.getString(2)),Vue.find(rs.getString(3)),rs.getDouble(4),rs.getInt(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());}
        idc.setCellValueFactory(new PropertyValueFactory<Chambre, Integer>("id_chambre"));
          type.setCellValueFactory(new PropertyValueFactory<Chambre, Type>("type"));
          vue.setCellValueFactory(new PropertyValueFactory<Chambre, Vue>("vue"));
          prix.setCellValueFactory(new PropertyValueFactory<Chambre, Double>("prix_nuitee"));
           id_hotell.setCellValueFactory(new PropertyValueFactory<Chambre, Integer>("id_hotel"));
         
          table.setItems(data);
    }

    @FXML
    private void updel(ActionEvent event) {
         try {
            Parent root= 
                    FXMLLoader.load(getClass().getResource("UpdatDelete.fxml"));
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

    @FXML
    private void ajoutt(ActionEvent event) {
         try {
            Parent root= 
                    FXMLLoader.load(getClass().getResource("AjouterChambre.fxml"));
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