/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Business delegate of {@link StudentGroup} domain
 */
package com.gadreel.lecture.schedule.bd;

import com.gadreel.lecture.schedule.domain.StudentGroup;

public interface StudentGroupBd {
	
	/**
	 * Creates a new {@link StudentGroup}
	 * @param studentGroup {@link StudentGroup} object to be created
	 */
	public void createStudentGroup(StudentGroup studentGroup);
	
	/**
	 * Gets a {@link StudentGroup} by its group code
	 * @param studentGroupCode group code of a particular {@link StudentGroup}
	 * @return {@link StudentGroup} object
	 */
	public StudentGroup getStudentGroupByGroupCode(String studentGroupCode);
}
