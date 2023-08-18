package com.care.project.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {
	
	@RequestMapping("site")
	public String site() {
		return "site/site";
	}
	
	@RequestMapping("site02")
	public String site02() {
		return "site/site02";
	}
	
	@RequestMapping("site03")
	public String site03() {
		return "site/site03";
	}
	
	@RequestMapping("site_update")
	public String site_update() {
		return "site/site_update";
	}
	
	@RequestMapping("siteUpdate02")
	public String siteUpdate02() {
		return "site/siteUpdate02";
	}
	
	@RequestMapping("siteUpdate03")
	public String siteUpdate03() {
		return "site/siteUpdate03";
	}
}
