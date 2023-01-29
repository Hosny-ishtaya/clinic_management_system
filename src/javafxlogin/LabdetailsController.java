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
public class LabdetailsController implements Initializable {
    
       @FXML   
    ChpasswordController obj =new ChpasswordController();
       
        @FXML
    private Button viewsample;

    @FXML
    private TextField rs;

    @FXML
    private Button addsample;

    @FXML
    private Button updatesample;

    @FXML
    private BorderPane maindetsample;

    @FXML
    private TextField ids;

    @FXML
    private Button deletesample;

    @FXML
    private Button searchsample;

    @FXML
    private TextField sn;

    @FXML
    private TextField pn;
    
    @FXML
    void addsamplee(ActionEvent event) {
        System.out.println("add sample");

        try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
              String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String name_p =  this.pn.getText();
               String name_s= this.sn.getText();
               String sample_r=this.rs.getText();
               String id_s = this.ids.getText();
               
             String str_stmt =" insert into labs values('"+name_p+"','"+name_s+"','"+sample_r+"',"+id_s+")";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "added");
              
              ids.setText("");
              pn.setText("");
              sn.setText("");
              rs.setText("");
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }
      
    }

    @FXML
    void deletesamplee(ActionEvent event) {
         System.out.println("delete sample");
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String name_p =  this.pn.getText();
               String name_s= this.sn.getText();
               String sample_r=this.rs.getText();
               String id_s = this.ids.getText();
               
             String str_stmt =" delete from labs WHERE id = "+id_s+"";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "deleted");
              
              
              ids.setText("");
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }

    }

    @FXML
    void updatesamplee(ActionEvent event) {
         System.out.println("Update sample");
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String name_p =  this.pn.getText();
               String name_s= this.sn.getText();
               String sample_r=this.rs.getText();
               String id_s = this.ids.getText();
               
             String str_stmt ="update labs set patiant = '"+name_p+"',samples_name='"+name_s+"',samples_results='"+sample_r+"',id="+id_s+" where id="+id_s+"";
             
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
    void searchsamplee(ActionEvent event) {
         System.out.println("Search sample");
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
               String name_p =  this.pn.getText();
               String name_s= this.sn.getText();
               String sample_r=this.rs.getText();
               String id_s = this.ids.getText();
               String emp="";
               
               if(name_p.compareTo(emp)!=0 && name_s.compareTo(emp)==0 && sample_r.compareTo(emp)==0&& id_s.compareTo(emp)==0){
             String str_stmt ="SELECT patiant,samples_name,samples_results,id FROM labs where patiant='"+name_p+"'";
              ResultSet ks=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(ks.next()){                  
              ids.setText(ks.getString(4));
              pn.setText(ks.getString(1));
              sn.setText(ks.getString(2));
              rs.setText(ks.getString(3));
             }
     }
     
             else if(name_p.compareTo(emp)==0 && name_s.compareTo(emp)!=0 && sample_r.compareTo(emp)==0&& id_s.compareTo(emp)==0){
               String str_stmt ="SELECT patiant,samples_name,samples_results,id FROM labs where samples_name='"+name_s+"'";
              ResultSet ks=stmt.executeQuery(str_stmt);
               System.out.println("Done");
         while(ks.next()){
                            
              ids.setText(ks.getString(4));
              pn.setText(ks.getString(1));
              sn.setText(ks.getString(2));
              rs.setText(ks.getString(3));
              }
       }
              
       else if(name_p.compareTo(emp)==0 && name_s.compareTo(emp)==0 && sample_r.compareTo(emp)!=0&& id_s.compareTo(emp)==0){
               String str_stmt ="SELECT patiant,samples_name,samples_results,id FROM labs where samples_results='"+sample_r+"'";
              ResultSet ks=stmt.executeQuery(str_stmt);
               System.out.println("Done");
         while(ks.next()){
                            
             ids.setText(ks.getString(4));
              pn.setText(ks.getString(1));
              sn.setText(ks.getString(2));
              rs.setText(ks.getString(3));
              }
       }
       else if(name_p.compareTo(emp)==0 && name_s.compareTo(emp)==0 && sample_r.compareTo(emp)==0&& id_s.compareTo(emp)!=0){
               String str_stmt ="SELECT patiant,samples_name,samples_results,id FROM labs where id="+id_s+"";
              ResultSet ks=stmt.executeQuery(str_stmt);
               System.out.println("Done");
         while(ks.next()){
                            
             ids.setText(ks.getString(4));
              pn.setText(ks.getString(1));
              sn.setText(ks.getString(2));
              rs.setText(ks.getString(3));
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
    void viewsample(ActionEvent event) {
        
         System.out.println("view sample");
         
         Pane view = obj.getPage("viewsample.fxml");
        maindetsample.setCenter(view);

    }

    
      @FXML
    void ids(ActionEvent event) {

    }

    @FXML
    void sn(ActionEvent event) {

    }

    @FXML
    void pn(ActionEvent event) {

    }

    @FXML
    void rs(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
