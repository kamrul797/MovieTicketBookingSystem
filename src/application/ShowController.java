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

	public class ShowController implements Initializable{
		@FXML
		private TableView<ShowModel> tableView;
		@FXML
		private TableColumn<ShowModel, Integer> col_mid;
		@FXML
		private TableColumn<ShowModel, String> col_mname;
		@FXML
		private TableColumn<ShowModel, String> col_stime;
		@FXML
		private TableColumn<ShowModel, String> col_status;

		@FXML
		private TextField text_mid;
		@FXML
		private TextField text_mname;
		@FXML
		private TextField text_stime;
		@FXML
		private TextField text_status;

		@FXML
		private Label msg;
		
		ShowQuery query;
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			query = new ShowQuery();
			col_mid.setCellValueFactory(new PropertyValueFactory<ShowModel, Integer>("mid"));
			col_mname.setCellValueFactory(new PropertyValueFactory<ShowModel, String>("mname"));
			col_stime.setCellValueFactory(new PropertyValueFactory<ShowModel, String>("stime"));
			col_status.setCellValueFactory(new PropertyValueFactory<ShowModel, String>("status"));
			tableView.setItems(query.getMovies());
		}
		
		public void insertMovie(ActionEvent event) {
			ShowModel model = new ShowModel(0, text_mname.getText(), text_stime.getText(), text_status.getText());
			query.addMovie(model);
			//msg.setText(count + " rows inserted!");
			refreshTable();
			
		}
		
		public void editMovie(ActionEvent event) {
			ShowModel model = new ShowModel(Integer.parseInt(text_mid.getText()), text_mname.getText(), text_stime.getText(), text_status.getText());
			query.updateMovie(model);
			refreshTable();
			
		}
		
		public void selectMovie(ActionEvent event) {
			ShowModel model = tableView.getSelectionModel().getSelectedItem();
			text_mid.setText(Integer.toString(model.getMid()));
			text_mname.setText(model.getMname());
			text_stime.setText(model.getStime());
			text_status.setText(model.getStatus());
		}
		
		
		public void deleteMovie(ActionEvent event) {
			int mid = tableView.getSelectionModel().getSelectedItem().getMid();
			query.deleteMovie(mid);
			//msg.setText(count + " rows deleted!");
			refreshTable();
		}
		
	    public void changeScreenButtonPushedBacktoAdmin(ActionEvent event) throws IOException
	    {
	        Parent tableViewParent = FXMLLoader.load(getClass().getResource("landingpageforadmin.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
	    }
		
	    public void changeScreenButtonPushedBacktoUser(ActionEvent event) throws IOException
	    {
	        Parent tableViewParent = FXMLLoader.load(getClass().getResource("landingpageforuser.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
	    }
	    
		private void refreshTable() {
			tableView.setItems(query.getMovies());
			text_mid.clear();
			text_stime.clear();
			text_mname.clear();
			text_status.clear();
		}

	}


	

