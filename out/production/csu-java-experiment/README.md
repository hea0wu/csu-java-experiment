# csu-java-experiment

## experiment3
1.定义一个抽象类Shape，它包含一个抽象方法getArea()，从Shape类派生出Rectangle和Circle类，这两个类都用getArea()方法计算对象的面积。编写应用程序使用Rectangle和Circle类。实验要求：定义Rectangle和Circle类的构造方法，初始化成员变量。
2.学校中有老师和学生两类人，而在职研究生既是老师又是学生。实验要求：在Graduate中实现各个接口声明的抽象方法。
(1) 设计两个信息管理接口StudentInterface和TeacherInterface，其中StudentInterface接口包括setFee()方法和getFee()方法，分别用于设置和获取学生的学费，TeacherInterface接口包括setPay()和getPay()方法，分别用于设置和获取老师的工资。
(2) 定义一个研究生类Graduate，实现StudentInterface接口和TeacherInterface接口，它定义的成员变量有name（姓名），sex（性别），age（年龄），fee（每学期学费） pay（月工资）。
(3) 创建一个姓名为“zhangsan”的研究生，统计他的年收入和学费，如果收入减去学费不足2000元，则输出“You need a loan!”（需要贷款）的信息，否则输出“You income is enough！”信息。

## experiment4
1. 自定义非法年龄类IllegalAgeException，定义一个Person类，包含年龄，姓名，性别等属性，编写属性设置和读取函数，在设置年龄函数中，判断参数是否符合要求（1~150），如果不符合则抛出异常，编写main函数进行测试。
2. 用继承Thread类的方法实现一个多线程程序，该程序先后启动三个线程，每个线程首先打印出一条线程创建信息，然后休眠一个随机时间，最后打印出线程结束信息退出。
3. 在一个线程中求100以内素数，求出后休眠一个随机时间。在另一线程中求100以内能被3整除的数，求出后休眠一个随机时间。输出数据时应有提示，指明哪个线程输出的数据。