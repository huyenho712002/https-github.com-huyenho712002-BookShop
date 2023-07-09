package BookShop.AdminController;

import java.util.List;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BookShop.Entity.Categorys;
import BookShop.Service.CategoryServiceImpl;
import BookShop.UserController.BaseController;

@SuppressWarnings("unused")
@Controller
public class AdminCategoryController extends BaseController {
    @Autowired
    CategoryServiceImpl _categoryService;

    // Hiển thị danh sách danh mục và form thêm danh mục
    @RequestMapping(value = { "admin/category" })
    public ModelAndView ViewCategory() {
        List<Categorys> listCategory = _categoryService.GetDataCategory();
        Categorys category = new Categorys();
        _mvShare.addObject("category", category);
        _mvShare.addObject("listCategory", listCategory);
        _mvShare.setViewName("admin/category");
        return _mvShare;
    }

    // Xóa danh mục dựa trên id
    @RequestMapping(value = "admin/categorys/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        this._categoryService.delete(id);
        return "redirect:/admin/category";
    }

    // Thêm danh mục
    @RequestMapping(value = "/admin/category/add", method = RequestMethod.POST)
    public String save(@ModelAttribute("category") Categorys category) {
        _categoryService.save(category);
        return "redirect:/admin/category";
    }

    // Cập nhật thông tin danh mục
    @RequestMapping(value = "admin/category/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("category") Categorys categorys) {
        _categoryService.update(categorys);
        return "redirect:/admin/category";
    }
}
