# Java 学习项目

这是一个 Java 入门 Demo 项目，包含计算器、学生信息管理、猜数字游戏三个功能。

## 当前环境

| 项目 | 信息 |
|------|------|
| JDK 版本 | **Amazon Corretto 21**（OpenJDK 21.0.11 LTS） |
| 安装路径 | `C:\Program Files\Amazon Corretto\jdk21.0.11_10` |
| 项目路径 | `d:\cc-project\project\java-lianxi` |

## 如何运行

### ✅ 方式一：双击 run.bat 运行（最简单）
在文件管理器中双击 `run.bat`，即可编译并运行程序。

### ✅ 方式二：在 Git Bash 中运行
```bash
cd d:/cc-project/project/java-lianxi
./run.sh
```

### ✅ 方式三：手动编译运行
```bash
javac -d out src/main/java/com/demo/*.java
java -cp out com.demo.DemoApplication
```

### ✅ 方式四：在 VS Code 中运行
1. 打开 VS Code
2. **文件 → 打开文件夹** → 选择 `d:\cc-project\project\java-lianxi`
3. 安装 **Extension Pack for Java**（点击左侧扩展按钮搜索安装）
4. 打开 `src/main/java/com/demo/DemoApplication.java`
5. 点击上方的 **Run** 或按 `F5`

## 设置 JAVA_HOME 环境变量（一次性）

为了方便在命令行中使用 `java` 和 `javac`，建议设置系统环境变量：

1. 按 `Win + R`，输入 `sysdm.cpl` → 确定
2. **高级 → 环境变量**
3. 在 **系统变量** 中点击 **新建**：
   - 变量名: `JAVA_HOME`
   - 变量值: `C:\Program Files\Amazon Corretto\jdk21.0.11_10`
4. 找到 `Path` 变量 → 编辑 → 新建 → 添加 `%JAVA_HOME%\bin`
5. 确定保存，重新打开终端输入 `javac -version` 验证

---

## 项目结构

```
java-lianxi/
├── .vscode/                    # VS Code 配置
│   ├── settings.json           # 编辑器设置（JDK 路径等）
│   └── launch.json             # 调试启动配置
├── out/                        # 编译输出（自动生成）
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── demo/
│                   ├── DemoApplication.java   # 主程序入口
│                   ├── Calculator.java         # 计算器类
│                   └── Student.java            # 学生类（OOP 示例）
├── run.bat                     # Windows 一键运行脚本
├── run.sh                      # Git Bash 运行脚本
└── README.md                   # 本说明文件
```

## 功能说明

| 功能 | 说明 | 涉及的知识点 |
|------|------|-------------|
| 🧮 简单计算器 | 加减乘除四则运算 | 条件分支、异常处理、方法调用 |
| 📊 学生信息管理 | 展示学生列表和成绩统计 | 面向对象、数组、循环、格式化输出 |
| 🎯 猜数字游戏 | 1-100 猜数字，限 7 次机会 | 随机数、循环、输入输出 |

## VS Code 快捷键速查

| 快捷键 | 功能 |
|--------|------|
| `Ctrl+Shift+X` | 打开扩展面板 |
| `F5` | 启动调试运行 |
| `Ctrl+F5` | 直接运行（不调试） |
| `Ctrl+\`` | 打开终端 |
| `Ctrl+Shift+P` | 打开命令面板 |
