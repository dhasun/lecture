/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Business delegate implementation of {@link ModuleBd}
 */
package com.gadreel.lecture.schedule.bd.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gadreel.lecture.schedule.bd.ModuleBd;
import com.gadreel.lecture.schedule.dao.ModuleDao;
import com.gadreel.lecture.schedule.domain.Module;

public class ModuleBdImpl implements ModuleBd{
	
	@Autowired
	private ModuleDao moduleDao;

	@Override
	public void createModule(Module module) {
		moduleDao.createModule(module);
	}

	@Override
	public Module getModuleByModuleCode(String moduleCode) {
		return moduleDao.getModuleByModuleCode(moduleCode);
	}
	
}
