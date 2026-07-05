#!/bin/bash
# Java Demo - 编译并运行（用于 Git Bash / Linux / macOS）

echo "Java Demo - 编译并运行"
echo "========================"

# 编译 Java 文件
echo "正在编译..."
javac -d out src/main/java/com/demo/*.java

if [ $? -ne 0 ]; then
    echo "编译失败！请确认 JDK 已正确安装。"
    exit 1
fi

# 运行程序
echo "编译成功！正在运行..."
echo "------------------------"
java -cp out com.demo.DemoApplication
