package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {

	private Connection connection;

	public UserDao() {
//		this.connection = MySQLAccess.getConnection();
	}

	public void addUser(User user) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into user (login, password) values (?, ?)");

			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			MySQLAccess.close(connection, null, preparedStatement);
		}
	}

	public User loginUser(User user) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		User userRs = null;
		try {
			preparedStatement = connection.prepareStatement("select * from user where login=? and password=?");
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				userRs = new User();
				userRs.setId(rs.getInt("id"));
				userRs.setLogin(rs.getString("login"));
				userRs.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			MySQLAccess.close(connection, rs, preparedStatement);
		}
		return userRs;

	}
}
