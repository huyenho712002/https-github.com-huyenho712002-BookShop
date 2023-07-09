//package BookShop.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//
//import BookShop.Dao.UsersDao;
//import BookShop.Entity.Customer;
//import BookShop.Entity.Users;
//
//@Service
//public class AccountServiceImpl implements IAccountService {
//	@Autowired
//	UsersDao usersDao = new UsersDao();
//
//	public int AddAccount(Users user) {
//		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
//		return usersDao.AddAccount(user);
//	}
//
//	public Users CheckAccount(Users user) {
//		String pass = user.getPassword();
//	
//		user = usersDao.GetUserByAcc(user);
//	
//		if (user != null) {
//			if (BCrypt.checkpw(pass, user.getPassword())) {
//				return user;
//			} else {
//				return null;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public int AddAccount(Customer user) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Users CheckAccount(Customer user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
