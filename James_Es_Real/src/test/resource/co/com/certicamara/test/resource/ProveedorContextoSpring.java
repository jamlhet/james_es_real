package co.com.certicamara.test.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * CertiFactura
 * Certicámara S.A.
 * ApplicationContextProvider
 * @author Seven4N Ltda.
 * Aug 15, 2012
 */
public class ProveedorContextoSpring implements ApplicationContextAware
{
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext ctx) throws BeansException { 
        // Conecta el contexto de spring a la clase estática
        ContextoSpring.setApplicationContext(ctx); 
    }  
}
