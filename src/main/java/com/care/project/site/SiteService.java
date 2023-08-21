package com.care.project.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class SiteService {
	@Autowired private SiteMapper siteMapper;
	public void siteInfo(String category, Model model) {
		String siteInfo = siteMapper.siteInfo(category);
		model.addAttribute("siteInfo", siteInfo);
	}
	public void siteUpdate(String content, String category) {
		siteMapper.siteUpdate(category, content);
	}

}




