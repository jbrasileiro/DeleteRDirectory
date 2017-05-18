package org.com.owl.utils.deleteRDirectory;

import org.junit.Test;

public class MainTest {

	@Test
	public void testMain() throws Exception {
		Main.main(new String[]{
		    "--DEBUG"
		    ,"--SC:\\.rep\\svn\\IATA"
		    ,".settings"
//		    ,"bin"
//		    ,"target"
		    });

	}

}
