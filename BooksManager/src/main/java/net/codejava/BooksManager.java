package net.codejava;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BooksManager {
	static EntityManagerFactory facto;
	static EntityManager facto1;

	private static void begin() {
		facto = Persistence.createEntityManagerFactory("bookDB");
		facto1 = facto.createEntityManager();
		facto1.getTransaction().begin();
	}
    private static void query() {
    	String req="Select b From Book b Where b.price < 1000";
    	Query query=facto1.createQuery(req);
    	
    	@SuppressWarnings("unchecked")
		List <Book> Listbooks = query.getResultList();
    	for(Book aBook:Listbooks) {
    		System.out.println(aBook.getAuthor()+"--"+aBook.getPrice()+"---"+aBook.getTitle());
    	}
    }
	private static void find() {
		Integer primaryKey = 2;
         Book booklook=facto1.find(Book.class, primaryKey);
         System.out.println(booklook.getAuthor());
         System.out.println(booklook.getPrice());
         System.out.println(booklook.getTitle());
	}

	private static void create() {
		Book b1 = new Book();
		b1.setAuthor("MENSER AMMAR");
		b1.setPrice(25);
		b1.setTitle("The Best Friend Ever");
		facto1.persist(b1);
	}

	private static void update() {
		Book existe = new Book();
		existe.setBookId(1);
		existe.setAuthor("Abderrrachid MENSER");
		existe.setPrice(25000);
		existe.setTitle("inchallah");
		facto1.merge(existe);
	}

	private static void remove() {
		Integer primaryKey=3;
		Book bookdelet=facto1.getReference(Book.class, primaryKey);
		facto1.remove(bookdelet);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		begin();
		remove();
		//query();
		//find();
		//update();
		//create();
		end();

	}

	private static void end() {
		facto1.getTransaction().commit();
		facto1.close();
		facto.close();
	}

}
