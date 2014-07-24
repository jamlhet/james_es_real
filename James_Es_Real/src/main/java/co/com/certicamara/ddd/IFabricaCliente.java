package co.com.certicamara.ddd;

import java.util.LinkedHashMap;

/**
 * 
 * Certicámara S.A.
 * IFabricaCliente
 * @author Certicámara S.A.
 * 24/07/2014
 */
public interface IFabricaCliente<T, DTO>
{
	public T create( DTO dto );

	public T create( LinkedHashMap< String, Object > mapaCliente ) throws Throwable;
}
