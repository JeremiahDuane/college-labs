package bp;

public class Database implements Runnable {
	private String sqlToExecute;
	private String result;
	
	public void executeSql() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = "ToyID 123, Inspector Caleb";
	}

	@Override
	public void run() {
		executeSql();

	}

	/**
	 * @return the sqlTOExecute
	 */
	public String getSqlToExecute() {
		return sqlToExecute;
	}

	/**
	 * @param sqlTOExecute the sqlTOExecute to set
	 */
	public void setSqlToExecute(String sqlTOExecute) {
		this.sqlToExecute = sqlTOExecute;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
}
