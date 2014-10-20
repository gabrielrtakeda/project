package project.modules.Airport.View.Template;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Template.AbstractTemplate;
import project.modules.Application.View.Panel.ApplicationBaseLayoutHeaderPanel;
import project.modules.Application.View.Panel.ApplicationBaseLayoutFooterPanel;
import project.modules.Airport.View.Panel.AirportConsultResultPanel;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;

public class AirportConsultResultTemplate extends AbstractTemplate
{
	public AirportConsultResultTemplate(ConfigurationEntity configuration)
	{
		configuration.setTemplate(this);
		setConfiguration(configuration);

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(new ApplicationBaseLayoutHeaderPanel(configuration), BorderLayout.NORTH);
		add(new ApplicationBaseLayoutFooterPanel(configuration), BorderLayout.SOUTH);
		add(new AirportConsultResultPanel(configuration), BorderLayout.CENTER);
	}
}