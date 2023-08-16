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
		int payData = Integer.parseInt(checkData[3]);
		String pay = forematter.format(payData);
		int inventory = Integer.parseInt(checkData[4]);
		String info = checkData[5];
		if(imageFile != null) {
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
		
		if(fileName == null) {
			fileName = "";
		}else {
			fileName = "/image/"+fileName;
		}
		AShopDTO shopDto = new AShopDTO();
		shopDto.setCategory(category);
		shopDto.setName(name);
		shopDto.setCompany(company);
		shopDto.setPay(pay);
		shopDto.setInventory(inventory);
		shopDto.setImageFile(fileName);
		shopDto.setInfo(info);
		AShopDTO check = shopMapper.checkShop(shopDto);
		if(check == null) {
			shopMapper.insertShop(shopDto);		
		}
	}
}