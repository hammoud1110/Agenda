package com.mycompany;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	PanelCalc pCalc = new PanelCalc("PanelCalc");
	PanelReminder pReminder = new PanelReminder("PanelReminder");
	PanelRest pRest = new PanelRest("PanelRest");

	public HomePage(final PageParameters parameters) {
		super(parameters);
		
		add(pCalc);
		add(pReminder);
		add(pRest);
    }

}
