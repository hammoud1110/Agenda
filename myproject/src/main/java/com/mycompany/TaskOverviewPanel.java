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
import org.junit.internal.runners.model.EachTestNotifier;

public class TaskOverviewPanel extends Panel {
	ReminderBean rBean = new ReminderBean();
	public Form showForm;
	public Form hideForm;
	public Form tableForm;
	public boolean visibility = false;
	public ListView<String> eachEntry;

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
			@Override
			protected void onConfigure() {
				setVisible(visibility);
			}
		};
		tableForm.setOutputMarkupId(true).setOutputMarkupPlaceholderTag(true);
		add(tableForm);
		ReminderController.load(rBean);

		eachEntry = new ListView("eachEntry", rBean.getrBeanList()) {
			protected void populateItem(ListItem item) {
				item.setModel(new CompoundPropertyModel(item.getModelObject()));

				item.add(new Label("id"));
				item.add(new Label("name"));
				item.add(new Label("stadt"));
				item.add(new Label("age"));
				item.add(new Label("adresse"));
				item.add(new Label("fax"));
				item.add(new Label("handy"));
				item.add(new Label("telefon"));
				item.add(new Label("email"));
				item.add(new Label("notiz"));

			}

		};
		eachEntry.setOutputMarkupId(true);
		tableForm.add(eachEntry);
	}

}
