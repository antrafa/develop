package br.com.antrafa.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploFlowLayout extends JFrame {
	
	public ExemploFlowLayout(){
		
		super("Exemplo de FlowLayout");
		setSize(300,200);
		add(montaPainelBotoes());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public JPanel montaPainelBotoes(){
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		p.add(new JButton("Salvar"));
		p.add(new JButton("Excluir"));
		p.add(new JButton("Listar"));
		
		return p;
	}

	public static void main(String[] args) {
		ExemploFlowLayout frame = new ExemploFlowLayout();
	}
}
