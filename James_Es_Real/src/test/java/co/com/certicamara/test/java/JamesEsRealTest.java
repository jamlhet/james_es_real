package co.com.certicamara.test.java;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.certicamara.dto.ClienteDTO;
import co.com.certicamara.excepciones.ExcepcionExisteCliente;
import co.com.certicamara.excepciones.ExcepcionMongoDb;
import co.com.certicamara.respository.RepositorioCliente;

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

	private String id;

	@Before
	public void antesDe( )
	{
		System.out.println( "James Es Real Señores" );
		Random randomGenerator = new Random( );
		id = String.valueOf( randomGenerator.nextInt( 100 ) );
	}

	@Test
	public void prueba( ) throws ExcepcionExisteCliente, ExcepcionMongoDb
	{
		RepositorioCliente repositorioCliente = new RepositorioCliente( "TestRepositorioCliente" );
		ClienteDTO dto = new ClienteDTO( );

		dto.setId( id );
		dto.setNombre( "James es Real" );
		dto.setFax( "1354" );
		dto.setTelefono( "236 56 25" );

		repositorioCliente.guardarCliente( dto );
	}

}
