//package BookShop.Dao;
//
//import org.springframework.stereotype.Repository;
//import BookShop.Entity.MapperUsers;
//import BookShop.Entity.Users;
//
//@Repository
//public class UsersDao extends BaseDao {
//	public int AddAccount(Users user) {
//		StringBuffer  sql = new StringBuffer();
//		sql.append("INSERT ");
//		sql.append("INTO users ");
//		sql.append("( ");
//		sql.append("user, ");
//		sql.append("phone,");
//		sql.append("password, ");
//		sql.append("display_name, ");
//		sql.append("address ");
//		sql.append(") ");
//		sql.append("VALUES ");
//		sql.append("( ");
//		sql.append(" '"+user.getUser()+"', ");
//		sql.append(" '"+user.getPhone()+"', ");
//		sql.append(" '"+user.getPassword()+"', ");
//		sql.append(" '"+user.getDisplay_name()+"', ");
//		sql.append(" '"+user.getAddress()+"' ");
//		sql.append(")");
//		
//		int insert = _jdbcTemplate.update(sql.toString());
//
//		return insert;
//
//	};
//	public Users GetUserByAcc(Users user) {	
//		String sql = "SELECT * FROM users WHERE user = '"+ user.getUser()+"'";
//		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
//
//	return result;
//
//	}
//	
//
//	
//}
