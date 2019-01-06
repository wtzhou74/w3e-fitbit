package com.w3e.fitbit.model.fitbit;

import java.util.List;

/**
 * Model of fitbit summary
 * @author ZHOU WENTAO
 * */
public class Summary {

	private int activeScore;
	private int activityCalories;
	private int calorieEstimationMu;
	private int caloriesBMR;
	private int caloriesOut;
	private int caloriesOutUnestimated;
	private List<Distances> distances;
	//float elevation;
	private int fairlyActivityMinutes;
	//int floors;
	private int lightlyActivityMinutes;
	private int marginalCalories;
	private int sedentaryMinutes;
	private int steps;
	private int veryActiveMinutes;
	private boolean useEstimation;
	
	
	public int getActiveScore() {
		return activeScore;
	}
	public void setActiveScore(int activeScore) {
		this.activeScore = activeScore;
	}
	public int getActivityCalories() {
		return activityCalories;
	}
	public void setActivityCalories(int activityCalories) {
		this.activityCalories = activityCalories;
	}
	public int getCaloriesBMR() {
		return caloriesBMR;
	}
	public void setCaloriesBMR(int caloriesBMR) {
		this.caloriesBMR = caloriesBMR;
	}
	public int getCaloriesOut() {
		return caloriesOut;
	}
	public void setCaloriesOut(int caloriesOut) {
		this.caloriesOut = caloriesOut;
	}
	public List<Distances> getDistances() {
		return distances;
	}
	public void setDistances(List<Distances> distances) {
		this.distances = distances;
	}
//	public float getElevation() {
//		return elevation;
//	}
//	public void setElevation(float elevation) {
//		this.elevation = elevation;
//	}
	public int getFairlyActivityMinutes() {
		return fairlyActivityMinutes;
	}
	public void setFairlyActivityMinutes(int fairlyActivityMinutes) {
		this.fairlyActivityMinutes = fairlyActivityMinutes;
	}
//	public int getFloors() {
//		return floors;
//	}
//	public void setFloors(int floors) {
//		this.floors = floors;
//	}
	public int getLightlyActivityMinutes() {
		return lightlyActivityMinutes;
	}
	public void setLightlyActivityMinutes(int lightlyActivityMinutes) {
		this.lightlyActivityMinutes = lightlyActivityMinutes;
	}
	public int getMarginalCalories() {
		return marginalCalories;
	}
	public void setMarginalCalories(int marginalCalories) {
		this.marginalCalories = marginalCalories;
	}
	public int getSedentaryMinutes() {
		return sedentaryMinutes;
	}
	public void setSedentaryMinutes(int sedentaryMinutes) {
		this.sedentaryMinutes = sedentaryMinutes;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	public int getVeryActiveMinutes() {
		return veryActiveMinutes;
	}
	public void setVeryActiveMinutes(int veryActiveMinutes) {
		this.veryActiveMinutes = veryActiveMinutes;
	}
	public int getCalorieEstimationMu() {
		return calorieEstimationMu;
	}
	public void setCalorieEstimationMu(int calorieEstimationMu) {
		this.calorieEstimationMu = calorieEstimationMu;
	}
	public int getCaloriesOutUnestimated() {
		return caloriesOutUnestimated;
	}
	public void setCaloriesOutUnestimated(int caloriesOutUnestimated) {
		this.caloriesOutUnestimated = caloriesOutUnestimated;
	}
	public boolean isUseEstimation() {
		return useEstimation;
	}
	public void setUseEstimation(boolean useEstimation) {
		this.useEstimation = useEstimation;
	}
	
	
}
