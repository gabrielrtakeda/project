package project.modules.Passage.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Passage.View.Template.PassageConsultTemplate;
import project.modules.Passage.View.Template.PassageConsultResultTemplate;

public class PassageConsultResultView extends AbstractView
{
    public PassageConsultResultView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Check In"));
        setTemplate(new PassageConsultResultTemplate(configuration));
        showTemplate();
    }
}
