package co.com.certicamara.excepciones;

/**
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionTecnica
 * @author Seven4N Ltda.
 * Apr 25, 2012
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





