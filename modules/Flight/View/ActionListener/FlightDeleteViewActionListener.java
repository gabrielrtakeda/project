package project.modules.Flight.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Flight.Controller.FlightController;
import java.awt.event.ActionEvent;

public class FlightDeleteViewActionListener extends AbstractActionListener
{
    public FlightDeleteViewActionListener(ConfigurationEntity configuration)
    {
        configuration.setActionListener(this);
        setConfiguration(configuration);
    }

    public void actionPerformed(ActionEvent e)
    {
        getController().deleteConsultAction();
    }

    private FlightController getController()
    {
        return new FlightController(configuration);
    }
}
