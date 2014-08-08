/**
 * 
 * @author Hammoud
 * @version 1.0
 */
package com.mycompany;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

public class PhoneBookPanel extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PhoneBookPanel(String id) {
		super(id);
		ListView eachEntry = new ListView("eachEntry", PhoneBook
				.getGlobal().getEntries()) {
			protected void populateItem(ListItem item) {
				item.setModel(new CompoundPropertyModel(item
						.getModelObject()));
				
				item.add(new AttributeModifier("class", true, new Model(item
						.getIndex() % 2 == 0 ? "even" : "odd")));
				item.add(new Label("id"));
				item.add(new Label("firstName"));
				item.add(new Label("lastName"));
				item.add(new Label("telNo"));
				item.add(createDeleteButton(item));
			}
			
		};
		add(eachEntry);
	}
	
	public Form createDeleteButton(final ListItem item){
		
		Form deleteForm= new Form("deleteForm");

		return deleteForm;
	
}
		
	
}