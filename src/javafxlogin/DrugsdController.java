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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hosny
 */
public class DrugsdController implements Initializable {
        @FXML
    private BorderPane maind;
    @FXML
    ChpasswordController ob =new ChpasswordController();
     @FXML
    private Button deleted;

    @FXML
    private Button updated;

    @FXML
    private Button addd;

    @FXML
    private Button viewd;
    
     @FXML
    private Button searchd;
     @FXML
    private TextField txtDN;

    @FXML
    private TextField txtid;
      @FXML
    private TextField txtC;


    @FXML
    void adddr(ActionEvent event) {
        
        System.out.println(" add drugs");
        /*
        Pane pp =ob.getPage("adddrugs.fxml");
        maind.setCenter(pp);
        */
         try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String id =  txtid.getText();
               String name= txtDN.getText();
               String cost = txtC.getText();
               
             String str_stmt =" insert into pharmacy values('"+id+"','"+name+"',"+cost+")";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "added");
              
              txtid.setText("");
              txtDN.setText("");
              txtC.setText("");
              
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }

    }

    @FXML
    void deletedr(ActionEvent event) {
       
         System.out.println(" delete drugs");
        /*
    Pane pp =ob.getPage("deletedrugs.fxml");
        maind.setCenter(pp);
        */
        try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
              String id =  txtid.getText();
               String name= txtDN.getText();
               String cost = txtC.getText();
               
             String str_stmt =" delete from pharmacy WHERE id = '"+id+"'";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "deleted");
              
              
              
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }
        
    }

    @FXML
    void updatedr(ActionEvent event) {
        
         System.out.println(" uodate drugs");
        
        
        /*
    Pane pp =ob.getPage("updatedrugs.fxml");
        maind.setCenter(pp);
        */
        try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
                String id =  txtid.getText();
               String name= txtDN.getText();
               String cost = txtC.getText();
               
             String str_stmt ="update pharmacy set id = '"+id+"',drugs='"+name+"',cost="+cost+" where id='"+id+"'";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "updated");
              
              
              
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }

    }
    
       @FXML
    void searchdr(ActionEvent event) {
        
         System.out.println("serch drugs");
        
        /*
         Pane pp =ob.getPage("searchdrugs.fxml");
        maind.setCenter(pp);
        
        */
        try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
                String id =  txtid.getText();
               String name= txtDN.getText();
               String cost = txtC.getText();
               String emp="";
               
               if(id.compareTo(emp)!=0 && name.compareTo(emp)==0 && cost.compareTo(emp)==0){
             String str_stmt ="SELECT id,drugs,cost FROM pharmacy where id='"+id+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.txtDN.setText(rs.getString(2));
         this.txtC.setText(rs.getString(3));
         }
     }
     
             else if(id.compareTo(emp)==0 && name.compareTo(emp)!=0 && cost.compareTo(emp)==0){
               String str_stmt ="SELECT id,drugs,cost FROM pharmacy where drugs='"+name+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
               System.out.println("Done");
         while(rs.next()){
                            
         this.txtC.setText(rs.getString(3));
         this.txtid.setText(rs.getString(1));
         }
       }
              
       else if(id.compareTo(emp)==0 && name.compareTo(emp)==0 && cost.compareTo(emp)!=0){
               String str_stmt ="SELECT id,drugs,cost FROM pharmacy where cost="+cost+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
               System.out.println("Done");
         while(rs.next()){
                            
         this.txtDN.setText(rs.getString(2));
         this.txtid.setText(rs.getString(1));
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
    void viewdr(ActionEvent event) {
        
        
       Pane pp =ob.getPage("viewdrugss.fxml");
        maind.setCenter(pp);
        
    }

    
      @FXML
    void txtid(ActionEvent event) {

    }

    @FXML
    void txtC(ActionEvent event) {

    }

    @FXML
    void txtDN(ActionEvent event) {
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }    
    
}
