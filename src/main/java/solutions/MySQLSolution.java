package solutions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import configurations.Configuration;
import configurations.ProcedureConfiguration;
import connections.MySQLConnection;

public class MySQLSolution extends Solution {

	private final static String METRIC_EXECUTION_TIME = "ExecutionTimeSecs";

	@Override
	public void run(Configuration c) {
		if (c instanceof ProcedureConfiguration) {
			ProcedureConfiguration pc = (ProcedureConfiguration) c;
			Connection conn = MySQLConnection.getConnection(pc.getsScenario(), pc.getDbusername(), pc.getDbpassword());
			final String callStatement = String.format("{call %s('%s','%s')}", pc.getsProcedureCall(), pc.getsCaller(),
					pc.getsRole());
			CallableStatement cs;
			try {
				cs = conn.prepareCall(callStatement);
				final long nanosExecutionStart = System.nanoTime();
				cs.execute();
				final long nanosExecutionEnd = System.nanoTime();
				final double timeInSecs = ((double) nanosExecutionEnd - nanosExecutionStart) / 1_000_000_000;

				printMetric(pc, METRIC_EXECUTION_TIME, timeInSecs);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void printMetric(Configuration c, String metricExecutionTime, Object metricValue) {
		if (c instanceof ProcedureConfiguration) {
			ProcedureConfiguration pc = (ProcedureConfiguration) c;

			System.out.println(String.format("%s;%s;%s;%s;%s;%s", pc.getsTool(), pc.getsScenario(),
					pc.getsProcedureCall(), pc.getRunIndex(), metricExecutionTime, metricValue.toString()));

		}

	}

}
