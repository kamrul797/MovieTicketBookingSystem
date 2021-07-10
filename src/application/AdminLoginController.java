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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    void login(MouseEvent event) throws SQLException, IOException {

        String username, password;

        username = tf_username.getText();
        password = pf_password.getText();

        Connection connection = DbConnect.getInstance().getConnection();

        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("select * from admin where username" +
                " = '" + username + "' and password = '" + password + "'");
        
        if (resultSet.next()) {
        	System.out.println("Successfully Logged In");
        	Parent root = FXMLLoader.load(getClass().getResource("landingpageforadmin.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));        
        }
        else {
        	System.out.println("Sorry, you are not an admin.");
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
    
	public void changeScreenButtonPushedSignUp(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("signup.fxml"));
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


