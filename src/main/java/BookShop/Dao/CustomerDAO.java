package BookShop.Dao;

import java.util.ArrayList;
import java.util.List;

import BookShop.Entity.Author;
import BookShop.Entity.Customer;
import BookShop.Entity.MapperAuthor;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerDAO {
	 public void setSessionFactory(SessionFactory sessionFactory);
    Customer findByUserName(String username);
    List<Customer> findAll();
    Customer create(Customer customer);
    Customer update(Customer customer);
    Customer delete(int id);
    Customer findById(int id);
 // Lấy danh sách tác giả từ cơ sở dữ liệu
    public List<Customer> GetDataCustomer() ;
	public int save(Customer customer);
}

