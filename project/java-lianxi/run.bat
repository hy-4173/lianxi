@echo off
chcp 65001 >nul
echo Java Demo - 编译并运行
echo ========================

REM 编译 Java 文件
echo 正在编译...
javac -d out src\main\java\com\demo\*.java

IF %ERRORLEVEL% NEQ 0 (
    echo 编译失败！请确认 JDK 已正确安装。
    pause
    exit /b 1
)

REM 运行程序
echo 编译成功！正在运行...
echo ------------------------
java -cp out com.demo.DemoApplication

pause
