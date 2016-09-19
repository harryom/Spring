package com.store.dao;

import java.util.List;

import com.store.entity.Category;
import com.store.entity.Product;

public interface CategoryDAO 
{
	public List<Category> getAllCategories();
	public List<Product> getProductByCategory(int id);
	public Category getCategoryById(int id);
}