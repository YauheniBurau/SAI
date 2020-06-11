package core.application.workflowPlugins.algo;

import core.old.ftpStorage.FtpStorageServer;
import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataFtpStorageServerFX;
import core.application.workflowPlugins.param.*;

import java.io.Serializable;

/**
 * Algo FtpStorageServer
 * Created by anonymous on 02.05.2019.
 */
@Algo(name = "FTP Server",
        description = "run ftp server on local machine",
        group = "FTP")
public class Algo_FtpServer extends AbstractAlgorithm implements Serializable {
    @AlgoParam
    private Param<FileDirectory> pFileDirectory = new Param<>(" FTP servel local Directory", new FileDirectory(), ParamFileDirectoryFX.class);
    @AlgoParam
    private Param<Integer> pFtpPort = new Param<>("FTP server port", 2221, ParamIntegerFX.class);
    @AlgoParam
    private Param<String> pAdminName = new Param<>("Admin login", "admin", ParamStringFX.class);
    @AlgoParam
    private Param<String> pAdminPass = new Param<>("Admin password", "adminpass", ParamStringFX.class);
    @AlgoParam
    private Param<String> pUserName = new Param<>("ReadUser login", "user", ParamStringFX.class);
    @AlgoParam
    private Param<String> pUserPass = new Param<>("ReadUser password", "userpass", ParamStringFX.class);
    @AlgoDataOut
    private Data<FtpStorageServer> oFtpStorageServer = new Data<>("FtpStorageServer", new FtpStorageServer(), this, DataFtpStorageServerFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        FtpStorageServer server = new FtpStorageServer(pFileDirectory.getValue().getFile().getAbsolutePath(),
                pFtpPort.getValue(),
                pAdminName.getValue(), pAdminPass.getValue(), pUserName.getValue(), pUserPass.getValue() );
        oFtpStorageServer.setValue(server);
        server.start();
        return result;
    }

}
