/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
public class SearchpatienttController implements Initializable {
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
    private TextField txtA;

    @FXML
    private TextField txtSS;

    @FXML
    private TextField txtL;

    @FXML
    private TextField txtND;

    @FXML
    private Button search_p;

    

    @FXML
    void search_pa(ActionEvent event) {
        
       System.out.println("search patienttttttttttt");

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
               String emp="";
               
               if(FN.compareTo(emp)!=0 && LN.compareTo(emp)==0 && id.compareTo(emp)==0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)==0&&ss.compareTo(emp)==0&&ND.compareTo(emp)==0){
             String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where first_name='"+FN+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
      txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }
               else  if(FN.compareTo(emp)==0 && LN.compareTo(emp)!=0 && id.compareTo(emp)==0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)==0&&ss.compareTo(emp)==0&&ND.compareTo(emp)==0){
             String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where last_name='"+LN+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
          txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }        
               else  if(FN.compareTo(emp)==0 && LN.compareTo(emp)==0 && id.compareTo(emp)!=0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)==0&&ss.compareTo(emp)==0&&ND.compareTo(emp)==0){
             String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where id_pat="+id+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }
                if(FN.compareTo(emp)==0 && LN.compareTo(emp)==0 && id.compareTo(emp)==0 && CN.compareTo(emp)!=0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)==0&&ss.compareTo(emp)==0&&ND.compareTo(emp)==0){
            String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where clinic_name='"+CN+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
          txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }
             else   if(FN.compareTo(emp)==0 && LN.compareTo(emp)==0 && id.compareTo(emp)==0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)!=0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)==0&&ss.compareTo(emp)==0&&ND.compareTo(emp)==0){
             String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where gender='"+Gen+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
          txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }
             else  if(FN.compareTo(emp)==0 && LN.compareTo(emp)==0 && id.compareTo(emp)==0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)!=0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)==0&&ss.compareTo(emp)==0&&ND.compareTo(emp)==0){
             String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where phone_number="+Pho+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
          txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }
         else  if(FN.compareTo(emp)==0 && LN.compareTo(emp)==0 && id.compareTo(emp)==0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)!=0&&Address.compareTo(emp)==0&&ss.compareTo(emp)==0&&ND.compareTo(emp)==0){
            String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where birthdate='"+Birth+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
          txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }   
                 else  if(FN.compareTo(emp)==0 && LN.compareTo(emp)==0 && id.compareTo(emp)==0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)!=0&&ss.compareTo(emp)==0&&ND.compareTo(emp)==0){
            String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where address='"+Address+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
          txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }
                 else  if(FN.compareTo(emp)==0 && LN.compareTo(emp)==0 && id.compareTo(emp)==0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)==0&&ss.compareTo(emp)!=0&&ND.compareTo(emp)==0){
            String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where social_state='"+ss+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
          txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }
                 else  if(FN.compareTo(emp)==0 && LN.compareTo(emp)==0 && id.compareTo(emp)==0 && CN.compareTo(emp)==0 && Gen.compareTo(emp)==0&&Pho.compareTo(emp)==0&&Birth.compareTo(emp)==0&&Address.compareTo(emp)==0&&ss.compareTo(emp)==0&&ND.compareTo(emp)!=0){
           String str_stmt ="SELECT first_name,last_name,birthdate,address,phone_number,id_pat,social_state,clinic_name,name_doctor,gender FROM patient where name_doctor='"+ND+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
          txtF.setText(rs.getString(1));
      txtL.setText(rs.getString(2));
      txtid.setText(rs.getString(6));
      txtCN.setText(rs.getString(8));
      txtG.setText(rs.getString(10));
      txtph.setText(rs.getString(5));
      txtbirth.setText(rs.getString(3));
      txtA.setText(rs.getString(4));
      txtSS.setText(rs.getString(7));
      txtND.setText(rs.getString(9));
         
         
         }
     }
               con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "Search is Done");
              
              
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
