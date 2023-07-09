//package BookShop.UserController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import BookShop.Entity.Customer;
//import BookShop.Entity.Users;
//import BookShop.Service.AccountServiceImpl;
//
//@Controller
//@RequestMapping("/user")
//public class UserController extends BaseController {
//	@Autowired
//	AccountServiceImpl accountService;
//
//	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
//	public ModelAndView showRegistrationForm() {
//		ModelAndView modelAndView = new ModelAndView("user/account/register");
//		modelAndView.addObject("user", new Customer());
//		return modelAndView;
//	}
////
//	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
//	public ModelAndView processRegistrationForm(@ModelAttribute("user") Users user, BindingResult bindingResult) {
//	    ModelAndView modelAndView = new ModelAndView();
//	    
//	    if (bindingResult.hasErrors()) {
//	        modelAndView.setViewName("user/account/register");
//	    } else {
//	        Users existingUser = accountService.CheckAccount(user);
//	        if (existingUser == null) {
//	            int count = accountService.AddAccount(user);
//	            if (count > 0) {
//	                modelAndView.addObject("count", count);
//	                modelAndView.setViewName("user/account/login");
//	            }
//	        } else {
//	            modelAndView.addObject("status", "Email đã tồn tại");
//	            modelAndView.addObject("count", 0);
//	            modelAndView.setViewName("user/account/register");
//	        }
//	    }
//	    return modelAndView;
//	}
//
//
//	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
//	public ModelAndView showLoginForm() {
//		ModelAndView modelAndView = new ModelAndView("user/account/login");
//		modelAndView.addObject("user", new Users());
//		return modelAndView;
//	}
//
//	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
//	public ModelAndView processLoginForm(HttpSession session, @ModelAttribute("user") Users user) {
//		ModelAndView modelAndView = new ModelAndView();
//		user = accountService.CheckAccount(user);
//		if (user != null) {
//			modelAndView.setViewName("redirect:/home");
//			session.setAttribute("LoginInfo", user);
//		} else {
//			modelAndView.addObject("statusLogin", "Đăng nhập thất bại");
//			modelAndView.setViewName("user/account/login");
//		}
//		return modelAndView;
//	}
//
//	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
//	public String logout(HttpSession session, HttpServletRequest request) {
//		session.removeAttribute("LoginInfo");
//		return "redirect:" + request.getHeader("Referer");
//	}
//}
