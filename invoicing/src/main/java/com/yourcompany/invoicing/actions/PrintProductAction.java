package com.yourcompany.invoicing.actions;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;
import org.openxava.model.*;
import org.openxava.util.*;
import org.openxava.validators.*;

import com.yourcompany.invoicing.model.*;

import net.sf.jasperreports.engine.*;

public class PrintProductAction extends JasperReportBaseAction {

	private Product product;
	
	@Override
	protected JRDataSource getDataSource() throws Exception {
		return new JREmptyDataSource();
	}

	@Override
	protected String getJRXML() throws Exception {
		return "ProductDetail.jrxml"; 
	}

	@Override
	protected Map getParameters() throws Exception {
		Messages errors = MapFacade.validate("Product", getView().getValues());
		if (errors.contains()) throw new ValidationException(errors);
		System.out.println(getView().getValue("number"));
		
		Map parameters = new HashMap();	
		parameters.put("id", (getProduct().getNumber()));
		parameters.put("description", getProduct().getDescription());
		parameters.put("author", getProduct().getAuthor().getName());
		parameters.put("isbn", getProduct().getIsbn());
		parameters.put("category", getProduct().getCategory().getDescription());
		parameters.put("price", getProduct().getPrice());
		
		return parameters;
	}

	private Product getProduct() throws Exception {
		if (product == null) {
			int number = getView().getValueInt("number");
			product = XPersistence.getManager().find(Product.class, Integer.valueOf(number));
		}
		return product;
	}

	
}
