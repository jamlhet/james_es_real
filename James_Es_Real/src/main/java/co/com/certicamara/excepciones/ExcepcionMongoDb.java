package co.com.certicamara.excepciones;

/**
 * 
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionMongoDb
 * @author Seven4N Ltda.
 * Nov 2, 2012
 */
public class ExcepcionMongoDb extends ExcepcionTecnica
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5207111602862480832L;

	/**
	 * Constructor
	 */
	public ExcepcionMongoDb( String mensaje, Throwable excepcion )
	{
		super( mensaje, excepcion );
	}
	
	/**
	 * Constructor
	 */
	public ExcepcionMongoDb( String mensaje )
	{
		super( mensaje );
	}
}





