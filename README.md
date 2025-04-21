# csu-java-experiment

## experiment3
1.定义一个抽象类Shape，它包含一个抽象方法getArea()，从Shape类派生出Rectangle和Circle类，这两个类都用getArea()方法计算对象的面积。编写应用程序使用Rectangle和Circle类。实验要求：定义Rectangle和Circle类的构造方法，初始化成员变量。
2.学校中有老师和学生两类人，而在职研究生既是老师又是学生。实验要求：在Graduate中实现各个接口声明的抽象方法。
(1) 设计两个信息管理接口StudentInterface和TeacherInterface，其中StudentInterface接口包括setFee()方法和getFee()方法，分别用于设置和获取学生的学费，TeacherInterface接口包括setPay()和getPay()方法，分别用于设置和获取老师的工资。
(2) 定义一个研究生类Graduate，实现StudentInterface接口和TeacherInterface接口，它定义的成员变量有name（姓名），sex（性别），age（年龄），fee（每学期学费） pay（月工资）。
(3) 创建一个姓名为“zhangsan”的研究生，统计他的年收入和学费，如果收入减去学费不足2000元，则输出“You need a loan!”（需要贷款）的信息，否则输出“You income is enough！”信息。