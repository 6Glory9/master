package utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by jxilong on 2016/7/12.
 */
@Component
@Scope("prototype")
public class FTPClientUtils implements InitializingBean {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final FTPClient ftp = new FTPClient();
	
	@Value("${ftp.hostName}")
	private String hostName = "127.0.0.1";
	
	@Value("${ftp.port}")
	private Integer port = 21;
	
	@Value("${ftp.userName}")
	private String username = "root";
	
	@Value("${ftp.password}")
	private String password = "root";
	
	@Value("${ftp.keepAliveTimeout}")
	private Integer keepAliveTimeout = 3000;
	
	@Value("${ftp.controlKeepAliveReplyTimeout}")
	private Integer controlKeepAliveReplyTimeout = 3000;
	
	@Value("${ftp.ftpEncoding}")
	private String ftpEncoding = "UTF-8";
	
	public boolean uploadFile(File file, String remotePath) {
		return false;
	}
	
	public boolean uploadFile(File file, String remoteDir, String fileName) {
		try {
			InputStream inputStream = new FileInputStream(file);
			return uploadFile(inputStream, remoteDir, fileName);
		} catch (FileNotFoundException e) {
			logger.warn("文件不存在,file{}", file);
		}
		return false;
	}
	
	private boolean uploadFile(InputStream inputStream, String remoteDir, String fileName) {
		if (connection() && login()) {
			try {
				changeDirIfMkdir(remoteDir);
				return ftp.storeFile(fileName, inputStream);
			} catch (Exception e) {
				logger.warn("uploadFile fail");
			} finally {
				closeInputAndLoginout(inputStream);
			}
		}
		return false;
	}
	
	private void changeDirIfMkdir(String remoteDir) {
		if (!cd(remoteDir)) {
			mkdir(remoteDir);
			cd(remoteDir);
		}
	}
	
	private void closeInputAndLoginout(InputStream inputStream) {
		try {
			if (inputStream != null) {
				inputStream.close();
			}
			ftp.noop();
			ftp.logout();
			disonnection();
		} catch (Exception e) {
			logger.warn("关闭资源出来问题");
		}
		
	}
	
	public InputStream downloadFile(String remotePath) {
		if (connection() && login()) {
			try {
				return ftp.retrieveFileStream(remotePath);
			} catch (IOException e) {
				logger.warn("下载资源失败");
			} finally {
				closeInputAndLoginout(null);
			}
		}
		return null;
	}
	
	private boolean mkdir(String dir) {
		try {
			ftp.mkd(dir);
		} catch (IOException e) {
			logger.warn("目录【{}】创建失败Exception【{}】", dir, e);
		}
		return false;
	}
	
	private boolean cd(String dir) {
		try {
			return ftp.changeWorkingDirectory(dir);
		} catch (IOException e) {
			logger.warn("【{}】此目录不存在", dir);
		}
		
		return false;
	}
	
	private boolean connection() {
		try {
			ftp.connect(hostName, port);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				logger.warn("ftp disconnect server");
				return false;
			}
		} catch (Exception e) {
			logger.warn("ftp connect server[{}:{}] fail", hostName, port);
			return false;
		}
		return true;
	}
	
	private void disonnection() {
		try {
			if (ftp.isConnected()) {
				ftp.disconnect();
				logger.warn("ftp disconnect server success");
			}
		} catch (Exception e) {
			logger.warn("ftp disconnect server fail");
		}
	}
	
	private boolean login() {
		try {
			if (!ftp.login(username, password)) {
				ftp.logout();
				logger.warn("ftp logout server");
			}
		} catch (Exception e) {
			logger.warn("ftp login server[{}:{}] fail", username, password);
			return false;
		}
		return true;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//ftp.setCopyStreamListener(createListener());
		ftp.setControlKeepAliveTimeout(keepAliveTimeout);
		ftp.setControlKeepAliveReplyTimeout(controlKeepAliveReplyTimeout);
		ftp.setControlEncoding(ftpEncoding);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
	}
	
	public static void main(String[] args) {
		FTPClientUtils test = new FTPClientUtils();
		test.uploadFile(
			new File("F:\\codes\\sources\\git\\springmvc-example-master\\src\\main\\resources\\ftp.properties"), "xx\\xxx",
			"ftp.properties");
	}
	
}
