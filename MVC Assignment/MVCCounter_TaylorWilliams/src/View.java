
//View.java
//(C) Joseph Mack 2011, jmack (at) wm7d (dot) net, released under GPL v3 (or any later version)

//inspired by Joseph Bergin's MVC gui at http://csis.pace.edu/~bergin/mvc/mvcgui.html

//View is an Observer

/*
 * View shows the model's state, and allows the user to enter commands which will change the model's state
 * As is required for re-usability, the View doesn't know about (i.e. have a reference to) the Model
 * The view is an Observer. The view is a GUI which has 
 * 			a TextField to display the status of the model (the value of the counter). 
 * 			a Button to communicate with the controller (the controller is a button Listener).
 * */

import java.awt.Button;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Label;
import java.awt.event.WindowEvent;	//for CloseListener()
import java.awt.event.WindowAdapter;	//for CloseListener()
import java.lang.Integer;		//int from Model is passed as an Integer
import java.util.Observable;		//for update();
import java.awt.event.ActionListener;	//for addController()


class View implements java.util.Observer {

	//attributes as must be visible within class
	private TextField myTextField;
	private Button button; 

	/*
	 * The trivial functionality of View is 
	 * 	a constructor which generates the GUI 
	 * 	a method to initialize the TextField
	 */
	View() {
		System.out.println("View()");	
		
		Frame frame 		= new Frame("simple MVC");
		frame.add("North", new Label("counter"));

		myTextField 		= new TextField();
		frame.add("Center", myTextField);

		Panel panel 		= new Panel();
		button	 		= new Button("PressMe");
		panel.add(button);
		frame.add("South", panel);		

		frame.addWindowListener(new CloseListener());	
		frame.setSize(400,400);
		frame.setLocation(100,100);
		frame.setVisible(true);

	} //View()
	
	
	//to initialize TextField
		public void setValue(int v){
	    		myTextField.setText("" + v);
		} //setValue()
		
		

	/*
	 * The interesting functionality of View communicates with the controller and the model. 
	 * 		1- a method addController(ActionListener controller), which attaches the controller as a listener to the button
	 * 		2- the magic part, update(), which receives the status message from model 
	 * 
	 * How does myView.update() get updated? 
	 * 	 (It all happens inside the instance Observable:myModel.) 
     *    model changes state when the method Model:incrementValue() is executed (by the controller). 
     *    After first changing the model's state, Observable:setChanged() changes the flag Observable:changed to true. 
     *    next Model:notifyObservers(counter) is ran. 
     *    notifyObservers(counter) is a method of Observable. 
     *    notifyObservers() checks that changed is true, sets it to false, 
     *    looks up the vector of observers, in our case finding myView, 
     *    and then runs myView.update(Observable myModel, Object (Integer)counter). 
     *    myView now has the reference to the observable myModel and a reference to its (new) status. 
     *    Subsequent commands in update() present the model's (new) status to the user.
	 */     
	// Called from the Model
    	public void update(Observable obs, Object obj) {

		myTextField.setText("" + ((Integer)obj).intValue());	//obj is an Object, need to cast to an Integer
		System.out.println("The state of the model is displayed through the view");

    	} //update()

	
    // a method addController(ActionListener controller), which attaches the controller as a listener to the button	
	public void addController(ActionListener controller){
		System.out.println("View      : adding controller");
		button.addActionListener(controller);	//need instance of controller before can add it as a listener 
	} //addController()

		
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} //windowClosing()
	} //CloseListener

} //View
