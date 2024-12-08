package com.yourcompany.invoicing.actions;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.model.*;
import org.openxava.util.*;
import org.openxava.validators.*;

import net.sf.jasperreports.engine.*;

public class PrintCustomerInvoicesAction extends JasperReportBaseAction {
	
	@Override
	protected JRDataSource getDataSource() throws Exception {
		return null;
	}

	@Override
	protected String getJRXML() throws Exception {
		return "CustomerInvoices.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
		Messages errors = MapFacade.validate("Customer", getView().getValues());
		if (errors.contains()) throw new ValidationException(errors);
		Map parameters = new HashMap();			
		parameters.put("number", getView().getValueInt("number"));
		parameters.put("name", getView().getValue("name"));
		return parameters;
	}

}
