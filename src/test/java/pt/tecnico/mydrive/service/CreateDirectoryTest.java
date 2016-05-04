package pt.tecnico.mydrive.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import pt.tecnico.mydrive.domain.App;
import pt.tecnico.mydrive.domain.File;
import pt.tecnico.mydrive.domain.Directory;
import pt.tecnico.mydrive.domain.FileSystem;
import pt.tecnico.mydrive.domain.User;
import pt.tecnico.mydrive.exception.FilenameAlreadyExistsException;

public class CreateDirectoryTest extends AbstractServiceTest {
	private static final byte DEFAULT_MASK = (byte) 0b11110000;
	
	@Override
	protected void populate() {
		// TODO Auto-generated method stub
		 FileSystem fs = FileSystem.getInstance();
		 new User(fs, "bbranco", "es2016", "Bernardo", DEFAULT_MASK);
		 Directory f = (Directory) fs.getFile("/home/bbranco");
	 
	}
	
	@Test
    public void successUser() {
		FileSystem fs = FileSystem.getInstance();
    	LoginService lser = new LoginService( "bbranco", "es2016" );
    	lser.execute();	
    	
    	CreateDirectoryService service = new CreateDirectoryService("TestDir", lser.result());
    	service.execute();
    	
    	File dir = fs.getFile("/home/bbranco/TestDir");
    	
    	assertNotNull("Directory was not created", dir);
        assertEquals("Directory created with wrong name", "TestDir", dir.getName());
        assertEquals("Directory created with wrong owner", fs.getUser("bbranco"), dir.getOwner());
        assertEquals("Directory created with wrong content", 0, ((Directory) dir).getFileCount());
	}
	
	
	


}
