//RunMVC.java
//(C) Joseph Mack 2011, jmack (at) wm7d (dot) net, released under GPL v3 (or any later version)

//  non-reusable piece of code RunMVC tells model to send notices to view and to accept commands from controller.
// With the code for the Model not having a reference to the View (at least as an attribute), how does the Model know where view is? 
// A non-reusable glue class (my term) RunMVC instantiates the objects model, view and controller and tells them what they need to know about each other. 
// RunMVC:myModel.addObserver(Observer myView) gives the model a reference to the view.
public class RunMVC {

	//The order of instantiating the objects below will be important for some pairs of commands.
	//I haven't explored this in any detail, beyond that the order below works.

	private int start_value = 10;	//initialise model, which in turn initialises view

	public RunMVC() {

		//create Model and View
		Model myModel 	= new Model();
		View myView 	= new View();
		View2 myView2 = new View2();
		//created new View
		View3 myView3 = new View3();
	
		

		//tell Model about View.
		//Although there is no mention of view in the model code (thus making Model reusable), 
		//the model is being passed a reference to the view. This can be done 
		//because Model is an Observable and an Observable knows the declaration of an Observer (like view). 
		myModel.addObserver(myView);
		myModel.addObserver(myView2);
		//added new View Observer
		myModel.addObserver(myView3);
	
		/*	
			init model after view is instantiated and can show the status of the model
			(I later decided that only the controller should talk to the model
			and moved initialization to the controller (see below).)
		*/
		

		//create Controller. tell it about Model and View, initialize model
		Controller myController = new Controller();
		myController.addModel(myModel);
		myController.initModel(start_value);

		//tell View about Controller 
		// a method addController(ActionListener controller), which attaches the controller as a listener to the button (called by the glue class RunMVC). 
		myView.addController(myController);
		myView2.addController(myController);
		//added controller to new View
		myView3.addController(myController);
		
		
		

	} //RunMVC()

} //RunMVC