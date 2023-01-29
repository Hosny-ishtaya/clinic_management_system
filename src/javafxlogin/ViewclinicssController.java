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

public class ViewclinicssController implements Initializable {
    public Clinic_table ct ;

    @FXML
    private TableView<Clinic_table> tab;
    
    @FXML
    private TableColumn<Clinic_table, String> NC;

    @FXML
    private TableColumn<Clinic_table, Integer> idc;

    @FXML
    private TableColumn<Clinic_table, String> DC;
    
    @FXML
    private Button view_cl;

    @FXML
    void view_cli(ActionEvent event) {
            System.out.println("view clinicccccccccccccccccccccccc");
            ObservableList <Clinic_table> obsl=FXCollections.observableArrayList();
            
           try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();       
             String str_stmt ="select * from clinics order by id";
              ResultSet rs=stmt.executeQuery(str_stmt);
              
          
         while(rs.next()){
             ct=new Clinic_table();
             ct.setName_of_clinics(rs.getString(3));
             ct.setDoctors_work_in(rs.getString(1));
             ct.setId(rs.getInt(2));
             tab.getItems().add(ct);
       
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
          DC.setCellValueFactory(new PropertyValueFactory<>("Doctors_work_in"));
          idc.setCellValueFactory(new PropertyValueFactory<>("id"));
          NC.setCellValueFactory(new PropertyValueFactory<>("Name_of_clinics"));
      
    }    
    
}
