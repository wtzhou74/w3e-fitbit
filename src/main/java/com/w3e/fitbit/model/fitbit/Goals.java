package com.w3e.fitbit.model.fitbit;

/**
 * Model of fitbit goals
 * @author ZHOU WENTAO
 * */
public class Goals {

	private int activeMinutes;
	private float distance;
	private int caloriesOut;
	//int floors;
	private int steps;
	
	public int getCaloriesOut() {
		return caloriesOut;
	}
	public void setCaloriesOut(int caloriesOut) {
		this.caloriesOut = caloriesOut;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
//	public int getFloors() {
//		return floors;
//	}
//	public void setFloors(int floors) {
//		this.floors = floors;
//	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	public int getActiveMinutes() {
		return activeMinutes;
	}
	public void setActiveMinutes(int activeMinutes) {
		this.activeMinutes = activeMinutes;
	}
	
	
}
