package co.com.certicamara.dto;

/**
 * CertiFactura Certicámara S.A. ClienteDTO
 * 
 * @author Seven4N Ltda. May 28, 2012
 */

public class ClienteDTO implements DataTransferObject
{
	
	

	private String id;
	private String nombre;
	private String nuip;
	private String direccion;
	private String telefono;
	private String fax;

	/**
	 * @return the id
	 */
	public String getId( )
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId( String id )
	{
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre( )
	{
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre( String nombre )
	{
		this.nombre = nombre;
	}

	/**
	 * @return the nuip
	 */
	public String getNuip( )
	{
		return nuip;
	}

	/**
	 * @param nuip
	 *            the nuip to set
	 */
	public void setNuip( String nuip )
	{
		this.nuip = nuip;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion( )
	{
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion( String direccion )
	{
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono( )
	{
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono( String telefono )
	{
		this.telefono = telefono;
	}

	/**
	 * @return the fax
	 */
	public String getFax( )
	{
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax( String fax )
	{
		this.fax = fax;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString( )
	{
		return "ClienteDTO [id=" + id + ", nombre=" + nombre + ", nuip=" + nuip + ", direccion=" + direccion + ", telefono=" + telefono + ", fax=" + fax + "]";
	}

}
