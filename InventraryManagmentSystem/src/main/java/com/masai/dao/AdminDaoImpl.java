package com.masai.dao;



import java.util.ArrayList;
import java.util.List;

import com.masai.entity.Admin;
import com.masai.entity.IsDeleted;
import com.masai.entity.LoginAdmin;
import com.masai.exceptions.RecordNotFoundException;
import com.masai.exceptions.SomthingWentWrongException;
import com.masai.utility.DBUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class AdminDaoImpl implements AdminDao{

	@Override
	public void addAdmin(Admin admin) throws SomthingWentWrongException {
	  EntityManager em=null;EntityTransaction et=null;
	  try {
		  em=DBUtils.createConnection();
		  Query q=em.createQuery("SELECT count(a) FROM Admin a WHERE userName=:username");
			q.setParameter("username", admin.getUsername());
			if((long)q.getSingleResult()>0) {
				throw new SomthingWentWrongException("Username already Exist in System");
			}
			 et=em.getTransaction();
			et.begin();
			em.persist(admin);
			et.commit();
			System.out.println("Admin Added Successfully");
	} catch (PersistenceException e) {
		e.printStackTrace();
		throw new SomthingWentWrongException("Somthing went wrong please try again");
	}
	  finally {
		em.close();
	  }
	}

	

	@Override
	public List<Admin> getAdminList() throws SomthingWentWrongException, RecordNotFoundException {
		EntityManager em=null;
		List<Admin> list=new ArrayList<>();
		try {
			em=DBUtils.createConnection();
			Query q=em.createQuery("From Admin a");
			list=(List<Admin>)q.getResultList();
			if(list.size()==0) {
				throw new RecordNotFoundException("No record found in admin List");
			}
		} catch (PersistenceException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SomthingWentWrongException("Somthing went wrong please try again later");
		}
		finally {
			em.close();
		}
		return list;
		
	}

	@Override
	public void deleteAdmin(int id) throws SomthingWentWrongException, RecordNotFoundException {
		EntityManager em=null;
		EntityTransaction et=null;
		try {
			em=DBUtils.createConnection();
			et=em.getTransaction();
			et.begin();
			Admin a=em.find(Admin.class, id);
			if(a==null) {
				throw new RecordNotFoundException("Record not found with given id");
			}
			a.setIsDeleted(IsDeleted.YES);
			em.persist(a);
			et.commit();
			System.out.println("Admin deleted Successfully");
			
		} catch (PersistenceException e) {
			// TODO: handle exception
			throw new SomthingWentWrongException("Somhting went wrong ");
			
		}
		finally {
			em.close();
		}
		
	}



   @Override
   public void logInAdmin(String userName, String password) throws SomthingWentWrongException, RecordNotFoundException {
	   EntityManager em = null;
	    try {
	        em = DBUtils.createConnection();
	        Query q = em.createQuery("SELECT a.admin_id FROM Admin a WHERE a.userName = :username AND a.password = :password");
	        q.setParameter("username", userName);
	        q.setParameter("password", password);
	        List<Integer> userlist = q.getResultList();
	        if (userlist.isEmpty()) {
	            throw new SomthingWentWrongException("Something went wrong: Username or password incorrect");
	        }
	        LoginAdmin.loginAdminId = userlist.get(0);
	        System.out.println("Welcome " + userName);
	    } catch (IllegalArgumentException | PersistenceException e) {
	        // Log the exception for debugging purposes
	        e.printStackTrace();
	        throw new SomthingWentWrongException("Something went wrong: Unable to process your request");
	    } finally {
	        if (em != null && em.isOpen()) {
	            em.close();
	        }
	    }
	
 }
   
}
