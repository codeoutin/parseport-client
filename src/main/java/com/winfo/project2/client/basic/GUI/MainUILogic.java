package com.winfo.project2.client.basic.GUI;

import com.vaadin.server.Page;
import com.vaadin.ui.UI;

/**
 * Created by patrick on 13.06.17.
 */
public class MainUILogic extends MainUI {
    public MainUILogic() {


        homepageButton.addClickListener(e -> {
            //scheiße aber geht
            //Page.getCurrent().reload();
            System.out.println("homepage");

            //ClientUI.setCurrent(UI.getCurrent());
            //remove und add geht hier nicht

            mainContent.removeAllComponents();
            mainContent.addComponent(new HomepageUI().getLayout());
        });

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
