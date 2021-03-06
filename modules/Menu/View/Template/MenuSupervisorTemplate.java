package project.modules.Menu.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Menu.View.Panel.MenuAtendentePanel;
import project.modules.Menu.View.Panel.MenuSupervisorPanel;
import java.awt.BorderLayout;

public class MenuSupervisorTemplate extends AbstractTemplate
{
    public MenuSupervisorTemplate(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setTemplate(this));
        setLayout(new BorderLayout());
        add(new ApplicationBaseLayoutHeaderPanel(configuration), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(configuration), BorderLayout.SOUTH);
        add(new MenuSupervisorPanel(configuration));
    }
}
