package com.moises.teachers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@GetMapping(value = "/socialMedias/{id}", headers = "Accept=application/json")
	public ResponseEntity<SocialMedia> getSocialMediaById(@PathVariable("id") Long socialMediaId){
		SocialMedia socialMedia = null;
		return new ResponseEntity<SocialMedia>(socialMedia, HttpStatus.OK);
	}
	
	@PostMapping(value = "/socialMedias", headers = "Accept=application/json")
	public ResponseEntity<?> createSocialMedia(@RequestBody SocialMedia socialMedia, UriComponentsBuilder uriComponentsBuilder){
		if(socialMedia.getName().equals(null) || socialMedia.getName().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		if (socialMediaService.findByName(socialMedia.getName()) != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		socialMediaService.saveSocialMedia(socialMedia);
		SocialMedia stored = socialMediaService.findByName(socialMedia.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				uriComponentsBuilder.path("/v1/socialMedias/{id}")
				.buildAndExpand(stored.getIdSocialMedia())
				.toUri()
				);
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}
