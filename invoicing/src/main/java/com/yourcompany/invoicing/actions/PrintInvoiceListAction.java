package com.yourcompany.invoicing.actions;

import java.util.*;

import javax.inject.*;

import org.openxava.actions.*;
import org.openxava.model.*;
import org.openxava.tab.*;

import com.yourcompany.invoicing.model.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

public class PrintInvoiceListAction extends JasperReportBaseAction {

	@Inject
	private Tab tab;
	
	@Override
	protected JRDataSource getDataSource() throws Exception {
		List invoiceList = new ArrayList();
		if (tab.getSelectedKeys().length > 0) {
			for (Map key : tab.getSelectedKeys()) {
				Invoice invoice = (Invoice) MapFacade.findEntity("Invoice", key);
				invoiceList.add(invoice);
			}
		} else {
			for (int i = 0; i<tab.getTableModel().getRowCount(); i++) {
				Invoice invoice = (Invoice) MapFacade.findEntity("Invoice", (Map) tab.getTableModel().getObjectAt(i));
				invoiceList.add(invoice);
			}
		}
		return new JRBeanCollectionDataSource(invoiceList);
	}

	@Override
	protected String getJRXML() throws Exception {
		return "InvoiceList.jrxml";
	}

	@Override
	protected Map getParameters() throws Exception {
		return null;
	}

}
