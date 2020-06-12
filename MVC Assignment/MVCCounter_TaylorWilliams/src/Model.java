//Model.java
//(C) Joseph Mack 2011, jmack (at) wm7d (dot) net, released under GPL v3 (or any later version)

//inspired by Joseph Bergin's MVC gui at http://csis.pace.edu/~bergin/mvc/mvcgui.html

/* The model has state (a counter). 
 * Model holds an int counter (that's all it is).
 * Model is an Observable.
 * By extending Observable, Model has the method Observable:addObservers() 
 * to send (change of) status messages to the view
 * Notice that Model doesn't know about View or Controller 
 * (DeCoupling, emphasize low coupling and high cohesion)*/

/*
 * This Model Class has: 
	a counter 
	a method to increment the counter (the Model's main functionality) 
	a method to initialize the counter 
	a null constructor (well, the constructor prints a notice to the console
 */


public class Model extends java.util.Observable {	
	
	private int counter;	//primitive, automatically initialized to 0

	public Model(){

		System.out.println("Model()");

	} //Model()

	
/*
The model has no code specifying where the notices are sent or from where it will accept the command. 
This makes the model reusable.
The model emits notices of change of state, and the new state.
*/ 
	public void setValue(int value) {

		this.counter = value;
		System.out.println("Model init: counter = " + counter);
		
		// Marks this Observable object as having been changed.
		setChanged();
		
		//then notify all of its observers. 
		//In this code Model:notifyObservers(counter) pushes the model's status to the View.
		notifyObservers(counter); 
		

	} //setValue()
	
	
	// The model accepts a command to change state (increment the counter). 
	public void incrementValue() {

		++counter;
		System.out.println("Model     : counter = " + counter);
		setChanged();
		notifyObservers(counter);
		
	} //incrementValue()
	
} //Model
