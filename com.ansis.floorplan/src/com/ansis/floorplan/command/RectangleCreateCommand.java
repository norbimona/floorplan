package com.ansis.floorplan.command;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.ansis.floorplan.model.ModelTest;
import com.ansis.floorplan.model.RectangleModel;

public class RectangleCreateCommand extends Command {


	// ====================== 2. Instance Fields =============================

	private ModelTest canvas;

	private RectangleModel rFigure;

	private Point location;
	
	private Dimension size;


	// ==================== 6. Action Methods ====================

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void execute() {
		
		if (size == null)
			return;
			
		rFigure.setBounds(new Rectangle(location, size));
		
		canvas.addChild(rFigure);
	}


	// ==================== 7. Getters & Setters ====================

	public void setRectangle(final RectangleModel rFigure) {
		this.rFigure = rFigure;
	}

	public void setCanvas(final ModelTest canvas) {
		this.canvas = canvas;
	}

	public void setLocation(final Point location) {
		this.location = location;
	}
	
	public void setSize(final Dimension size) {
		this.size = size;
	}

}