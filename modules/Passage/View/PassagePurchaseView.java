package project.modules.Passage.View;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.AbstractView;
import project.modules.Passage.View.Template.PassagePurchaseTemplate;
import project.modules.Menu.View.Template.MenuSupervisorTemplate;
import project.modules.Menu.View.Template.MenuAtendenteTemplate;

public class PassagePurchaseView extends AbstractView
{
    public PassagePurchaseView(ConfigurationEntity configuration)
    {
        configuration.setView(this);
        setConfiguration(configuration);

        setTitle(configuration.getTranslator().__("Compra de Passagem"));
        setTemplate(new PassagePurchaseTemplate(configuration));
        showTemplate();
    }
}
