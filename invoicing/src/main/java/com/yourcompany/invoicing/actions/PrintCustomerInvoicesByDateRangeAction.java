package com.yourcompany.invoicing.actions;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.model.*;
import org.openxava.util.*;
import org.openxava.validators.*;

import net.sf.jasperreports.engine.*;

public class PrintCustomerInvoicesByDateRangeAction extends JasperReportBaseAction {

	@Override
	protected JRDataSource getDataSource() throws Exception {
		return null;
	}

	@Override
	protected String getJRXML() throws Exception {
		return "CustomerInvoicesByDateRange.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
		Messages errors = MapFacade.validate("CustomDateRange", getView().getValues());
		if (errors.contains()) throw new ValidationException(errors);
		Map parameters = new HashMap();
		parameters.put("name", getPreviousView().getValue("name"));
		parameters.put("number", getView().getValueInt("customerNumber"));
		parameters.put("startDate", getView().getValue("startDate").toString());
		parameters.put("endDate", getView().getValue("endDate").toString());
		return parameters;
	}

}
