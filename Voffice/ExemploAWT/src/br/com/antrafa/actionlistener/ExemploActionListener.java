package br.com.antrafa.actionlistener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.antrafa.layout.ExemploBorderLayout;

public class ExemploActionListener extends JFrame {
	
	public ExemploActionListener(){
		
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
		
		JButton botao = new JButton("Salvar");
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Acao executada");	
			}
		});
		
		p.add(botao);

		p.add(new JButton("Excluir"));
		p.add(new JButton("Listar"));
		
		return p;
	}

	public static void main(String[] args) {
		ExemploActionListener frame = new ExemploActionListener();
	}
}