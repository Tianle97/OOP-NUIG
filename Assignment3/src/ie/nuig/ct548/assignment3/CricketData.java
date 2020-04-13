package ie.nuig.ct548.assignment3;

import java.util.*;

public class CricketData extends Observable {
	private int runs;
	private float overs;
	private int wickets;
	private ArrayList<Observer> observers;

	public CricketData() {
		this.observers = new ArrayList<Observer>();
	}

	public int getRuns() {
		return runs;
	}

	public float getOvers() {
		return overs;
	}

	public int getWickets() {
		return wickets;
	}

	//add object into arraylist
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	public void notifyObserver() {
		for (Observer o : observers) {
			o.update(this, null);
			System.out.println("update already");
		}

	}
	//set value to runs, overs and wickets
	public void setScore(int runs, float overs, int wickets) {
		this.runs = runs;
		this.overs = overs;
		this.wickets = wickets;
		notifyObserver();
	}

}
