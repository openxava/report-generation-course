package com.yourcompany.report.action;

import java.util.*;

import org.openxava.actions.*;

import net.sf.jasperreports.engine.*;

public class PrintMyCustomReportAction extends JasperReportBaseAction {

	@Override
	protected JRDataSource getDataSource() throws Exception {
		return new JREmptyDataSource();
	}

	@Override
	protected String getJRXML() throws Exception {
		return "Blank_A4.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
		return null;
	}

}
