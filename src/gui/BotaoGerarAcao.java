package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import nomes_pessoas.NomesPessoas;

/**
 * @author Mauri Ranieri
 */

public class BotaoGerarAcao implements ActionListener {

    private final BotaoEscolhaAcao botaoEscolhaAcao;
    private final JTextField campoTexto;
    
    public BotaoGerarAcao(BotaoEscolhaAcao botaoEscolhaAcao, JTextField campoTexto) {
        this.botaoEscolhaAcao = botaoEscolhaAcao;
        this.campoTexto = campoTexto;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(new NomesPessoas().arraysEstaoNulosOuVazios()) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar um nome!", "Erro no Programa", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if(botaoEscolhaAcao.selecionarBotaoMasculino()) {
            campoTexto.setText(new NomesPessoas().gerarNome("nomes masculinos"));
        }
        if(botaoEscolhaAcao.selecionarBotaoFeminino()) {
            campoTexto.setText(new NomesPessoas().gerarNome("nomes femininos"));
        }
    }
}
