package co.com.certicamara.ddd;

import java.io.Serializable;



/**
 * 
 * CertiFactura
 * Certicámara S.A.
 * IdentificadorVO
 * @author Certicámara S.A.
 * 24/07/2014
 */
public abstract class IdentificadorVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1616632949051770246L;
	
	//------------------------------
	//        Atributos
	//------------------------------
	
	/**
	 * Identificador del VO
	 */
	private String id;

	//------------------------------
	//        Constructores
	//------------------------------
	
	/**
	 * Constructor
	 */
	public IdentificadorVO( )
	{
		super( );
	}
	
	//------------------------------
	//          Métodos
	//------------------------------

	public IdentificadorVO( String identificador )
	{
		this.setId( identificador );
	}

	/**
	 * @return the id
	 */
	public String getId( )
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId( String id )
	{
		this.id = id;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		if( obj instanceof IdentificadorVO )
		{
			final IdentificadorVO other = ( IdentificadorVO  ) obj;
			return this.id.equals( other.getId( ) );
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString( )
	{
		return this.getId( );
	}
}





