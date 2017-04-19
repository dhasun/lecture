/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Domain class to map with 'stu_grp' table in the database
 */
package com.gadreel.lecture.schedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="stu_grp")
public class StudentGroup {
	
	private int groupId;
	private String groupCode;
	private String groupDesc;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="grp_id")
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	@Column(name="grp_code")
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	@Column(name="grp_desc")
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	
	
}
