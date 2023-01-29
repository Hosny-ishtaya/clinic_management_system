/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Hosny
 */
public class PatientdfaceController implements Initializable {
    
      ChpasswordController ob =new ChpasswordController();
    @FXML
    private Button btnaddp;
    
    @FXML
    private Button deletep;
    
      @FXML
    private Button updatep;

    @FXML
    private Button searchp;
        @FXML
    private Button viewp;

    
    @FXML
    private BorderPane mainpo;
    @FXML
    private Pane veee;

    @FXML
    private  void addpatient(ActionEvent event)
     {
         Pane pp =getPag("patientde.fxml");
        mainpo.setCenter(pp);
        
    }
    @FXML
    void deletep(ActionEvent event) {
        
        Pane dd =getPag("deletepatientt.fxml");
        mainpo.setCenter(dd);
        

    }
    @FXML
    void updatep(ActionEvent event) {
        
         Pane uu =getPag("updatepatientt.fxml");
        mainpo.setCenter(uu);

    }

    @FXML
    void searchp(ActionEvent event) {
        
         Pane ss =getPag("searchpatientt.fxml");
        mainpo.setCenter(ss);

    }
    
        @FXML
    void viewp(ActionEvent event) {
          Pane vv =getPag("viewpatientt.fxml");
        mainpo.setCenter(vv);

    }
    
          @FXML
    public Pane getPag(String filename)//for move from button in left side to show the fream in center 
    {
        try{
            URL fileurl = JavaFXlogin.class.getResource(filename);
            if(fileurl==null)
            {
                throw new java.io.FileNotFoundException("file cant be founded");
            }
            veee = new FXMLLoader().load(fileurl);
            
        } catch(Exception e){
            System.out.println("////////");
        }
        return veee;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
