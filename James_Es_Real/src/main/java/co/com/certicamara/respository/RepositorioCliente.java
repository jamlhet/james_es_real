package co.com.certicamara.respository;

import co.com.certicamara.ddd.IRepositorio;
import co.com.certicamara.dto.ClienteDTO;
import co.com.certicamara.excepciones.ExcepcionDocumentoNoExiste;
import co.com.certicamara.excepciones.ExcepcionDocumentoYaExiste;
import co.com.certicamara.excepciones.ExcepcionExisteCliente;
import co.com.certicamara.excepciones.ExcepcionMongoDb;
import co.com.certicamara.excepciones.ExcepcionNoExisteCliente;
import co.com.certicamara.vo.ClienteVO;
/**
 * 
 * CertiFactura
 * Certicámara S.A.
 * RepositorioCliente
 * @author Certicámara S.A.
 * 24/07/2014
 */
public class RepositorioCliente extends IRepositorio< ClienteDTO >
{

	/**
	 * Constructor encargado de inicializar un repositorio
	 * 
	 * @param collectionName
	 *            Nombre de la colección donde se va almacenar los TSA
	 */
	public RepositorioCliente( String collectionName )
	{
		super( collectionName );
	}

	/**
	 * Método encargado de guardar un Cliente
	 * 
	 * @param clienteDTO
	 *            Cliente
	 * @throws ExcepcionExisteCliente
	 * @throws ExcepcionMongoDb
	 */
	public void guardarCliente( ClienteDTO clienteDTO ) throws ExcepcionExisteCliente, ExcepcionMongoDb
	{
		try
		{
			guardar( clienteDTO, new ClienteVO( clienteDTO.getId( ) ) );
		}
		catch ( ExcepcionDocumentoYaExiste e )
		{
			throw new ExcepcionExisteCliente( e.getMessage( ), e );
		}
		catch ( ExcepcionMongoDb e )
		{
			throw new ExcepcionMongoDb( "Fallo guardando el cliente en " + this.getClass( ).getName( ), e );
		}
	}

	/**
	 * Método encargado de actualizar un Cliente
	 * 
	 * @param clienteDTO
	 *            Cliente
	 * @throws ExcepcionNoExisteCliente
	 *             se lanza cuando no se encuentra un Cliente
	 * @throws ExcepcionMongoDb
	 */
	public void actualizarCliente( ClienteDTO clienteDTO ) throws ExcepcionNoExisteCliente, ExcepcionMongoDb
	{
		try
		{
			actualizar( clienteDTO, new ClienteVO( clienteDTO.getId( ) ), ClienteDTO.class );
		}
		catch ( ExcepcionDocumentoNoExiste e )
		{
			throw new ExcepcionNoExisteCliente( e.getMessage( ), e );
		}
		catch ( ExcepcionMongoDb e )
		{
			throw new ExcepcionMongoDb( "Fallo actualizando el cliente en " + this.getClass( ).getName( ), e );
		}
	}

	/**
	 * Método encargado de buscar un Cliente dado un VO
	 * 
	 * @param vo
	 *            el VO usado para buscar el Cliente
	 * @return devuelve un ClienteDTO
	 * @throws ExcepcionNoExisteCliente
	 *             se lanza cuando no se encuentra el Cliente
	 * @throws ExcepcionMongoDb
	 */
	public ClienteDTO buscarCliente( ClienteVO vo ) throws ExcepcionNoExisteCliente, ExcepcionMongoDb
	{
		ClienteDTO clienteDTO;
		try
		{
			clienteDTO = super.buscar( vo, ClienteDTO.class );
		}
		catch ( ExcepcionMongoDb e )
		{
			throw new ExcepcionMongoDb( "Fallo buscando el cliente en " + this.getClass( ).getName( ), e );
		}
		if ( clienteDTO == null )
			throw new ExcepcionNoExisteCliente( "En RepositorioCliente.buscarCliente No se encontró el Cliente buscado " + vo.getId( ) );
		else
			return clienteDTO;
	}

	/**
	 * Borra un cliente de la colección según su VO
	 * 
	 * @param vo
	 * @throws ExcepcionNoExisteCliente
	 * @throws ExcepcionMongoDb
	 */
	public void borrarCliente( ClienteVO vo ) throws ExcepcionNoExisteCliente, ExcepcionMongoDb
	{
		try
		{
			super.eliminar( vo, ClienteDTO.class );
		}
		catch ( ExcepcionDocumentoNoExiste e )
		{
			throw new ExcepcionNoExisteCliente( "Cliente a borrar no existe " + vo.getId( ) );
		}
		catch ( ExcepcionMongoDb e )
		{
			throw new ExcepcionMongoDb( "Excepcion de base de datos al eliminar cliente ", e );
		}
	}
}
