package br.com.antrafa;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;

public class JanelaSimples extends Frame {

	public JanelaSimples(String titulo){
		
		this.setTitle(titulo);
		this.setSize(300, 200);
		
		Label label = new Label("Label comum");
		this.add(label);
		
		Button botao = new Button("botao");
		this.add(botao);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		JanelaSimples janela = new JanelaSimples("Primeira Janela");
	}
}