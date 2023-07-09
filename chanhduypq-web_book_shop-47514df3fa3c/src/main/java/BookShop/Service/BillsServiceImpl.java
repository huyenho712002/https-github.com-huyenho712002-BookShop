package BookShop.Service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookShop.Dao.BillsDao;
import BookShop.Dao.CartDao;
import BookShop.Dto.CartDto;
import BookShop.Entity.BillDetail;
import BookShop.Entity.Bills;

@Service
public class BillsServiceImpl implements IBillsService {
@Autowired
private BillsDao billsDao;

@Override
public int AddBills(Bills bill) {
	return billsDao.AddBills(bill);
}


@Override
public void AddBillsDetail(HashMap<Long, CartDto> carts) {
	long billsId = billsDao.GetIDLastBills();
	
	for(Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
		BillDetail billDetail = new BillDetail();
		billDetail.setBillsId(billsId);
		billDetail.setBookId(itemCart.getValue().getProduct().getBookId());
		billDetail.setQuanty(itemCart.getValue().getQuanty());
		billDetail.setTotal(itemCart.getValue().getTotalPrice());
		billsDao.AddBillsDetail(billDetail);
	}
	
}


}
