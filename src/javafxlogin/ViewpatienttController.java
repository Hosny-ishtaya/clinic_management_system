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
public class ViewpatienttController implements Initializable {
     @FXML
    private TableColumn<pat_table, String> ss;

    @FXML
    private TableColumn<pat_table, String> gen;

    @FXML
    private TableColumn<pat_table, String> ln;

    @FXML
    private TableColumn<pat_table, String> bd;

    @FXML
    private TableColumn<pat_table, String> ad;

    @FXML
    private TableView<pat_table> tab;

    @FXML
    private Button view_p;

    @FXML
    private TableColumn<pat_table, String> nd;

    @FXML
    private TableColumn<pat_table, String> fn;

    @FXML
    private TableColumn<pat_table, Integer> ph;

    @FXML
    private TableColumn<pat_table, Integer> id;

    @FXML
    private TableColumn<pat_table, String> cn;

    @FXML
    void view_pa(ActionEvent event) {
        System.out.println("view patient ttttttttttttttt");

           ObservableList <Clinic_table> obsl=FXCollections.observableArrayList();
  
    try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();       
             String str_stmt ="select * from patient order by id_pat";
              ResultSet rs=stmt.executeQuery(str_stmt);
              
          
         while(rs.next()){
           pat_table pt=new pat_table();
             pt.setId(rs.getInt(6));
             pt.setFirstn(rs.getString(1));
             pt.setLastn(rs.getString(2));
             pt.setBd(rs.getString(3));
             pt.setAdd(rs.getString(4));
             pt.setPh(rs.getInt(5));
             pt.setSs(rs.getString(7));
             pt.setCn(rs.getString(8));
             pt.setDn(rs.getString(9));
             pt.setGen(rs.getString(10));
             tab.getItems().add(pt);
       
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
  //      String firstn,lastn,bd,add,ss,cn,dn,gen;
  //  int id,ph;
  
          this.fn.setCellValueFactory(new PropertyValueFactory<>("firstn"));
          this.ln.setCellValueFactory(new PropertyValueFactory<>("lastn"));
          this.bd.setCellValueFactory(new PropertyValueFactory<>("bd"));
          this.ad.setCellValueFactory(new PropertyValueFactory<>("add"));
          this.ss.setCellValueFactory(new PropertyValueFactory<>("ss"));
          this.cn.setCellValueFactory(new PropertyValueFactory<>("cn"));
          this.nd.setCellValueFactory(new PropertyValueFactory<>("dn"));
          this.gen.setCellValueFactory(new PropertyValueFactory<>("gen"));
          this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
          this.ph.setCellValueFactory(new PropertyValueFactory<>("ph"));
  
    }    
    
}
