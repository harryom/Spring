package com.store.service;

import java.util.List;

import com.store.entity.Category;
import com.store.entity.Product;

public interface CategoryManager 
{
	public List<Category> getAllCategories();
	public List<Product> getProductByCategory(int id);
	public Category getCategoryById(int parseInt);
}
