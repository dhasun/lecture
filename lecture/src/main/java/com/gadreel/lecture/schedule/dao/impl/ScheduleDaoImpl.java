/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Data access object implementation layer of {@link Schedule} domain
 */
package com.gadreel.lecture.schedule.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.gadreel.lecture.schedule.dao.ScheduleDao;
import com.gadreel.lecture.schedule.domain.Schedule;
import com.gadreel.lecture.schedule.hibernate.support.HibernateSupport;

public class ScheduleDaoImpl extends HibernateSupport implements ScheduleDao{

	
	@Override
	public void createSchedule(Schedule schedule) {
		getSession().save(schedule);
	}

	@Override
	public List<Schedule> searchScheduleList(String studentGroupCode,
			String moduleCode, Date startDateTime, Date endDateTime) {
		
		Criteria criteria = getSession().createCriteria(Schedule.class);
		
		criteria.createAlias("module", "module");
		criteria.createAlias("studentGroup", "studentGroup");
		
		if(moduleCode != null && !moduleCode.equals("") )
			criteria.add(Restrictions.eq("module.moduleCode", moduleCode));
		if(studentGroupCode != null && !studentGroupCode.equals(""))
			criteria.add(Restrictions.eq("studentGroup.groupCode",studentGroupCode));
		
		if(startDateTime != null && endDateTime != null){
			criteria.add(Restrictions.ge("scheduleStartDateTime", startDateTime));
			criteria.add(Restrictions.le("scheduleEndDateTime", endDateTime));
		} else if(startDateTime != null && endDateTime == null)
			criteria.add(Restrictions.ge("scheduleStartDateTime", startDateTime));
		  else if(startDateTime == null && endDateTime != null)
			criteria.add(Restrictions.le("scheduleEndDateTime", endDateTime));
		
		List<Schedule> scheduleList = criteria.list();
		return scheduleList;
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.update(schedule);
		tx.commit();
		session.close();
	}

	@Override
	public Schedule getScheduleByScheduleId(int scheduleId) {
		Criteria criteria = getSession().createCriteria(Schedule.class);
		
		criteria.createAlias("module", "module");
		criteria.createAlias("studentGroup", "studentGroup");
		criteria.add(Restrictions.eq("scheduleId", scheduleId));
		Schedule schedule = (Schedule) criteria.uniqueResult();
		return schedule;
	}

	@Override
	public void deleteSchedule(Schedule schedule) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.delete(schedule);
		tx.commit();
		session.close();
	}

}
