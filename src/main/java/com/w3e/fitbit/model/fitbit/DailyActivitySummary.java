package com.w3e.fitbit.model.fitbit;

import java.util.List;

/**
 * Model of fitbit daily activity summary
 * @author ZHOU WENTAO
 * */
public class DailyActivitySummary {

	private List<Activities> activities;
	private Goals goals;
	private Summary summary;
	
	public List<Activities> getActivities() {
		return activities;
	}
	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}
	public Goals getGoals() {
		return goals;
	}
	public void setGoals(Goals goals) {
		this.goals = goals;
	}
	public Summary getSummary() {
		return summary;
	}
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	
	
}
