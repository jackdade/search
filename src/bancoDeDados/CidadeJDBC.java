package bancoDeDados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Cidade;
import classes.UF;



public class CidadeJDBC implements CidadeDAO {
	
	private UF uf;
	
	@Override
	public List<Cidade> listar() {
		List<Cidade> cidades = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from cidade where id";
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setCodigo(rs.getLong("idCidade"));
				cidade.setNomeCidade(rs.getString("nomeCidade"));
				
				UF UF= new UF();
				UF.setCodigo(rs.getLong("idUF"));
				cidade.setUfSelecionada(UF);
				cidades.add(cidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidades;
	}

	@Override
	public void inserir(Cidade entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cidade entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cidade get(Long codigo) {
		Cidade cidade = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from cidade where idUF=" + uf.getCodigo();
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			cidade = new Cidade();
			cidade.setCodigo(rs.getLong("idCidade"));
			cidade.setNomeCidade(rs.getString("nomeCidade"));
			
			UF uf = new UF();
			uf.setCodigo(rs.getLong("idUF"));
			cidade.getUfSelecionada(uf);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidade;
	}

}
