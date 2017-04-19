/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Student group service class which is responsible for handling student groups related requests.
 */
package com.gadreel.lecture.schedule.service;

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

import com.gadreel.lecture.schedule.bd.StudentGroupBd;
import com.gadreel.lecture.schedule.domain.StudentGroup;

@Controller
@RequestMapping("/group")
public class StudentGroupService {

	@Autowired
	private StudentGroupBd studentGroupBd;
	
	/**
	 * Creates a student group
	 * @param groupCode group code name
	 * @param groupDesc description/name of the group
	 * @return a json string which contains the results
	 * @throws JSONException If and only if the value is a non-finite number or if the key is null.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces="application/json",consumes={"application/json", "application/xml","application/x-www-form-urlencoded"})
	public @ResponseBody ResponseEntity<String> createGroup(@RequestParam("groupCode") String groupCode,
															@RequestParam("groupDesc") String groupDesc) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		try{
			
			StudentGroup studentGroup = new StudentGroup();
			studentGroup.setGroupCode(groupCode);
			studentGroup.setGroupDesc(groupDesc);
		
			studentGroupBd.createStudentGroup(studentGroup);
			
			jsonObject.put("msg", "Group, "+groupCode+" created successfully!");
			
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.OK);
			
		} catch(Exception exception){
			jsonObject.put("msg", "An unexpected error occurred while creating group, "+groupCode+"!");
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
