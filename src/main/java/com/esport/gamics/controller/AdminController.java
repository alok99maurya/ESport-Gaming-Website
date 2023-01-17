package com.esport.gamics.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.esport.gamics.entity.Advertisment;
import com.esport.gamics.entity.Blogs;
import com.esport.gamics.entity.Brands;
import com.esport.gamics.entity.Events;
import com.esport.gamics.entity.RegisteredEvents;
import com.esport.gamics.entity.UserModel;
import com.esport.gamics.helper.AdvertismentHelper;
import com.esport.gamics.repository.AdvertismentRepo;
import com.esport.gamics.repository.BlogsRepo;
import com.esport.gamics.repository.BrandRepo;
import com.esport.gamics.repository.EventsRepo;
import com.esport.gamics.repository.UserRepository;
import com.esport.gamics.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserService userv;
	@Autowired
	AdvertismentRepo adsrepo;
	@Autowired
	BlogsRepo brepo;
	@Autowired
	EventsRepo erepo;
	@Autowired
	BrandRepo brandrepo;
	@Autowired
	UserRepository urepo;
	@RequestMapping("/home")
	public String homePage() {
		return "admin-home";
	}

	@RequestMapping("/advertisment")
	public String showupoadAdspage(Model m) {
		List<Advertisment> list=adsrepo.findAll(PageRequest.of(0, 10)).get().toList();
		System.out.println(list);
		m.addAttribute("pageno",0);
		m.addAttribute("total", adsrepo.count()/10);
		m.addAttribute("ads",list);
		return "viewads";
	}

	@RequestMapping("/saveads")
	public String saveimage(@RequestParam("email") String email, 
			@RequestParam("file") CommonsMultipartFile file,
			@RequestParam("url") String url,
			HttpSession session, Model m) throws Exception {
		ServletContext context = session.getServletContext();
		Advertisment adv=new Advertisment();
		if (userv.findByEmail(email) != null) {
			String imgpath = "/images/adss/";
			String path = context.getRealPath(imgpath);
			String filename = file.getOriginalFilename();

			System.out.println(email + " " + path + " " + filename);

			byte[] bytes = file.getBytes();
			String imgsrc = path + File.separator + filename;
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imgsrc)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			adv.setEmail(email);
			adv.setImg(imgpath+filename);
			adv.setUrl(url);
			adv.setStatus(AdvertismentHelper.ACTIVE);
			adsrepo.save(adv);
			m.addAttribute("msg", "Advertisment added succesfully");
		} else {
			m.addAttribute("msg", "Invalid email");
		}
		return "redirect:/admin/advertisment";
	}
	@RequestMapping("/all/{offset}")
	public String findAllAds(@PathVariable int offset,Model m,@RequestParam(defaultValue = "10") String size) {
		if(offset<0) {
			offset*=-1;
			offset-=1;
			m.addAttribute("pageno", (offset));
		}
		else {
			m.addAttribute("pageno", offset);
		}
		m.addAttribute("total", adsrepo.count()/Integer.parseInt(size));
		m.addAttribute("ads", adsrepo.findAll(PageRequest.of(offset,Integer.parseInt(size))).get().toList());
		return "viewads";
	}
	@RequestMapping("/ACTIVE/{id}")
	public String deactivateAds(@PathVariable int id) {
		Advertisment adv=adsrepo.findById(id).get();
		adv.setStatus(AdvertismentHelper.INACTIVE);
		adsrepo.save(adv);
		return "viewimg";	
	}
	@RequestMapping("/INACTIVE/{id}")
	public String activateAds(@PathVariable int id) {
		Advertisment adv=adsrepo.findById(id).get();
		adv.setStatus(AdvertismentHelper.ACTIVE);
		adsrepo.save(adv);
		return "viewimg";	
	}
	@RequestMapping("/delete/{id}")
	public String deleteAds(@PathVariable int id) {
		Advertisment adv=adsrepo.findById(id).get();
		adsrepo.delete(adv);
		return "viewimg";
	}
	@RequestMapping("/blog")
	public String show_blog_page(Model m) {
		m.addAttribute("blogs", brepo.findAll(PageRequest.of(0, 10)).toList());
		m.addAttribute("total",brepo.count()/10);
		m.addAttribute("pageno", 0);
		return "viewblogs";
	}
	@RequestMapping("/addblog")
	public String addBlog(@RequestParam("content") String cntent,
			@RequestParam("img") CommonsMultipartFile img,
			Model m,HttpSession session) throws Exception{
		Blogs b=new Blogs();
		String imgpath = "/images/blogimg/";
		String path = session.getServletContext().getRealPath(imgpath);
		String filename = img.getOriginalFilename();
		byte[] bytes = img.getBytes();
		String imgsrc = path + File.separator + filename;
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imgsrc)));
		stream.write(bytes);
		stream.flush();
		stream.close();
		b.setContent(cntent);
		b.setUrl(imgpath+filename);
		b.setDate(new Date());
		brepo.save(b);
		return "redirect:/admin/blog";
	}
	@RequestMapping("/deleteblog/{id}")
	public String deleteblogs(@PathVariable int id) {
		Blogs adv=brepo.findById(id).get();
		brepo.delete(adv);
		return "redirect:/admin/blog";
	}
	@RequestMapping("/allblogs/{offset}")
	public String allblogs(@PathVariable int offset,@RequestParam(defaultValue = "10") String size,Model m) {
		m.addAttribute("pageno",offset);
		m.addAttribute("total", brepo.count()/Integer.parseInt(size));
		m.addAttribute("blogs", brepo.findAll(PageRequest.of(offset,Integer.parseInt(size))).get().toList());
		return "viewblogs";
	}
	
	
	@RequestMapping("/event")
	public String show_event_page(Model m) {
		m.addAttribute("events", erepo.findAll(PageRequest.of(0, 10)).toList());
		m.addAttribute("total",erepo.count()/10);
		m.addAttribute("pageno", 0);
		return "viewevents";
	}
	@RequestMapping("/addevent")
	public String addevent(@RequestParam("name") String name,@RequestParam("teamsize") int teamsize,
			@RequestParam("totalteams") int totalteams,@RequestParam("date") String date,
			@RequestParam("hrs") int hrs,@RequestParam("minutes") int minutes,
			@RequestParam("img") CommonsMultipartFile img,
			Model m,HttpSession session) throws Exception{
		Events e=new Events();
		String imgpath = "/images/eventimg/";
		String path = session.getServletContext().getRealPath(imgpath);
		String filename = img.getOriginalFilename();
		byte[] bytes = img.getBytes();
		String imgsrc = path + File.separator + filename;
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imgsrc)));
		stream.write(bytes);
		stream.flush();
		stream.close();
		LocalDateTime d=LocalDateTime.of(LocalDate.parse(date), LocalTime.of(hrs, minutes));
		e.setDate(d);
		e.setName(name);
		e.setTeamsize(teamsize);
		e.setTotalteams(totalteams);
		e.setUrl(imgpath+filename);
		erepo.save(e);
		return "redirect:/admin/event";
	}
	@RequestMapping("/viewevent/{id}")
	public String viewEvent(@PathVariable int id,Model m){
		Events e=erepo.findById(id).get();
			List<RegisteredEvents> re=e.getList();
			List<UserModel> users=new ArrayList<UserModel>();
			for(RegisteredEvents r:re){
				String[]tmp=r.getMembers().split(",");
				for(String x:tmp){
					if(x!=null)users.add(urepo.findById(Integer.parseInt(x)).get());
				}
			}
			m.addAttribute("regusers", users);
		return "viewevent";
	}
	@RequestMapping("/deleteevent/{id}")
	public String deleteevent(@PathVariable int id) {
		Events adv=erepo.findById(id).get();
		erepo.delete(adv);
		return "redirect:/admin/event";
	}
	@RequestMapping("/allevent/{offset}")
	public String allevent(@PathVariable int offset,@RequestParam(defaultValue = "10") String size,Model m) {
		m.addAttribute("pageno",offset);
		m.addAttribute("total", erepo.count()/Integer.parseInt(size));
		m.addAttribute("allevents", erepo.findAll(PageRequest.of(offset,Integer.parseInt(size))).get().toList());
		return "viewevents";
	}
	
	
	@RequestMapping("/brand")
	public String show_brand_page(Model m) {
		m.addAttribute("brands", brandrepo.findAll(PageRequest.of(0, 10)).toList());
		m.addAttribute("total",brandrepo.count()/10);
		m.addAttribute("pageno", 0);
		return "viewbrands";
	}
	@RequestMapping("/addbrand")
	public String addbrand(@RequestParam("name") String name,@RequestParam("url") String url,
			@RequestParam("img") CommonsMultipartFile img,
			Model m,HttpSession session) throws Exception{
		Brands brand=new Brands();
		String imgpath = "/images/brandimg/";
		String path = session.getServletContext().getRealPath(imgpath);
		String filename = img.getOriginalFilename();
		byte[] bytes = img.getBytes();
		String imgsrc = path + File.separator + filename;
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(imgsrc)));
		stream.write(bytes);
		stream.flush();
		stream.close();
		brand.setName(name);
		brand.setUrl(url);
		brand.setImg(imgpath+filename);
		brandrepo.save(brand);
		return "redirect:/admin/brand";
	}
	@RequestMapping("/deletebrand/{id}")
	public String deletebrand(@PathVariable int id) {
		Brands adv=brandrepo.findById(id).get();
		brandrepo.delete(adv);
		return "redirect:/admin/event";
	}
	@RequestMapping("/allbrand/{offset}")
	public String allbrand(@PathVariable int offset,@RequestParam(defaultValue = "10") String size,Model m) {
		m.addAttribute("pageno",offset);
		m.addAttribute("total", brandrepo.count()/Integer.parseInt(size));
		m.addAttribute("allbrands", brandrepo.findAll(PageRequest.of(offset,Integer.parseInt(size))).get().toList());
		return "viewbrands";
	}
	
}