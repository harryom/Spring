package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dao.CategoryDAO;
import com.store.entity.Category;
import com.store.entity.Product;

@Service
public class CategoryManagerImpl implements CategoryManager {

	@Autowired
	CategoryDAO dao;
	
	public List<Category> getAllCategories() {
		return dao.getAllCategories();
	}

	public List<Product> getProductByCategory(int id) {
		return dao.getProductByCategory(id);
	}

	@Override
	public Category getCategoryById(int id) {
		return dao.getCategoryById(id);
	}
}
