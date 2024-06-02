package com.mvc.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;

//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.model.FindOneAndUpdateOptions;
//import com.mongodb.client.model.ReturnDocument;
//
//import org.bson.Document;
import com.mvc.model.Book;
import com.mvc.model.User;

public class UserRepository {
	@Autowired
	private SessionFactory sessionfactory;
	private Session session;
	private Transaction transaction;
	
//	@Autowired
//    private MongoTemplate mongoTemplate;
	
	public void saveUser(User user) {
//		using MYSQL Database
		session = sessionfactory.openSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		
//		using MongoDB
		
		//fetching auto incremented id value:
//		MongoCollection<Document> countersCollection =  mongoTemplate.getCollection("counters");
//        Document sequenceDocument = countersCollection.findOneAndUpdate(
//                new Document("_id", "login"),
//                new Document("$inc", new Document("seq", 1)),
//                new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER).upsert(true)
//        );
//        
//        user.setId(sequenceDocument.getInteger("seq"));
//		//user.setId(1);
//		System.out.println("inside saveuser method in user repository"+user.getUsername()+" "+user.getEmail()+" "+user.getAddress()+" "+user.getPassword()+" "+user.getPhone());
//		mongoTemplate.save(user);
		
	}
	
	public List<User> getUser(){
		session = sessionfactory.openSession();
		Query<User> q = session.createQuery("from User u");
		List<User> li = q.list();
		return li;
	}

	public int validateUser(User user) {
		// TODO Auto-generated method stub
//		System.out.println(email);
//		System.out.println(password);
		int userid = 0;
		String email = user.getEmail();
		String password = user.getPassword();
		session = sessionfactory.openSession();
		String hql = "Select user.id from User user where user.email=:email and user.password=:password";
		System.out.println(hql);
		Query query = session.createQuery(hql);
       
        query.setParameter("email", email);
        query.setParameter("password", password);
        System.out.println(query);
        
//        List result = query.list();
//        System.out.println(result);
//        Iterator it = result.iterator();
//       
//        while( it.hasNext() ) {
//        	System.out.println("userid fetching!");
//        	 System.out.println(it.next());
//        	 userid = (int)it.next();
//        	 System.out.println("Login Successful!");
//        	return userid;
//        }
//        
//        System.out.println("Login failed!");
//		return userid;
        
        userid = (int) query.uniqueResult();
        System.out.println("userid fetched!");
        return userid;
        
	}

	public User getProfile(int user_id) {
		// TODO Auto-generated method stub
		session = sessionfactory.openSession();
		String hql = "FROM User u WHERE u.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", user_id);
		User user = (User) query.uniqueResult();
		System.out.println("inside book repository and profile is : "+user.getUsername());
        return user;
	}
	
}
