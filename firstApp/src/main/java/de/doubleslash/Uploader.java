package de.doubleslash;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.Receiver;



public class Uploader implements Receiver {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2922894716579155026L;
	
    private FileOutputStream fos = null;
	private File file;
	
    public OutputStream receiveUpload(String filename, String mimeType) {

        try {
            // Open the file for writing.
            file = new File("/tmp/"+filename);
            fos = new FileOutputStream(file);
        } catch (final FileNotFoundException e) {
            new Notification("Could not open file", e.getMessage(), Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
        }
        return fos; // Return the output stream to write to
    }

}

