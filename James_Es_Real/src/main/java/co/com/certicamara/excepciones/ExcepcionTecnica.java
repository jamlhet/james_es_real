package co.com.certicamara.excepciones;

/**
 * 
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionTecnica
 * @author Certicámara S.A.
 * 24/07/2014
 */
public class ExcepcionTecnica extends Throwable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -925445124995831375L;

	/**
	 * Constructor
	 */
	public ExcepcionTecnica( String mensaje, Throwable excepcion )
	{
		super( mensaje, excepcion );
	}
	
	/**
	 * Constructor
	 */
	public ExcepcionTecnica( String mensaje )
	{
		super( mensaje );
	}
}





