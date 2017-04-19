/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Schedule service class which is responsible for handling schedule related requests
 */
package com.gadreel.lecture.schedule.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gadreel.lecture.schedule.bd.ModuleBd;
import com.gadreel.lecture.schedule.bd.ScheduleBd;
import com.gadreel.lecture.schedule.bd.StudentGroupBd;
import com.gadreel.lecture.schedule.domain.Module;
import com.gadreel.lecture.schedule.domain.Schedule;
import com.gadreel.lecture.schedule.domain.StudentGroup;
import com.gadreel.lecture.schedule.util.Util;

@Controller
@RequestMapping("/schedule")
public class ScheduleService {
	
	@Autowired
	private ScheduleBd scheduleBd;
	
	@Autowired
	private StudentGroupBd studentGroupBd;
	
	@Autowired
	private ModuleBd moduleBd;
	
	/**
	 * Creates a schedule
	 * @param studentGroupCode student group code of the particular schedule
	 * @param moduleCode module code of the particular schedule
	 * @param scheduleStartDateTime schedule start date and time
	 * @param scheduleEndDateTime schedule end date and time
	 * @param remark remarks
	 * @return a json string which contains the result
	 * @throws JSONException 
	 */
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody ResponseEntity<String> createShedule( @RequestParam("studentGroup") String studentGroupCode,
															   @RequestParam("module") String moduleCode,
															   @RequestParam("scheduleStartDateTime") String scheduleStartDateTime,
															   @RequestParam("scheduleEndDateTime") String scheduleEndDateTime,
															   @RequestParam("remark") String remark) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		try{
			
			StudentGroup studentGroup = studentGroupBd.getStudentGroupByGroupCode(studentGroupCode);
			Module module= moduleBd.getModuleByModuleCode(moduleCode);
			
			Schedule schedule = new Schedule();
			schedule.setModule(module);
			schedule.setRemark(remark);
			schedule.setScheduleEndDateTime(Util.stringToDate(scheduleEndDateTime));
			schedule.setScheduleStartDateTime(Util.stringToDate(scheduleStartDateTime));
			schedule.setStudentGroup(studentGroup);
			
			scheduleBd.createSchedule(schedule);
			
			jsonObject.put("msg", "Schedule for module, "+moduleCode+" and group, "+studentGroupCode+" created successfully!");
			
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.OK);
			
		} catch(Exception exception){
			jsonObject.put("msg", "An unexpected error occurred while creating the schedule!");
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Publishes schedule accordingly for criteria
	 * @param studentGroupCode student group code of the particular schedule
	 * @param moduleCode module code of the particular schedule
	 * @param scheduleStartDateTime schedule start date and time
	 * @param scheduleEndDateTime schedule end date and time
	 * @return a json string which contains the result
	 * @throws JSONException 
	 */
	@RequestMapping(value = "/publish", method = {RequestMethod.POST,RequestMethod.GET}, produces="application/json", consumes={"application/json", "application/xml","application/x-www-form-urlencoded"})
	public @ResponseBody ResponseEntity<String> publishSchedule(@RequestParam("studentGroup") String studentGroupCode,
															 	@RequestParam("module") String moduleCode,
															 	@RequestParam("scheduleStartDateTime") String scheduleStartDateTime,
															 	@RequestParam("scheduleEndDateTime") String scheduleEndDateTime) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		try{
			List<Schedule> scheduleList = scheduleBd.searchScheduleList(studentGroupCode, moduleCode, Util.stringToDate(scheduleStartDateTime), Util.stringToDate(scheduleEndDateTime));
			JSONArray jsonArray = new JSONArray();
			for(Schedule schedule : scheduleList){
				JSONObject scheduleJsonObject = new JSONObject();
				
				scheduleJsonObject.put("id", schedule.getScheduleId());
				scheduleJsonObject.put("mod_code", schedule.getModule().getModuleCode());
				scheduleJsonObject.put("mod_name", schedule.getModule().getModuleName());
				scheduleJsonObject.put("grp_code", schedule.getStudentGroup().getGroupCode());
				scheduleJsonObject.put("start_dt", Util.dateToString(schedule.getScheduleStartDateTime()));
				scheduleJsonObject.put("end_dt", Util.dateToString(schedule.getScheduleEndDateTime()));
					if(!schedule.getRemark().equals("") && schedule.getRemark() != null)
						scheduleJsonObject.put("remark", schedule.getRemark());
				
					jsonArray.put(scheduleJsonObject);
			}
			
			jsonObject.put("count",scheduleList.size());
			jsonObject.put("schedules",jsonArray);
			
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.OK);
			
		} catch(Exception exception){
			exception.printStackTrace();
			jsonObject.put("msg", "An unexpected error occurred while publishing the schedules!");
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Updates a schedule
	 * @param sheduleId schedule id which needs to be updated
	 * @param studentGroupCode student group code of the particular schedule
	 * @param moduleCode module code of the particular schedule
	 * @param scheduleStartDateTime schedule start date and time
	 * @param scheduleEndDateTime schedule end date and time
	 * @param remark remarks
	 * @return a json string which contains the result
	 * @throws JSONException 
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.POST,RequestMethod.GET}, produces="application/json", consumes={"application/json", "application/xml","application/x-www-form-urlencoded"})
	public @ResponseBody ResponseEntity<String> editSchedule( @RequestParam("scheduleId") int scheduleId,
															  @RequestParam("studentGroup") String studentGroupCode,
															  @RequestParam("module") String moduleCode,
															  @RequestParam("scheduleStartDateTime") String scheduleStartDateTime,
															  @RequestParam("scheduleEndDateTime") String scheduleEndDateTime,
															  @RequestParam("remark") String remark) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		try{
			
			StudentGroup studentGroup = studentGroupBd.getStudentGroupByGroupCode(studentGroupCode);
			Module module= moduleBd.getModuleByModuleCode(moduleCode);
			
			Schedule schedule = scheduleBd.getScheduleByScheduleId(scheduleId);
			
			if(schedule == null){
				jsonObject.put("msg", "Schedule not found!");
				return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.NO_CONTENT);
			} else if(studentGroup == null){
				jsonObject.put("msg", "Student group not found!");
				return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.NO_CONTENT);
			} else if(module == null){
				jsonObject.put("msg", "Module not found!");
				return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.NO_CONTENT);
			}
			schedule.setModule(module);
			schedule.setRemark(remark);
			schedule.setScheduleEndDateTime(Util.stringToDate(scheduleEndDateTime));
			schedule.setScheduleStartDateTime(Util.stringToDate(scheduleStartDateTime));
			schedule.setStudentGroup(studentGroup);
			
			scheduleBd.updateSchedule(schedule);
			
			jsonObject.put("msg", "Schedule updated successfully!");
			
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.OK);
			
		} catch(Exception exception){
			jsonObject.put("msg", "An unexpected error occurred while updating the schedule!");
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Deletes a schedule
	 * @param sheduleId schedule id which needs to be deleted
	 * @return a json string which contains the result
	 * @throws JSONException 
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.POST,RequestMethod.GET}, produces="application/json", consumes={"application/json", "application/xml","application/x-www-form-urlencoded"})
	public @ResponseBody ResponseEntity<String> deleteSchedule( @RequestParam("scheduleId") int scheduleId) throws JSONException{
		JSONObject jsonObject = new JSONObject();
		try{
			
			Schedule schedule = scheduleBd.getScheduleByScheduleId(scheduleId);
			scheduleBd.deleteSchedule(schedule);
			
			jsonObject.put("msg", "Schedule deleted successfully!");
			
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.OK);
			
		} catch(Exception exception){
			jsonObject.put("msg", "An unexpected error occurred while deleting the schedule!");
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
