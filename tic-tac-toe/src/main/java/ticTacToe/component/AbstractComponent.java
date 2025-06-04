package ticTacToe.component;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import ticTacToe.gui.Paintable;
import ticTacToe.gui.util.MouseListenerAdapter;

public abstract class AbstractComponent implements Paintable {
	
	protected Point position;
	protected Dimension dimension;
	protected boolean mouseOver = false;
	
	public AbstractComponent() {
		this.position = new Point(0, 0);
		this.dimension = new Dimension(10, 10);
	}

	public AbstractComponent(int x, int y) {
		this();
		setPosition(x, y);
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}

	public Point getPosition() {
		return new Point(this.position);
	}

	public AbstractComponent(int x, int y, int width, int height) {
		this(x, y);
		setSize(width, height);
	}

	public void setSize(int width, int height) {
		this.dimension = new Dimension(width, height);
	}

	public Dimension getSize() {
		return new Dimension(this.dimension);
	}
	
	public int width() {
		return this.dimension.width;
	}

	public int height() {
		return this.dimension.height;
	}

	public boolean isOver(Point point) {
		int xLeft = this.position.x;
		int yTop = this.position.y;
		int xRight = xLeft + this.width();
		int yBottom = yTop + this.height();

		return ((point.x > xLeft && point.x < xRight) && (point.y > yTop && point.y < yBottom));
	}
	
	public MouseListener mouseListener() {

		return new MouseListenerAdapter() {

			@Override
			public void mouseClicked(MouseEvent me) {

				if (!isOver(me.getPoint()))
					return;

				System.out.println("oiieee!");
			}

		};
	}
	
	public MouseMotionListener mouseMotionListener() {

		return new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent me) {
				mouseOver = isOver(me.getPoint());
			}
		};
	}
	
}
