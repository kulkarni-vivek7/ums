package org.jsp.app;

import java.util.Scanner;

import javax.persistence.EntityManager;

import org.jsp.emf.EntityManagerImpl;
import org.jsp.entity.User;

public class SelectUserById {

	public Integer selectUserById(Scanner sc)
	{
		EntityManager em = new EntityManagerImpl().createEntityManagerObject();
		
		System.out.println("Enter User Id");
		Integer id = sc.nextInt();
		
		User user = em.find(User.class, id);
		
		System.out.println(user + "\n");
		
		return id;
	}
}
