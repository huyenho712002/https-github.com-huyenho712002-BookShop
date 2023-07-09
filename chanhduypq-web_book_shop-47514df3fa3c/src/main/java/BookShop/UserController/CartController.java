package BookShop.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import BookShop.Dao.CustomerDAO;
import BookShop.Dto.CartDto;
import BookShop.Entity.Bills;
import BookShop.Entity.Customer;
//import BookShop.Entity.Users;
import BookShop.Service.BillsServiceImpl;
import BookShop.Service.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	
	@Autowired
	private CustomerDAO dao;
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
	
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	private int quanty;
	
	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		
		return _mvShare;
	}
	
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
	    Customer loginInfo = (Customer) session.getAttribute("LoginInfo");
	    boolean isLoggedIn = false;

	    if (loginInfo != null) {
	        // Người dùng đã đăng nhập thành công
	    	System.out.print("111111");
	        isLoggedIn = true;
	    }

	    if (isLoggedIn) {
	        HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>) session.getAttribute("Cart");
	        String username = loginInfo.getUsername();

	        if (cart == null) {
	            cart = new HashMap<Long, CartDto>();
	        }

	        cart = cartService.AddCart(id, cart);
	        session.setAttribute("Cart", cart);
	        session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
	        session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));

	        return "redirect:" + request.getHeader("Referer");
	    } else {
	        // Người dùng chưa đăng nhập, hiển thị thông báo yêu cầu đăng nhập
	        session.setAttribute("LoginMessage", "Yêu cầu đăng nhập để thêm vào giỏ hàng");
	        return "redirect:" + request.getHeader("Referer");
	    }
	}



	@RequestMapping(value = "EditCart/{id}")
	public String EditCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request ,HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request ,HttpSession session) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		
		if(cart == null) {
			_mvShare.setViewName("user/cart/list_cart");
		}else {
		_mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		Customer loginInfo =(Customer)session.getAttribute("LoginInfo");
		if(loginInfo != null) {
			bills.setAddress(loginInfo.getAddress());
			bills.setDisplay_name(loginInfo.getFullname());
			bills.setUser(loginInfo.getUsername());
	}
		
		_mvShare.addObject("bills", bills);
		}
		return _mvShare;
	}	
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") @Validated Bills bill, BindingResult bindingResult, Model model) {
	    if (bindingResult.hasErrors()) {
	        // Có lỗi, hiển thị thông báo lỗi
	        model.addAttribute("errorMessage", "Vui lòng nhập đầy đủ thông tin.");
	        return "user/bills/checkout";
	    } else {
	        // Không có lỗi, tiến hành thanh toán và xử lý đơn hàng
	        HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>) session.getAttribute("Cart");
	        if (carts != null) {
	            if (billsService.AddBills(bill) > 0) {
	                billsService.AddBillsDetail(carts);
	            }
	            session.removeAttribute("Cart");
	            model.addAttribute("message", "Đơn Hàng Thành Công");
	            return "redirect:gio-hang";
	        } else {
	            // Không có giỏ hàng, xử lý lỗi tại đây (ví dụ: quay trở lại trang giỏ hàng)
	            model.addAttribute("errorMessage", "Không có giỏ hàng.");
	            return "user/cart/list_cart";
	        }
	    }
	}

	

	
}