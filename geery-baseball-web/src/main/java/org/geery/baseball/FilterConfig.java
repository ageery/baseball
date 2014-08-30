package org.geery.baseball;

import org.apache.wicket.protocol.http.WicketFilter;
import org.geery.baseball.web.app.BaseballWebApp;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Registers web filters.
 */
@Configuration
public class FilterConfig {
	
	/**
	 * @return Wicket filter
	 */
	@Bean
	public FilterRegistrationBean getWicketFiler() {
		WicketFilter wicketFilter = new WicketFilter(new BaseballWebApp());
		wicketFilter.setFilterPath("/");
		return new FilterRegistrationBean(wicketFilter);
	}

}
