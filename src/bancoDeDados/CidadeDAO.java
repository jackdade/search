package bancoDeDados;

import java.util.List;

import classes.Cidade;
import classes.UF;

public interface CidadeDAO extends CrudDao<Cidade>{

	
	List<Cidade> buscaPorUf(UF uf);
}
