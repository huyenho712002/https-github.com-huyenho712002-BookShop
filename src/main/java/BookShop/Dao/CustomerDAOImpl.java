package BookShop.Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import BookShop.Entity.Customer;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDAOImpl implements CustomerDAO {


	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	@Override
	public Customer findByUserName(String username) {
		TypedQuery<Customer> query = sessionFactory.getCurrentSession()
		        .createQuery("SELECT c FROM Customer c WHERE c.username = :username", Customer.class);
		query.setParameter("username", username);
		List<Customer> resultList = query.getResultList();
		if (!resultList.isEmpty()) {
		    return resultList.get(0); // Trả về kết quả đầu tiên trong danh sách
		} else { } // Xử lý trường hợp không tìm thấy bản ghi
		    return null;
	}

@Override
public List<Customer> findAll() {
    Session session = sessionFactory.getCurrentSession();
    String hql = "FROM Customer";
    List<Customer> list = session.createQuery(hql, Customer.class).getResultList();
    return list;
}

@Override
public Customer create(Customer customer) {
	
	
    Session session = sessionFactory.getCurrentSession();
    session.save(customer);
    
    return customer;
}

@Override
public Customer update(Customer customer) {
    Session session = sessionFactory.getCurrentSession();
    session.update(customer);
    return customer;
}

@Override
public Customer delete(int id) {
    Session session = sessionFactory.getCurrentSession();
    Customer customer = session.find(Customer.class, id);
    session.delete(customer);
    return customer;
}

@Override
public Customer findById(int id) {
    Session session = sessionFactory.getCurrentSession();
    Customer customer = session.find(Customer.class, id);
    return customer;
}



@Override
public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
}

public List<Customer> GetDataCustomer() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int save(Customer customer) {
	// TODO Auto-generated method stub
	return 0;
}


}
