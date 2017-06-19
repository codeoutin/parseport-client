package com.winfo.project2.client.basic.GUI;

import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;

import java.io.File;

/**
 * Created by patrick on 13.06.17.
 */
public class MainUILogic extends MainUI {
    public MainUILogic() {


        homepageButton.addClickListener(e -> {


            //ClientUI.setCurrent(UI.getCurrent());
            //remove und add geht hier nicht

            mainContent.removeAllComponents();
            mainContent.addComponent(new HomepageUI().getLayout());
        });

        // Find the application directory
        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();

        // Image as a file resource
        FileResource resource = new FileResource(new File(basepath+ "Images/ParsePortLogo.png"));

        logo.setSource( resource );

        uploadButton.addClickListener(e -> {
            mainContent.removeAllComponents();
            mainContent.addComponent(new UploadUI().getLayout());
        });

        aboutbutton.addClickListener(e -> {
            mainContent.removeAllComponents();
            mainContent.addComponent(new AboutUI().getLayout());
        });

        dataButton.addClickListener(e -> {
            mainContent.removeAllComponents();
            mainContent.addComponent(new DataUI().getLayout());
        });

        settingsButton.addClickListener(e -> {
            mainContent.removeAllComponents();
            mainContent.addComponent(new SettingsUI().getLayout());
        });

        contactButton.addClickListener(e -> {
            mainContent.removeAllComponents();
            mainContent.addComponent(new ContactUI().getLayout());
        });
    }
}
