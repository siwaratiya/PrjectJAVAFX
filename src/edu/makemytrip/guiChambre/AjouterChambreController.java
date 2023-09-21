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
import edu.makemytrip.services.ChambreCrud;
import edu.makemytrip.utils.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author siwar
 */
public class AjouterChambreController implements Initializable {

    @FXML
    private Button btnajout;
    @FXML
    private ToggleGroup type;
    @FXML
    private ToggleGroup vue;
    @FXML
    private TextField prix_n;
    private TextField idh;
    
    @FXML
    private Label iid;
    @FXML
    private ComboBox cmbo;
    
    final ObservableList data=FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        selectnom();           
    }    

   

    private void selectnom() {
         
        // data.clear();
          try {
              
            String requete="SELECT id_hotel FROM hotel"; 
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(requete);
            while(rs.next()){
              

                data.add(new Integer(rs.getInt(1)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
cmbo.setItems(null);
cmbo.setItems(data);

    }
     @FXML
    private void AjouterChambre(ActionEvent event) {
        
        Chambre ch=new Chambre();
        RadioButton selectedRadioButton = (RadioButton) type.getSelectedToggle();
        String t = selectedRadioButton.getText();
       
       
      if(t.compareTo("Single")==0){
      ch.setType(Type.Types.Single);}
      else{
         ch.setType(Type.Types.Double); }
       RadioButton selctedRadioButton = (RadioButton) vue.getSelectedToggle();
       String v = selctedRadioButton.getText();
      if(v.compareTo("Sur_mer")==0) 
      ch.setVue(Vue.Veus.Sur_mer);
      else if(v.compareTo("Sur_piscine")==0)
      ch.setVue(Vue.Veus.Sur_piscine);
      
      else
          ch.setVue(Vue.Veus.Normale);
      
      String p =prix_n.getText();
       Double prix=Double.parseDouble(p);
   
           
       //int id=Integer.parseInt(i);
         ch.setPrix_nuitee(prix);
        String sl=cmbo.getSelectionModel().getSelectedItem().toString();
         
            int i=Integer.parseInt(sl);
         ch.setId_hotel(i);
       ChambreCrud chh=new ChambreCrud();
        int stats= chh.ajouterChambre(ch);
       if(stats>0){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("add chambre");
            alert.setHeaderText("Information");
            alert.setContentText("chambre bien ajouter");
            alert.showAndWait();
        }
        else{
         Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("add chambre");
            alert.setHeaderText("Information");
            alert.setContentText("chambre non ajouter");
            alert.showAndWait();
        }
    }

    

   }