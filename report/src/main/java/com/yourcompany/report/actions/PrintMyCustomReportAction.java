package com.yourcompany.report.actions;

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
		return "MyCustomReport.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
		return null;
	}

}
