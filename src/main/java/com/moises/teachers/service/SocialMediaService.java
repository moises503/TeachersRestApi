package com.moises.teachers.service;

import java.util.List;

import com.moises.teachers.model.SocialMedia;
import com.moises.teachers.model.TeacherSocialMedia;

public interface SocialMediaService {
	void saveSocialMedia(SocialMedia socialMedia);
	void deleteSocialMediaById(Long socialMediaId);
	void updateSocialMedia(SocialMedia socialMedia);
	List<SocialMedia> findAllSocialMedia();
	SocialMedia findById(Long socialMediaId);
	SocialMedia findByName(String name);
	TeacherSocialMedia findSocialMediaByIdAndName(Long socialMediaId, String nickname);
}
