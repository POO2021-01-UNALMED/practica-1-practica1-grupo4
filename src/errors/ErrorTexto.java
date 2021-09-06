package errors;

public class ErrorTexto extends ErrorAplicacion{

	/**
	 * 
	 */
	private String message = "Faltan campos por rellenar";
	private static final long serialVersionUID = 1L;
	public ErrorTexto() {
		super();
	}
	public String getMessage() {
		return super.getMessage() + message;
	}
}
