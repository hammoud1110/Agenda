/**
 * 
 * @author Hammoud
 * @version 1.0
 */

package com.mycompany;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormChoiceComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class PanelReminder extends Panel implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public boolean connect=false;
	ReminderBean rBean = new ReminderBean();

	public PanelReminder(String id) {
		super(id);
		ReminderController.connect();
		Form form = new Form("form");
		add(form);

		TextField<String> tfName = new TextField<String>("tfName",
				new PropertyModel<String>(rBean, "tfName"));

		tfName.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});

		TextField<String> tfAdresse = new TextField<String>("tfAdresse",
				new PropertyModel<String>(rBean, "tfAdresse"));
		tfAdresse.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});

		// TextField<String> tfStadt = new TextField<String>("tfStadt",
		// new PropertyModel<String>(rBean, "tfStadt"));

		TextField<String> tfFaxNb = new TextField<String>("tfFaxNb",
				new PropertyModel<String>(rBean, "tfFaxNb"));

		tfFaxNb.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});

		TextField<String> tfPhone = new TextField<String>("tfPhone",
				new PropertyModel<String>(rBean, "tfPhone"));

		tfPhone.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});
		TextField<String> tfHandy = new TextField<String>("tfHandy",
				new PropertyModel<String>(rBean, "tfHandy"));
		tfHandy.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});
		TextField<String> tfEmail = new TextField<String>("tfEmail",
				new PropertyModel<String>(rBean, "tfEmail"));

		tfEmail.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});
		DropDownChoice tfStadt = new DropDownChoice("tfStadt",
				new PropertyModel<String>(rBean, "ddStadt"),
				Stadt.getStringValues());

		tfStadt.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});

		form.add(tfName, tfAdresse, tfStadt, tfFaxNb, tfPhone, tfHandy, tfEmail);
		form.add(creatTextArea());
		form.add(createTextField());
		form.add(new AjaxLink("saveButton") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
//				if(connect==false){
//				 connect = ReminderController.connect();
//				System.out.println(connect);
//				}
//				ReminderController.save(rBean);
				
				connect = ReminderController.connect();
				ReminderController.save(rBean);
				ReminderController.load(rBean);

			}
		});

		add(new PhoneBookPanel("phonePanel"));
		
		add(new TaskOverviewPanel("taskOverview"));
		

	}

	public TextArea<String> creatTextArea() {

		TextArea<String> tfNotiz = new TextArea<String>("tfNotiz",
				new PropertyModel<String>(rBean, "tfNotiz"));
		tfNotiz.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});

		return tfNotiz;

	}

	public DateTextField createTextField() {

		DateTextField dateTextField = new DateTextField("dateTextField",
				new PropertyModel<Date>(rBean, "datePicker"),
				new StyleDateConverter("S-", true));
		DatePicker datePicker = new DatePicker();
		datePicker.setShowOnFieldClick(true);
		datePicker.setAutoHide(true);
		dateTextField.add(datePicker);
		dateTextField.add(new OnChangeAjaxBehavior() {

			@Override
			protected void onUpdate(AjaxRequestTarget target) {

			}
		});
		return dateTextField;

	}

}
