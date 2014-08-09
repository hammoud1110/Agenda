/**
 * 
 * @author Hammoud
 * @version 1.0
 */
package com.mycompany;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.SharedResourceReference;

public class PhoneBookPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ReminderBean> rBeanList = new ArrayList<ReminderBean>();
	private ListView<ReminderBean>  eachEntry;
	private final Form form;
	// PhoneBook.getGlobal() .getEntries()
	public PhoneBookPanel(String id) {
		super(id);
		form = new Form("form");
		add(form).setOutputMarkupPlaceholderTag(true);
		
		rBeanList=ReminderController.load(rBeanList);
		eachEntry = new ListView<ReminderBean> ("eachEntry", rBeanList) {
			protected void populateItem(ListItem<ReminderBean>  item) {
//				item.setModel(new CompoundPropertyModel(item.getModelObject()));
				ReminderBean r = (ReminderBean) item.getModelObject();
				item.add(new AttributeModifier("class", true, new Model(item
						.getIndex() % 2 == 0 ? "even" : "odd")));
				item.add(new Label("id",r.getTfID()));
				item.add(new Label("firstName",r.getTfName()));
				item.add(new Label("lastName",r.getTfEmail()));
				item.add(new Label("telNo",r.getTfPhone()));
				item.add(createDeleteButton(item));
			}

		};
		
		
		
		form.add(new AjaxLink("refreshLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				rBeanList=ReminderController.load(rBeanList);
				target.add(form);
				
			}
		});
		
		//
		
//		String url = null;
//		ExternalLink link = new ExternalLink("link", url);
//		Image image = new Image("img", new SharedResourceReference(PhoneBookPanel.class, "images/MyImage.png"));
//		link.add(image);
//		add(link);
		///
		
		form.add(eachEntry);
	}

	public Form createDeleteButton(final ListItem item) {

		Form deleteForm = new Form("deleteForm");
		deleteForm.add(new AjaxLink("deleteLink") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				
				rBeanList.remove((ReminderBean) item.getModelObject());
				target.add(form);
			}
		});
		return deleteForm;

	}

}