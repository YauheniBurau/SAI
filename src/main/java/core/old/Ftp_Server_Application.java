package core.old;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Ftp_Server_Application{

    public static void main(String[] args) throws FtpException {
        // read AI_Config
        Properties pFile = new Properties();
        try {
            String fileName = "AI_Config.properties";
            ClassLoader classLoader = new Ftp_Server_Application().getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            pFile.load( new FileReader(file) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dir = pFile.getProperty("local.ftp.dir");
        String port = pFile.getProperty("local.ftp.port");
        String name = pFile.getProperty("local.ftp.userName");
        String password = pFile.getProperty("local.ftp.userPassword");

        // run ftp server
        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        UserManager userManager = userManagerFactory.createUserManager();
        BaseUser user = new BaseUser();
        user.setName(name);
        user.setPassword(password);
        user.setHomeDirectory(dir);
        userManager.save(user);

        ListenerFactory listenerFactory = new ListenerFactory();
        listenerFactory.setPort(Integer.parseInt(port));

        FtpServerFactory factory = new FtpServerFactory();
        factory.setUserManager(userManager);
        factory.addListener("default", listenerFactory.createListener());

        FtpServer server = factory.createServer();
        server.start();

        // write AI_Config

    }

    // get file from classpath, resources folder
    public static File getFileFromResources(Ftp_Server_Application app, String fileName) {
        ClassLoader classLoader = app.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }

}
