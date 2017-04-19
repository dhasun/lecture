/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Business delegate implementation of {@link StudentGroupBd}
 */
package com.gadreel.lecture.schedule.bd.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gadreel.lecture.schedule.bd.StudentGroupBd;
import com.gadreel.lecture.schedule.dao.StudentGroupDao;
import com.gadreel.lecture.schedule.domain.StudentGroup;

public class StudentGroupBdImpl implements StudentGroupBd{
	
	@Autowired
	private StudentGroupDao studentGroupDao;
	
	@Override
	public void createStudentGroup(StudentGroup studentGroup) {
		studentGroupDao.createStudentGroup(studentGroup);
	}

	@Override
	public StudentGroup getStudentGroupByGroupCode(String studentGroupCode) {
		return studentGroupDao.getStudentGroupByGroupCode(studentGroupCode);
	}

}
