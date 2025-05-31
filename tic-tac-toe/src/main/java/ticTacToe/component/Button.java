package ticTacToe.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ticTacToe.gui.Paintable;
import ticTacToe.gui.util.MouseListenerAdapter;

public class Button implements Paintable {

	private Point position = null;
	private Dimension dimension = null;

	public Button() {
		this.position = new Point(0, 0);
		this.dimension = new Dimension(20, 20);
	}

	public Button(int x, int y) {
		this();
		this.setPosition(x, y);
	}

	public Button(int x, int y, int width, int height) {
		this(x, y);
		this.setSize(width, height);
	}

	public void setPosition(int x, int y) {
		this.position = new Point(x, y);

	}

	public Point getPosition() {
		return new Point(this.position);
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
		int yBotton = yTop + this.height();
		
		return ( (point.x > xLeft && point.x < xRight) && (point.y > yTop && point.y < yBotton) );
	}
	
	//--reacting to mouse click ---------------------------
	
	public MouseListener mouseListener() {
		
		return new MouseListenerAdapter() {
			
			@Override
			public void mouseClicked( MouseEvent me) {
				
				if( !isOver( me.getPoint() ))
					return;
				
				System.out.println("oieeee!");
			}
		};
	}
	
	@Override
	public void paint(Graphics g) {
		int xLeft = this.position.x;
		int yTop = this.position.y;
		int width = this.width();
		int height = this.height();

		g.drawRect(xLeft, yTop, width, height);
	}

}
