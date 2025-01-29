package org.jsp.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jsp.emf.EntityManagerImpl;
import org.jsp.entity.User;

public class SelectAllApp {

	public void selectAllUsers() {
		EntityManager em = new EntityManagerImpl().createEntityManagerObject();
		
		Query q = em.createQuery("from User");
		
		List<User> users = q.getResultList();
		
		for (User user : users) {
			System.out.println("\n"+user);
		}
		System.out.println();
	}

}
