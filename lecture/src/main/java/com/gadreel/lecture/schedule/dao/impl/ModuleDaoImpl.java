/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Data access object implementation layer of {@link Module} domain
 */
package com.gadreel.lecture.schedule.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.gadreel.lecture.schedule.dao.ModuleDao;
import com.gadreel.lecture.schedule.domain.Module;
import com.gadreel.lecture.schedule.hibernate.support.HibernateSupport;

public class ModuleDaoImpl extends HibernateSupport implements ModuleDao{

	@Override
	public void createModule(Module module) {
		getSession().save(module);
	}

	@Override
	public Module getModuleByModuleCode(String moduleCode) {
		Criteria criteria = getSession().createCriteria(Module.class);
		criteria.add(Restrictions.eq("moduleCode", moduleCode));
		Module module = (Module) criteria.uniqueResult();
		return module;
	}

}
