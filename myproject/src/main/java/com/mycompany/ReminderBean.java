/**
 * 
 * @author Hammoud
 * @version 1.0
 */
package com.mycompany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReminderBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tfDate;
	private String tfTime;
	private String tfTask;
	private int id;
	

	private String tfIDDelete;
	private String tfName;

	private String tfAdresse;
	private String ddStadt;
	private String tfEmail;
	private String tfNotiz;

	private Date datePicker;
	private String tfPhone;
	private String tfFaxNb;
	private String tfHandy;
	private List<String> rBeanList = new ArrayList<String>();
	
	
	public List<String> getrBeanList() {
		// ID,NAME,STADT,AGE,ADDRESS,FAX, HANDY, TELEFON, EMAIL, NOTIZ
		rBeanList.add(getTfName());
		rBeanList.add(getDdStadt());
		rBeanList.add(ReminderController.convertDateToString(getDatePicker()));
		rBeanList.add(getTfAdresse());
		rBeanList.add(getTfFaxNb());
		rBeanList.add(getTfHandy());
		rBeanList.add(getTfPhone());
		rBeanList.add(getTfEmail());
		rBeanList.add(getTfNotiz());
		
		
		return rBeanList;
	}

	public String getTfPhone() {
		return tfPhone;
	}

	public void setTfPhone(String tfPhone) {
		this.tfPhone = tfPhone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTfDate() {
		return tfDate;
	}

	public void setTfDate(String tfDate) {
		this.tfDate = tfDate;
	}

	public String getTfTime() {
		return tfTime;
	}

	public void setTfTime(String tfTime) {
		this.tfTime = tfTime;
	}

	public String getTfTask() {
		return tfTask;
	}

	public void setTfTask(String tfTask) {
		this.tfTask = tfTask;
	}

	public String getTfFaxNb() {
		return tfFaxNb;
	}

	public void setTfFaxNb(String tfFaxNb) {
		this.tfFaxNb = tfFaxNb;
	}

	public String getTfIDDelete() {
		return tfIDDelete;
	}

	public void setTfIDDelete(String tfIDDelete) {
		this.tfIDDelete = tfIDDelete;
	}

	public String getTfName() {
		return tfName;
	}

	public void setTfName(String tfName) {
		this.tfName = tfName;
	}

	public String getTfAdresse() {
		return tfAdresse;
	}

	public void setTfAdresse(String tfAdresse) {
		this.tfAdresse = tfAdresse;
	}

	public String getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(String tfEmail) {
		this.tfEmail = tfEmail;
	}

	public String getTfNotiz() {
		return tfNotiz;
	}

	public void setTfNotiz(String tfNotiz) {
		this.tfNotiz = tfNotiz;
	}

	public String getTfHandy() {
		return tfHandy;
	}

	public void setTfHandy(String tfHandy) {
		this.tfHandy = tfHandy;
	}

	public Date getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(Date datePicker) {
		this.datePicker = datePicker;
	}

	public String getDdStadt() {
		return ddStadt;
	}

	public void setDdStadt(String ddStadt) {
		this.ddStadt = ddStadt;
	}
}
