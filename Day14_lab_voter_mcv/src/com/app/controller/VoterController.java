package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Voter;
import com.app.service.IVoterService;

@Controller
@RequestMapping("/user")
public class VoterController {

	@Autowired
	private IVoterService service;
	
	public VoterController() {
		System.out.println("in voter controller ctor");
	}
	
	@GetMapping("/login")	//req mapping + method=get
	public String showLoginForm()
	{
		System.out.println("in show login form");
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam(name = "password") String pass, Model map, HttpSession hs, RedirectAttributes flashScope)
	{
		System.out.println("in process Login .."+email+" "+pass);
		try {
			Voter v = service.authenticateVoter(email, pass);
			hs.setAttribute("voter_dtls", v);
			flashScope.addFlashAttribute("msg","Login Successful!!");
			if(v.getRole().equals("admin"))
				return "/admin/voting_analysis";
			if(v.isStatus()) 
			{
				map.addAttribute("status", true);
				return "/voter/status";
			}
		}catch(RuntimeException e)
		{
			map.addAttribute("msg", "Invalid Login!! Please Try again");
			return "/user/login";
		}
		
		//return "redirect: ../user/voter/candidate_list";
		return "redirect:/candidate/candidate_list";
	}
	
//	@GetMapping("/voter/candidate_list")
//	public String m()
//	{
//		System.out.println("in m");
//		return "/voter/candidate_list";
//	}
	
	
	@PostMapping("/status")
	public String updateStatusRedirectPage(@RequestParam String canId , RedirectAttributes flashMap, HttpSession hs)
	{
		System.out.println("in updateStatusRedirectPage "+canId);
		
		Voter v = (Voter) hs.getAttribute("voter_dtls");
		//flashMap.addFlashAttribute("canId", canId);
		hs.setAttribute("canId", canId);
		String statusMsg = service.updateStatus(v.getId());
		if(statusMsg != null)
		{
			System.out.println("in update status..."+statusMsg);
			flashMap.addFlashAttribute("sMsg", statusMsg);
			return "redirect:/candidate/inc_votes";
		}
		flashMap.addFlashAttribute("sMsg", "Status NOT updated!!");
		return "/voter/status";
	}
	
	@GetMapping("/index")
	public String backToIndex(HttpSession hs)
	{
		hs.invalidate();
		return "/index";
	}
	
}
