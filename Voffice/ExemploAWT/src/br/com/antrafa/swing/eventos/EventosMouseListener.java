package br.com.antrafa.swing.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicado");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse Pressionado");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse Solto");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse Hover");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse Hover out");
		
	}

}
