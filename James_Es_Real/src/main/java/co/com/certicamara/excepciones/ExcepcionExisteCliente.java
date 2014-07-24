package co.com.certicamara.excepciones;


/**
 * 
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionExisteCliente
 * @author Seven4N Ltda.
 * May 28, 2012
 */

public class ExcepcionExisteCliente extends ExcepcionNegocio{

	// ------------------------------
	// 			Constantes
	// ------------------------------
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1456903222964884089L;
	// ------------------------------
	// 			Constructores
	// ------------------------------
	
	/**
	 * Constructor
	 */
	public ExcepcionExisteCliente( String mensaje, Throwable excepcion )
	{
		super( mensaje, excepcion );
	}

	/**
	 * Constructor
	 */
	public ExcepcionExisteCliente( String mensaje )
	{
		super( mensaje );
	}	
	

}
