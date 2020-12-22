package com.shaun.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shaun.lookify.models.Lookify;
import com.shaun.lookify.repository.LookifyRepo;
import com.shaun.lookify.service.LookifyServ;

@Controller
public class MainController {
	
	@Autowired
	private final LookifyRepo lrepo;
	private final LookifyServ lookifyservice;
	
	public MainController(LookifyRepo lrepo, LookifyServ lookifyservice) {
		this.lrepo = lrepo;
		this.lookifyservice = lookifyservice;
	}
		@RequestMapping("/")
		public String index() {
		return "index.jsp";
		}
		
		@RequestMapping("/addnew")
		public String addnew() {
			return "newsong.jsp";
		}
		
		
		
		@RequestMapping ("/dashboard")
        public String dashboard(Model model) {
            List<Lookify> lookify = lookifyservice.all();
            model.addAttribute("lookify", lookify);
            return "dashboard.jsp";
        }
//		@RequestMapping("/songs/new")
//        public String addnewsong(@ModelAttribute("lookify") Lookify lookify) {
//            return "dashboard.jsp";
//        }
		
		@PostMapping("/songs/new")
	    public String create(@Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "newsong.jsp";
	        } else {
	        	lookifyservice.save(lookify);
	            return "redirect:/dashboard";
	        }
		}
		@GetMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
			lookifyservice.delete(id);
	    	return "redirect:/dashboard";
	    }
		

		
		
		@RequestMapping("/show/{id}")
		public String show(@PathVariable("id") Long id, Model model) {
			Lookify lookify = lookifyservice.find(id);
			model.addAttribute("lookify", lookify);
			return "show.jsp";
			
		}
		
	
	
	
	
	
	
}
