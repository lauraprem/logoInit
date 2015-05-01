package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Segment {
	private Point ptStart;
	private Point ptEnd;
	private Color color;

	public Segment() {
		ptStart = new Point(0, 0);
		ptEnd = new Point(0, 0);
	}

	public Point getPtStart() {
		return ptStart;
	}

	public void setPtStart(Point ptStart) {
		this.ptStart = ptStart;
	}

	public Point getPtEnd() {
		return ptEnd;
	}

	public void setPtEnd(Point ptEnd) {
		this.ptEnd = ptEnd;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}	
}
