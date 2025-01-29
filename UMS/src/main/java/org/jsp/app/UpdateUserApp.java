package org.jsp.app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.jsp.emf.EntityManagerImpl;
import org.jsp.entity.User;

public class UpdateUserApp {
	
	public User takeInput(Scanner sc, Integer id)
	{
		System.out.println("Enter The Name");
		String name = sc.next();
		
		System.out.println("\nEnter The Phone Number");
		Long phono = sc.nextLong();
		
		System.out.println("\nEnter The Username");
		String username = sc.next();
		
		System.out.println("\nEnter The Email");
		String email = sc.next();
		
		System.out.println("\nEnter The Password");
		String password = sc.next();
		
		return new User(id,name, phono, username, email, password);
	}

	public void updateUser(Scanner sc) {
		
		EntityManager em = new EntityManagerImpl().createEntityManagerObject();
		
		Integer id = new SelectUserById().selectUserById(sc);
		
		User u = new UpdateUserApp().takeInput(sc, id);
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(u);
		et.commit();
		
		System.out.println("\nUser Data Updated Successfully....\n");
	}
}
