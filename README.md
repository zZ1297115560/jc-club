# jc-club

图片识别系统 (Image Recognition System)

## 功能简介 (Features)

本项目实现了基本的图片识别功能，可以识别常见的图片格式并获取图片信息。

This project implements basic image recognition functionality that can identify common image formats and retrieve image information.

### 支持的图片格式 (Supported Image Formats)

- **JPEG** (.jpg, .jpeg)
- **PNG** (.png)
- **GIF** (.gif)
- **BMP** (.bmp)

### 主要功能 (Main Features)

1. **图片格式识别** - 通过分析文件头部字节识别图片格式
2. **文件信息获取** - 获取文件名、文件大小、文件路径等信息
3. **图片验证** - 检查文件是否为有效的图片文件

## 项目结构 (Project Structure)

```
jc-club/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── jc/
│                   └── club/
│                       └── image/
│                           ├── ImageRecognition.java       # 核心识别类
│                           └── ImageRecognitionDemo.java   # 演示程序
├── pom.xml
└── README.md
```

## 使用方法 (Usage)

### 1. 构建项目 (Build the Project)

```bash
mvn clean compile
```

### 2. 运行演示程序 (Run Demo)

```bash
# 查看使用说明
mvn exec:java -Dexec.mainClass="com.jc.club.image.ImageRecognitionDemo"

# 识别指定图片
mvn exec:java -Dexec.mainClass="com.jc.club.image.ImageRecognitionDemo" -Dexec.args="/path/to/your/image.jpg"
```

### 3. 代码示例 (Code Example)

```java
import com.jc.club.image.ImageRecognition;
import java.io.File;

public class Example {
    public static void main(String[] args) throws Exception {
        // 识别图片
        ImageRecognition.ImageInfo info = ImageRecognition.recognizeImage("image.jpg");
        
        // 输出信息
        System.out.println("格式: " + info.getFormat().getName());
        System.out.println("大小: " + info.getFileSize() + " bytes");
        
        // 检查是否为图片
        boolean isImage = ImageRecognition.isImage("image.jpg");
        System.out.println("是否为图片: " + isImage);
    }
}
```

## API 文档 (API Documentation)

### ImageRecognition 类

#### 主要方法 (Main Methods)

- `recognizeImage(File file)` - 识别图片文件并返回详细信息
- `recognizeImage(String filePath)` - 通过文件路径识别图片
- `isImage(File file)` - 检查文件是否为有效图片
- `isImage(String filePath)` - 通过文件路径检查是否为有效图片

#### ImageInfo 类

包含以下信息：
- `fileName` - 文件名
- `format` - 图片格式
- `fileSize` - 文件大小（字节）
- `filePath` - 文件完整路径

## 技术实现 (Technical Implementation)

图片格式识别通过分析文件的魔数（magic numbers）实现，即读取文件头部的特定字节序列来判断文件类型：

- **JPEG**: `FF D8 FF`
- **PNG**: `89 50 4E 47 0D 0A 1A 0A`
- **GIF87a**: `47 49 46 38 37 61`
- **GIF89a**: `47 49 46 38 39 61`
- **BMP**: `42 4D`

## 系统要求 (Requirements)

- Java 11 或更高版本
- Maven 3.x

## 许可证 (License)

See LICENSE file for details.
