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
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Hosny
 */
public class InterController implements Initializable {
   @FXML
    private Button bnadmin;
   
   @FXML
    private Button bnrecep;

    @FXML
    private Button bnpharm;

    @FXML
    private Button bndoctor;
    
      @FXML
    private Button btnlabface;

   
     @FXML
    void admin(ActionEvent event) throws IOException 
    {
       
 Parent home_page_parent  = FXMLLoader.load(getClass().getResource("log.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           
    }
  @FXML
    void doctor(ActionEvent event) throws IOException
    {
         Parent home_page_parent  = FXMLLoader.load(getClass().getResource("log.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           

    }
    
    
   @FXML
    void recep(ActionEvent event) throws IOException
    {
         Parent home_page_parent  = FXMLLoader.load(getClass().getResource("log.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           

    }
        
    @FXML
    void pharm(ActionEvent event)  throws IOException
    {
         Parent home_page_parent  = FXMLLoader.load(getClass().getResource("log.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           
    } 
    
    @FXML
    void btnlabfacee(ActionEvent event)throws IOException
    {
        
         Parent home_page_parent  = FXMLLoader.load(getClass().getResource("log.fxml"));
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
