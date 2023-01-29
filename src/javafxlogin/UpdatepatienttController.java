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
public class UpdatepatienttController implements Initializable {
    
     @FXML
    private TextField txtF;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtCN;

    @FXML
    private TextField txtG;

    @FXML
    private TextField txtph;

    @FXML
    private TextField txtbirth;

    @FXML
    private Button update_pa;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtSS;

    @FXML
    private TextField txtL;

    @FXML
    private TextField txtND;

   
    @FXML
    void update_pat(ActionEvent event) {
        
       System.out.println("update patient");
       
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
      String ss=txtSS.getText();
      String ND=txtND.getText();
              
             String str_stmt ="update patient set first_name = '"+FN+"',last_name='"+LN+"',id_pat="+id+",birthdate='"+Birth+"',address='"+Address+"',phone_number="+Pho+",gender='"+Gen+"',clinic_name='"+CN+"',social_state='"+ss+"',name_doctor='"+ND+"' where id_pat="+id+"";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "updated");
              
                txtF.clear();
                txtL.clear();
                txtid.clear();
                txtCN.clear();
                txtG.clear();
                txtph.clear();
                txtbirth.clear();
                txtA.clear();
                txtSS.clear();
                txtND.clear();
              
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }

    }

     @FXML
    void txtF(ActionEvent event) {

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
    void txtSS(ActionEvent event) {

    }

    @FXML
    void txtL(ActionEvent event) {

    }

    @FXML
    void txtA(ActionEvent event) {

    }

    @FXML
    void txtid(ActionEvent event) {

    }

    @FXML
    void txtCN(ActionEvent event) {

    }

    @FXML
    void txtG(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
