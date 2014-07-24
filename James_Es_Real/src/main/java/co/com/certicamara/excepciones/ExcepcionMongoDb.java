package co.com.certicamara.excepciones;

/**
 * 
 * Certicámara S.A.
 * ExcepcionMongoDb
 * @author Certicámara S.A.
 * 24/07/2014
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





