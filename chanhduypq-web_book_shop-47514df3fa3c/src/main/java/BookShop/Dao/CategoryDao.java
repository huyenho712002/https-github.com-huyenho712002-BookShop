package BookShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import BookShop.Entity.Categorys;

import BookShop.Entity.MapperCategorys;

@Repository
public class CategoryDao extends BaseDao{
	

	public List<Categorys> GetDataCategory(){
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM categorys";
		list = _jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	} 

	
	public int save(Categorys categorys){    
	    String sql="insert into categorys(name,description) values('"+categorys.getName()+"','"+categorys.getDescription()+"')";    
	    return _jdbcTemplate.update(sql);    
	}    
	public int update(Categorys categorys){    
		 String sql="update categorys set name='"+categorys.getName()+"',description='"+categorys.getDescription()+"'where id='"+categorys.getId()+"'";    
	    return _jdbcTemplate.update(sql);    
	}    
	public int delete(int id){    
	    String sql="delete from categoryss where id="+id+"";    
	    return _jdbcTemplate.update(sql);    
	}    
	@SuppressWarnings("deprecation")
	public Categorys getCatgegoryById(int id){    
	    String sql="select * from categorys where id=?";    
	    return _jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Categorys>(Categorys.class));    
	} 

@Repository
public class CategorysDao extends BaseDao{
	
	public List<Categorys> GetDataCategorys(){
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM categorys";
		list = _jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}    

}
}