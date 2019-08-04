import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import web.api.revolt.AppRevolt.UsersResource;
import web.api.revolt.BLO.Client;

/**
 * 
 */

/**
 * @author arab
 *
 */

public class UsersTest {
	
	@Mock
	UsersResource uersResource;
	
	@InjectMocks 
	Client client;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		client = new Client();
		client.setId(1);
		client.setUsername("arabhossain");
		client.setName("Arab Hossain");
		
		Mockito.when(uersResource.user(1)).thenReturn(client);
		
		Client resutl = uersResource.user(1);
		assertEquals(1, resutl.getId());
	}

}
