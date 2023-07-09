package BookShop.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import BookShop.Service.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController extends BaseController{
	
	@Autowired
	private IProductService _productService;
	
	@RequestMapping(value = { "chi-tiet-san-pham/{bookId}" })
	public ModelAndView Index(@PathVariable long bookId) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("products", _productService.GetProductByID(bookId));
		int idCategory = _productService.GetProductByID(bookId).getId();
		_mvShare.addObject("productByIDCategory", _productService.GetProductByIDCategory(idCategory));
		return _mvShare;
	}
	@RequestMapping(value ="search", method=RequestMethod.GET)
	public ModelAndView SearchProductByName(@RequestParam("search-value") String searchItem) {
//		System.out.println(searchItem);
		_mvShare.setViewName("user/index");
		_mvShare.addObject("slides",_homeService.GetDataSlide());
	    _mvShare.addObject("categorys",_homeService.GetDataCategorys());
	    // mới sửa products
	    _mvShare.addObject("products", _homeService.GetDataProductsBySearching(searchItem));
	    _mvShare.addObject("searching", true);
		return _mvShare;
	}
}