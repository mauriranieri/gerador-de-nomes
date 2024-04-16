package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 * @author Mauri Ranieri
 */

public class Painel extends JPanel {

    private JLabel geradorNomesLabel;
    private JRadioButton botaoMasculino;
    private JRadioButton botaoFeminino;
    private JButton botaoGerarNome;
    private JTextField campoTexto;
    
    public Painel() {
        configurarPainel();
        configurarComponentes();
        adicionarComponentes();
    }   
    
    private void configurarPainel() {
        this.setPreferredSize(new Dimension(800, 400));
        this.setBackground(Color.decode("#2d2938"));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED)); 
        this.setLayout(null);
    }
    
    private void configurarComponentes() {
        configurarGeradorNomesLabel();
        configurarCampoTexto();
        configurarBotaoGerarNome();
        botaoMasculino = criarBotaoEscolha("Masculino", 200, 200);
        botaoFeminino = criarBotaoEscolha("Feminino", 500, 200);
    }
    
    private void configurarGeradorNomesLabel() {
        geradorNomesLabel = new JLabel("Gerador de Nomes");
        geradorNomesLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        geradorNomesLabel.setBounds(140, 100, 520, 50);
        geradorNomesLabel.setForeground(Color.WHITE);
    }
    
    private void configurarCampoTexto() {
        campoTexto = new JTextField("Nome a ser gerado");
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 16));
        campoTexto.setBounds(125, 250, 400, 50);
        campoTexto.setMargin(new Insets(0, 20, 0, 0));
        campoTexto.setEditable(false);
    }
    
    private void configurarBotaoGerarNome() {
        botaoGerarNome = new JButton("Criar Nome");
        botaoGerarNome.setBounds(525, 250, 150, 50);
        botaoGerarNome.setBackground(Color.decode("#0172d5"));
        botaoGerarNome.setForeground(Color.WHITE);
        botaoGerarNome.setFocusable(false);
        botaoGerarNome.setEnabled(false);
        botaoGerarNome.setFont(new Font("Arial", Font.PLAIN, 16));
    }
    
    private void adicionarComponentes() {
        BotaoEscolhaAcao botaoEscolhaAcao = new BotaoEscolhaAcao(botaoMasculino, botaoFeminino, botaoGerarNome);
        botaoMasculino.addItemListener(botaoEscolhaAcao);
        botaoFeminino.addItemListener(botaoEscolhaAcao);
        botaoGerarNome.addActionListener(new BotaoGerarAcao(botaoEscolhaAcao, campoTexto));
        
        this.add(geradorNomesLabel);
        this.add(botaoMasculino);
        this.add(botaoFeminino);
        this.add(campoTexto);
        this.add(botaoGerarNome);
        
    }
    
    private JRadioButton criarBotaoEscolha(String sexo, int posx, int posy) {
        JRadioButton botaoEscolha = new JRadioButton(sexo);
        botaoEscolha.setFont(new Font("Arial", Font.PLAIN, 15));
        botaoEscolha.setBounds(posx, posy, 100, 40);
        botaoEscolha.setOpaque(false);
        botaoEscolha.setForeground(Color.WHITE);
        botaoEscolha.setFocusable(false);
        
        return botaoEscolha;
    }
}
