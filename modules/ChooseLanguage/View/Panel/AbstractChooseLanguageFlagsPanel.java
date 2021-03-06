package project.modules.ChooseLanguage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.TransparentButton;
import project.modules.ChooseLanguage.View.ActionListener.ChooseLanguageActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class AbstractChooseLanguageFlagsPanel extends JPanel
{
    protected String[] arLanguages = {"br", "uk", "es", "fr"};
    protected String resourceDirectory = "/images/flags/";

    private ConfigurationEntity configuration;
    private EmptyBorder margin;
    private String iconSize;
    private Dimension flagButtonSize;

    public AbstractChooseLanguageFlagsPanel(ConfigurationEntity configuration,
                                            EmptyBorder margin,
                                            String iconSize,
                                            Dimension flagButtonSize)
    {
        super(new GridLayout(1, 4));
        this.configuration = configuration;
        this.margin = margin;
        this.iconSize = iconSize;
        this.flagButtonSize = flagButtonSize;
        build();
    }

    protected void build()
    {
        setBorder(margin);
        for (String language : arLanguages) {
            TransparentButton button =
                new TransparentButton(
                    new ImageIcon(
                        getClass().getResource(
                            resourceDirectory + language + "_" + iconSize + ".png"
                        )
                    ),
                    flagButtonSize
                );
            button.addActionListener(new ChooseLanguageActionListener(configuration));
            button.setActionCommand(language);
            add(button);
        }
    }
}
