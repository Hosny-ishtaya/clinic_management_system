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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hosny
 */
public class DeletepatienttController implements Initializable {
    
    @FXML
    private TextField txtF;

    @FXML
    private TextField txtG;

    @FXML
    private TextField txtCN;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtph;

    @FXML
    private TextField txtbirth;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtss;

    @FXML
    private TextField txtL;

    @FXML
    private Button delete_pa;

    @FXML
    private TextField txtND;

   
    @FXML
    void delete_pat(ActionEvent event) {
        
        System.out.println("delete patientttttttttttttt");

        
        try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
      String FN=txtF.getText();
      String LN=txtL.getText();
      String id=txtid.getText();
      String CN=txtCN.getText();
      String Gen=txtG.getText();
      String Pho=txtph.getText();
      String Birth=txtbirth.getText();
      String Address=txtA.getText();
      String ss=txtss.getText();
      String ND=txtND.getText();
               
               
             String str_stmt =" delete from patient WHERE id_pat = "+id+"";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "deleted");
              
              txtF.clear();
                txtL.clear();
                txtid.clear();
                txtCN.clear();
                txtG.clear();
                txtph.clear();
                txtbirth.clear();
                txtA.clear();
                txtss.clear();
                txtND.clear();
              
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }
    }
    
    
     @FXML
    void txtFN(ActionEvent event) {

    }

    @FXML
    void txtbirth(ActionEvent event) {

    }

    @FXML
    void txtph(ActionEvent event) {

    }

    @FXML
    void txtND(ActionEvent event) {

    }

    @FXML
    void txtss(ActionEvent event) {

    }

    @FXML
    void txtG(ActionEvent event) {

    }

    @FXML
    void txtCN(ActionEvent event) {

    }

    @FXML
    void txtid(ActionEvent event) {

    }

    @FXML
    void txtA(ActionEvent event) {

    }

    @FXML
    void txtLN(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
