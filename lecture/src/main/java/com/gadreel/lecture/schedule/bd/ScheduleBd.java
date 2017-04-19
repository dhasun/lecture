/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Business delegate of {@link Schedule} domain
 */
package com.gadreel.lecture.schedule.bd;

import java.util.Date;
import java.util.List;

import com.gadreel.lecture.schedule.domain.Schedule;

public interface ScheduleBd {
	
	/**
	 * Creates a new {@link Schedule}
	 * @param schedule {@link Schedule} object to be created
	 */
	public void createSchedule(Schedule schedule);
	
	/**
	 * Search for a List of {@link Schedule} with the given parameters
	 * @param studentGroupCode Student group code
	 * @param moduleCode Module code
	 * @param startDateTime Schedule start date object
	 * @param endDateTime Schedule end date object
	 * @return a List of {@link Schedule}
	 */
	public List<Schedule> searchScheduleList(String studentGroupCode,String moduleCode,Date startDateTime,Date endDateTime);
	
	/**
	 * Updates a particular {@link Schedule}
	 * @param schedule {@link Schedule} object to be updated
	 */
	public void updateSchedule(Schedule schedule);
	
	/**
	 * Gets a {@link Schedule} by its id
	 * @param scheduleId ID of a particular {@link Schedule}
	 * @return {@link Schedule} object
	 */
	public Schedule getScheduleByScheduleId(int scheduleId);
	
	/**
	 * Delete a {@link Schedule}
	 * @param schedule {@link Schedule} object to be deleted
	 */
	public void deleteSchedule(Schedule schedule);
}
