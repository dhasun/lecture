/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Business delegate implementation of {@link StudentGroupBd}
 */
package com.gadreel.lecture.schedule.bd.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gadreel.lecture.schedule.bd.ScheduleBd;
import com.gadreel.lecture.schedule.dao.ScheduleDao;
import com.gadreel.lecture.schedule.domain.Schedule;

public class ScheduleBdImpl implements ScheduleBd {
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Override
	public void createSchedule(Schedule schedule) {
		scheduleDao.createSchedule(schedule);
	}

	@Override
	public List<Schedule> searchScheduleList(String studentGroupCode,
			String moduleCode, Date startDateTime, Date endDateTime) {
		return scheduleDao.searchScheduleList(studentGroupCode, moduleCode, startDateTime, endDateTime);
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		scheduleDao.updateSchedule(schedule);
	}

	@Override
	public Schedule getScheduleByScheduleId(int scheduleId) {
		return scheduleDao.getScheduleByScheduleId(scheduleId);
	}

	@Override
	public void deleteSchedule(Schedule schedule) {
		scheduleDao.deleteSchedule(schedule);
	}

}
