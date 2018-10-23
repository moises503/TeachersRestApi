package com.moises.teachers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moises.teachers.model.SocialMedia;
import com.moises.teachers.service.SocialMediaService;

@Controller
@RequestMapping("/v1")
public class SocialMediaController {

	@Autowired
	private SocialMediaService socialMediaService;
	
	@GetMapping(value = "/socialMedias", headers = "Accept=application/json")
	public ResponseEntity<List<SocialMedia>> getSocialMedias(){
		List<SocialMedia> socialMedias = new ArrayList<>();
		socialMedias = socialMediaService.findAllSocialMedia();
		if (socialMedias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<List<SocialMedia>>(socialMedias, HttpStatus.OK);
	}
}
