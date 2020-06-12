package calculator;

import javax.swing.JFrame;

/**
 * The Calculator class along with CalculatorController,
 * CalculatorModel and CalculatorView implements a 
 * simple-minded calculator.
 * The implementation is based on the MVC design pattern.
 * 
 * Added # of lines: 12
 * 
 * @author Tom Bylander
 */
public class Calculator {
	/**
	 * Create the model, view and controller objects,
	 * and launch the application.
	 */
	public static void main(String[] args) {
		/* create new model, view and controller */
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView();
		//added instance of View2
		View2 view2 = new View2();
		//added view2 as a parameter
		CalculatorController controller = new CalculatorController(model, view, view2);
		
		/* register controller as listener */
		view.registerListener(controller);
		//registered controller as a listener for view2
		view2.registerListener(controller);
		
		/* start it up */
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
		//set up view2
		view2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view2.setSize(400, 300);
		view2.setVisible(true);
	}
}
