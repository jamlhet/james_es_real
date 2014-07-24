package co.com.certicamara.excepciones;


/**
 * 
 * CertiFactura
 * Certicámara S.A.
 * ExcepcionDocumentoYaExiste
 * @author Certicámara S.A.
 * 24/07/2014
 */
public class ExcepcionDocumentoYaExiste extends ExcepcionNegocio
{


	//------------------------------
	//        Atributos
	//------------------------------




	//------------------------------
	//        Constructores
	//------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6309156199539449894L;

	/**
	 * Constructor
	 */
	public ExcepcionDocumentoYaExiste( String mensaje, Throwable excepcion )
	{
		super( mensaje, excepcion );
		// TODO Auto-generated constructor stub
	}

	public ExcepcionDocumentoYaExiste( String mensaje )
	{
		super( mensaje );
	}

	//------------------------------
	//          Métodos
	//------------------------------

	//------------------------------
	//       Métodos Privados
	//------------------------------
}





