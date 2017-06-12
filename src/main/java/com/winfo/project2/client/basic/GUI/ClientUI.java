package com.winfo.project2.client.basic.GUI;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import sun.applet.Main;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class ClientUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final MainUILogic mainUILogic = new MainUILogic();

        //Click Listener for navigation between the pages >> moved to MainUILogic
        // knackiger code hm
        setContent(mainUILogic);

        //startseite laden
        mainUILogic.mainContent.removeAllComponents();
        mainUILogic.mainContent.addComponent(new HomepageUI().getLayout());
    }

    //kann man getrost wieder löschen, dann verschwindet die warnung. liebe gruesse ihr herr steger
    public ClientUI() {
        showNotification("Halt STOP","Achtung achtung der Kack VPN muss an sein, bevor du auf DATA klickst.", Notification.Type.WARNING_MESSAGE);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ClientUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
