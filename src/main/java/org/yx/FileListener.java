package org.yx;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FileListener extends FileAlterationListenerAdaptor {

    Logger log = LoggerFactory.getLogger(FileListener.class);

    @Override
    public void onDirectoryCreate(File directory) {
        log.info("文件创建:{}", directory.getAbsoluteFile());
    }

    @Override
    public void onDirectoryChange(File directory) {
        log.info("文件夹改变:{}", directory.getAbsoluteFile());
    }

    @Override
    public void onDirectoryDelete(File directory) {
        log.info("文件夹删除:{}", directory.getAbsoluteFile());
    }

    @Override
    public void onFileCreate(File file) {
        log.info("文件创建:{}", file.getAbsoluteFile());
    }

    @Override
    public void onFileChange(File file) {
        log.info("文件改变:{}", file.getAbsoluteFile());
    }

    @Override
    public void onFileDelete(File file) {
        log.info("文件删除:{}", file.getAbsoluteFile());
    }
}
