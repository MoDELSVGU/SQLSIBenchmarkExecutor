package launchers;

import configurations.Configuration;
import configurations.ProcedureConfiguration;
import solutions.MySQLSolution;

public class SQLSI_MySQLLauncher {

	public static void main(String[] args) {
		Configuration c = new ProcedureConfiguration();
		new MySQLSolution().run(c);
	}
	
}
