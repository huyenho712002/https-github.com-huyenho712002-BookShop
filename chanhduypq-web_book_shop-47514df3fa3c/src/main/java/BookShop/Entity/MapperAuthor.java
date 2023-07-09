package BookShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperAuthor implements RowMapper<Author> {
	public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		Author author = new Author();
		author.setId(rs.getInt("author_id"));
		author.setName(rs.getString("author_name"));
		return author;
	}
}