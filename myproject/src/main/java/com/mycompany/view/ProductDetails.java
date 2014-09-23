/**
 * 
 * @author Hammoud
 * @version 1.0
 */
package com.mycompany.view;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;

import com.mycompany.HomePage;
import com.mycompany.model.Product;

public class ProductDetails extends WebPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ContextImage bleistiftImage;
	ContextImage RadiergummiImage;
	ContextImage kugelschreiberImage;
	
	
	public ProductDetails(Product p) {
		add(new Label("title", p.getName()));
		add(new Label("heading", p.getName()));
		add(new Label("desc",p.getDesc()));
		add(bleistiftImage = new ContextImage("bleistiftImage","bleistift.PNG"));
		add(RadiergummiImage = new ContextImage("RadiergummiImage","radiergummi.PNG"));
		add(kugelschreiberImage = new ContextImage("kugelschreiberImage","kugelschreiber.PNG"));
		
			if(p.getName().equals("Bleistift")){
				bleistiftImage.setVisible(true);
				RadiergummiImage.setVisible(false);
				kugelschreiberImage.setVisible(false);
			}
			if (p.getName().equals("Radiergummi")) {
				bleistiftImage.setVisible(false);
				RadiergummiImage.setVisible(true);
				kugelschreiberImage.setVisible(false);	
			}
			if (p.getName().equals("Kugelschreiber")) {
				bleistiftImage.setVisible(false);
				RadiergummiImage.setVisible(false);
				kugelschreiberImage.setVisible(true);
			}
		
			add(new Label("preis", "Preis: "+p.getPrice()+ " €"));
			
			Form form = new Form("form");
			add(form);
			form.add(new AjaxLink("kaufButton") {

				private static final long serialVersionUID = 1L;

				@Override
				public void onClick(AjaxRequestTarget target) {
				}
			});
			
			form.add(new AjaxLink("einkaufButton") {

				private static final long serialVersionUID = 1L;

				@Override
				public void onClick(AjaxRequestTarget target) {
				}
			});
			
	}
}