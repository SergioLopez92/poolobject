/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		ReusablePool r = ReusablePool.getInstance();
		assert(r!=null);
		assert(r instanceof ReusablePool);
		
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * @throws NotFreeInstanceException 
	 */
	@Test
	public void testAcquireReusable() throws NotFreeInstanceException {
		ReusablePool r = ReusablePool.getInstance();
		try{
			assert(r.acquireReusable() instanceof Reusable);
			assert(r.acquireReusable() instanceof Reusable);
		}catch(NotFreeInstanceException ex){fail("Error, no hay espacio en el pool");}
		try{
			r.acquireReusable();
		}catch(NotFreeInstanceException ex2){}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		
	
		try{
			ReusablePool r = ReusablePool.getInstance();
			
			assert(r.acquireReusable() instanceof Reusable);
			Reusable reu=r.acquireReusable();
			r.releaseReusable(reu);
			r.acquireReusable();
			
		}catch(NotFreeInstanceException ex3){fail("Error, no hay espacio en el pool");}catch(DuplicatedInstanceException ex3){fail("Instancia duplicada");}
		}
		
		
}

