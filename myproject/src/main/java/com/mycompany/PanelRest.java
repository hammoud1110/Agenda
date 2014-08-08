/**
 * 
 * @author Hammoud
 * @version 1.0
 */
package com.mycompany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class PanelRest extends Panel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelRest(String id) {
		super(id);

		List<Product> catalog = new ArrayList<Product>();

		catalog.add(new Product("p01", "Pencil", "a", 1.20));
		catalog.add(new Product("p02", "Eraser", "b", 2.00));
		catalog.add(new Product("p03", "Ball pen", "c", 3.50));
		ListView<Product> eachProduct = new ListView<Product>("eachProduct",
				catalog) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			protected void populateItem(ListItem<Product> item) {
				final Product p = (Product) item.getModelObject();
				item.add(new Label("id", new PropertyModel(p, "id")));
//				item.add(new Label("name", new PropertyModel(p, "name")));
				item.add(new Label("price", new PropertyModel(p, "price")));

				Link detailsLink = new Link("detailsLink") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void onClick() {
						ProductDetails details = new ProductDetails(p);
						setResponsePage(details);
					}
				};
				detailsLink.add(new Label("name",new PropertyModel(p, "name")));
				item.add(detailsLink);
			}
		};
		add(eachProduct);
	}

}
