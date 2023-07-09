//package BookShop.AdminController;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import BookShop.Entity.Author;
//import BookShop.Entity.Customer;
//import BookShop.Service.AuthorServiceImpl;
//import BookShop.Service.CustomerServiceImpl;
//import BookShop.UserController.BaseController;
//
//@Controller
//public class AdminCustomerController extends BaseController {
//    @Autowired
//    CustomerServiceImpl _customerService;
//
//    // Hiển thị danh sách người dùng
//    @RequestMapping(value = { "admin/customer" })
//    public ModelAndView ViewCustomer() {
//        List<Customer> listCustomer = _customerService.GetDataCustomer();
//        Customer customer = new Customer();
//        _mvShare.addObject("customer", customer);
//        _mvShare.addObject("listCustomer", listCustomer);
//        _mvShare.setViewName("admin/customer");
//        return _mvShare;
//    }
//    // Xóa tác giả dựa trên id
//    @RequestMapping(value = "admin/customer/delete/{id}", method = RequestMethod.GET)
//    public String delete(@PathVariable int id) {
//        this._customerService.delete(id);
//        return "redirect:/admin/customer";
//    }
//
//}
