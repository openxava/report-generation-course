package com.yourcompany.invoicing.model;

import java.time.*;

import lombok.*;

@Getter @Setter
public class CustomDateRange {

	int customerNumber;
	
	LocalDate startDate;
	
	LocalDate endDate;
	
}
