package project.modules.Airport.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Airport.Controller.AirportController;
import java.awt.event.ActionEvent;

public class AirportMenuViewActionListener extends AbstractActionListener
{
    public AirportMenuViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().menuAction();
    }

    private AirportController getController()
    {
        return new AirportController(configuration);
    }
}
