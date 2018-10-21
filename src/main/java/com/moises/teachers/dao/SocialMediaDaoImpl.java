package com.moises.teachers.dao;

import java.util.List;

import com.moises.teachers.model.SocialMedia;
import com.moises.teachers.model.TeacherSocialMedia;

public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao{

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().persist(socialMedia);
	}

	@Override
	public void deleteSocialMediaById(Long socialMediaId) {
		// TODO Auto-generated method stub
		SocialMedia socialMedia = findById(socialMediaId);
		if (socialMedia != null) {
			getSession().delete(socialMedia);
		}
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().update(socialMedia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SocialMedia> findAllSocialMedia() {
		// TODO Auto-generated method stub
		return (List<SocialMedia>) getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findById(Long socialMediaId) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().get(SocialMedia.class, socialMediaId);
	}

	@Override
	public SocialMedia findByName(String name) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().
				createQuery("from SocialMedia where name = :name")
				.setParameter("name", name)
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(Long socialMediaId, String nickname) {
		// TODO Auto-generated method stub
		List<Object[]> objects = getSession()
				.createQuery("from TeacherSocialMedia tsm join tsm.socialMedia sm "
						+ "where sm.idSocialMedia = :socialMediaId and tsm.nickname = :nickname")
				.setParameter("socialMediaId", socialMediaId)
				.setParameter("nickname", nickname)
				.list();
		if (objects.size() > 0) {
			for(Object[] data : objects) {
				for (Object object : data) {
					if (object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
				}
			}
		}
		
		return null;
	}

}
