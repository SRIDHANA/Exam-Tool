package com.sridhana.controller.student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sridhana.service.TimeTrackerService;

@RestController
public class TimeTrackerController {
	
	@RequestMapping(value = "/timetracker/getTimePassed", method = RequestMethod.GET)
	public String getTimePassed(@RequestParam Integer examId) {
		TimeTrackerService service = new TimeTrackerService();
		return service.getTimePassed(examId);		
	}

	@RequestMapping(value = "/timetracker/startTimeTracker", method = RequestMethod.GET)
	public String startTimer(@RequestParam Integer examId) {
		TimeTrackerService service = new TimeTrackerService();
		return String.valueOf(service.startTimeTracker(examId));
	}

	@RequestMapping(value = "/timetracker/endTimeTracker", method = RequestMethod.GET)
	public String endTimer(@RequestParam Integer examId) {
		TimeTrackerService service = new TimeTrackerService();
		return String.valueOf(service.endTimeTracker(examId));
	}
}