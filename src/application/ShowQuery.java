package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ShowQuery {

	Connection connection;

	public ShowQuery() {
		connection = DBConnector.connect();
	}

	public ObservableList<ShowModel> getMovies() {
		ObservableList<ShowModel> list = FXCollections.observableArrayList();

		try {
			ResultSet resultSet = connection.createStatement().executeQuery("select * from movie ORDER BY status");
			while (resultSet.next()) {
				ShowModel model = new ShowModel(resultSet.getInt("mid"), resultSet.getString("mname"), resultSet.getString("stime"), resultSet.getString("status"));
				list.add(model);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	public int addMovie(ShowModel model) {
		String query = "INSERT INTO `movie` (`mname`, `stime`, `status`) VALUES (?, ?, ?)";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, model.getMname());
			statement.setString(2, model.getStime());
			statement.setString(3, model.getStatus());
			

			int result = statement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateMovie(ShowModel model) {
		String query = "UPDATE `movie` SET `mname`= ?, `stime` = ?, `status`= ? WHERE `mid`= ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, model.getMname());
			statement.setString(2, model.getStime());
			statement.setString(3, model.getStatus());
			statement.setInt(4, model.getMid());

			int result = statement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteMovie(int mid) {
		String query = "DELETE FROM `movie` WHERE `mid`= ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
//?
			statement.setInt(1, mid);

			int result = statement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
