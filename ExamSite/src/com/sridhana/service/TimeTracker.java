package com.sridhana.service;

public class TimeTracker extends Thread implements Runnable {
	
	private int examId;
	private long examTimeLimitInMinutes;
	private long timePassedInSeconds;
	private long timePassedInMinutes;
	private String timePassedString;
	private boolean timeTrackerRunning;
	
	public TimeTracker(int examId, long examTimeLimitInMinutes) {
		this.examId = examId;
		this.examTimeLimitInMinutes = examTimeLimitInMinutes;
		this.timePassedInSeconds = 0;
		this.timePassedInMinutes = 0;
		this.timePassedString = "00 mins:...00 secs";
		this.timeTrackerRunning = false;
	}

	public int getExamId() {
		return examId;
	}

	public boolean isTimeTrackerRunning() {
		return timeTrackerRunning;
	}

	public void setTimeTrackerRunning(boolean timeTrackerRunning) {
		this.timeTrackerRunning = timeTrackerRunning;
	}
	
	public String getTimePassedString() {
		return timePassedString;
	}

	public void run() {
		try {
			while(timeTrackerRunning) {
				Thread.sleep(1000);
				timePassedInSeconds++;
				if (timePassedInSeconds % 60 == 0 && timePassedInSeconds != 0) {
					timePassedInSeconds -= 60;
					timePassedInMinutes++;
				}
				timePassedString = "Time Counter:  " + timePassedInMinutes + " mins : " + timePassedInSeconds + " secs ";
				System.out.println(timePassedString);
				if (timePassedInMinutes >= examTimeLimitInMinutes) {
					System.out.println("Ending Time tracker as Time limit reached.. ");
					timeTrackerRunning = false;
				}
			}
			System.out.println("Ending time Tracker as it is Switched off..");
		} catch (InterruptedException ex) {
			System.out.print(ex);
		}
	}
}