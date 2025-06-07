package ticTacToe.component.button;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.ButtonClickEvent.MouseButton;

public class Button extends AbstractComponent {

	Set<ButtonClickListener> buttonClickListeners = new HashSet<>();

	public void addButtonClickListener(ButtonClickListener listener) {
		buttonClickListeners.add(listener);
	}

	public void removeButtonClickListener(ButtonClickListener listener) {
		buttonClickListeners.remove(listener);
	}

	private void dispatchButtonClickEvent(MouseEvent me) {

		MouseButton button = ((me.getButton() == MouseEvent.BUTTON1) ? MouseButton.LEFT
				: (me.getButton() == MouseEvent.BUTTON2) ? MouseButton.MIDLE : MouseButton.RIGHT);

		ButtonClickEvent event = new ButtonClickEvent(this, button);
		buttonClickListeners.forEach(listener -> listener.onClick(event));
	}

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

	@Override
	protected void onMouseClick(MouseEvent me) {
		dispatchButtonClickEvent(me);
	}
}