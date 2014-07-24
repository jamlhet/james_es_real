package co.com.certicamara.ddd;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import co.com.certicamara.dto.ClienteDTO;
import co.com.certicamara.excepciones.ExcepcionDocumentoNoExiste;
import co.com.certicamara.excepciones.ExcepcionDocumentoYaExiste;
import co.com.certicamara.excepciones.ExcepcionMongoDb;
import co.com.certicamara.excepciones.ExcepcionNegocio;
import co.com.certicamara.test.resource.ContextoSpring;
import co.com.certicamara.vo.ClienteVO;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;



/**
 * 
 * CertiFactura
 * Certicámara S.A.
 * IRepositorio
 * @author Certicámara S.A.
 * 24/07/2014
 */
public abstract class IRepositorio<T>
{

	/**
	 * El nombre de la colección sobre la cual se van a realizar las operaciones
	 */
	protected String collectionName;
	
	/**
	 * Constructor
	 * @param collectionName
	 *            Nombre de la colección
	 */

	public IRepositorio( String collectionName ) 
	{
		setCollectionName( collectionName );
	}
	
	// //////////////////////////////////////////////////
	// Métodos
	// //////////////////////////////////////////////////

	/**
	 * Método encargado de persistir un elemento
	 * 
	 * @param elemento
	 *            que se va a persistir
	 * @param vo
	 *            con el id del elemento
	 * @param clase
	 *            La clase del elemento que se va a persistir
	 * @throws ExcepcionMongoDb si hay alguna falla conectándose a mongo db
	 * @exception ExcepciónNegocio
	 *                Ya existe un elemento con el mismo id
	 */
	protected void guardar( T entidad, ClienteVO vo ) throws ExcepcionDocumentoYaExiste, ExcepcionMongoDb
	{
		
		try
		{
			T entidadEncontrada = buscar( vo, ClienteDTO.class );
			if ( null == entidadEncontrada )
				darMongoTemplate( ).save( entidad, collectionName );
			else
				throw new ExcepcionDocumentoYaExiste( " En IRepositorio: Ya existe un elemento con el mismo Id "+vo.getId( ));
		}
		catch ( Exception excepcion )
		{
			throw new ExcepcionMongoDb( "Error al intentar almacenar la entidad", excepcion );
		}
	}
	
	/**
	 * Método encargado de persistir una lista de elementos
	 * @param listaEntidades la lista que se va a persistir
	 * @throws ExcepcionMongoDb si hay alguna falla conectándose a mongo db
	 */
	protected void guardarVarios( List< T > listaEntidades ) throws ExcepcionMongoDb
	{
		try
		{
			darMongoTemplate( ).insert( listaEntidades, collectionName );
		}
		catch ( Exception excepcion )
		{
			throw new ExcepcionMongoDb( "Error al intentar almacenar varias entidades", excepcion );
		}
	}

	/**
	 * Método encargado de actualizar un elemento existente
	 * 
	 * @param elemento
	 *            Elemento que va a reemplazar el existente
	 * @param vo
	 *            VO con el id del elemento a actualizar
	 * @param clase
	 *            La clase del elemento que se va a actualizar
	 * @throws ExcepcionMongoDb si hay alguna falla conectándose a mongo db
	 * @throws ExcepcionNegocio
	 *             No encontró el elemento a actualizar
	 */

	protected void actualizar( T elemento, ClienteVO vo, Class< ClienteDTO > clase ) throws ExcepcionDocumentoNoExiste, ExcepcionMongoDb
	{
		T elementoBuscado = buscar( vo, ClienteDTO.class );
		if ( null == elementoBuscado )
		{
			throw new ExcepcionDocumentoNoExiste( "IRepositorio.actualizar: No se encontró el documento "+vo.getId( ) );
		}
		else
		{
			try
			{
				darMongoTemplate( ).save( elemento, collectionName );
			}
			catch( Exception excepcion )
			{
				throw new ExcepcionMongoDb( "Error al actualizar la entidad, no se pudo conectar a la base de datos", excepcion );
			}
		}

	}

	/**
	 * @param VO
	 *            con el id del elemento a buscar
	 * @param class1
	 *            Clase del elemento que se va a buscar
	 * @return elemento encontrado o null en caso contrario
	 * @throws ExcepcionMongoDb si hay alguna falla conectándose a mongo db
	 */
	protected T buscar( ClienteVO vo, Class< ClienteDTO > class1 ) throws ExcepcionMongoDb
	{
		T elemento = null;
		try
		{
			elemento = ( T ) darMongoTemplate( ).findById( vo.getId( ), ClienteDTO.class, collectionName );
		}
		catch( Exception excepcion )
		{
			throw new ExcepcionMongoDb( "Error al buscar la entidad, no se pudo conectar a la base de datos", excepcion );
		}
		
		return elemento;
	}
	
	/**
	 * Método encargado de devolver todos los elementos de la colección
	 * @param clase Clase del elemento que se va a buscar
	 * @return devuelve una con todos los elementos de la colección
	 * @throws ExcepcionMongoDb si hay alguna falla conectándose a mongo db
	 */
	protected List< T > darTodos( Class< T > clase ) throws ExcepcionMongoDb
	{
		try
		{
			return darMongoTemplate( ).findAll( clase, collectionName );
		}
		catch( Exception excepcion )
		{
			throw new ExcepcionMongoDb( "Error al buscar las entidades, no se pudo conectar a la base de datos", excepcion );
		}
	}
	
	/**
	 * Método encargado de eliminar un elemento existente
	 * 
	 * @param vo
	 *            Objeto con el id del elemento a buscar
	 * @param clase
	 *            Clase del elemento que se va a buscar
	 * @throws ExcepcionDocumentoNoExiste
	 *             No encontró el elemento a eliminar
	 * @throws ExcepcionMongoDb si hay alguna falla conectándose a mongo db
	 */
	protected void eliminar( ClienteVO vo, Class< ClienteDTO > clase ) throws ExcepcionDocumentoNoExiste, ExcepcionMongoDb
	{
		T elementoBuscado = buscar( vo, clase );
		if ( null == elementoBuscado )
		{
			throw new ExcepcionDocumentoNoExiste( "IRepositorio.borrar: No se encontró el documento "+vo.getId( ) );
		}
		else
		{
			try
			{
				darMongoTemplate( ).remove( elementoBuscado, collectionName );
			}
			catch( Exception excepcion )
			{
				throw new ExcepcionMongoDb( "Error al eliminar la entidad, no se pudo conectar a la base de datos", excepcion );
			}
			
		}
	}
	
	/**
	 * Borra la colección
	 * @throws ExcepcionMongoDb
	 */
	public void borrarColeccion( ) throws ExcepcionMongoDb
	{
		DBCollection coleccion = darMongoTemplate( ).getDb( ).getCollection( getCollectionName( ) );
		try
		{
			coleccion.remove( new BasicDBObject( ) );
		}
		catch ( MongoException e )
		{
			throw new ExcepcionMongoDb( "Hubo problemas al borrar la colección" );
		}
	}
	
	/**
	 * Devuelve el mongo template del contexto spring
	 * @return devuelve un objeto tipo MongoTemplate
	 */
	protected MongoTemplate darMongoTemplate( )
	{
		ApplicationContext ctx = ContextoSpring.getApplicationContext( );
		return ctx.getBean( MongoTemplate.class );
	}

	/**
	 * @param collectionName
	 *            Nombre de la colección
	 */
	protected void setCollectionName( String collectionName )
	{
		this.collectionName = collectionName;
	}

	/**
	 * @return the collectionName
	 */
	protected String getCollectionName( )
	{
		return collectionName;
	}

}
