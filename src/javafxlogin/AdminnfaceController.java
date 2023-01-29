/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import oracle.jdbc.pool.OracleDataSource;

/**
 * FXML Controller class
 *
 * @author Hosny
 */
public class AdminnfaceController implements Initializable {
    @FXML
    ChpasswordController object =new ChpasswordController();
    
      @FXML
    private Button btnchpa;
       @FXML
    private BorderPane maina;
       @FXML
    private Button btnloggout;
       
       
    @FXML
    private Button doctord;

    @FXML
    private Button pharmacidtd;
    
        @FXML
    private Button receptionistd;
        @FXML
    private Button btnclinicde;
        
        @FXML
    private Button doctorreport;
        
        @FXML
    private Button samplereport;
        
        
    @FXML
    void btnclinicdet(ActionEvent event) {
        Pane view = object.getPage("clinicsdetails.fxml");
        maina.setCenter(view);

    }
        
            @FXML
    void receptionistde(ActionEvent event) {
        
         Pane view = object.getPage("receptiondetails.fxml");
        maina.setCenter(view);

    }

    @FXML
    void doctorde(ActionEvent event) {
        
          Pane view = object.getPage("doctordetails.fxml");
        maina.setCenter(view);
       // System.out.println("ffffff");

    }

    @FXML
    void pharmacidtde(ActionEvent event) {
        
         //System.out.println("ffffff");
         Pane view = object.getPage("pharmacistdetails.fxml");
        maina.setCenter(view);
        

    }
    
       @FXML
    void samplereportt(ActionEvent event) {
        
        System.out.println("report for sample is done");
         try {
            // TODO add your handling code here:

            OracleDataSource ods=new OracleDataSource();
            ods.setURL("jdbc:oracl:thin:localhost:1521:orcl");
            ods.setUser("hr");
            ods.setPassword("123");
          Connection con= ods.getConnection();
          
          InputStream input= new FileInputStream(new File("Tree_clinic_lab.jrxml"));
          JasperDesign JD;
          JD=JRXmlLoader.load(input);
          JasperReport JR;
          JR=JasperCompileManager.compileReport(JD);
          JasperPrint JP=JasperFillManager.fillReport(JR, null, con);
          OutputStream out =new FileOutputStream(new File("Clinic-labs-report.pdf"));
          JasperExportManager.exportReportToPdfStream(JP, out);
          out.close();
          input.close();
       
        } catch (Exception ex) {
            Logger.getLogger(AdminnfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
     JOptionPane.showMessageDialog(null, "The Report you need in file projectf");
    }

    @FXML
    void doctorreport(ActionEvent event) {
        
         System.out.println("report for doctor is done");
         try {
            // TODO add your handling code here:

            OracleDataSource ods=new OracleDataSource();
            ods.setURL("jdbc:oracl:thin:localhost:1521:orcl");
            ods.setUser("hr");
            ods.setPassword("123");
          Connection con= ods.getConnection();
          
          InputStream input= new FileInputStream(new File("Tree.jrxml"));
          JasperDesign JD;
          JD=JRXmlLoader.load(input);
          JasperReport JR;
          JR=JasperCompileManager.compileReport(JD);
          JasperPrint JP=JasperFillManager.fillReport(JR, null, con);
          OutputStream out =new FileOutputStream(new File("Clinic-doctor-report.pdf"));
          JasperExportManager.exportReportToPdfStream(JP, out);
          out.close();
          input.close();
       
        } catch (Exception ex) {
            Logger.getLogger(AdminnfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
     JOptionPane.showMessageDialog(null, "The Report you need in file projectf"); 

    }



    @FXML
    void btnchpaa(ActionEvent event) {
        
        Pane view = object.getPage("chpassword.fxml");
        maina.setCenter(view);
        
    }
    
     @FXML
    void btnloggoutt(ActionEvent event)throws IOException  {
        
              Parent home_page_parent  = FXMLLoader.load(getClass().getResource("Inter.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
       
        
        

    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
