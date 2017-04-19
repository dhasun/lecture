/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Domain class to map with 'module' table in the database
 */
package com.gadreel.lecture.schedule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class Module {
	
	private int moduleId;
	private String moduleCode;
	private String moduleName;
	private int credits;
	private String moduleLeader;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mod_id")
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	
	@Column(name="mod_code")
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	
	@Column(name="mod_name")
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	@Column(name="crdt")
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	@Column(name="mod_leader")
	public String getModuleLeader() {
		return moduleLeader;
	}
	public void setModuleLeader(String moduleLeader) {
		this.moduleLeader = moduleLeader;
	}
	
	
}
