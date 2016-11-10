package com.bit2015.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2015.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {
	 
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping( "/form" )
	public String form() {
		return "form";
	}
	
	@RequestMapping("/upload")
	public String upload(
			//이름이 같으면 생략이 가능하다. @RequestParam String email
			@RequestParam(value = "email", required = false, defaultValue="") String email, 
			@RequestParam(value = "file1" ) MultipartFile file1,
			Model model
			){
		System.out.println("email:"+email);
		String url1 = fileUploadService.restore(file1);
		model.addAttribute("url1",url1);
		
		return "result";
	}


}
