package com.mvc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import com.mvc.model.Book;

public class BookRepository {
	@Autowired
	private SessionFactory sessionfactory;
	private Session session;
	private Transaction transaction;
	
	public void saveBook(Book book) {
//	public void saveBook() {
		session = sessionfactory.openSession();
		transaction = session.beginTransaction();
//		Book bk = new Book();
//		bk.setBook_author("abc");
//		bk.setBook_name("cde");
//		bk.setBook_price(123);
//		bk.setBook_publisher("efg");
		session.save(book);
		transaction.commit();
	}

	public List<Book> getBook() {
		session = sessionfactory.openSession();
		Query<Book> q = session.createQuery("from Book b");
		List<Book> li = q.list();
//		System.out.println("inside book repository and li is : "+li);
		return li;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		session = sessionfactory.openSession();
		transaction = session.beginTransaction();
		String hql = "delete from Book where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		int res = query.executeUpdate();
		transaction.commit(); 
	}

	public Book getUpdateBook(int id) {
		// TODO Auto-generated method stub
		session = sessionfactory.openSession();
		String hql = "FROM Book b WHERE b.bid = :bid";
		Query query = session.createQuery(hql);
		query.setParameter("bid", id);
		
		Book book = (Book) query.uniqueResult();
		System.out.println("inside book repository and book is : "+book.getBook_name());
        return book;
	}

	public void update(Book book) {
		// TODO Auto-generated method stub
		session = sessionfactory.openSession();
		transaction = session.beginTransaction();
		Book getbook = session.get(Book.class, book.getBid());
		getbook.setBook_author(book.getBook_author());
		getbook.setBook_name(book.getBook_name());
		getbook.setBook_price(book.getBook_price());
		getbook.setBook_publisher(book.getBook_publisher());
		transaction.commit();
	}
}
