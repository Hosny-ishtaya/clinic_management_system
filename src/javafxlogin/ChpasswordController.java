/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hosny
 */

public class ChpasswordController implements Initializable {
    
    
        @FXML
       private Pane view;

   
  
         
    
        @FXML
    public Pane getPage(String filename)//for move from button in left side to show the fream in center 
    {
        try{
            URL fileurl = JavaFXlogin.class.getResource(filename);
            if(fileurl==null)
            {
                throw new java.io.FileNotFoundException("file cant be founded");
            }
            view = new FXMLLoader().load(fileurl);
            
        } catch(Exception e){
            System.out.println("////////");
        }
        return view;
    }
    
             @FXML
    private TextField cupass; //TextField for current password

        @FXML
      private TextField nepass; //TextField for new password

    @FXML
    private Button chapass;// button to change the password//TextField for current password

    
      @FXML
    void changepass(ActionEvent event) {
       
        System.out.println("change password");
        try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String cuu =  this.cupass.getText();
               String newp= this.nepass.getText();
               
               
             String str_stmt ="update password_of_employee set password = '"+newp+"' where password='"+cuu+"'";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "Changed");
              
              cupass.clear();
              nepass.clear();
              
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }

    }
    
    @FXML
    void currpass(ActionEvent event) {

    }

    @FXML
    void newpass(ActionEvent event) {

    }

  
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
