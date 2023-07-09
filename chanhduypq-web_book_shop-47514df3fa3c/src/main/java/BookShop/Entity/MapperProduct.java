//package BookShop.Entity;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//public class MapperProduct implements RowMapper<Product> {
//
//	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Author author = new Author();
//		author.setId(rs.getInt("Author_Id"));
//		author.setName(rs.getString("Author_Name"));
//		
//		
//		Categorys category = new Categorys();
//		category.setId(rs.getInt("Category_Id"));
//		category.setName(rs.getString("Category_Name"));
//		
//		Product product = new Product();
//		product.setId(rs.getInt("id"));
//		product.setName(rs.getString("name"));
//		product.setPrice(rs.getDouble("price"));
//		product.setAuthor(author);
//		product.setCategory(category);
//		product.setQuantityRemain(rs.getInt("quantity_remain"));
//		product.setDescription(rs.getString("description"));
//		product.setImg(rs.getString("img"));
//		product.setPublisher(rs.getString("publisher"));
//		product.setPublish_year(rs.getDate("publish_year"));	
//		product.setAvg_rating(rs.getFloat("avg_rating"));
//		product.setCreatedAt(rs.getDate("created_at"));
//		product.setUpdatedAt(rs.getDate("updated_at"));
//		product.setIsDeleted(rs.getInt("is_deleted"));
//		product.setNewBooks(rs.getInt("new_books"));
//		product.setHighLight(rs.getInt("high_light"));
//		return product;
//	}
//}
//	