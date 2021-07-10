package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_email;

    @FXML
    private PasswordField pf_password;

    double x = 0, y = 0;

    @FXML
    void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void signup(MouseEvent event) throws IOException {

        Connection connection = DbConnect.getInstance().getConnection();

        try {

            String username = tf_username.getText();
            String email = tf_email.getText();
            String password = pf_password.getText();

            Statement statement = connection.createStatement();

            int status = statement.executeUpdate("insert into users (username,email,password)" +
                    " values('" + username + "','" + email + "','" + password + "')");

            if (status > 0) {
                System.out.println("User Registered Successfully");
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("login.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                
                //This line gets the Stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                
                window.setScene(tableViewScene);
                window.show();
            }
            else {
            	System.out.println("User Already Registered, Please Log In");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public void changeScreenButtonPushedCancel(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("cinetickets.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
	public void changeScreenButtonPushedLogIn(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
