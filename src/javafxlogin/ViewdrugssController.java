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
public class ViewdrugssController implements Initializable {

     @FXML
    private TableColumn<dru_table, Integer> cd;

    @FXML
    private TableView<dru_table> tab;

    @FXML
    private TableColumn<dru_table, String> nd;

    @FXML
    private Button view_dr;

    @FXML
    private TableColumn<dru_table, String> id;
    
    @FXML
    void view_dru(ActionEvent event) {
        System.out.println("view drugs sssssssssssssssssss");

     try { 
               DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                String str_url ="jdbc:oracle:thin:@localhost:1521:orcl";
              Connection con = DriverManager.getConnection(str_url,"hr","123");
              Statement stmt = con.createStatement();       
             String str_stmt ="select * from pharmacy order by id";
              ResultSet rs=stmt.executeQuery(str_stmt);
              
          
         while(rs.next()){
            dru_table dt=new dru_table();
             dt.setCost(rs.getInt(3));
             dt.setId(rs.getString(1));
             dt.setDrugName(rs.getString(2));
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
    //     String drugName,id;
   // int cost;
          this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
          this.nd.setCellValueFactory(new PropertyValueFactory<>("drugName"));
          this.cd.setCellValueFactory(new PropertyValueFactory<>("cost"));
    }    
    
}
