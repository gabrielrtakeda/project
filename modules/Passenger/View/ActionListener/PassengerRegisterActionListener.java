package project.modules.Passenger.View.ActionListener;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.ActionListener.AbstractActionListener;
import project.modules.Passenger.Controller.PassengerController;
import java.awt.event.ActionEvent;

public class PassengerRegisterActionListener extends AbstractActionListener
{
    protected String nameModal = "passenger-register";

    public PassengerRegisterActionListener(ConfigurationEntity configuration)
    {
        setConfiguration(configuration.setActionListener(this));
    }

    public void actionPerformed(ActionEvent e)
    {
        configuration.setParameter("passenger-register-form-data", getComponents());
        getController().registerAndGoNextAction();
    }

    private PassengerController getController()
    {
        return new PassengerController(configuration);
    }
}
