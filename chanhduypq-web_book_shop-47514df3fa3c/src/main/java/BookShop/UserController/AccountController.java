package BookShop.UserController;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import BookShop.Dao.CustomerDAO;
import BookShop.Entity.Customer;
import BookShop.Service.CookieService;
import BookShop.Service.MailService;
import BookShop.bean.MailInfo;
import BookShop.config.Mailer;

@Controller
public class AccountController {
	@Autowired
	private CustomerDAO dao;
    @Autowired
    private HttpSession session;
    
    @Autowired
    private CookieService cookie;
    
    @Autowired
    private MailService mailer;
    
    @Autowired
    private HttpServletRequest request;
    @Transactional
    @GetMapping("/dang-nhap")
    public String showLoginForm(Model model) {
        Cookie ckid = cookie.read("username");
        Cookie ckpw = cookie.read("password");
        if (ckid != null) {
            String username = ckid.getValue();
            String pwd = ckpw.getValue();

            model.addAttribute("username", username);
            model.addAttribute("password", pwd);
        }
        return "user/account/login";
    }

    @Transactional
    @PostMapping("/dang-nhap")
    public String processLoginForm(Model model, @RequestParam("username") String username,
            @RequestParam("password") String pw, @RequestParam(value = "rm", defaultValue = "false") boolean rm) {
        Customer user = dao.findByUserName(username);
        if (user == null) {
            model.addAttribute("message", "Người dùng không hợp lệ");
        } else if (!pw.equals(user.getPassword())) {
            model.addAttribute("message", "Mật khẩu không hợp lệ");
        } else if (!user.getActivated()) {
            model.addAttribute("message", "Tài khoản chưa được kích hoạt");
        } else {
            model.addAttribute("message", "Đăng nhập thành công");
            session.setAttribute("user", user);
            
            if (rm) {
                cookie.create("user", user.getUsername(), 30);
                cookie.create("pass", user.getPassword(), 30);
            } else {
                cookie.delete("user");
                cookie.delete("pass");
            }
            
            if (user.getAdmin()) {
                return "redirect:/admin";
            }
            
            // Quay lại trang được bảo vệ
            String backUrl = (String) session.getAttribute("back-url");
            if (backUrl != null) {
                return "redirect:" + backUrl;
            }
            return "redirect:/home";
        }

        return "user/account/login";
    }


    @RequestMapping("/dang-xuat")
    public String logout(Model model) {
        session.removeAttribute("user");
        return "redirect:/home";
    }
    @Transactional
    @GetMapping("/dang-ky")
    public String register(Model model) {
        Customer user = new Customer();
        model.addAttribute("form", user);
        return "user/account/register";
    }
    @Transactional
    @PostMapping("/dang-ky")
    public String register(Model model, @Validated @ModelAttribute("form") Customer user, BindingResult errors)
            throws MappingException, MessagingException {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau");
            return "user/account/register";
        } else {
        	
        	Customer  user1 = dao.findByUserName(user.getUsername());
           
            if (user1 == null) {
                model.addAttribute("message", "Người dùng chưa đăng ký");
                return "user/account/register";
            }
        }

        user.setActivated(true);
        user.setAdmin(false);
        dao.create(user);
        model.addAttribute("message", "Đăng ký thành công");

//        // Gửi email kích hoạt tài khoản
//        String from = "your_email@gamil.com";
//        String to = user.getEmail();
//        String subject = "Chào bạn " + user.getUsername();
//        String url = request.getRequestURL().toString().replace("register", "kich-hoat/" + user.getId());
//        String body = "Nhấn vào đường link sau để kích hoạt tài khoản: <a href='" + url + "'>Kích Hoạt</a>";
//
//        // Gửi email
//        try {
//            // Sử dụng thư viện hoặc đối tượng mailer để gửi email
//            // Ví dụ: Mailer.send(from, to, subject, body);
//            // Mailer là đối tượng quản lý việc gửi email
//            Mailer.send(from, to, subject, body);
//        } catch (Exception e) {
//            // Xử lý lỗi gửi email (nếu cần)
//            model.addAttribute("message", "Đăng ký thành công, nhưng gửi email kích hoạt thất bại");
//        }

        return "user/account/register";
    }

//    @GetMapping("/kich-hoat/{id}")
//    public String activate(Model model, @PathVariable("id") int id) {
//        Customer user = dao.findById(id);
//        if (user != null) {
//            user.setActivated(true);
//            dao.update(user);
//            return "redirect:/login";
//        } else {
//            model.addAttribute("message", "Không tìm thấy tài khoản để kích hoạt");
//            return "user/account/register";
//        }
//    }

    @GetMapping("/forgot")
    public String forgot(Model model) {
        return "user/account/forgot";
    }

    @PostMapping("/forgot")
    public String forgot(Model model, @RequestParam("username") String username, @RequestParam("email") String email)
            throws MappingException, MessagingException {
        Customer user = dao.findByUserName(username);
        if (user == null) {
            model.addAttribute("message", "Người dùng không hợp lệ");
        } else if (!email.equals(user.getEmail())) {
            model.addAttribute("message", "Email không hợp lệ");
        } else {
            //gmail cập nhật
            String from = "your_email@gmail.com";
            String to = user.getEmail();
            String subject = "Chào bạn " + user.getUsername();
            String body = "Mật khẩu của bạn là: " + user.getPassword();
            MailInfo mail = new MailInfo(from, to, subject, body);
            mailer.send(mail);
            model.addAttribute("message", "Email đã được gửi");
        }
        return "redirect:/dang-nhap";
    }

    @GetMapping("/change")
    public String change(Model model) {
        return "user/account/change";
    }

    @PostMapping("/change")
    public String change(Model model, @RequestParam("username") String username, @RequestParam("pw") String pw,
            @RequestParam("pw1") String pw1, @RequestParam("pw2") String pw2) {
        if (!pw1.equals(pw2)) {
            model.addAttribute("message", "Mật khẩu không trùng nhau");
        } else {
            Customer user = dao.findByUserName(username);
            if (user == null) {
                model.addAttribute("message", "Người dùng không hợp lệ");
            } else {
                user.setPassword(pw1);
                dao.update(user);
                model.addAttribute("message", "Đổi mật khẩu thành công");
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        Customer user = (Customer) session.getAttribute("user");
        model.addAttribute("form", user);
        return "user/account/edit";
    }

    @PostMapping("/edit")
    public String edit(Model model, @ModelAttribute("form") Customer user) {
        dao.update(user);
        session.setAttribute("user", user);
        model.addAttribute("message", "Cập nhật thành công");
        return "user/account/edit";
    }
}
