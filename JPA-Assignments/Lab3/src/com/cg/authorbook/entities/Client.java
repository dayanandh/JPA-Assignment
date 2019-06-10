package com.cg.authorbook.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Author aut = new Author();
		aut.setId(1);
		aut.setName("Prem");
		
		Author aut1 = new Author();
		aut1.setId(2);
		aut1.setName("Kaku");
		
		Author aut3 = new Author();
		aut3.setId(3);
		aut3.setName("Suri");
		
		
		Book bk = new Book();
		bk.setIsbn(100);
		bk.setTitle("MahaBarath");
		bk.setPrice(15000);
		
		bk.addAuthor(aut);
		
		Book bk1 = new Book();
		bk1.setIsbn(200);
		bk1.setTitle("KS");
		bk1.setPrice(15);
		
		bk.addAuthor(aut1);
		
		
		
		
		em.persist(bk);
		em.persist(bk1);
		
		System.out.println("Added orders along with order details to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();


	}

}
