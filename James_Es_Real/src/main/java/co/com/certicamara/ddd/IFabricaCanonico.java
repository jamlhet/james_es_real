package co.com.certicamara.ddd;



/**
 * 
 * Certicámara S.A.
 * IFabricaCanonico
 * @author Certicámara S.A.
 * 24/07/2014
 */
public interface IFabricaCanonico<T,DTO>
{
	public T create(DTO dto);
}





