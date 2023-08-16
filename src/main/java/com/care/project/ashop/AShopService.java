package com.care.project.ashop;

import java.io.File;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.project.aboard.ABoardMapper;

@Service
public class AShopService {
	@Autowired private AShopMapper shopMapper;
	public void uploadImage(String selectedValues, MultipartFile imageFile, String fileName) {
		DecimalFormat forematter = new DecimalFormat("###,###");
		String[] checkData = selectedValues.split(",");
		String name = checkData[0];
		String category = checkData[1];
		String company = checkData[2];
		int pay = Integer.parseInt(checkData[3]);
		int inventory = Integer.parseInt(checkData[4]);
		String info = checkData[5];
		if(fileName == null) {
			fileName = "";
		}else {
			if(imageFile.getSize() != 0) {
				String fileLocation = "C:\\javas\\boot_workspace\\project\\src\\main\\webapp\\image\\"+fileName;
				File save = new File(fileLocation);
				try {
					imageFile.transferTo(save);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fileName = "/image/"+fileName;
			
		}
		
	}
}