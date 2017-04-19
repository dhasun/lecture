/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Data access object implementation layer of {@link StudentGroup} domain
 */
package com.gadreel.lecture.schedule.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gadreel.lecture.schedule.dao.StudentGroupDao;
import com.gadreel.lecture.schedule.domain.StudentGroup;
import com.gadreel.lecture.schedule.hibernate.support.HibernateSupport;

public class StudentGroupDaoImpl extends HibernateSupport implements StudentGroupDao {
	
	@Override
	public void createStudentGroup(StudentGroup studentGroup) {
		getSession().save(studentGroup);
	}

	@Override
	public StudentGroup getStudentGroupByGroupCode(String studentGroupCode) {
		Criteria criteria = getSession().createCriteria(StudentGroup.class);
		criteria.add(Restrictions.eq("groupCode", studentGroupCode));
		StudentGroup studentGroup = (StudentGroup) criteria.uniqueResult();
		return studentGroup;
	}

}
