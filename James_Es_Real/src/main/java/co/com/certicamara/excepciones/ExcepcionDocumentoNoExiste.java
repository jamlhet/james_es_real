package co.com.certicamara.excepciones;

/**
 * 
 * Certicámara S.A.
 * ExcepcionDocumentoNoExiste
 * @author Certicámara S.A.
 * 24/07/2014
 */
public class ExcepcionDocumentoNoExiste extends ExcepcionNegocio
{

	// ------------------------------
	// Atributos
	// ------------------------------

	// ------------------------------
	// Constructores
	// ------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 2868362804840701454L;

	/**
	 * Constructor
	 */
	public ExcepcionDocumentoNoExiste( String mensaje, Throwable excepcion )
	{
		super( mensaje, excepcion );
		// TODO Auto-generated constructor stub
	}

	public ExcepcionDocumentoNoExiste( String mensaje )
	{
		super( mensaje );
	}

	// ------------------------------
	// Métodos
	// ------------------------------

	// ------------------------------
	// Métodos Privados
	// ------------------------------
}
