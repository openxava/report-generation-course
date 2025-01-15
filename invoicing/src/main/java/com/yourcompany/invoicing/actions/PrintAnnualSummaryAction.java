package com.yourcompany.invoicing.actions;

import java.util.*;

import org.openxava.actions.*;

import net.sf.jasperreports.engine.*;

public class PrintAnnualSummaryAction extends JasperReportBaseAction {

	@Override
	protected JRDataSource getDataSource() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getJRXML() throws Exception {
		// TODO Auto-generated method stub
		return "AnnualBillingSummary.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
