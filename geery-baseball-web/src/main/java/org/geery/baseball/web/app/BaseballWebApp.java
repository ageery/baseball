package org.geery.baseball.web.app;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.geery.baseball.web.content.home.HomePage;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.SingleThemeProvider;
import de.agilecoders.wicket.themes.markup.html.bootstrap.BootstrapThemeTheme;

public class BaseballWebApp extends WebApplication {

	@Override
	protected void init() {
		super.init();
		BootstrapSettings settings = new BootstrapSettings();
		Bootstrap.install(this, settings);
		settings.setThemeProvider(new SingleThemeProvider(new BootstrapThemeTheme()));
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

}
