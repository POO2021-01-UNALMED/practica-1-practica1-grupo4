package errors;

public class ErrorCantidaProducto extends ErrorAplicacion {
	

	private static final long serialVersionUID = 1L; 
	private String message = "No queda más de ese producto";
	public ErrorCantidaProducto(){
		super();
	}
	public String getMessage() {
		return super.getMessage() + "\n" + this.message;
	}
}
