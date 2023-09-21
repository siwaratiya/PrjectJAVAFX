/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.makemytrip.gui;
//import edu.makemytrip.guiChambre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author siwar
 */
public class MenuController implements Initializable {

    @FXML
    private Button hot;
    @FXML
    private Button chmbr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Hotels(ActionEvent event) {
                  Stage stage =new Stage();
         try {
            Parent root=
                   FXMLLoader.load(getClass().getResource("DetailsWindow.fxml"));
            
            Scene scene = new Scene(root);
             
           stage.setTitle("Hello World!");
            stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
    }
    }
 @FXML
    private void chambres(ActionEvent event) {
                   Stage stage =new Stage();
         try {
            Parent root=
                   FXMLLoader.load(getClass().getResource("DetailsChambres.fxml"));
            
            Scene scene = new Scene(root);
             
           stage.setTitle("Hello World!");
            stage.setScene(scene);
             stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
    }
    }
    
}
