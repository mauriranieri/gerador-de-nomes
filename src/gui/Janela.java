package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 * @author Mauri Ranieri
 */

public class Janela extends JFrame {
    
    private final Container contentPane = this.getContentPane();
    private final GridBagConstraints gbc = new GridBagConstraints();
    
    public Janela() {
        super("Gerador de Nomes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        configurarLayout();
        contentPane.add(new Painel(), gbc);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    private void configurarLayout() {
        contentPane.setBackground(Color.decode("#074D51"));
        this.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.CENTER;
    }    
}
