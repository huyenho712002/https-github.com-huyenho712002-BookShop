package BookShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import BookShop.Entity.Author;
import BookShop.Entity.MapperAuthor;
@Repository
public class AuthorDao extends BaseDao{
	public List<Author> GetDataAuthor(){
		List<Author> list = new ArrayList<Author>();
		String sql = "SELECT * FROM authors";
		list = _jdbcTemplate.query(sql, new MapperAuthor());
		return list;
	} 
	
	public int save(Author author){    
	    String sql="insert into authors(author_name) values('"+author.getName()+"')";    
	    return _jdbcTemplate.update(sql);    
	}    
	public int update(Author author){    
		 String sql="update authors set author_name='"+author.getName()+"'where author_id='"+author.getId()+"'";    
	    return _jdbcTemplate.update(sql);    
	}    
	public int delete(int id){    
	    String sql="delete from authors where author_id="+id+"";
	
	    return _jdbcTemplate.update(sql);    
	}    
}
