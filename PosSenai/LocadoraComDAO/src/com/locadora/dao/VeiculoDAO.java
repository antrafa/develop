package com.locadora.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.locadora.entidade.Veiculo;

public class VeiculoDAO extends BaseDAO {

		public Veiculo buscaPorNome(String nome){
			conectar();
			Veiculo veiculo = new Veiculo();
			
			try{
				ResultSet rs;
				rs = comando.executeQuery("select * from veiculo where nome = '"+nome+"'");
				while(rs.next()){
					veiculo.setId(rs.getInt("id"));
					veiculo.setNome(rs.getString("nome"));
					veiculo.setMarca(rs.getString("marca"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				fechar();
			}
			return veiculo;
		}
	
		public List<Veiculo> lista(){
			conectar();
			List<Veiculo> lista = new ArrayList<Veiculo>();
			try {
				ResultSet rs;
				rs = comando.executeQuery("select id, nome, transmissao, marca from veiculo");

				while (rs.next()) {
					Veiculo veiculo = new Veiculo();
					veiculo.setId(rs.getInt("id"));
					veiculo.setNome(rs.getString("nome"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setTransmissao(rs.getInt("transmissao"));

					lista.add(veiculo);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				fechar();
			}
			return lista;
		}
		
		public Veiculo buscaId(int id){
			conectar();
			Veiculo veiculo = new Veiculo();
			try {
				ResultSet rs;
				rs = comando.executeQuery("select id, nome from veiculo where id= "+id);

				while (rs.next()) {
					veiculo.setId(rs.getInt("id"));
					veiculo.setNome(rs.getString("nome"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				fechar();
			}
			return veiculo;
		}
		
		public void inserir(Veiculo veiculo){
			conectar();
			try {
				comando.execute("insert into veiculo (nome, marca, transmissao) values ('"+veiculo.getNome()+"', '"
						+veiculo.getMarca()+"', "+veiculo.getTransmissao()+")");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				fechar();
			}
		}
		
		public void atualizar(Veiculo veiculo){
			conectar();
			try{
				comando.execute("update veiculo set nome = '"+veiculo.getNome()
						+ "', marca = '"+veiculo.getMarca()+"' where id = "+veiculo.getId());
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				fechar();
			}
		}
		
		
		public void deletar(Veiculo veiculo){
			conectar();
			try {
				comando.execute("delete from veiculo where id="+veiculo.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				fechar();
			}
		}
}
