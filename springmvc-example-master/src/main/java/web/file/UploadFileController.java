/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-22 12:33 创建
 *
 */
package web.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import web.BaseController;

import java.io.File;
import java.io.IOException;

/**
 * @author jxilong@yiji.com
 */
@RequestMapping("file")
@Controller
public class UploadFileController extends BaseController {


    /**
     * 自动会删除上传的文件
     * @param file
     */
    @RequestMapping("upload")
    public void upload(MultipartFile file) {
        logger.info("UploadFileController upload [{}]", file);
        if (!file.isEmpty()) {
            checkFileSize(file);
            checkFileFormat(file);
            saveFile(file);
        }
    }

    private void saveFile(MultipartFile file) {
        try {
            file.transferTo(new File("temp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkFileFormat(MultipartFile file) {

    }

    private void checkFileSize(MultipartFile file) {

    }


}
