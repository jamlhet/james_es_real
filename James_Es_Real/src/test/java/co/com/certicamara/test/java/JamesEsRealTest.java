package co.com.certicamara.test.java;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.certicamara.dto.ClienteDTO;
import co.com.certicamara.excepciones.ExcepcionExisteCliente;
import co.com.certicamara.excepciones.ExcepcionMongoDb;
import co.com.certicamara.excepciones.ExcepcionNoExisteCliente;
import co.com.certicamara.respository.RepositorioCliente;
import co.com.certicamara.vo.ClienteVO;

/**
 * CertiFactura Certicámara S.A. GenerarPedfTest
 * 
 * @author Seven4N Ltda. 26/06/2013
 */
@RunWith ( SpringJUnit4ClassRunner.class )
@ContextConfiguration ( locations =
{ "classpath:/co/com/certicamara/test/resource/configuracionPruebasUnitarias.xml" } )
public class JamesEsRealTest
{

	private static final String ID = "123456";
	private static final String ID2 = "1234567";
	private static final String ID3 = "12345678";

	private RepositorioCliente repositorioCliente;

	private ClienteDTO dto;
	private ClienteVO vo;

	private Random randomGenerator = new Random( );

	@Before
	public void before( )
	{
		repositorioCliente = new RepositorioCliente( "TestRepositorioCliente" );
	}

	@Test
	public void create( ) throws ExcepcionExisteCliente, ExcepcionMongoDb, ExcepcionNoExisteCliente
	{
		// Create
		dto = new ClienteDTO( );
		dto.setId( ID );
		dto.setNombre( "James es Real" );
		dto.setFax( "1354" );
		dto.setTelefono( "236 56 25" );

		repositorioCliente.guardarCliente( dto );
	}

	@Test
	public void read( ) throws ExcepcionNoExisteCliente, ExcepcionMongoDb
	{
		// Read
		vo = new ClienteVO( ID );
		dto = repositorioCliente.buscarCliente( vo );
		assertNotNull( dto );
		assertEquals( "dto1 mismo id " + ID, ID, dto.getId( ) );
		assertFalse( "No es un caracter", "v" == dto.getId( ) );
	}

	@Test
	public void update( ) throws ExcepcionNoExisteCliente, ExcepcionMongoDb, ExcepcionExisteCliente
	{
		// Update
		dto = new ClienteDTO( );
		dto.setId( ID2 );
		dto.setNombre( "update" );
		dto.setFax( "1354" );
		dto.setTelefono( "236 56 25" );

		repositorioCliente.guardarCliente( dto );

		dto.setId( ID2 );
		dto.setNombre( "mongo db test" );
		dto.setFax( String.valueOf( randomGenerator.nextInt( 1000 ) ) + " 77 77" );
		dto.setTelefono( "888 88 88" );

		repositorioCliente.actualizarCliente( dto );

		vo = new ClienteVO( ID2 );
		dto = repositorioCliente.buscarCliente( vo );
		assertNotEquals( "dto's nombre diferente ", dto.getNombre( ), "update" );
	}

	@Test
	public void delete( ) throws ExcepcionNoExisteCliente, ExcepcionMongoDb, ExcepcionExisteCliente
	{
		// Delete
		dto = new ClienteDTO( );
		dto.setId( ID3 );
		dto.setNombre( "update" );
		dto.setFax( "1354" );
		dto.setTelefono( "236 56 25" );

		repositorioCliente.guardarCliente( dto );

		vo = new ClienteVO( ID3 );
		repositorioCliente.borrarCliente( vo );

		try
		{
			dto = repositorioCliente.buscarCliente( vo );
		}
		catch ( ExcepcionNoExisteCliente e )
		{
			assertNull( "No se encontro el cliente", null );
		}

	}
}
