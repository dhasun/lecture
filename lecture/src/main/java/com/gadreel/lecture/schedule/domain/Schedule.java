/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Domain class to map with 'schedule' table in the database
 */
package com.gadreel.lecture.schedule.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
	
	private int scheduleId;
	private StudentGroup studentGroup;
	private Module module;
	private Date scheduleStartDateTime;
	private Date scheduleEndDateTime;
	private String remark;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="schedule_id")
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stu_grp")
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="module")
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	@Column(name="schedule_start_date_time")
	public Date getScheduleStartDateTime() {
		return scheduleStartDateTime;
	}
	public void setScheduleStartDateTime(Date scheduleStartDateTime) {
		this.scheduleStartDateTime = scheduleStartDateTime;
	}
	
	@Column(name="schedule_end_date_time")
	public Date getScheduleEndDateTime() {
		return scheduleEndDateTime;
	}
	public void setScheduleEndDateTime(Date scheduleEndDateTime) {
		this.scheduleEndDateTime = scheduleEndDateTime;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
