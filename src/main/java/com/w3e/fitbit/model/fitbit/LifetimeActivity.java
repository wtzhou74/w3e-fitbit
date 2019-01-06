package com.w3e.fitbit.model.fitbit;

/**
 * Model of fitbit lifetime activity
 * @author ZHOU WENTAO
 * */
public class LifetimeActivity {

	private int caloriesOut;
	private float distance;
	private int floors;
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
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
}
