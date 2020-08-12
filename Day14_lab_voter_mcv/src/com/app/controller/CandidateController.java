package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.ICandidateService;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private ICandidateService service;
	
	public CandidateController() {
		System.out.println("in Cnadidate Controller Ctor");
	}
	
	@GetMapping("/candidate_list")
	public String forwardToListPage(Model map)
	{
		System.out.println("in forward list method");
		map.addAttribute("cand_list",service.getCandidateList());
		return "/voter/candidate_list";
	}
	
	@GetMapping("/inc_votes")
	public String updateVotes(HttpSession hs)
	{
		System.out.println("in updateVotes "+hs.getAttribute("canId"));
		
		service.incVotes(Integer.parseInt((String)hs.getAttribute("canId")));
		return "redirect:/candidate/status";
	}
	
	@GetMapping("/status")
	public String redirectToStatusForm()
	{
		return "/voter/status";
	}
}
