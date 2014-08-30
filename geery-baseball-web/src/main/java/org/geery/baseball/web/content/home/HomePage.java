package org.geery.baseball.web.content.home;

import org.apache.wicket.markup.html.basic.Label;
import org.geery.baseball.web.page.AbstractBasePage;

public class HomePage extends AbstractBasePage<Void> {

	public HomePage() {
		super();
		add(new Label("label", "Baseball Home"));
	}
	
}
