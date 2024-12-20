package com.yourcompany.invoicing.actions;

import org.openxava.actions.*;

public class ShowCustomDateRangeDialogAction extends ViewBaseAction {

	@Override
	public void execute() throws Exception {
		int number = getView().getValueInt("number");
		showDialog();
		getView().setModelName("CustomDateRange");
		getView().setValue("customerNumber", number);
		addActions("CustomDateRange.print");
	}

}
