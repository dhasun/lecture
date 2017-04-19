/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Data access object layer of {@link Module} domain
 */
package com.gadreel.lecture.schedule.dao;

import com.gadreel.lecture.schedule.domain.Module;

public interface ModuleDao{
	
	/**
	 * Creates a {@link Module}
	 * @param module {@link Module} object to be created
	 */
	public void createModule(Module module);
	
	/**
	 * Gets a particular {@link Module} by module code
	 * @param moduleCode Module code
	 * @return {@link Module} object
	 */
	public Module getModuleByModuleCode(String moduleCode);
}
