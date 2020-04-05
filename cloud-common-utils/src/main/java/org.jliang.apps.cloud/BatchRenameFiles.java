package org.jliang.apps.cloud;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
/**
 * 功能描述:批量重命名文件
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/4/5
 * @author Lenovo
 */
@Slf4j
public class BatchRenameFiles {
    /**
     * 新字符串,如果是去掉前缀后缀就留空，否则写上需要替换的字符串
     */
    private static String newString = "";
    /**
     * 要被替换的字符串
     */
    private static String oldString = "";
    /**
     * 文件所在路径，所有文件的根目录，记得修改为你电脑上的文件所在路径
     */
    private static String dir = "";

    public static void main(String[] args) throws IOException {
        //递归遍历此路径下所有文件夹
        recursiveTraversalFolder(dir);
    }
    /**
     * 递归遍历文件夹获取文件
     */
    public static void recursiveTraversalFolder(String path) {
        File folder = new File(path);
        if (folder.exists()) {
            File[] fileArr = folder.listFiles();
            if (null == fileArr || fileArr.length == 0) {
                log.info("文件夹是空的!");
                return;
            } else {
                //文件所在文件夹路径+新文件名
                File newDir = null;
                //新文件名
                String newName = "";
                //旧文件名
                String fileName = null;
                //文件所在父级路径
                File parentPath = new File("");
                for (File file : fileArr) {
                    //是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
                    if (file.isDirectory()) {
                        log.info("文件夹:" + file.getAbsolutePath() + "，继续递归！");
                        recursiveTraversalFolder(file.getAbsolutePath());
                    } else {//是文件，判断是否需要重命名
                        fileName = file.getName();
                        parentPath = file.getParentFile();
                        //文件名包含需要被替换的字符串
                        if (fileName.contains(oldString)) {
                            //新名字
                            newName = fileName.replaceAll(oldString, newString);
                            //文件所在文件夹路径+新文件名
                            newDir = new File(parentPath + "/" + newName);
                            //重命名
                            file.renameTo(newDir);
                            log.info("修改后：" + newDir);
                        }
                    }
                }
            }
        } else {
            log.info("文件不存在!");
        }
    }
}