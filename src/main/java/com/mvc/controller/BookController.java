package com.mvc.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.*;
import com.mvc.repository.*;

@Controller
@SessionAttributes({"userid"})
public class BookController {
	
	@Autowired
	BookRepository br;
	@Autowired
	UserRepository ur;
	
	@RequestMapping("/")
	public String home(Model m) {
		return "index";
	}
	
	@RequestMapping("index")
	public String homePage(Model m) {
		return "index";
	}
	
	@RequestMapping("/register")
	public String showRegister(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping("/user_register")
	public ModelAndView addUser(@ModelAttribute User user) {
		//@RequestParam("username") String username if we want to fetch a String instead of model attribute
		ur.saveUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping("/login")
	public String Login(Model m) {
		m.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping("/user_login")
	public String userLogin(@ModelAttribute User usr,Model m) {
		int userid = ur.validateUser(usr);
		m.addAttribute("userid", userid);
		if(userid != 0) {
			return "home";
		}
		return "login";
	}
	
	@RequestMapping("/addBook")
	public String showAddBook(Model m) {
		m.addAttribute("book", new Book());
		return "add_book";
	}
	
	@RequestMapping("/add")
	public ModelAndView addBook(@ModelAttribute Book book) {
//	public ModelAndView addBook() {
//		Book bk = new Book();
//		bk.setBook_author("abc");
//		bk.setBook_name("cde");
//		bk.setBook_price(123);
//		bk.setBook_publisher("efg");
//		br.saveBook();
		br.saveBook(book);
		ModelAndView mv = new ModelAndView();
		mv.addObject("book", book);
//		mv.addObject("book_name", book_name);
//		mv.addObject("book_price", book_price);
//		mv.addObject("book_author", book_author);
//		mv.addObject("book_publisher", book_publisher);
		mv.setViewName("add_book");
		return mv;
	}
	
	@RequestMapping("/view")
	public String view(Model m) {
//		m.addAttribute("book", new Book());
		List<Book> li = br.getBook();
//		System.out.println("inside book controller and li is : "+li);
		m.addAttribute("li", li);
		return "view";
	}
	
	@RequestMapping("/profile")
	public String profile(Model m,HttpSession session) {
		System.out.println("user id is:");
		System.out.println(session.getAttribute("userid"));
		int user_id = (int) session.getAttribute("userid");
		User user = ur.getProfile(user_id);
		m.addAttribute("user", user);
		return "profile";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		System.out.println("book id is:");
		System.out.println(id);
		br.delete(id);
		return "redirect:/view";
	}
	
	@RequestMapping("/update")
	public String update(Model m, @RequestParam("id") int id) {
		System.out.println("book id is:");
		System.out.println(id);
		Book book = br.getUpdateBook(id);
		m.addAttribute("book", book);
		return "update";
	}
	
	@RequestMapping("/updateBook")
	public String updateBook(@RequestParam("bid") int id,@ModelAttribute Book book) {
		System.out.println("book id is:");
		System.out.println(id);
		br.update(book);
		return "redirect:/view";
	}
	
}
