package appTest;

import ticTacToe.component.Button;
import ticTacToe.gui.MainWindow;

public class AppButtonMouseClickTest {
	
	public static void main(String[] args) {
		
		MainWindow window = new MainWindow();
		Button button = new Button(250, 100, 50, 50);
		window.add(button);;
		window.addMouseListener(button.mouseListener());
	}
}
