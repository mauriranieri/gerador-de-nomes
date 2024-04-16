package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 * @author Mauri Ranieri
 */

public class BotaoEscolhaAcao implements ItemListener {
    
    private final JRadioButton botaoMasculino;
    private final JRadioButton botaoFeminino;
    private final JButton botaoGerarNome;
    
    public BotaoEscolhaAcao(JRadioButton botaoMasculino, JRadioButton botaoFeminino, JButton botaoGerarNome) {
        this.botaoMasculino = botaoMasculino;
        this.botaoFeminino = botaoFeminino;
        this.botaoGerarNome = botaoGerarNome;
    }
    
    public boolean selecionarBotaoMasculino() {
        return botaoMasculino.isSelected();
    }
    
    public boolean selecionarBotaoFeminino() {
        return botaoFeminino.isSelected();
    }
    
    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            if (event.getSource() == botaoMasculino && botaoMasculino.isSelected()) {
                botaoFeminino.setSelected(false);
            } else if (event.getSource() == botaoFeminino && botaoFeminino.isSelected()) {
                botaoMasculino.setSelected(false);
            }
        }
        alternarBotaoGerarNome();
    }
    
    private void alternarBotaoGerarNome() {
        if(!botaoMasculino.isSelected() && !botaoFeminino.isSelected()) {
            botaoGerarNome.setEnabled(false);
        } else {
            botaoGerarNome.setEnabled(true);
        }
    }
}
