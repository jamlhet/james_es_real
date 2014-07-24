package co.com.certicamara.excepciones;

/**
 * 
 * Certicámara S.A.
 * ExcepcionExisteCliente
 * @author Certicámara S.A.
 * 24/07/2014
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
