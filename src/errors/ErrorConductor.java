package errors;

public class ErrorConductor extends ErrorAplicacion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private String message = " Aún no se le ha asignado un conductor";
	public ErrorConductor(){
		super();
		
	}
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}

}
