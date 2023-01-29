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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hosny
 */
public class ViewdoctorssController implements Initializable {

    @FXML
    private TableView<doc_table> tab;

    @FXML
    private TableColumn<doc_table, String> pass;

    @FXML
    private TableColumn<doc_table, Integer> sala;

    @FXML
    private Button view_do;

    @FXML
    private TableColumn<doc_table, String> Ld;

    @FXML
    private TableColumn<doc_table, String> un;

    @FXML
    private TableColumn<doc_table, String> jd;

    @FXML
    private TableColumn<doc_table, Integer> id;
    
    @FXML
    void view_doc(ActionEvent event) {
        
         System.out.println("view doctor sssssssssssssssssss");
  ObservableList <Clinic_table> obsl=FXCollections.observableArrayList();
  
    try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();       
             String str_stmt ="select * from doctor order by doctor_id";
              ResultSet rs=stmt.executeQuery(str_stmt);
              
          
         while(rs.next()){
           doc_table dt=new doc_table();
             dt.setId(rs.getInt(6));
             dt.setUsername(rs.getString(1));
             dt.setPassword(rs.getString(2));
             dt.setJoinD(rs.getString(3));
             dt.setLeavD(rs.getString(4));
             dt.setSalary(rs.getInt(5));
             tab.getItems().add(dt);
       
         }
      
              con.close();
           
           } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex.toString());  
           }
  
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  //     String username,password,joinD,leavD;
  //  int salary,id; 
          this.un.setCellValueFactory(new PropertyValueFactory<>("username"));
          this.pass.setCellValueFactory(new PropertyValueFactory<>("password"));
          this.jd.setCellValueFactory(new PropertyValueFactory<>("joinD"));
          this.Ld.setCellValueFactory(new PropertyValueFactory<>("leavD"));
          this.sala.setCellValueFactory(new PropertyValueFactory<>("salary"));
          this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
    }    
    
}
