package com.jc.club.image;

import java.io.File;
import java.io.IOException;

/**
 * Demo class to demonstrate image recognition functionality
 * 演示图片识别功能的示例类
 */
public class ImageRecognitionDemo {

    public static void main(String[] args) {
        System.out.println("=== 图片识别系统 (Image Recognition System) ===");
        System.out.println();

        if (args.length == 0) {
            System.out.println("使用方法 (Usage): java ImageRecognitionDemo <image-file-path>");
            System.out.println("示例 (Example): java ImageRecognitionDemo /path/to/image.jpg");
            System.out.println();
            demonstrateUsage();
            return;
        }

        // Process command line argument
        String imagePath = args[0];
        recognizeImageFromPath(imagePath);
    }

    /**
     * Demonstrate the usage of ImageRecognition class
     * 演示 ImageRecognition 类的使用
     */
    private static void demonstrateUsage() {
        System.out.println("=== 功能演示 (Feature Demonstration) ===");
        System.out.println();
        System.out.println("支持的图片格式 (Supported Image Formats):");
        System.out.println("- JPEG (.jpg, .jpeg)");
        System.out.println("- PNG (.png)");
        System.out.println("- GIF (.gif)");
        System.out.println("- BMP (.bmp)");
        System.out.println();
        System.out.println("主要功能 (Main Features):");
        System.out.println("1. 识别图片格式 (Identify image format)");
        System.out.println("2. 获取文件大小 (Get file size)");
        System.out.println("3. 检查文件是否为有效图片 (Check if file is a valid image)");
        System.out.println();
    }

    /**
     * Recognize image from file path
     * 从文件路径识别图片
     *
     * @param imagePath the path to the image file
     */
    private static void recognizeImageFromPath(String imagePath) {
        File imageFile = new File(imagePath);
        
        System.out.println("正在识别图片 (Recognizing image): " + imagePath);
        System.out.println();

        // Check if file exists
        if (!imageFile.exists()) {
            System.err.println("错误 (Error): 文件不存在 (File does not exist)");
            return;
        }

        if (!imageFile.isFile()) {
            System.err.println("错误 (Error): 路径不是文件 (Path is not a file)");
            return;
        }

        try {
            // Recognize the image
            ImageRecognition.ImageInfo imageInfo = ImageRecognition.recognizeImage(imageFile);
            
            // Display results
            System.out.println("识别结果 (Recognition Results):");
            System.out.println("-----------------------------------");
            System.out.println("文件名 (File Name): " + imageInfo.getFileName());
            System.out.println("图片格式 (Image Format): " + imageInfo.getFormat().getName());
            System.out.println("文件大小 (File Size): " + formatFileSize(imageInfo.getFileSize()));
            System.out.println("文件路径 (File Path): " + imageInfo.getFilePath());
            System.out.println("-----------------------------------");
            
            if (imageInfo.getFormat() == ImageRecognition.ImageFormat.UNKNOWN) {
                System.out.println("警告 (Warning): 无法识别图片格式 (Unable to recognize image format)");
            } else {
                System.out.println("✓ 成功识别图片 (Successfully recognized image)");
            }

        } catch (IOException e) {
            System.err.println("错误 (Error): " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Format file size to human-readable format
     * 将文件大小格式化为人类可读的格式
     *
     * @param size the file size in bytes
     * @return formatted string
     */
    private static String formatFileSize(long size) {
        if (size < 1024) {
            return size + " B";
        } else if (size < 1024 * 1024) {
            return String.format("%.2f KB", size / 1024.0);
        } else if (size < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", size / (1024.0 * 1024));
        } else {
            return String.format("%.2f GB", size / (1024.0 * 1024 * 1024));
        }
    }
}
