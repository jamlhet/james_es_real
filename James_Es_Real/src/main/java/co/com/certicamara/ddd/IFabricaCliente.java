package co.com.certicamara.ddd;

import java.util.LinkedHashMap;

/**
 * CertiFactura Certicámara S.A. Factory
 * 
 * @author Seven4N Ltda. Apr 20, 2012
 */
public interface IFabricaCliente<T, DTO>
{
	public T create( DTO dto );

	public T create( LinkedHashMap< String, Object > mapaCliente ) throws Throwable;
}
