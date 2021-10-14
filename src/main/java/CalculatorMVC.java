import model.*;
import controller.*;
import view.*;


public class CalculatorMVC {
	public static void main(String[] args) {
		CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);
        view.setVisible(true);
	}

}
