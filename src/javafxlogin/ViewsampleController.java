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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Hosny
 */
public class ViewsampleController implements Initializable {
    @FXML
    private Button viewsamp;

    @FXML
    private TableView<lab_table> tab;

    @FXML
    private TableColumn<lab_table, String> SN;

    @FXML
    private TableColumn<lab_table, Integer> id_s;

    @FXML
    private TableColumn<lab_table, String> PN;

    @FXML
    private TableColumn<lab_table, String> SR;
    
    @FXML
    void viewsampp(ActionEvent event) {
        
        System.out.println("view sampleeeeeeeeeeeeeeeeeeeeeeeee");
try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();       
             String str_stmt ="select * from labs order by id";
              ResultSet rs=stmt.executeQuery(str_stmt);
              
          
         while(rs.next()){
           lab_table ct=new lab_table();
             ct.setRes(rs.getString(3));
             ct.setName(rs.getString(1));
             ct.setType(rs.getString(2));
             ct.setId(rs.getInt(4));
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
      //  String name,type,res;
   // int id;
          this.PN.setCellValueFactory(new PropertyValueFactory<>("name"));
          this.SN.setCellValueFactory(new PropertyValueFactory<>("type"));
          this.SR.setCellValueFactory(new PropertyValueFactory<>("res"));
          this.id_s.setCellValueFactory(new PropertyValueFactory<>("id"));
    }    
    
}
