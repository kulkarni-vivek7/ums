package org.jsp.app;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jsp.emf.EntityManagerImpl;
import org.jsp.entity.User;

public class LoginApp {

	public void login(Scanner sc) {
		EntityManager em = new EntityManagerImpl().createEntityManagerObject();
		
		System.out.println("Enter The Username");
		String username = sc.next();
		
		System.out.println("\nEnter the Password");
		String password = sc.next();
		
//		Way 1 -> Number Placeholder
//		Query q = em.createQuery("select u from User u where u.username =?1 and u.password = ?2");
//		
//		q.setParameter(1, username);
//		q.setParameter(2, password);
		
//		Way 1 -> Named Placeholder
		Query q = em.createQuery("select u from User u where u.username =:un and u.password =:pwd");
		
		q.setParameter("un", username);
		q.setParameter("pwd", password);
		
		List<User> user = q.getResultList();
		
		if(!user.isEmpty())
		{
			System.out.println("\nUser Logged In Successfully...\n");
		}
		else {
			System.out.println("\nInvalid Credentials....!!\n");
		}
	}

}
