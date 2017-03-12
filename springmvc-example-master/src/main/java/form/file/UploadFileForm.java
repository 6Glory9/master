/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-22 12:34 创建
 *
 */
package form.file;

import com.yjf.common.util.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author jxilong@yiji.com
 */
public class UploadFileForm implements Serializable {

    private String fileName;

    private MultipartFile file;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
