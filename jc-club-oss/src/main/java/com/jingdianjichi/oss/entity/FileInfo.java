/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.entity
 * @className com.jingdianjichi.oss.entity.FileInfo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.entity;

/**
 * FileInfo类用于表示文件信息。
 * 包括文件名、是否为目录的标志以及文件的ETag（用于验证文件的改变）。
 * 此类提供了基本的属性存取方法，用于操作文件属性。
 * @author zxf
 * @date 2024/6/27 13:41
 * @version 1.0
 */
public class FileInfo {
    /**
     * 文件名
     */
    private String fileName;

    /**
     * 是否为目录的标志，true表示是目录，false表示不是目录。
     */
    private boolean directoryFlag;

    /**
     * 文件的ETag，一个用于检查文件是否有更新的标识符。
     */
    private String etag;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDirectoryFlag() {
        return directoryFlag;
    }

    public void setDirectoryFlag(boolean directoryFlag) {
        this.directoryFlag = directoryFlag;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}

