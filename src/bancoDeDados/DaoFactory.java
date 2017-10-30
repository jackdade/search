package bancoDeDados;


public class DaoFactory {
private static DaoFactory daoFactory;
	
	public static DaoFactory get(){
		if(daoFactory == null){
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}

	public signoDAO signoDao() {
		// TODO Auto-generated method stub
		return new signoJDBC();
	}

	public UFDao UFDao() {
		// TODO Auto-generated method stub
		return new UFJDBC();
	}

	public CidadeDAO CidadeDAO() {
		// TODO Auto-generated method stub
		return new CidadeJDBC();
	}

}
