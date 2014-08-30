package org.geery.baseball.web.page;

import java.util.Locale;

import org.apache.wicket.Component;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.ChromeFrameMetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.OptimizedMobileViewportMetaTag;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCssReference;

public class AbstractBasePage<T> extends GenericWebPage<T> {

    /**
     * Title of this page.
     */
    protected static final String RESKEY_PAGE_TITLE = "page.title";

    /**
     * Description of this page.
     */
    protected static final String RESKEY_DESCRIPTION = "page.description";

    /**
     * Author of this page.
     */
    protected static final String RESKEY_AUTHOR = "page.author";

    /*
     * Component IDs.
     */
    private static final String CID_TITLE = "title";
    private static final String CID_DEBUG = "debug";

    /*
     * Components.
     */
    private Component debugBar;

    public AbstractBasePage() {
    	super();
    }

    public AbstractBasePage(PageParameters pageParameters) {
    	super(pageParameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        // add HTML declaration
        add(new HtmlTag("html", Locale.ENGLISH));

        // add Bootstrap
        add(new BootstrapBaseBehavior());
        add(new OptimizedMobileViewportMetaTag("viewport"));
        add(new ChromeFrameMetaTag("chrome-frame"));
        add(new MetaTag("description", Model.of("description"), getPageDescriptionModel()));
        add(new MetaTag("author", Model.of("author"), getPageAuthorModel()));
        add(new Label(CID_TITLE, getPageTitleModel()));
        add(debugBar = new DebugBar(CID_DEBUG, false)
                .add(new AttributeAppender("style", " z-index: 1500; padding: 3px;")));
        debugBar.setVisible(true);
    }

    @Override
    public void renderHead(final IHeaderResponse response) {
        response.render(CssHeaderItem.forReference(FontAwesomeCssReference.instance()));
    }

//    @Override
//    public AbstractAuthenticatedWebSession getSession() {
//        return (AbstractAuthenticatedWebSession) super.getSession();
//    }

    /**
     * Returns the page title model.
     *
     * @return model for the page title
     */
    protected IModel<String> getPageTitleModel() {
        return new ResourceModel(RESKEY_PAGE_TITLE);
    }

    /**
     * Returns the page description model.
     *
     * @return model for the page description
     */
    protected IModel<String> getPageDescriptionModel() {
        return new StringResourceModel(RESKEY_DESCRIPTION, this, null);
    }

    /**
     * Returns the page author model.
     *
     * @return model for the page author
     */
    protected IModel<String> getPageAuthorModel() {
        return new StringResourceModel(RESKEY_AUTHOR, this, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setHeaders(final WebResponse response) {
        super.setHeaders(response);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache, max-age=0, must-revalidate, no-store");
    }
}
