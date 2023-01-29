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
public class ViewreceptionnController implements Initializable {
    @FXML
    private TableView<rec_table> tab;

    @FXML
    private TableColumn<rec_table, String> pass;

    @FXML
    private TableColumn<rec_table, Integer> sala;

    @FXML
    private TableColumn<rec_table, String> ld;

    @FXML
    private TableColumn<rec_table, String> un;

    @FXML
    private TableColumn<rec_table, String> jd;

    @FXML
    private TableColumn<rec_table, Integer> id_r;

    
     @FXML
    private Button view_re;

    @FXML
    void view_rec(ActionEvent event) {
          System.out.println("view reception sssssssssssssssssss");
          
          ObservableList <Clinic_table> obsl=FXCollections.observableArrayList();
  
    try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();       
             String str_stmt ="select * from manger order by manger_id";
              ResultSet rs=stmt.executeQuery(str_stmt);
              
          
         while(rs.next()){
           rec_table rt=new rec_table();
             rt.setId(rs.getInt(6));
             rt.setUsername(rs.getString(1));
             rt.setPassword(rs.getString(2));
             rt.setJoinD(rs.getString(3));
             rt.setLeavD(rs.getString(4));
             rt.setSalary(rs.getInt(5));
             tab.getItems().add(rt);
       
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
         this.un.setCellValueFactory(new PropertyValueFactory<>("username"));
          this.pass.setCellValueFactory(new PropertyValueFactory<>("password"));
          this.jd.setCellValueFactory(new PropertyValueFactory<>("joinD"));
          this.ld.setCellValueFactory(new PropertyValueFactory<>("leavD"));
          this.sala.setCellValueFactory(new PropertyValueFactory<>("salary"));
          this.id_r.setCellValueFactory(new PropertyValueFactory<>("id"));
    }    
    
}
