package com.sridhana.service;

import java.util.concurrent.ConcurrentHashMap;

public class TimeTrackerService {
	private static ConcurrentHashMap<Integer, TimeTracker> TimeTrackerThreadStack = new ConcurrentHashMap<Integer, TimeTracker>();
	private static long ExamTimeLimitInMins = 2;
	
	// This method will be called by javascript every 1 sec and then display on the UI
	public String getTimePassed(Integer examId) {
		System.out.println("Threaqd stack count size.. " + TimeTrackerThreadStack.size());
		TimeTracker timeTracker = TimeTrackerThreadStack.get(examId);
		System.out.println("TimeTracker java Thread object.. " + timeTracker);
		System.out.println("Checking the time passed string from stack.. ");
		if(timeTracker == null) return "";
		return timeTracker.getTimePassedString();
	}

	public boolean startTimeTracker(Integer examId) {
		if(!TimeTrackerThreadStack.containsKey(examId)) {			
			TimeTracker timeTracker = new TimeTracker(examId, ExamTimeLimitInMins);
			timeTracker.setTimeTrackerRunning(true);
			System.out.println("Putting Thread into Thread Stack..");
			TimeTrackerThreadStack.put(examId, timeTracker);
			System.out.println("Threaqd stack count size.. " + TimeTrackerThreadStack.size());
			System.out.println("Checking the time passed string from Stack init.. " + TimeTrackerThreadStack.get(examId).getTimePassedString());
			timeTracker.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Again.. Checking the time passed string from Stack init.. ");
			System.out.println("..." + TimeTrackerThreadStack.get(examId).getTimePassedString());
		}
		return true;
	}

	public boolean endTimeTracker(Integer examId) {
		TimeTracker timeTracker = TimeTrackerThreadStack.get(examId);
		timeTracker.setTimeTrackerRunning(false);
		TimeTrackerThreadStack.remove(examId);
		return true;
	}
}