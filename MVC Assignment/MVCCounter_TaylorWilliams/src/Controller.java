/*
 * Controller is a Listener. It 
 * has a method actionPerformed(), which listens to View's button. 
 * When the method receives a button press, it changes the state of Model by running myModel.incrementValue(). 
 * has code which is specific to Model and View. Controller is not reusable
 */

class Controller implements java.awt.event.ActionListener {

	
	Model model;

	Controller() {	
		System.out.println ("Controller()");
	} //Controller()

	//invoked when a button is pressed
	//listens to View's button. When the method receives a button press, 
	//it changes the state of Model by running myModel.incrementValue()
	public void actionPerformed(java.awt.event.ActionEvent e){
		
		System.out.println("Controller: acting on Model");
		model.incrementValue();
	} //actionPerformed()

	//I should be able to add any model/view with the correct API
	//but here I can only add Model/View
	public void addModel(Model m){
		System.out.println("Controller: adding model");
		this.model = m;
	} //addModel()

	public void initModel(int x){
		model.setValue(x);
	} //initModel()

} //Controller