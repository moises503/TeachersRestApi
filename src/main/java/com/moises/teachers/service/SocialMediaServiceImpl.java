package com.moises.teachers.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moises.teachers.dao.SocialMediaDao;
import com.moises.teachers.model.SocialMedia;
import com.moises.teachers.model.TeacherSocialMedia;

@Service("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements SocialMediaService{

	@Autowired
	private SocialMediaDao socialMediaDao;
	
	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		socialMediaDao.saveSocialMedia(socialMedia);
	}

	@Override
	public void deleteSocialMediaById(Long socialMediaId) {
		// TODO Auto-generated method stub
		socialMediaDao.deleteSocialMediaById(socialMediaId);
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		socialMediaDao.updateSocialMedia(socialMedia);
	}

	@Override
	public List<SocialMedia> findAllSocialMedia() {
		// TODO Auto-generated method stub
		return socialMediaDao.findAllSocialMedia();
	}

	@Override
	public SocialMedia findById(Long socialMediaId) {
		// TODO Auto-generated method stub
		return socialMediaDao.findById(socialMediaId);
	}

	@Override
	public SocialMedia findByName(String name) {
		// TODO Auto-generated method stub
		return socialMediaDao.findByName(name);
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Long socialMediaId, String nickname) {
		// TODO Auto-generated method stub
		return socialMediaDao.findSocialMediaByIdAndName(socialMediaId, nickname);
	}

}
