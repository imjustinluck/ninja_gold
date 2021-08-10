package com.jda.ninja_gold.controller;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);	
		}
		if(session.getAttribute("activities") == null) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activities", activities);
		}
		return "index.jsp";
	}

	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farm(HttpSession session) {
		Random rand = new Random();
		int num = rand.nextInt(21-10) + 10;
		session.setAttribute("gold", (int) session.getAttribute("gold") + num);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("You entered a farm and got " + num + " gold!");
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave(HttpSession session) {
		Random rand = new Random();
		int num = rand.nextInt(11-5) + 5;
		session.setAttribute("gold", (int) session.getAttribute("gold") + num);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("You entered a cave and got " + num + " gold!");
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	
	@RequestMapping(value="/house", method=RequestMethod.POST)
	public String house(HttpSession session) {
		Random rand = new Random();
		int num = rand.nextInt(6-2) + 2;
		session.setAttribute("gold", (int) session.getAttribute("gold") + num);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("You entered a house and got " + num + " gold!");
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	
	@RequestMapping(value="/casino", method=RequestMethod.POST)
	public String casino(HttpSession session) {
		Random rand = new Random();
		int num = rand.nextInt(101)-50;
		session.setAttribute("gold", (int) session.getAttribute("gold") + num);
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		if(num < 0) {
			activities.add("You entered a casino and lost " + num + " gold!");			
		}
		else {
			activities.add("You entered a casino and got " + num + " gold!");
		}
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
}
