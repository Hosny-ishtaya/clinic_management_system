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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Hosny
 */
public class PharmacistdetailsController implements Initializable {
    
    
    
      @FXML
     ChpasswordController ob =new ChpasswordController();
     @FXML
    private BorderPane mainphadd;

    @FXML
    private Button btnvieph;

    @FXML
    void btnviepha(ActionEvent event) {
       
        
          Pane view = ob.getPage("viewpharmacistt.fxml");
                 mainphadd.setCenter(view);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
