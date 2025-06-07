package appTest;

import ticTacToe.component.button.Button;
import ticTacToe.gui.MainWindow;

public class AppButtonPaintableTest {

	public static void main(String[] args) {

		MainWindow window = new MainWindow();

		Button buttonDefault = new Button();
		window.add(buttonDefault);

		Button buttonPosition = new Button(0, 30);
		window.add(buttonPosition);

		Button buttonPosDim = new Button(30, 60, 100, 100);
		window.add(buttonPosDim);
	}
}
