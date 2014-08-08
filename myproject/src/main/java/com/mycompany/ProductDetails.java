/**
 * 
 * @author Hammoud
 * @version 1.0
 */
package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class ProductDetails extends WebPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductDetails(Product p) {
		add(new Label("title", p.getName()));
		add(new Label("heading", p.getName()));
		add(new Label("desc", p.getDesc()));
	}
}