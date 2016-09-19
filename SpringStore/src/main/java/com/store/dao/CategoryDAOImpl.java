package com.store.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.store.entity.Category;
import com.store.entity.Product;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO 
{
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Category> getAllCategories() 
	{
		List<Category> employees = manager.createQuery("Select a From Category a", Category.class).getResultList();
        return employees;
	}
	
	public List<Product> getProductByCategory(int id) 
	{
		Query q = manager.createQuery("Select a From Product a Where a.id = :id");
		q.setParameter("id", id);
		return (List<Product>)q.getResultList();
	}

	@Override
	public Category getCategoryById(int id) {
		return manager.find(Category.class, (byte) id);
	}
	
}