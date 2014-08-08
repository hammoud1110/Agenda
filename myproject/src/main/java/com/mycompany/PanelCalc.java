/**
 * 
 * @author Hammoud
 * @version 1.0
 */
package com.mycompany;

import java.io.Serializable;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class PanelCalc extends Panel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s = "";
	String aktuelleZahl = "";
	int zeichen = 0;
	double gesamt = 0;
	
	Model<String> strMdl = Model.of("Click Button to Calc");
	TextField<String> tfAusgabe = new TextField<String>("tfAusgabe", strMdl);
	
	
	Form bEins = new Form("bEins"){
		protected void onSubmit(){	
			s = s + "1";
			aktuelleZahl = aktuelleZahl + "1";
			strMdl.setObject(s);
		}
	};
	Form bZwei = new Form("bZwei"){
		protected void onSubmit(){
			s = s + "2";
			aktuelleZahl = aktuelleZahl + "2";
			strMdl.setObject(s);
		}
	};
	Form bDrei = new Form("bDrei"){
		protected void onSubmit(){
			s = s + "3";
			aktuelleZahl = aktuelleZahl + "3";
			strMdl.setObject(s);
		}
	};
	Form bVier = new Form("bVier"){
		protected void onSubmit(){
			s = s + "4";
			aktuelleZahl = aktuelleZahl + "4";
			strMdl.setObject(s);
		}
	};
	Form bFuenf = new Form("bFuenf"){
		protected void onSubmit(){
			s = s + "5";
			aktuelleZahl = aktuelleZahl + "5";
			strMdl.setObject(s);
		}
	};
	Form bSechs = new Form("bSechs"){
		protected void onSubmit(){
			s = s + "6";
			aktuelleZahl = aktuelleZahl + "6";
			strMdl.setObject(s);
		}
	};
	Form bSieben = new Form("bSieben"){
		protected void onSubmit(){
			s = s + "7";
			aktuelleZahl = aktuelleZahl + "7";
			strMdl.setObject(s);
		}
	};
	Form bAcht = new Form("bAcht"){
		protected void onSubmit(){
			s = s + "8";
			aktuelleZahl = aktuelleZahl + "8";
			strMdl.setObject(s);
		}
	};
	Form bNeun = new Form("bNeun"){
		protected void onSubmit(){
			s = s + "9";
			aktuelleZahl = aktuelleZahl + "9";
			strMdl.setObject(s);
		}
	};
	Form bNull = new Form("bNull"){
		protected void onSubmit(){
			s = s + "0";
			aktuelleZahl = aktuelleZahl + "0";
			strMdl.setObject(s);
		}
	};
	Form bDelete = new Form("bDelete"){
		protected void onSubmit(){
			s =  "";
			gesamt = 0;
			zeichen = 0;
			aktuelleZahl = "";
			strMdl.setObject(s);
		}
	};
	Form bDeleteOne = new Form("bDeleteOne"){
		protected void onSubmit(){
			//DELETE ONE CHAR
			if(s.length() != 0){
				int laenge = s.length() - 1;
				s = s.substring(0, laenge);
			}
			//METHODE BERECHNE NEU
			strMdl.setObject(s);
		}
	};
	Form bPlus = new Form("bPlus"){
		protected void onSubmit(){
			s =  s + "+";
			if(aktuelleZahl != ""){
				gesamt = berechne(aktuelleZahl);
			}
			zeichen = 1;
			strMdl.setObject(s);
		}
	};
	Form bMinus = new Form("bMinus"){
		protected void onSubmit(){
			s =  s + "-";
			if(aktuelleZahl != ""){
				gesamt = berechne(aktuelleZahl);
			}
			zeichen = 2;
			strMdl.setObject(s);
		}
	};
	Form bMal = new Form("bMal"){
		protected void onSubmit(){
			s =  s + "x";
			if(aktuelleZahl != ""){
				gesamt = berechne(aktuelleZahl);
			}
			zeichen = 3;
			strMdl.setObject(s);
		}
	};
	Form bDurch = new Form("bDurch"){
		protected void onSubmit(){
			s =  s + "/";
			if(aktuelleZahl != ""){
				gesamt = berechne(aktuelleZahl);
			}
			zeichen = 4;
			strMdl.setObject(s);
		}
	};
	Form bPunkt = new Form("bPunkt"){
		protected void onSubmit(){
			s =  s + ".";
			aktuelleZahl = aktuelleZahl + ".";
			strMdl.setObject(s);
		}
	};
	Form bGleich = new Form("bGleich"){
		protected void onSubmit(){
			if(aktuelleZahl != ""){
				gesamt = berechne(aktuelleZahl);
			}
			s =  String.valueOf(gesamt);
			aktuelleZahl = "";
			strMdl.setObject(s);
		}
	};

	public PanelCalc(String id) {
		super(id);
		// TODO Auto-generated constructor stub
		add(bEins);
		add(bZwei);
		add(bDrei);
		add(bVier);
		add(bFuenf);
		add(bSechs);
		add(bSieben);
		add(bAcht);
		add(bNeun);
		add(bNull);
		add(bDelete);
		add(bDeleteOne);
		add(bPlus);
		add(bMinus);
		add(bMal);
		add(bDurch);
		add(bPunkt);
		add(bGleich);
		
		tfAusgabe.setOutputMarkupId(true);
		add(tfAusgabe);
	}
	
	public double berechne(String gedrueckt){
		double gedruecktInt = Double.parseDouble(gedrueckt);
		switch (zeichen) {
		case 1:
				gesamt = gesamt + gedruecktInt;
			break;
		case 2:
				gesamt = gesamt - gedruecktInt;
			break;
		case 3:
				gesamt = gesamt * gedruecktInt;
			break;
		case 4:
				gesamt = gesamt / gedruecktInt;
			break;
		default:
			gesamt = Double.parseDouble(aktuelleZahl);
			break;
		}
		aktuelleZahl = "";
		return gesamt;
	}
}
