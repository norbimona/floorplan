package com.ansis.floorplan.action;

import java.util.HashMap;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ansis.floorplan.model.Polly;


public class OpacityTwentyAction extends SelectionAction {

	// ==================== 1. Static Fields ========================

	public static final String opacityPropertyTwenty = "opacityPropertyTwenty"; //$NON-NLS-1$


	// ====================== 2. Instance Fields =============================

	private final String twenty = "20"; //$NON-NLS-1$

	// TODO undo
	private String oldOpacity;


	// ==================== 4. Constructors ====================

	public OpacityTwentyAction(final IWorkbenchPart part) {
		super(part);
		setLazyEnablementCalculation(true);
	}


	// ==================== 5. Creators ====================

	public Command createOpacityCommand(final String opacity) {
		final Request opacityReq = new Request("opacity"); //$NON-NLS-1$
		final HashMap<String, String> reqData = new HashMap<String, String>();
		reqData.put("newOpacity", opacity); //$NON-NLS-1$
		opacityReq.setExtendedData(reqData);
		final EditPart object = (EditPart)getSelectedObjects().get(0);
		final Command cmd = object.getCommand(opacityReq);
		return cmd; 
	}


	// ==================== 6. Action Methods ====================

	@Override
	protected boolean calculateEnabled() {
		final Command cmd = createOpacityCommand(""); //$NON-NLS-1$
		if (cmd == null)
			return false;
		return true;
	}

	@Override
	protected void init() {
		setId(opacityPropertyTwenty);
		setText(getTwenty()+"%");  //$NON-NLS-1$
		setToolTipText("Opacity 20"); //$NON-NLS-1$
		final ImageDescriptor icon = AbstractUIPlugin.imageDescriptorFromPlugin("FloorPlan", "icons/rename-icon.png"); //$NON-NLS-1$ //$NON-NLS-2$
		if (icon != null)
			setImageDescriptor(icon);
		setEnabled(false);
	}

	@Override
	public void run() {
		final Polly polly = getSelectedNode();
		this.oldOpacity = Integer.toString(polly.getOpacity());
		execute(createOpacityCommand(getTwenty()));
	}


	// ==================== 7. Getters & Setters ====================

	// Helper
	private Polly getSelectedNode() {
		final List<?> objects = getSelectedObjects();
		if (objects.isEmpty())
			return null;
		if (!(objects.get(0) instanceof EditPart))
			return null;
		final EditPart part = (EditPart)objects.get(0);
		return (Polly)part.getModel();
	}

	public String getTwenty() {
		return twenty;
	}

}