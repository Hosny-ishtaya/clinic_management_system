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
import java.sql.SQLException;
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
public class ClinicsdetailsController implements Initializable {
    
    
       @FXML
     ChpasswordController ob =new ChpasswordController();
    
    @FXML
    private BorderPane maincl;

    @FXML
    private Button btnvicli;
    
    @FXML
    private Button delete_cl;
    
    @FXML
    private Button add_clinics;
    
     @FXML
    private Button search_cl;
     
         @FXML
    private Button update_cl;
    
    @FXML
    private TextField doctorcl_text;

    @FXML
    private TextField id_text;
    
    @FXML
    private TextField namecl_text;
    
    
     @FXML
    void add_clinicss(ActionEvent event) throws SQLException {
        
        
        System.out.println("add clinics");
        
        
           try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String name_cl =  namecl_text.getText();
               String namedo_cl= doctorcl_text.getText();
               String id_cl = id_text.getText();
               
             String str_stmt =" insert into  clinics values('"+namedo_cl+"',"+id_cl+",'"+name_cl+"')";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "added");
              
              
              
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }

    }
    
    @FXML
    void delete_cli(ActionEvent event) {
        
        try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String name_cl =  namecl_text.getText();
               String namedo_cl= doctorcl_text.getText();
               String id_cl = id_text.getText();
               
             
              String str_stmt =" delete from clinics WHERE id = "+id_cl+"";
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
    void update_cli(ActionEvent event) {
        
        System.out.println("update clinic ");
        try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
              String name_cl =  namecl_text.getText();
               String namedo_cl= doctorcl_text.getText();
               String id_cl = id_text.getText();
               
             String str_stmt ="update clinics set doctors_work_in = '"+namedo_cl+"',name_of_clinics='"+name_cl+"',id="+id_cl+" where id="+id_cl+"";
             
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
    void search_cli(ActionEvent event) {
        
        
         System.out.println("search clinic ");
         
         try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
               String name_cl =  namecl_text.getText();
               String namedo_cl= doctorcl_text.getText();
               String id_cl = id_text.getText();
               String emp="";
               
               if(id_cl.compareTo(emp)!=0 && name_cl.compareTo(emp)==0 && namedo_cl.compareTo(emp)==0){
             String str_stmt ="SELECT doctors_work_in,id,name_of_clinics FROM Clinics where id="+id_cl+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.doctorcl_text.setText(rs.getString(1));
         this.namecl_text.setText(rs.getString(3));
         }
     }
     
             else if(id_cl.compareTo(emp)==0 && name_cl.compareTo(emp)!=0 && namedo_cl.compareTo(emp)==0){
               String str_stmt ="SELECT doctors_work_in,id,name_of_clinics FROM Clinics where name_of_clinics='"+name_cl+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
               System.out.println("Done");
         while(rs.next()){
                            
         this.doctorcl_text.setText(rs.getString(1));
         this.id_text.setText(rs.getString(2));
         }
       }
              
       else if(id_cl.compareTo(emp)==0 && name_cl.compareTo(emp)==0 && namedo_cl.compareTo(emp)!=0){
               String str_stmt ="SELECT doctors_work_in,id,name_of_clinics FROM Clinics where doctors_work_in='"+namedo_cl+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
               System.out.println("Done");
         while(rs.next()){
                            
         this.namecl_text.setText(rs.getString(3));
         this.id_text.setText(rs.getString(2));
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
    void btnviclin(ActionEvent event) {
        
        
         Pane view = ob.getPage("viewclinicss.fxml");
                 maincl.setCenter(view);

    }
    
        @FXML
    void id_textt(ActionEvent event) {

    }

    @FXML
    void doctorcl_textt(ActionEvent event) {

    }

    @FXML
    void namecl_textt(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
