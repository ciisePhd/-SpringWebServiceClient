package spring.tutorial.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.tutorial.service.IBanAcountService;
import spring.tutorial.service.UserDetails;

@Controller
public class HomeController {
	
	@Autowired
	private IBanAcountService bankAcountService;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{	
		return new ModelAndView("home");
	}
	
	@RequestMapping("/userDetails")
	public String accountDetails(Model model) {
		UserDetails userDetails	= bankAcountService.getUserDetails("test");
		model.addAttribute("userDetails", userDetails);
		return "userDetails";
	}
}
