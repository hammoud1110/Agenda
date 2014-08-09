package com.mycompany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.junit.internal.runners.model.EachTestNotifier;

public class TaskOverviewPanel extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1411187233945814779L;
	ReminderBean rBean = new ReminderBean();
	public Form showForm;
	public Form hideForm;
	public Form tableForm;
	public boolean visibility = false;
	public ListView<ReminderBean> eachEntry;

	public TaskOverviewPanel(String id) {
		super(id);
		setOutputMarkupPlaceholderTag(true);
		showForm = new Form("showForm");
		showForm.setOutputMarkupId(true).setOutputMarkupPlaceholderTag(true);
		add(showForm);

		hideForm = new Form("hideForm");
		hideForm.setOutputMarkupId(true).setOutputMarkupPlaceholderTag(true);
		add(hideForm);

		showForm.add(new AjaxLink("showButton") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				
				rBean=ReminderController.load(rBean);
				if (visibility == true) {

					tableForm.setVisibilityAllowed(false);
					visibility = false;
				} else {
					tableForm.setVisibilityAllowed(true);
					hideForm.setEnabled(true);
					showForm.setEnabled(false);
					visibility = true;
				}

				target.add(tableForm,hideForm,showForm);
			}
		});

		hideForm.add(new AjaxLink("hideButton") {

			private static final long serialVersionUID = 1L;
			@Override
			protected void onConfigure() {
				setEnabled(visibility);
			}

			@Override
			public void onClick(AjaxRequestTarget target) {
				rBean=ReminderController.load(rBean);
				if (visibility == false) {

					tableForm.setVisibilityAllowed(true);
					visibility = true;
				} else {
					tableForm.setVisibilityAllowed(false);
					hideForm.setEnabled(false);
					showForm.setEnabled(true);
					visibility = false;
				}

				target.add(tableForm,hideForm,showForm);
			}
		});

		tableForm = new Form("tableForm") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				setVisible(visibility);
			}
		};
		tableForm.setOutputMarkupId(true).setOutputMarkupPlaceholderTag(true);
		add(tableForm);
		

		final List<ReminderBean> rBeanList = new ArrayList<ReminderBean>();
		rBeanList.add(rBean);
		eachEntry = new ListView<ReminderBean>("eachEntry", rBeanList) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void populateItem(ListItem item) {
				ReminderBean r = (ReminderBean) item.getModelObject();
				
				item.add(new Label("id", Model.of("1")));
				item.add(new Label("name",r.getTfName()));
				item.add(new Label("stadt",new PropertyModel<String>(item.getDefaultModel(), "ddStadt")));
				item.add(new Label("age",new PropertyModel<String>(item.getDefaultModel(), "datePicker")));
				item.add(new Label("adresse",new PropertyModel<String>(item.getDefaultModel(), "tfAdresse")));
				item.add(new Label("fax",new PropertyModel<String>(item.getDefaultModel(), "tfFaxNb")));
				item.add(new Label("handy",new PropertyModel<String>(item.getDefaultModel(), "tfHandy")));
				item.add(new Label("telefon",new PropertyModel<String>(item.getDefaultModel(), "tfPhone")));
				item.add(new Label("email",new PropertyModel<String>(item.getDefaultModel(), "tfEmail")));
				item.add(new Label("notiz",new PropertyModel<String>(item.getDefaultModel(), "tfNotiz")));

			}

		};
		eachEntry.setOutputMarkupId(true);
		tableForm.add(eachEntry);
	}

}
