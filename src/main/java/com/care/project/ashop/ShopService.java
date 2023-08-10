package com.care.project.ashop;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ShopService {

	public void uploadImage(MultipartFile imageFile, String fileName) {
		if(imageFile.isEmpty()) {
			return;
		}
		if(imageFile.getSize() != 0) {
			String fileLocation = "C:\\javas\\boot_workspace\\project\\src\\main\\webapp\\image\\"+fileName;
			File save = new File(fileLocation);
			try {
				imageFile.transferTo(save);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}