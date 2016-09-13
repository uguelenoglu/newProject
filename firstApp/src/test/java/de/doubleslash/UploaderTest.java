package de.doubleslash;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class UploaderTest {

	@Test
	public void fileUploderTest() throws IOException {
		Uploader uploader = new Uploader();
		
		for(int i = 1; i <= 5; i++){
			OutputStream output = uploader.receiveUpload("test"+ i +".jpg", "");
			output.flush();
			Path path = FileSystems.getDefault().getPath("/tmp/test"+ i +".jpg");
			assertTrue(Files.exists(path));
		}
		
	}

}
