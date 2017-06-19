package com.winfo.project2.client.basic.GUI;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.io.File;

/**
 * Created by patrick on 13.06.17.
 */
public class HomepageUI {
    public static final String VIEW_NAME = "home";

    public HomepageUI() {
    }

    public VerticalLayout getLayout() {
        Label headerLabel = new Label();
        headerLabel.setStyleName("h1");
        Label infoLabel = new Label();
        infoLabel.setStyleName("p");
        VerticalLayout vertical = new VerticalLayout ();

        headerLabel.setValue("ParsePort");
        infoLabel.setValue("Edit me, i'll wait at HomepageUI::21");
        infoLabel.setWidth("70%");


// Find the application directory
        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();

// Image as a file resource
        FileResource resource = new FileResource(new File(basepath+ "Images/ParsePortLogo.png"));

/*"C:/Users/laura/Documents/parseportclient/src/main/resources/Images/ParsePortLogo.png"));
*/
// Show the image in the application

        Image image = new Image("",resource);
        image.setWidth("40%");
/*
        Label loremIpsum = new Label();
        loremIpsum.setValue("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        loremIpsum.setWidth("70%");

*/

        vertical.addComponents(headerLabel, infoLabel, image);


//        mainContent.removeAllComponents();
//        mainContent.addComponents(vertical);

        return vertical;
    }
}
