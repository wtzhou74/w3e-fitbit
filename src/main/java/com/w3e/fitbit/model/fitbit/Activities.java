package com.w3e.fitbit.model.fitbit;

import java.util.Date;

/**
 * Model of fitbit acitivities
 * @author ZHOU WENTAO
 * */
public class Activities {
	private long activityId;
	private long activityParentId;
	private String activityParentName;
	private int calories;
	private String description;
	private float distance;
	private long duration;
	private boolean hasStartTime;
	private boolean isFavorite;
	private Date lastModified;
	private long logId;
	private String name;
	private String startTime;
	private int steps;
	
	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}
	public long getActivityParentId() {
		return activityParentId;
	}
	public void setActivityParentId(long activityParentId) {
		this.activityParentId = activityParentId;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public boolean isHasStartTime() {
		return hasStartTime;
	}
	public void setHasStartTime(boolean hasStartTime) {
		this.hasStartTime = hasStartTime;
	}
	public boolean isFavorite() {
		return isFavorite;
	}
	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	public long getLogId() {
		return logId;
	}
	public void setLogId(long logId) {
		this.logId = logId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getActivityParentName() {
		return activityParentName;
	}
	public void setActivityParentName(String activityParentName) {
		this.activityParentName = activityParentName;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	
	
}
