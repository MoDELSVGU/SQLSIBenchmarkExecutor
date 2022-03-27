package configurations;

import java.util.Map;

public class ProcedureConfiguration extends DatabaseConfiguration {
	private String sScenario, sProcedureCall, sCaller, sRole;

	private static final String ENV_CALLER = "CALLER";
	private static final String ENV_ROLE = "ROLE";
	private static final String ENV_PROCEDURE_CALL = "PROCEDURECALL";
	private static final String ENV_SCENARIO = "SCENARIO";
	
	public String getsCaller() {
		return sCaller;
	}

	public void setsCaller(String sCaller) {
		this.sCaller = sCaller;
	}

	public String getsScenario() {
		return sScenario;
	}

	public void setsScenario(String sScenario) {
		this.sScenario = sScenario;
	}

	public String getsProcedureCall() {
		return sProcedureCall;
	}

	public void setsProcedureCall(String sProcedureCall) {
		this.sProcedureCall = sProcedureCall;
	}

	public String getsRole() {
		return sRole;
	}

	public void setsRole(String sRole) {
		this.sRole = sRole;
	}

	public ProcedureConfiguration() {
		super();
		final Map<String, String> env = System.getenv();

		final String sProcedureCall = env.get(ENV_PROCEDURE_CALL);
		if (sProcedureCall != null) {
			setsProcedureCall(sProcedureCall);
		}

		final String sScenario = env.get(ENV_SCENARIO);
		if (sScenario != null) {
			setsScenario(sScenario);
		}

		final String sRole = env.get(ENV_ROLE);
		if (sRole != null) {
			setsRole(sRole);
		}

		final String sCaller = env.get(ENV_CALLER);
		if (sCaller != null) {
			setsCaller(sCaller);
		}
	}

}
