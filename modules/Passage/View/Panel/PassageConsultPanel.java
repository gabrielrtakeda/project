package project.modules.Passage.View.Panel;

import project.modules.Application.Entity.ConfigurationEntity;
import project.modules.Application.View.Button.ImageButton;
import project.modules.Application.View.Layout.AbstractGridBagLayout;
import project.modules.Application.View.Layout.ColoredGridLayout;
import project.modules.Application.View.Layout.ComponentCreatePattern;
import project.modules.Passage.View.ActionListener.PassageConsultNavigationActionListener;
import project.modules.Passage.View.ActionListener.PassageConsultResultActionListener;
import project.modules.Passenger.View.Panel.PassengerInformationsPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class PassageConsultPanel extends JPanel
{
    public static Boolean SHOW_NAVIGATION_BUTTON = true;
    public static Boolean HIDE_NAVIGATION_BUTTON = false;

    private ConfigurationEntity configuration;

    public PassageConsultPanel(ConfigurationEntity configuration)
    {
        this.configuration = configuration;
        buildContent(SHOW_NAVIGATION_BUTTON);
    }

    public PassageConsultPanel( ConfigurationEntity configuration,
                                Boolean showNavigationButton)
    {
        this.configuration = configuration;
        buildContent(showNavigationButton);
    }

    private void buildContent(Boolean showNavigationButton)
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setLayout(gridBagLayout);

        if (showNavigationButton) {
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            AbstractGridBagLayout.addGridBagElement(
                this,
                ComponentCreatePattern.buildNavigationButton(
                    new PassageConsultNavigationActionListener(configuration)
                ),
                gridBagLayout,
                gridBagConstraints
            );
        }

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        AbstractGridBagLayout.addGridBagElement(
            this,
            ComponentCreatePattern.buildTitleLabel(
                configuration.getTranslator().__("Consultar Passagem")
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        Integer[] lineColumns = {1, 2};
        Dimension lineDimension = new Dimension(425, 30);

        Component[] components = {
            new JLabel(configuration.getTranslator().__("Código da Passagem") + ":"),
            new JTextField()
        };
        AbstractGridBagLayout.addGridBagElement(
            this,
            ColoredGridLayout.build(
                ColoredGridLayout.allBorders,
                Color.BLACK,
                lineDimension,
                lineColumns,
                new Color(204, 204, 204),
                components
            ),
            gridBagLayout,
            gridBagConstraints
        );

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        AbstractGridBagLayout.addGridBagElement(
            this,
            new ImageButton(
                configuration.getTranslator().__("Consultar"),
                "/images/buttonIcons/search.png",
                new Dimension(195, 45),
                new PassageConsultResultActionListener(configuration)
            ),
            gridBagLayout,
            gridBagConstraints
        );
    }
}
