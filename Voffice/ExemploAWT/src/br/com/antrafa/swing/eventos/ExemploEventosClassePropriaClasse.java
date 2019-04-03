package br.com.antrafa.swing.eventos;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExemploEventosClassePropriaClasse extends JFrame implements MouseListener {

	public ExemploEventosClassePropriaClasse(String titulo){
		super(titulo);
		setSize(300,200);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel jlabel = new JLabel("teste");
		add(jlabel);
		
		JButton botao = new JButton("Fechar");
		botao.setMnemonic(KeyEvent.VK_F);
		botao.addMouseListener(this);
		add(botao);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ExemploEventosClassePropriaClasse janela = new ExemploEventosClassePropriaClasse("Primeira Janela");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
