package br.com.locadora.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.locadora.Veiculo;

@ManagedBean
@ViewScoped
public class VeiculoMB {
		
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	private Veiculo veiculo = new Veiculo();
	
	public VeiculoMB(){
		
		Veiculo v = new Veiculo();
		v.setNome("Fiesta");
		v.setModelo("Sedan");
		veiculos.add(v);

		v = new Veiculo();
		v.setNome("Herbie");
		v.setModelo("Fusca");
		veiculos.add(v);

		v = new Veiculo();
		v.setNome("Pálio");
		v.setModelo("Fire");
		veiculos.add(v);

		v = new Veiculo();
		v.setNome("Gol");
		v.setModelo("G3");
		veiculos.add(v);		
		
		limpaVeiculo();
		
	}	

	public void insereVeiculo(){
		veiculos.add(veiculo);
		limpaVeiculo();
	}
	
	public Veiculo getVeiculo(){
		return this.veiculo;
	}
	
	public List<Veiculo> getVeiculos(){
		return this.veiculos;
	}
	
	private void limpaVeiculo(){
		veiculo = new Veiculo();
	}
	
}
