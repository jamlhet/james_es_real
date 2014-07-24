package co.com.certicamara.excepciones;

/**
 * 
 * Certicámara S.A.
 * ExcepcionNegocio
 * @author Certicámara S.A.
 * 24/07/2014
 */
public class ExcepcionNegocio extends Throwable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5273234137972575048L;

	/**
	 * Constructor
	 */
	public ExcepcionNegocio(String mensaje,Throwable excepcion )
	{
		super( mensaje, excepcion );
	}
	
	/**
	 * Constructor
	 */
	public ExcepcionNegocio( String mensaje )
	{
		super( mensaje );
	}
	
	

}





