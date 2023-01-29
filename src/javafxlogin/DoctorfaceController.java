/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hosny
 */


  

   
public class DoctorfaceController implements Initializable
{
     @FXML
    private Button btnlogoutt;
       @FXML
    private Button chpass;
          @FXML
 
    public BorderPane maindp;
           @FXML
    private Button btpd;
     @FXML   
    ChpasswordController object =new ChpasswordController();
       @FXML
    private void patientde(ActionEvent event) {
        
        Pane pp =object.getPage("patientdface.fxml");
        maindp.setCenter(pp);
        
        

    }
        @FXML
    void chpassword(ActionEvent event) 
    {
        
       
        Pane view = object.getPage("chpassword.fxml");
        maindp.setCenter(view);
        
        
       
    }

     
     
     @FXML
    void logoutt(ActionEvent event)throws IOException 
    {
        
             Parent home_page_parent  = FXMLLoader.load(getClass().getResource("Inter.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
       
    }
  
   
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
