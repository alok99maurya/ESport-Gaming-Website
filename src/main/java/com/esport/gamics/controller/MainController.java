package com.esport.gamics.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.esport.gamics.entity.RegisteredEvents;
import com.esport.gamics.entity.UserModel;
import com.esport.gamics.repository.BlogsRepo;
import com.esport.gamics.repository.BrandRepo;
import com.esport.gamics.repository.EventsRepo;
import com.esport.gamics.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	@Autowired
	UserService userv;
	@Autowired
	EventsRepo erepo;
		@Autowired
		BlogsRepo brepo;
		@Autowired
		BrandRepo brepo2;
	@RequestMapping("/")
	public String mainPage(Model m) {
		m.addAttribute("user", new UserModel());
		return "index";
	}
	@RequestMapping("/join")
	public String joinPage(Model m) {
		m.addAttribute("user", new UserModel());
		return "login";
	}
	@RequestMapping("/register")
	public String register(@RequestParam("name") String name,
			@RequestParam("email") String email,@RequestParam("password") String password,
			@RequestParam("number") String number,@RequestParam("usertype") String usertype,Model m) {
		UserModel user=new UserModel();
		user.setEmail(email);
		user.setName(name);
		user.setNumber(number);
		user.setRole("ROLE_"+usertype);
		user.setPassword(password);
		user.setUsertype(usertype);
		m.addAttribute("user", new UserModel());
		if(userv.addUser(user)==null) m.addAttribute("msg", "email already exists");
		else m.addAttribute("msg", "user register succesfull");
		return "login";
	}
	@RequestMapping("/home")
	public String homePage(Principal p,Model m) {
		UserModel user=userv.findByEmail(p.getName());
		if(user.getRole().equals("ROLE_ADMIN"))
			return "redirect:/admin/home";
		else if(user.getRole().equals("ROLE_CREATER"))
			return "redirect:/creater/home";
		else if(user.getRole().equals("ROLE_SPONSOR"))
			return "redirect:/sponsor/home";
		return "redirect:/user/home";
	}
	@RequestMapping("/tournament")
	public String getTournament(Model m,Principal p,HttpSession session){
		if(p==null){
			return "redirect:/join";
		}
		UserModel user=userv.findByEmail(p.getName());
		m.addAttribute("page", 0);
		m.addAttribute("user", user);
		m.addAttribute("events", erepo.findAll(PageRequest.of(0,10)).get().toList());
		m.addAttribute("total", erepo.count()/10);
		m.addAttribute("crdate",LocalDateTime.now());
		m.addAttribute("brands", brepo2.findAll());
		if(user.getTeam()!=null) {
			HashMap<Integer,Boolean> map=new HashMap<>();
			List<RegisteredEvents> list=user.getTeam().getEvents();
			for(RegisteredEvents re:list){
				map.put(re.getEvent().getId(),true);
			}
			System.out.println(map);
			session.setAttribute("regevent",map);
		}
		return "events";
	}
	@RequestMapping("/event/{offset}")
	public String event(@PathVariable int offset,@RequestParam(defaultValue="10") int size,Model m,Principal p){
		UserModel user=userv.findByEmail(p.getName());
		m.addAttribute("page", offset);
		m.addAttribute("user", user);
		m.addAttribute("events", erepo.findAll(PageRequest.of(0,10)).get().toList());
		m.addAttribute("total", erepo.count()/10);
		m.addAttribute("brands", brepo2.findAll());
		m.addAttribute("crdate",LocalDateTime.now());
		return "events";
	}
	@RequestMapping("/news")
	public String blogs(Model m,Principal p){
		if(p==null){
			return "redirect:/join";
		}
		UserModel user=userv.findByEmail(p.getName());
		m.addAttribute("m", 0);
		m.addAttribute("user", user);
		m.addAttribute("events", brepo.findAll(PageRequest.of(0,10)).get().toList());
		m.addAttribute("total", brepo.count()/10);
		m.addAttribute("brands", brepo2.findAll());
		return "blogs";
	}
	@RequestMapping("/news/{offset}")
	public String prevNext(@PathVariable int offset,Model m,Principal p){
		if(p==null){
			return "redirect:/join";
		}
		UserModel user=userv.findByEmail(p.getName());
		m.addAttribute("m", offset);
		m.addAttribute("user", user);
		m.addAttribute("events", brepo.findAll(PageRequest.of(offset,10)).get().toList());
		m.addAttribute("total", brepo.count()/10);
		m.addAttribute("brands", brepo2.findAll());
		return "blogs";
	}
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String requestMethodName(Model m,Principal p) {
		if(p==null) return "redirect:/join";
		UserModel u=userv.findByEmail(p.getName());
		m.addAttribute("user", u);
		m.addAttribute("brands", brepo2.findAll());
		return "contact";
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about(Model m,Principal p) {
		if(p==null) return "redirect:/join";
		UserModel u=userv.findByEmail(p.getName());
		m.addAttribute("user", u);
		m.addAttribute("brands", brepo2.findAll());
		return "aboput";
	}
	
}
