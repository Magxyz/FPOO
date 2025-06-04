package ticTacToe.component;

import java.awt.Color;
import java.awt.Graphics;

public class Button extends AbstractComponent {

	public Button() {
		super();
	}

	public Button(int x, int y) {
		super(x, y);
	}

	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void paint(Graphics g) {

		g.drawRect(position.x, position.y, width(), height());

		if (this.mouseOver)
			doMouseOverDecoration(g);

	}

	private void doMouseOverDecoration(Graphics g) {

		int offset = 5;
		int doubleOffset = offset * 2;
		Color buttonColor = g.getColor();

		g.setColor(Color.pink);
		g.drawRect(position.x + offset, position.y + offset, width() - doubleOffset, height() - doubleOffset);
		g.setColor(buttonColor);
	}
}