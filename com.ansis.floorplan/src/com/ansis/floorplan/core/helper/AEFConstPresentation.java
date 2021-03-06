package com.ansis.floorplan.core.helper;

/**
 * Note: Fields in an interface are always implicitly public static final.
 * 
 * @author ggrec
 *
 */
public interface AEFConstPresentation 
{
	int SWT_NORMAL = 0;
	int SWT_BOLD = 1;
	int SWT_ITALIC = 2;
	int SWT_BOLD_ITALIC = 3;

	String EMPTY_STRING = ""; //$NON-NLS-1$
	String SPACE = " "; //$NON-NLS-1$
	String NEW_LINE_STRING = System.getProperty("line.separator"); //$NON-NLS-1$
	String LIST_SEPARATOR = ", "; //$NON-NLS-1$
	String FULL_STOP_SEPARATOR = ". "; //$NON-NLS-1$
	String COLOR_SEPARATOR = ": "; //$NON-NLS-1$
	String ELIPSES = "..."; //$NON-NLS-1$
}
