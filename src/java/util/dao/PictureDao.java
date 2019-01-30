/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author dajana
 */
@ManagedBean(name = "PictureDao")
@SessionScoped
public class PictureDao {
    
    
    private static String folder;
    private static String picFolder = "pics/";

    static {
        ServletContext s = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String priv = s.getRealPath("/");
        folder = Paths.get(priv).getParent().toString() + "/web/";

    }
    
     public static void handleFileUpload(FileUploadEvent event) {
         try {
            UploadedFile fileUploaded = event.getFile();

            String fileName = fileUploaded.getFileName();
            String extension = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
            String picture = fileName;

            Path filePath = Paths.get(folder + picFolder + picture );
            
            Files.createDirectories(filePath);
            String aps = filePath.toAbsolutePath().toString();
            try (InputStream in = new ByteArrayInputStream(fileUploaded.getContents())) {
                Files.copy(in, filePath, StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (IOException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
