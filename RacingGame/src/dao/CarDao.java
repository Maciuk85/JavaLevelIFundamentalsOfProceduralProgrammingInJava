package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.User;

public class CarDao {
	private Connection connection;

	public CarDao() {
//		this.connection = MySQLAccess.getConnection();
	}
	
	public List<Car> getAllUserCars(int userID) {
		List<Car> cars = new ArrayList<Car>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
		preparedStatement = connection.prepareStatement("SELECT car.id, car.name, car.engine, car.tires, car.accelerati"
					+ "on, car.breaks FROM car left join user on car.user_id = user.id where car.user_id = " + userID);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				Car car = new Car();
				car.setId(rs.getInt(1));
				car.setName(rs.getString(2) );
				car.setEngine(rs.getInt(3));
				car.setTires(rs.getInt(4));
				car.setAcceleration(rs.getInt(5));
				car.setBreaks(rs.getInt(6));
				cars.add(car);
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			MySQLAccess.close(connection, rs, preparedStatement);
		}
		return cars;

	}
	
}
