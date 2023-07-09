package BookShop.Dao;

import org.springframework.stereotype.Repository;

import BookShop.Entity.BillDetail;
import BookShop.Entity.Bills;
//import BookShop.Entity.MapperUsers;
//import BookShop.Entity.Users;

@Repository
public class BillsDao extends BaseDao {
	public int AddBills(Bills bill) {
	    String sql = "INSERT INTO bills (user, phone, display_name, address, total, note, quanty) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    
	    int insert = _jdbcTemplate.update(
	        sql,
	        bill.getUser(),
	        bill.getPhone(),
	        bill.getDisplay_name(),
	        bill.getAddress(),
	        bill.getTotal(),
	        bill.getNote(),
	        bill.getQuanty()
	    );
	    
	    return insert;
	}


    public long GetIDLastBills() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT MAX(bills_id) FROM bills;");

        String sqlString = sql.toString(); // Convert StringBuffer to String
        
        Long id = _jdbcTemplate.queryForObject(sqlString, Long.class);
        return id;
    }

    public int AddBillsDetail(BillDetail billDetail) {
        String sql = "INSERT INTO billdetail (book_id, bills_id, quanty, total) VALUES (?, ?, ?, ?)";
        
        int insert = _jdbcTemplate.update(
            sql,
            billDetail.getBookId(),
            billDetail.getBillsId(),
            billDetail.getQuanty(),
            billDetail.getTotal()
        );
        
        return insert;
    }

}
