package project.modules.Authentication.View.Panel;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class AuthenticationHeaderPanel extends JPanel
{
    public AuthenticationHeaderPanel()
    {
        super(new GridBagLayout());
    	setBorder(new EmptyBorder(30, 0, 10, 0));
        add(
            new JLabel(
                new ImageIcon(getClass().getResource("/images/icons/lock.png"))
            )
        );
    }
}
