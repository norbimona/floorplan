package com.ansis.floorplan.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.ansis.floorplan.model.Canvas;
import com.ansis.floorplan.model.Polly;


public class PollyCreateCommand extends Command {

	// ====================== 2. Instance Fields =============================

	private Canvas en;

	private Polly srv;


	// ==================== 4. Constructors ====================

	public PollyCreateCommand() {
		super();
		en = null;
		srv = null;
	}


	// ==================== 6. Action Methods ====================

	@Override
	public boolean canExecute() {
		if (srv == null || en == null)
			return false;
		return true;
	}

	@Override
	public void execute() {
		en.addChild(srv);
		srv.setParent(en);
	}


	// ==================== 7. Getters & Setters ====================

	public void setPolly(final Object s) {
		if (s instanceof Polly)
			this.srv = (Polly)s;
	}

	public void setCanvas(final Object e) {
		if (e instanceof Canvas)
			this.en = (Canvas)e;
	}

	public void setLayout(final Rectangle r) {
		if (srv == null)
			return;
		srv.setLayout(r);
	}

}