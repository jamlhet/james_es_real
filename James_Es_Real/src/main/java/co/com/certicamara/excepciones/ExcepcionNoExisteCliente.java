package co.com.certicamara.excepciones;


/**
 * 
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionNoExisteCliente
 * @author Seven4N Ltda.
 * May 28, 2012
 */

public class ExcepcionNoExisteCliente extends ExcepcionNegocio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9085469639333221212L;
	
	// ------------------------------
	// 			Constructores
	// ------------------------------
	
	/**
	 * Constructor
	 */
	public ExcepcionNoExisteCliente( String mensaje, Throwable excepcion )
	{
		super( mensaje, excepcion );
		// TODO Auto-generated constructor stub
	}

	public ExcepcionNoExisteCliente( String mensaje )
	{
		super( mensaje );
	}

}
