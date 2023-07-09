package BookShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCustomer implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Customer customer = new Customer();
		 customer.setId(rs.getInt("author_id")); // Lấy giá trị từ cột "id" trong ResultSet và gán cho thuộc tính "id" của đối tượng Author
		 customer.setUsername(rs.getString("username")); // Lấy giá trị từ cột "name" 
		 customer.setPassword(rs.getString("password"));
		 customer.setFullname(rs.getString("fullname"));
		 customer.setEmail(rs.getString("email"));
		 customer.setPhone(rs.getString("phone"));
		 customer.setActivated(rs.getBoolean("activated"));
		 customer.setAdmin(rs.getBoolean("admin"));
		 customer.setAddress(rs.getString("address"));
	        return customer; // Trả về đối tượng Author đã được ánh xạ từ ResultSet
	    
	}

}
