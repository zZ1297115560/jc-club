package com.jc.club.image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Image Recognition Utility Class
 * Provides functionality to identify and analyze images
 */
public class ImageRecognition {

    /**
     * Image format enumeration
     */
    public enum ImageFormat {
        JPEG("JPEG", new byte[][]{
            {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF}
        }),
        PNG("PNG", new byte[][]{
            {(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A}
        }),
        GIF("GIF", new byte[][]{
            {0x47, 0x49, 0x46, 0x38, 0x37, 0x61},  // GIF87a
            {0x47, 0x49, 0x46, 0x38, 0x39, 0x61}   // GIF89a
        }),
        BMP("BMP", new byte[][]{
            {0x42, 0x4D}
        }),
        UNKNOWN("UNKNOWN", new byte[0][]);

        private final String name;
        private final byte[][] signatures;

        ImageFormat(String name, byte[][] signatures) {
            this.name = name;
            this.signatures = signatures;
        }

        public String getName() {
            return name;
        }

        public byte[][] getSignatures() {
            return signatures;
        }
    }

    /**
     * Image information class
     */
    public static class ImageInfo {
        private final String fileName;
        private final ImageFormat format;
        private final long fileSize;
        private final String filePath;

        public ImageInfo(String fileName, ImageFormat format, long fileSize, String filePath) {
            this.fileName = fileName;
            this.format = format;
            this.fileSize = fileSize;
            this.filePath = filePath;
        }

        public String getFileName() {
            return fileName;
        }

        public ImageFormat getFormat() {
            return format;
        }

        public long getFileSize() {
            return fileSize;
        }

        public String getFilePath() {
            return filePath;
        }

        @Override
        public String toString() {
            return "ImageInfo{" +
                    "fileName='" + fileName + '\'' +
                    ", format=" + format.getName() +
                    ", fileSize=" + fileSize + " bytes" +
                    ", filePath='" + filePath + '\'' +
                    '}';
        }
    }

    /**
     * Recognize image format from file
     *
     * @param file the image file to recognize
     * @return ImageInfo containing image details
     * @throws IOException if file cannot be read
     */
    public static ImageInfo recognizeImage(File file) throws IOException {
        if (!file.exists() || !file.isFile()) {
            throw new IOException("File does not exist or is not a file: " + file.getPath());
        }

        byte[] fileBytes = Files.readAllBytes(file.toPath());
        ImageFormat format = detectFormat(fileBytes);
        
        return new ImageInfo(
            file.getName(),
            format,
            file.length(),
            file.getAbsolutePath()
        );
    }

    /**
     * Recognize image format from file path
     *
     * @param filePath the path to the image file
     * @return ImageInfo containing image details
     * @throws IOException if file cannot be read
     */
    public static ImageInfo recognizeImage(String filePath) throws IOException {
        return recognizeImage(new File(filePath));
    }

    /**
     * Detect image format from byte array
     *
     * @param fileBytes the byte array to analyze
     * @return detected ImageFormat
     */
    private static ImageFormat detectFormat(byte[] fileBytes) {
        if (fileBytes == null || fileBytes.length == 0) {
            return ImageFormat.UNKNOWN;
        }

        for (ImageFormat format : new ImageFormat[]{
            ImageFormat.PNG, ImageFormat.JPEG, ImageFormat.GIF, ImageFormat.BMP
        }) {
            for (byte[] signature : format.getSignatures()) {
                if (matchesSignature(fileBytes, signature)) {
                    return format;
                }
            }
        }

        return ImageFormat.UNKNOWN;
    }

    /**
     * Check if file bytes match a signature
     *
     * @param fileBytes the file bytes to check
     * @param signature the signature to match against
     * @return true if matches, false otherwise
     */
    private static boolean matchesSignature(byte[] fileBytes, byte[] signature) {
        if (fileBytes.length < signature.length) {
            return false;
        }

        for (int i = 0; i < signature.length; i++) {
            if (fileBytes[i] != signature[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check if a file is a valid image
     *
     * @param file the file to check
     * @return true if the file is a recognized image format
     */
    public static boolean isImage(File file) {
        try {
            ImageInfo info = recognizeImage(file);
            return info.getFormat() != ImageFormat.UNKNOWN;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Check if a file is a valid image by path
     *
     * @param filePath the file path to check
     * @return true if the file is a recognized image format
     */
    public static boolean isImage(String filePath) {
        return isImage(new File(filePath));
    }
}
