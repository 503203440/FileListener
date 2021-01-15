package org.yx;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(Main.class.getResourceAsStream("/config.properties"));
        String rootDir = properties.getProperty("rootDir");
        log.info("监听目录为：{}", rootDir);

        // 间隔时间
        long interval = TimeUnit.SECONDS.toMillis(1);

        //过滤器
        IOFileFilter directories = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(), HiddenFileFilter.VISIBLE);
        IOFileFilter files = FileFilterUtils.and(FileFilterUtils.fileFileFilter(), FileFilterUtils.suffixFileFilter(".txt"));
        IOFileFilter filter = FileFilterUtils.or(directories, files);

//        FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir), filter);
        FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir));

        observer.addListener(new FileListener());

        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);

        monitor.start();

    }
}
