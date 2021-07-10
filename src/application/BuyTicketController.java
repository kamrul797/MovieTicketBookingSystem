package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class BuyTicketController implements Initializable{
	@FXML
	private TableView<BookingModel> tableView;
	@FXML
	private TableColumn<BookingModel, String> col_movie;
	@FXML
	private TableColumn<BookingModel, String> col_time;
	
	@FXML
	private TextField text_bid;
	@FXML
	private TextField text_cname;
	@FXML
	private TextField text_cnumber;
	@FXML
	private TextField text_movie;
	@FXML
	private TextField text_date;
	@FXML
	private TextField text_time;
	@FXML
	private TextField text_seat;
	@FXML
	private Label msg;
	
	BookingQuery query;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		query = new BookingQuery();
		col_movie.setCellValueFactory(new PropertyValueFactory<BookingModel, String>("movie"));
		col_time.setCellValueFactory(new PropertyValueFactory<BookingModel, String>("time"));
		tableView.setItems(query.getBookings());
	}
	
	public void insertBooking(ActionEvent event) {
		BookingModel model = new BookingModel(0, text_cname.getText(), text_cnumber.getText(), text_movie.getText(), text_date.getText(), text_time.getText(), Integer.parseInt(text_seat.getText()));
		query.addBooking(model);
		refreshTable();
		
	}
	
	
    public void changeScreenButtonPushedBacktoUser(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("landingpageforuser.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
	
	private void refreshTable() {
		tableView.setItems(query.getBookings());
		text_bid.clear();
		text_cname.clear();
		text_cnumber.clear();
		text_movie.clear();
		text_date.clear();
		text_time.clear();
		text_seat.clear();
	}

}

