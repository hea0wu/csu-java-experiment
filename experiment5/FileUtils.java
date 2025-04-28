package experiment5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class FileUtils {
    // 问题7：生成2~200的素数并保存到PRIME.DAT
    public static void generatePrimesToFile() throws IOException {
        boolean[] isPrime = new boolean[201];
        Arrays.fill(isPrime, true);
        for (int i = 2; i*i <= 200; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= 200; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("PRIME.DAT"))) {
            for (int i = 2; i <= 200; i++) {
                if (isPrime[i]) {
                    writer.write(Integer.toString(i));
                    writer.newLine();
                }
            }
        }
    }

    // 问题8：检查C盘CONFIG.SYS是否存在并显示内容
    public static void checkAndDisplayConfigSys() throws IOException {
        File config = new File("C:\\CONFIG.SYS");
        if (!config.exists()) {
            System.out.println("文件不存在");
            return;
        }

        System.out.println("文件名：" + config.getName());
        System.out.println("内容：");
        Files.readAllLines(config.toPath(), StandardCharsets.ISO_8859_1)
                .forEach(System.out::println);
    }

    // 问题9：保存学生信息到二进制文件
    public static void saveStudentsToBinaryFile() throws IOException {
        List<Student> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 5; i++) {
                System.out.println("输入学生信息（学号 姓名 成绩1 成绩2 成绩3）：");
                String id = scanner.next();
                String name = scanner.next();
                int[] scores = {
                        scanner.nextInt(),
                        scanner.nextInt(),
                        scanner.nextInt()
                };
                students.add(new Student(id, name, scores));
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("STUDENT.DAT"))) {
            oos.writeObject(students);
        }
    }

    // 问题10：读取二进制文件并输出最高分学生
    public static void findTopStudentFromFile() throws IOException, ClassNotFoundException {
        List<Student> students;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("STUDENT.DAT"))) {
            students = (List<Student>) ois.readObject();
        }

        Student topStudent = students.stream()
                .max(Comparator.comparingDouble(Student::getAverage))
                .orElseThrow();

        System.out.println("最高分学生：");
        System.out.println(topStudent);
    }

    // 学生数据类
    static class Student implements Serializable {
        private final String id;
        private final String name;
        private final int[] scores;
        private final int total;

        public Student(String id, String name, int[] scores) {
            this.id = id;
            this.name = name;
            this.scores = scores;
            this.total = Arrays.stream(scores).sum();
        }

        public double getAverage() {
            return total / 3.0;
        }

        @Override
        public String toString() {
            return String.format("学号：%s 姓名：%s 成绩：[%d, %d, %d] 总分：%d 平均分：%.1f",
                    id, name, scores[0], scores[1], scores[2], total, getAverage());
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("=== 生成素数并保存到文件 ===");
            generatePrimesToFile();
            System.out.println();
            
            System.out.println("=== 检查系统配置文件 ===");
            try {
                checkAndDisplayConfigSys();
            } catch (IOException e) {
                System.out.println("检查配置文件时出错: " + e.getMessage());
            }
            System.out.println();
            
            System.out.println("=== 输入学生信息并保存 ===");
            try {
                saveStudentsToBinaryFile();
            } catch (IOException e) {
                System.out.println("保存学生信息时出错: " + e.getMessage());
            }
            System.out.println();
            
            System.out.println("=== 查找最高分学生 ===");
            try {
                findTopStudentFromFile();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("查找最高分学生时出错: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("程序执行过程中出现错误: ");
            e.printStackTrace();
        }
    }
}
