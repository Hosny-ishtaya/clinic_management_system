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
public class ReceptiondetailsController implements Initializable {
    
     @FXML
    private TextField txtjd;

    @FXML
    private TextField txtid;

    @FXML
    private Button add_r;

    @FXML
    private TextField txtld;

    @FXML
    private TextField txtu;

    @FXML
    private TextField txts;

    @FXML
    private Button delete_r;

    @FXML
    private TextField txtp;

    @FXML
    private BorderPane mainredet;

    @FXML
    private Button update_r;

    @FXML
    private Button btnviewr;

    @FXML
    private Button search_r;

    

    @FXML
    void add_r(ActionEvent event) {
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
             
               String id =  txtid.getText();
               String JD =  txtjd.getText();
               String Username =  txtu.getText();
               String LD =  txtld.getText();
               String Pass =  txtp.getText();
               String salary =  txts.getText();
               
        //       String namedo_cl= txtdoctor.getText();
        //       String id_cl = txtid.getText();
               
             String str_stmt =" insert into  Manger values('"+Username+"','"+Pass+"','"+JD+"','"+LD+"',"+salary+","+id+")";
             
              stmt.executeUpdate(str_stmt);
              con.commit();
              con.close();
              JOptionPane.showMessageDialog(null, "added");
              
                txtid.setText("");
                txtjd.setText("");
                txtu.setText("");
                txtld.setText("");
                txtp.setText("");
                txts.setText("");
                      
              
           } catch (Exception ex) {
              // Logger.getLogger(ClinicsdetailsController.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, ex.toString());  
           }
    }

    @FXML
    void delete_r(ActionEvent event) {
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
              String id =  txtid.getText();
               String JD =  txtjd.getText();
               String Username =  txtu.getText();
               String LD =  txtld.getText();
               String Pass =  txtp.getText();
               String salary =  txts.getText();
               
               
             String str_stmt =" delete from Manger WHERE Manger_id = "+id+"";
             
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
    void update_r(ActionEvent event) {
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
               
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
               String id =  txtid.getText();
               String JD =  txtjd.getText();
               String Username =  txtu.getText();
               String LD =  txtld.getText();
               String Pass =  txtp.getText();
               String salary =  txts.getText();
              
             String str_stmt ="update Manger set username = '"+Username+"',joining_date='"+JD+"',Manger_id="+id+",Leaving_date='"+LD+"',Password='"+Pass+"',salary="+salary+" where Manger_id="+id+"";
             
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
    void search_r(ActionEvent event) {
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();
              
               String id =  txtid.getText();
               String JD =  txtjd.getText();
               String Username =  txtu.getText();
               String LD =  txtld.getText();
               String Pass =  txtp.getText();
               String salary =  txts.getText();
               String emp="";
               
               if(id.compareTo(emp)!=0 && JD.compareTo(emp)==0 && Username.compareTo(emp)==0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,Manger_id,joining_date,leaving_date,password,salary FROM Manger where Manger_id="+id+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.txtu.setText(rs.getString(1));
         this.txtp.setText(rs.getString(5));
         this.txtjd.setText(rs.getString(3));
         this.txtld.setText(rs.getString(4));
         this.txts.setText(rs.getString(6));
         this.txtid.setText(rs.getString(2));
         
         
         }
     }
               else  if(id.compareTo(emp)==0 && JD.compareTo(emp)!=0 && Username.compareTo(emp)==0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,Manger_id,joining_date,leaving_date,password,salary FROM Manger where Joining_date='"+JD+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.txtu.setText(rs.getString(1));
         this.txtp.setText(rs.getString(5));
         this.txtjd.setText(rs.getString(3));
         this.txtld.setText(rs.getString(4));
         this.txts.setText(rs.getString(6));
         this.txtid.setText(rs.getString(2));
         
         
         }
     }        
               else  if(id.compareTo(emp)==0 && JD.compareTo(emp)==0 && Username.compareTo(emp)!=0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,manger_id,joining_date,leaving_date,password,salary FROM Manger where username='"+Username+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.txtu.setText(rs.getString(1));
         this.txtp.setText(rs.getString(5));
         this.txtjd.setText(rs.getString(3));
         this.txtld.setText(rs.getString(4));
         this.txts.setText(rs.getString(6));
         this.txtid.setText(rs.getString(2));
         
         
         }
     }
                if(id.compareTo(emp)==0 && JD.compareTo(emp)==0 && Username.compareTo(emp)==0 && LD.compareTo(emp)!=0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,manger_id,joining_date,leaving_date,password,salary FROM manger where Leaving_date='"+LD+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.txtu.setText(rs.getString(1));
         this.txtp.setText(rs.getString(5));
         this.txtjd.setText(rs.getString(3));
         this.txtld.setText(rs.getString(4));
         this.txts.setText(rs.getString(6));
         this.txtid.setText(rs.getString(2));
         
         
         }
     }
             else   if(id.compareTo(emp)==0 && JD.compareTo(emp)==0 && Username.compareTo(emp)==0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)!=0&&salary.compareTo(emp)==0){
             String str_stmt ="SELECT username,manger_id,joining_date,leaving_date,password,salary FROM manger where Password='"+Pass+"'";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.txtu.setText(rs.getString(1));
         this.txtp.setText(rs.getString(5));
         this.txtjd.setText(rs.getString(3));
         this.txtld.setText(rs.getString(4));
         this.txts.setText(rs.getString(6));
         this.txtid.setText(rs.getString(2));
         
         
         }
     }
             else  if(id.compareTo(emp)==0 && JD.compareTo(emp)==0 && Username.compareTo(emp)==0 && LD.compareTo(emp)==0 && Pass.compareTo(emp)==0&&salary.compareTo(emp)!=0){
             String str_stmt ="SELECT username,manger_id,joining_date,leaving_date,password,salary FROM manger where salary="+salary+"";
              ResultSet rs=stmt.executeQuery(str_stmt);
              System.out.println("Done");
         while(rs.next()){
                            
         this.txtu.setText(rs.getString(1));
         this.txtp.setText(rs.getString(5));
         this.txtjd.setText(rs.getString(3));
         this.txtld.setText(rs.getString(4));
         this.txts.setText(rs.getString(6));
         this.txtid.setText(rs.getString(2));
         
         
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
    void txtid(ActionEvent event) {

    }

    @FXML
    void txtu(ActionEvent event) {

    }

    @FXML
    void txtp(ActionEvent event) {

    }

    @FXML
    void txtjd(ActionEvent event) {

    }

    @FXML
    void txtld(ActionEvent event) {

    }

    @FXML
    void txts(ActionEvent event) {

    }
    
       @FXML
     ChpasswordController ob =new ChpasswordController();
   

    @FXML
    void btnviewre(ActionEvent event) {
        
          Pane view = ob.getPage("viewreceptionn.fxml");
                 mainredet.setCenter(view);
        

    }
    
    
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
