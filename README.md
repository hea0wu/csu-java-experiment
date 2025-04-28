# csu-java-experiment

## experiment1
1. 定义一个表示学生信息的类Student，要求如下：
- 类Student的成员变量： sNO表示学号；sName表示姓名；sSex表示性别；sAge表示年龄；sJava表示Java课程成绩。
- 类Student的方法成员： getNo()获得学号；getName()获得姓名；getSex()获得性别；getAge()获得年龄；getJava()获得Java 课程成绩。
2. 按第1题中学生类Student的定义，创建两个该类的对象，存储并输出两个学生的信息，计算并输出这两个学生Java语言成绩的平均值。
3. 创建第1题的Student类的5个对象，求他们Java语言成绩的最大值和最小值。

## experiment2
1. 根据下面的要求实现圆类Circle。
- 圆类Circle的成员变量：radius表示圆的半径。
- 圆类Circle的方法成员：
Circle()：构造方法，将半径置0；
Circle(double r)：构造方法，创建Circle对象时将半径初始化为r；
double getRadius()：获得圆的半径值；
double getPerimeter()：获得圆的周长；
double getArea()：获得圆的面积；
void disp()：将圆的半径、圆的周长和圆的面积输出到屏幕。
2. 继承第1题中的圆Circle类，派生球类Sphere。要求如下：
- 球类Circle的方法成员：
Sphere()：构造方法，将半径置0；
Sphere(double r)：构造方法，创建Sphere对象时将半径初始化为r；
double getVol()：获得球的体积；
double getArea()：获得球的面积；
void disp()：将球的半径、面积、体积输出到屏幕。
3. 继承第1题中的圆Circle类，派生圆柱体类Cylinder。要求如下：
- 圆柱体类Cylinder的成员变量：height表示圆柱体的高。
- 圆柱体类Cylinder的成员方法：
Cylinder(double r，double h)：构造方法，创建Cylinder对象时将圆半径初始化为r，圆柱高初始为h；
double getHeight()：获得圆柱体的高；
double getVol()：获得圆柱体的体积；
double getArea()：获得圆柱体的面积；
void disp()：将圆柱体半径、高、面积和体积输出到屏幕。
4. 完成主函数，依据用户的键盘输入对象类型和参数，分别实例化圆、球和圆柱体对象，并采用多态的方法，调用disp()灵活输出所生成对象的信息。

## experiment3
1. 定义一个抽象类Shape，它包含一个抽象方法getArea()，从Shape类派生出Rectangle和Circle类，这两个类都用getArea()方法计算对象的面积。编写应用程序使用Rectangle和Circle类。实验要求：定义Rectangle和Circle类的构造方法，初始化成员变量。
2. 学校中有老师和学生两类人，而在职研究生既是老师又是学生。实验要求：在Graduate中实现各个接口声明的抽象方法。
- 设计两个信息管理接口StudentInterface和TeacherInterface，其中StudentInterface接口包括setFee()方法和getFee()方法，分别用于设置和获取学生的学费，TeacherInterface接口包括setPay()和getPay()方法，分别用于设置和获取老师的工资。
- 定义一个研究生类Graduate，实现StudentInterface接口和TeacherInterface接口，它定义的成员变量有name（姓名），sex（性别），age（年龄），fee（每学期学费） pay（月工资）。
- 创建一个姓名为“zhangsan”的研究生，统计他的年收入和学费，如果收入减去学费不足2000元，则输出“You need a loan!”（需要贷款）的信息，否则输出“You income is enough！”信息。

## experiment4
1. 自定义非法年龄类IllegalAgeException，定义一个Person类，包含年龄，姓名，性别等属性，编写属性设置和读取函数，在设置年龄函数中，判断参数是否符合要求（1~150），如果不符合则抛出异常，编写main函数进行测试。
2. 用继承Thread类的方法实现一个多线程程序，该程序先后启动三个线程，每个线程首先打印出一条线程创建信息，然后休眠一个随机时间，最后打印出线程结束信息退出。
3. 在一个线程中求100以内素数，求出后休眠一个随机时间。在另一线程中求100以内能被3整除的数，求出后休眠一个随机时间。输出数据时应有提示，指明哪个线程输出的数据。

## experiment5
1. 输入一个字符串，将其中的大写英文字母改小写字母，小写字母改大写字母，然后输出.
2. 检查输入的字符串是否是“回文”，例如 “abc123321cba”就是回文.
3. 输入两个字符串，从第一个字符串中删除第二个字符串的内容.
4. 从命令行方式输入的字符串中删去所有重复的字符，每种字符只保留一个。
5. 统计一个字符串中给定字符串出现的频率。
6. 将一个表示十进制数的字符串转换为以逗号分隔的字符串，从右边开始每三个数字标一个逗号. 例如，给定一个字符串“1234567”，该方法返回 “1,234,567”。
7. 求2~200之间的所有素数，将求得的结果保存到 PRIME.DAT 文件中.
8. 检查C盘根目录下 CONFIG.SYS 文件是否存在，若在则显示该文件的名称和内容。
9. 输入5个学生的信息（包含学号、姓名、3科成绩），统计各学生的总分，然后将学生信息和统 计结果存入二进制数据文件 STUDENT.DAT 中。
10. 从第9题中建立的STUDENT.DAT 文件中读取数据，寻找平均分最高的学生，并输出该学生 的所有信息。

## Snake Off
“太贪吃”和“大迷糊”是两条贪吃蛇。饥饿的他们来到一块苹果园，你能帮他们找到苹果吗？
主要规则如下：
1. 游戏会在界面中不同的位置随机生成苹果，但同一时刻界面中只会存在一个苹果；
2. 玩家可以通过“上下左右”方向键控制“太贪吃”的移动方向，寻找苹果，每吃一个苹果就能获得一定的积分，同时“太贪吃”的身体会随着吃到苹果数量的增加而变长。
3. “大迷糊”不能被玩家控制，在场景里会随机移动，“太贪吃”在寻找苹果的过程中需要避开“大迷糊”。
4. 失败条件：蛇头碰到蛇身、蛇头碰到边界、“太贪吃”碰到“大迷糊”。