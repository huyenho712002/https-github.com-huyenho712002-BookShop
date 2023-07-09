//package BookShop.Entity;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//public class MapperUsers implements RowMapper<Users> {
//	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Users user = new Users();
//	
//		user.setId_account(rs.getLong("id_account"));
//		user.setUser(rs.getString("user"));
//		user.setPhone(rs.getString("phone"));
//		user.setPassword(rs.getString("password"));
//		user.setDisplay_name(rs.getString("display_name"));
//		user.setAddress(rs.getString("address"));
//		return user;
//	}
//}
