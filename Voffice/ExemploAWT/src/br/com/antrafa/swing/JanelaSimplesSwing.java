package br.com.antrafa.swing;

import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaSimplesSwing extends JFrame {

	public JanelaSimplesSwing(String titulo){
		super(titulo);
		setSize(300,200);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel jlabel = new JLabel("teste");
		add(jlabel);
		
		JButton botao = new JButton("Fechar");
		botao.setMnemonic(KeyEvent.VK_F);
		add(botao);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		JanelaSimplesSwing janela = new JanelaSimplesSwing("Primeira Janela");
	}
}
