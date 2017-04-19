/**
 * @author Hasun Rathnayake
 * Date : 14/04/2017
 * Module service class which is responsible for handling module related request
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

import com.gadreel.lecture.schedule.bd.ModuleBd;
import com.gadreel.lecture.schedule.domain.Module;

@Controller
@RequestMapping("/module")
public class ModuleService {
	
	@Autowired
	private ModuleBd moduleBd;
	
	/**
	 * Creates a Module
	 * @param moduleCode module code name
	 * @param moduleName name of the module
	 * @param credits number of creadits allocated to a particular module
	 * @param moduleLeader name of the module leader
	 * @return a json string containing the result
	 * @throws JSONException 
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody ResponseEntity<String> createModule(@RequestParam("moduleCode") String moduleCode,
															 @RequestParam("moduleName") String moduleName,
															 @RequestParam("credits") int credits,
															 @RequestParam("moduleLeader") String moduleLeader) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		try{
			
			Module module = new Module();
			module.setCredits(credits);
			module.setModuleCode(moduleCode);
			module.setModuleLeader(moduleLeader);
			module.setModuleName(moduleName);
			
			moduleBd.createModule(module);
			
			jsonObject.put("msg", "Module, "+moduleCode+" created successfully!");
			
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.OK);
			
		} catch(Exception exception){
			jsonObject.put("msg", "An unexpected error occurred while creating module, "+moduleCode+"!");
			return new ResponseEntity<String>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
