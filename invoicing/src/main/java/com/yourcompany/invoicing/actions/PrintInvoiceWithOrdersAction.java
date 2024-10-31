package com.yourcompany.invoicing.actions;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.model.*;
import org.openxava.util.*;
import org.openxava.validators.*;

import com.yourcompany.invoicing.model.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

public class PrintInvoiceWithOrdersAction extends JasperReportBaseAction {

	private Invoice invoice;
	
	@Override
	protected JRDataSource getDataSource() throws Exception {
		return new JREmptyDataSource();
	}

	@Override
	protected String getJRXML() throws Exception {
		return "InvoiceWithOrders.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
		Messages errors = MapFacade.validate("Invoice", getView().getValues());
		if (errors.contains()) throw new ValidationException(errors);
		Map parameters = new HashMap();		
		parameters.put("customerNumber", getInvoice().getCustomer().getNumber());
		parameters.put("customerName", getInvoice().getCustomer().getName());
		parameters.put("invoiceNumber", getInvoice().getNumber());
		parameters.put("date", getInvoice().getDate().toString());
		parameters.put("vatPercentage", getInvoice().getVatPercentage());
		parameters.put("vat", getInvoice().getVat());
		parameters.put("totalAmount", getInvoice().getTotalAmount());
		
		parameters.put("details", new JRBeanCollectionDataSource(getInvoice().getDetails()));
		parameters.put("orders", new JRBeanCollectionDataSource(getInvoice().getOrders()));
		
		return parameters;
	}

	private Invoice getInvoice() {
		if (invoice == null) {
			int year = getView().getValueInt("year");
			int number = getView().getValueInt("number");
			invoice = Invoice.findByYearNumber(year, number);
		}
		return invoice;
	}
	
}