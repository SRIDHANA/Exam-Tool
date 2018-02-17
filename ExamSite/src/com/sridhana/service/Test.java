package com.sridhana.service;

public class Test {
	public static void main(String args[]) throws Exception {
		TimeTrackerService service = new TimeTrackerService();
		int examId = 10;
		System.out.println("Starting Time Tracker.. ");
		service.startTimeTracker(examId);
		System.out.println("Sleeping on Main thread.. for 60 seconds ");
		Thread.sleep(1000 * 60 * 3);
		System.out.println("Ending Time Tracker.. ");
		service.endTimeTracker(examId);
	}
}
