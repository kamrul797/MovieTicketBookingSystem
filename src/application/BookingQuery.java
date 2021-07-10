package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookingQuery {

	Connection connection;

	public BookingQuery() {
		connection = DBConnector.connect();
	}

	public ObservableList<BookingModel> getBookings() {
		ObservableList<BookingModel> list = FXCollections.observableArrayList();

		try {
			ResultSet resultSet = connection.createStatement().executeQuery("select * from booking");
			while (resultSet.next()) {
				BookingModel model = new BookingModel(resultSet.getInt("bid"), resultSet.getString("cname"), resultSet.getString("cnumber"), resultSet.getString("movie"), resultSet.getString("date"), resultSet.getString("time"), resultSet.getInt("seat"));
				list.add(model);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}
	
	public int addBooking(BookingModel model) {
		String query = "INSERT INTO `booking` (`cname`, `cnumber`, `movie`, `date`, `time`, `seat`) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, model.getCname());
			statement.setString(2, model.getCnumber());
			statement.setString(3, model.getMovie());
			statement.setString(4, model.getDate());
			statement.setString(5, model.getTime());
			statement.setInt(6, model.getSeat());
			int result = statement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateBooking(BookingModel model) {
		String query = "UPDATE `booking` SET `cname` = ?, `cnumber`= ?, `movie` = ?, `date`= ?, `time` = ?, `seat` = ? WHERE `bid`= ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, model.getCname());
			statement.setString(2, model.getCnumber());
			statement.setString(3, model.getMovie());
			statement.setString(4, model.getDate());
			statement.setString(5, model.getTime());
			statement.setInt(6, model.getSeat());
			statement.setInt(7, model.getBid());
			int result = statement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteBooking(int bid) {
		String query = "DELETE FROM `booking` WHERE `bid`= ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);

			statement.setInt(1, bid);

			int result = statement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
