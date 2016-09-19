
package com.store.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.store.entity.Category;
import com.store.entity.Product;
import com.store.service.CategoryManager;

@Controller
@SessionAttributes({"categories","selectedCategory","categoryProducts"})
public class FrontStoreController{
	
	@Autowired
	CategoryManager manager;
 
	@RequestMapping("/")
	protected ModelAndView initPage() {
 
		ModelAndView modelandview = new ModelAndView("index");
		modelandview.addObject("categories", manager.getAllCategories());
		
		return modelandview;
	}
	
	@RequestMapping("/category/{id}")
	protected ModelAndView categoryDetail(@PathVariable Map<String,String> varmap) {
		
		ModelAndView modelandview = new ModelAndView("category");
		Category selectedCategory = manager.getCategoryById(Integer.parseInt(varmap.get("id")));
		modelandview.addObject("selectedCategory", selectedCategory);
		modelandview.addObject("categoryProducts", selectedCategory.getProductCollection());
		return modelandview;
	}
	
	@RequestMapping(value="/addToCart",method = RequestMethod.POST)
	protected ModelAndView addToCart(@RequestParam("productId") String productId) {
		
		ModelAndView modelandview = new ModelAndView("category");
		modelandview.addObject("msg","addedToCart");
		return modelandview;
	}
	
	private List<Category> getCategoryList(){
		List<Category> list = new ArrayList<>();
		for(int i=0;i<4;i++){
			list.add(generateCategoryData(i));
		}
		return list;
	}
	
	private Category generateCategoryData(int i){
		Category cat1 = new Category();
		cat1.setName("Category"+i);
		cat1.setId((byte) i);
		List<Product> test = new ArrayList<>();
		test.add(generateProductData(i+1));
		cat1.setProductCollection(test);
		return cat1;
	}
	
	private Product generateProductData(int i){
		Product cat1 = new Product();
		cat1.setName("Product"+i);
		cat1.setId(i);
		cat1.setPrice(new BigDecimal("2361"));
		return cat1;
	}
}