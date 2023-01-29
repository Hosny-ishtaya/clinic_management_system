/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Hosny
 */
public class loginController implements Initializable {
     

    @FXML
    private Button btnx;

    @FXML
    private Button btnsignin;

    @FXML
    private Button btnsignup;
    @FXML
    private Button btnback;
    
     
     @FXML
    private TextField tfuser;
     
      @FXML
    private PasswordField tspass;
     @FXML
    private Label warnlabel;
     
     
    @FXML
    void back(ActionEvent event) throws IOException {
 
               
        Parent home_page_parent  = FXMLLoader.load(getClass().getResource("Inter.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
       
      

    }
     ChpasswordController objectt =new  ChpasswordController();
    @FXML
    void signin(ActionEvent event) throws IOException
    {
        System.out.println("signin");
        
         if (tfuser.getText().equals("a")&&tspass.getText().equals("1"))
         {
            System.out.println("this account for admin hosny and   is correct");
            
            
            Parent home_page_parent  = FXMLLoader.load(getClass().getResource("adminnface.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           
            
         }
         
        
         
        
         
         else if (tfuser.getText().equals("d")&&tspass.getText().equals("2"))//for move from login to doctor portal
         {
            System.out.println("this account for admin hosny and   is correct");
            
            
            Parent home_page_parent  = FXMLLoader.load(getClass().getResource("doctorface.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           
            
         }
         
         
         else if (tfuser.getText().equals("r")&&tspass.getText().equals("3"))//for move from login to receptionist portal
         {
            System.out.println("this account for admin hosny and   is correct");
            
            
            Parent home_page_parent  = FXMLLoader.load(getClass().getResource("recepface.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           
            
         }
         
         else if (tfuser.getText().equals("p")&&tspass.getText().equals("4"))//for move from login to receptionist portal
         {
            System.out.println("this account for admin hosny and   is correct");
            
            
            Parent home_page_parent  = FXMLLoader.load(getClass().getResource("pharmacisttface.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           
            
         }
         
          else if (tfuser.getText().equals("l")&&tspass.getText().equals("5"))//for move from login to labface  portal
         {
            System.out.println("this account for admin hosny and   is correct");
            
            
            Parent home_page_parent  = FXMLLoader.load(getClass().getResource("labface.fxml"));// that we want to edite it 
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
           
            
         }
         
         
         else 
         {
             
             JOptionPane.showMessageDialog(null, "Wrong User or Password .please Try Again","Message",JOptionPane.INFORMATION_MESSAGE );
             System.out.println("this account is  wrong");
            //warnlabel.setText("This account is wrong");  
             //warnlabel.setText(" ");
       
         }
             tfuser.clear();
             tspass.clear();
 
    }

    
    @FXML
    void signup(ActionEvent event) {
        System.out.println("signup");
        
        
        
        
        
        
        
        
        
        /*
         Parent home_page_parent  = FXMLLoader.load(getClass().getResource("interface.fxml"));
        Scene home_page_Scene = new Scene(home_page_parent); 
        Stage app_stage = (Stage)  ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_Scene);
        app_stage.show();
       */
    
    }

    @FXML
    void exit(ActionEvent event) {
        System.out.println("you click exit");
    }
    @FXML
    void user(ActionEvent event) {
        
        
       if( event.equals("hosny"))
           System.out.println("that it hosny");

    }
     @FXML
    void password(ActionEvent event) {

    }
       @FXML
    void passwo(ActionEvent event) {

    }
    
     @FXML
    void wlabel(ActionEvent event) {

    }
 

    @FXML
    private Label labe;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        labe.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
