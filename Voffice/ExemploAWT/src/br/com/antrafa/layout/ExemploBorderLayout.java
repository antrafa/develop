package br.com.antrafa.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExemploBorderLayout extends JFrame {
	
	public ExemploBorderLayout(){
		
		super("Exemplo de FlowLayout");
		this.setLayout(new BorderLayout());
		setSize(300,200);
		add(new JLabel("Sistema"),BorderLayout.NORTH);
		add(montaPainelBotoes(), BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public JPanel montaPainelBotoes(){
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.setBackground(new Color(255, 255, 255));
		
		p.add(new JButton("Salvar"));
		p.add(new JButton("Excluir"));
		p.add(new JButton("Listar"));
		
		return p;
	}

	public static void main(String[] args) {
		ExemploBorderLayout frame = new ExemploBorderLayout();
	}
}
