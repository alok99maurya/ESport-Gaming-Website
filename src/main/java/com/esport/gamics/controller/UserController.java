package com.esport.gamics.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.esport.gamics.entity.Events;
import com.esport.gamics.entity.RegisteredEvents;
import com.esport.gamics.entity.Teams;
import com.esport.gamics.entity.UserModel;
import com.esport.gamics.repository.BrandRepo;
import com.esport.gamics.repository.EventsRepo;
import com.esport.gamics.repository.Registrationrepo;
import com.esport.gamics.repository.TeamRepo;
import com.esport.gamics.repository.UserRepository;
import com.esport.gamics.service.UserService;

import antlr.debug.Event;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	EventsRepo erepo;
	@Autowired
	Registrationrepo regrepo;
	@Autowired
	UserService userv;
	@Autowired
	TeamRepo trepo;
	@Autowired
	UserRepository usrepo;
	@Autowired
	BrandRepo brepo;
	@RequestMapping("/home")
	public String homePage(Model m,Principal p,HttpSession session) {
		UserModel user=userv.findByEmail(p.getName());
		m.addAttribute("events", erepo.findAll());
		m.addAttribute("crdate",LocalDateTime.now());
		m.addAttribute("user", user);
		m.addAttribute("brands", brepo.findAll());
		if(user.getTeam()!=null) {
			HashMap<Integer,Boolean> map=new HashMap<>();
			List<RegisteredEvents> list=user.getTeam().getEvents();
			for(RegisteredEvents re:list){
				map.put(re.getEvent().getId(),true);
			}
			System.out.println(map);
			session.setAttribute("regevent",map);
		}
		return "userhome";
	}
	@RequestMapping("/registerevent/{id}")
	public String register(@PathVariable int id,Model m,Principal p) {
		UserModel user=userv.findByEmail(p.getName());
		Events e=erepo.findById(id).get();
		m.addAttribute("user", user);
		m.addAttribute("brands", brepo.findAll());
		if(user.getTeam()==null||user.getTeam().getList().size()<e.getTeamsize()){
			Teams team=user.getTeam();
			m.addAttribute("team", team);
			if(team !=null) m.addAttribute("member", team.getList());
			m.addAttribute("msg", "add members");
			return "addteam";
		}
		m.addAttribute("event", e);
		m.addAttribute("members", user.getTeam().getList());
		return "register";
	}
	@RequestMapping("/reg/{id}")
	public String reg(@PathVariable("id") String id,@RequestParam("members") List<String> list,Model m,Principal p) {
		Events e=erepo.findById(Integer.parseInt(id)).get();
		UserModel user=userv.findByEmail(p.getName());
		m.addAttribute("brands", brepo.findAll());
		if(list.size()!=e.getTeamsize()){
			m.addAttribute("msg", "please select 4 members");
		m.addAttribute("user", user);
		m.addAttribute("event", e);
		m.addAttribute("members", user.getTeam().getList());
		return "register";
		}else{
			String members="";
			for(String x:list){
				members+=(x+",");
			}
			RegisteredEvents re=new RegisteredEvents();
			re.setEvent(e);
			re.setMembers(members);
			re.setTeam(user.getTeam());
			regrepo.save(re);
		}
		return "redirect:/user/home";
	}
	@RequestMapping("/team")
	public String addTeam(Model m,Principal p) {
		String email=p.getName();
		m.addAttribute("brands", brepo.findAll());
		UserModel user=userv.findByEmail(email);
		Teams team=user.getTeam();
		m.addAttribute("user", user);
		m.addAttribute("team", team);
		if(team !=null) m.addAttribute("member", team.getList());
		return "addteam";
	}
	@RequestMapping("/savemem")
	public String addmem(@RequestParam("email") String email,
			@RequestParam(required = false,value = "teamname") String teamname,
			Principal p,
			Model m,
			HttpSession session
			) throws Exception {
		Teams t;
		m.addAttribute("brands", brepo.findAll());
		UserModel user=userv.findByEmail(email);
			if(user==null){
				throw new Exception("email invalid");
			}
		if(teamname==null) {
			UserModel u2=userv.findByEmail(p.getName());
			t=u2.getTeam();
			if(user.getTeam()==null) {
				user.setTeam(t);
			}else {
				m.addAttribute("msg","this member is already in some team");
			}
			usrepo.save(user);
		}else{
			t=new Teams();
			t.setName(teamname);
			t=trepo.save(t);
			UserModel u2=userv.findByEmail(p.getName());
			u2.setTeam(t);
			usrepo.save(u2);
			if(user.getTeam()==null) {
				user.setTeam(t);
				m.addAttribute("msg","member added successfully");
				usrepo.save(user);
			}else {
				m.addAttribute("msg","this member is already in some team");
			}
		}
		return "userhome";
	}
}
