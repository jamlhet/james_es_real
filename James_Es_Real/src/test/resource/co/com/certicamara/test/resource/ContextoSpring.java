package co.com.certicamara.test.resource;

import org.springframework.context.ApplicationContext;

/**
 * CertiFactura
 * Certicámara S.A.
 * AppContext
 * @author Seven4N Ltda.
 * Aug 15, 2012
 */
public class ContextoSpring
{
	//------------------------------
	//        Constantes
	//------------------------------
	
	/**
	 * El contexto de spring
	 */
	private static ApplicationContext ctx; 
	
	//------------------------------
	//        Métodos
	//------------------------------
	 
    /**
     * Inyectado de la clase "ContextoSpring" que es cargado automáticamente cuando spring empieza.
     */ 
    public static void setApplicationContext(ApplicationContext applicationContext) { 
        ctx = applicationContext; 
    } 
 
    /**
     * Obtener acceso al contexto de spring desde cualquier parte
     *
     * @return devuelve el contexto de spring
     */ 
    public static ApplicationContext getApplicationContext() { 
        return ctx; 
    }  
}
