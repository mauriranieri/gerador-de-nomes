package main;

import javax.swing.SwingUtilities;
import gui.Janela;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> 
                        new Janela().setVisible(true));
    }
}
