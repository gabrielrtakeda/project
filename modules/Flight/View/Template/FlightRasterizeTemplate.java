package project.modules.Flight.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Flight.View.Panel.FlightRasterizePanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class FlightRasterizeTemplate extends AbstractTemplate
{
    public FlightRasterizeTemplate(ConfigurationEntity configuration)
    {
        configuration.setTemplate(this);
        setConfiguration(configuration);

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(new ApplicationBaseLayoutHeaderPanel(configuration), BorderLayout.NORTH);
        add(new ApplicationBaseLayoutFooterPanel(configuration), BorderLayout.SOUTH);
        add(new FlightRasterizePanel(configuration), BorderLayout.CENTER);
    }
}
