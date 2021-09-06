package errors;

public class CarritoVacio extends ErrorAplicacion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = " No ha escogido ningún producto aún";
	public CarritoVacio(){
		super();
		
	}
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}
}
