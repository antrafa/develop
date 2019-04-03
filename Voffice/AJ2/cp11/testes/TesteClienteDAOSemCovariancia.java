public class TesteClienteDAOSemCovariancia{
	public static void main(String[] args) {
		ClienteDAOSemCovariancia dao = new ClienteDAOSemCovariancia();
		Cliente c = (Cliente) dao.getByPrimaryKey(new Integer(20));
	}
}