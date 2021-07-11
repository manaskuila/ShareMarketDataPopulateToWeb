package com.manas.org.ShareMarketData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manas.org.ShareMarketData.service.ShareDataFetch;

@Controller
public class ShareController {
	
	@Autowired
	private ShareDataFetch shareDataFetch;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("shares",shareDataFetch.getAllShares());
		return "home";
	}

}
