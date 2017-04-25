package model;

public class Car {
	private int id;
	private String name;
	private int tires;
	private int breaks;
	private int engine;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTires() {
		return tires;
	}
	public void setTires(int tires) {
		this.tires = tires;
	}
	public int getBreaks() {
		return breaks;
	}
	public void setBreaks(int breaks) {
		this.breaks = breaks;
	}
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public int getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}
	private int acceleration;
}
