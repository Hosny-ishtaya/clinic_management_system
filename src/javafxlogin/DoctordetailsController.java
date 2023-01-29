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
public class DoctordetailsController implements Initializable {
    
      @FXML
    private Button update_doc;
 @FXML
    private Button delete_doc;
@FXML
    private Button search_doc;

     @FXML
     ChpasswordController ob =new ChpasswordController();
    
     @FXML
    private Button btnviewdo;
       @FXML
    private BorderPane maindode;
       
        @FXML
    private TextField leaving_d;

    @FXML
    private TextField id_d;

    @FXML
    private TextField username_d;
    
    @FXML
    private TextField password_d;

    @FXML
    private TextField sallary_d;
    
       @FXML
    private TextField join_ind;
       
     @FXML
    private Button add_do;
     
      @FXML
    void add_doc(ActionEvent event) {
        
         try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String name_do =  username_d.getText();
               String id_do = id_d.getText();
               String password = password_d.getText();
               String join_in = join_ind.getText();
               String leaving = leaving_d.getText();
                String sallary = sallary_d.getText();
             
             String str_stmt =" insert into  doctor values('"+name_do+"','"+password+"','"+join_in+"','"+leaving+"',"+sallary+","+id_do+")";
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "added doctor");
              
              
              
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }
         
                id_d.clear();
                join_ind.clear();
                leaving_d.clear();
                sallary_d.clear();
                password_d.clear();
                username_d.clear();
        

    }
    
    @FXML
    void delete_doc(ActionEvent event) {
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
              String id = id_d.getText();
               String JD = join_ind.getText();
               String Username =  username_d.getText();
               String LD = leaving_d.getText();
               String Pass = password_d.getText();
               String salary = sallary_d.getText();
               
               
             String str_stmt =" delete from Doctor WHERE Doctor_id = "+id+"";
             
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
    void update_doc(ActionEvent event) {
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
                String id = id_d.getText();
               String JD = join_ind.getText();
               String Username =  username_d.getText();
               String LD = leaving_d.getText();
               String Pass = password_d.getText();
               String salary = sallary_d.getText();
              
             String str_stmt ="update doctor set username = '"+Username+"',joining_date='"+JD+"',doctor_id="+id+",Leaving_date='"+LD+"',Password="+Pass+",salary="+salary+" where Doctor_id="+id+"";
             
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
    void search_doc(ActionEvent event) {
  try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
                String id = id_d.getText();
               String JD = join_ind.getText();
               String Username =  username_d.getText();
               String LD = leaving_d.getText();
               String Pass = password_d.getText();
               String salary = sallary_d.getText();
               String emp="";
               
               if(id.compareTo(emp)!=0 && JD.compareTo(emp)==0 && Username.compareTo(emp)==0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,doctor_id,joining_date,leaving_date,password,salary FROM Doctor where doctor_id="+id+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.username_d.setText(rs.getString(1));
         this.password_d.setText(rs.getString(5));
         this.join_ind.setText(rs.getString(3));
         this.leaving_d.setText(rs.getString(4));
         this.sallary_d.setText(rs.getString(6));
         this.id_d.setText(rs.getString(2));
         
         
         }
     }
               else  if(id.compareTo(emp)==0 && JD.compareTo(emp)!=0 && Username.compareTo(emp)==0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,doctor_id,joining_date,leaving_date,password,salary FROM Doctor where Joining_date='"+JD+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
    //     this.txtu.setText(rs.getString(1));
    //     this.txtp.setText(rs.getString(5));
    //     this.txtjd.setText(rs.getString(3));
    //     this.txtld.setText(rs.getString(4));
    //     this.txts.setText(rs.getString(6));
    //     this.txtid.setText(rs.getString(2));
      this.username_d.setText(rs.getString(1));
         this.password_d.setText(rs.getString(5));
         this.join_ind.setText(rs.getString(3));
         this.leaving_d.setText(rs.getString(4));
         this.sallary_d.setText(rs.getString(6));
         this.id_d.setText(rs.getString(2));   
         
         }
     }        
               else  if(id.compareTo(emp)==0 && JD.compareTo(emp)==0 && Username.compareTo(emp)!=0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,doctor_id,joining_date,leaving_date,password,salary FROM Doctor where username='"+Username+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
      //   this.txtu.setText(rs.getString(1));
      //   this.txtp.setText(rs.getString(5));
      //   this.txtjd.setText(rs.getString(3));
       //  this.txtld.setText(rs.getString(4));
       //  this.txts.setText(rs.getString(6));
       //  this.txtid.setText(rs.getString(2));
         this.username_d.setText(rs.getString(1));
         this.password_d.setText(rs.getString(5));
         this.join_ind.setText(rs.getString(3));
         this.leaving_d.setText(rs.getString(4));
         this.sallary_d.setText(rs.getString(6));
         this.id_d.setText(rs.getString(2));
         
         }
     }
                if(id.compareTo(emp)==0 && JD.compareTo(emp)==0 && Username.compareTo(emp)==0 && LD.compareTo(emp)!=0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,doctor_id,joining_date,leaving_date,password,salary FROM Doctor where Leaving_date='"+LD+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
       //  this.txtu.setText(rs.getString(1));
       //  this.txtp.setText(rs.getString(5));
       //  this.txtjd.setText(rs.getString(3));
       //  this.txtld.setText(rs.getString(4));
       //  this.txts.setText(rs.getString(6));
       //  this.txtid.setText(rs.getString(2));
         this.username_d.setText(rs.getString(1));
         this.password_d.setText(rs.getString(5));
         this.join_ind.setText(rs.getString(3));
         this.leaving_d.setText(rs.getString(4));
         this.sallary_d.setText(rs.getString(6));
         this.id_d.setText(rs.getString(2));
         
         }
     }
             else   if(id.compareTo(emp)==0 && JD.compareTo(emp)==0 && Username.compareTo(emp)==0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)!=0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,doctor_id,joining_date,leaving_date,password,salary FROM Doctor where Password="+Pass+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
       //  this.txtu.setText(rs.getString(1));
       //  this.txtp.setText(rs.getString(5));
        // this.txtjd.setText(rs.getString(3));
        // this.txtld.setText(rs.getString(4));
        // this.txts.setText(rs.getString(6));
         //this.txtid.setText(rs.getString(2));
         
         this.username_d.setText(rs.getString(1));
         this.password_d.setText(rs.getString(5));
         this.join_ind.setText(rs.getString(3));
         this.leaving_d.setText(rs.getString(4));
         this.sallary_d.setText(rs.getString(6));
         this.id_d.setText(rs.getString(2));
         }
     }
             else  if(id.compareTo(emp)==0 && JD.compareTo(emp)==0 && Username.compareTo(emp)==0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)!=0){
             String str_stmt ="SELECT username,doctor_id,joining_date,leaving_date,password,salary FROM Doctor where salary="+salary+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
       //  this.txtu.setText(rs.getString(1));
       //  this.txtp.setText(rs.getString(5));
       //  this.txtjd.setText(rs.getString(3));
       //  this.txtld.setText(rs.getString(4));
       //  this.txts.setText(rs.getString(6));
        // this.txtid.setText(rs.getString(2));
         this.username_d.setText(rs.getString(1));
         this.password_d.setText(rs.getString(5));
         this.join_ind.setText(rs.getString(3));
         this.leaving_d.setText(rs.getString(4));
         this.sallary_d.setText(rs.getString(6));
         this.id_d.setText(rs.getString(2));
         
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
    void btnviewdoc(ActionEvent event) {
        
          Pane view = ob.getPage("viewdoctorss.fxml");
                 maindode.setCenter(view);
        System.out.println("hosny king");

    }
    
       @FXML
    void id_do(ActionEvent event) {

    }

    @FXML
    void password_do(ActionEvent event) {

    }

    @FXML
    void username_do(ActionEvent event) {

    }

    @FXML
    void sallary_do(ActionEvent event) {

    }

    @FXML
    void join_indo(ActionEvent event) {

    }

    @FXML
    void leaving_do(ActionEvent event) {

    }
    

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
