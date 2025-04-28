package SnakeOff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * 游戏面板类
 * 负责游戏的绘制和逻辑处理
 */
public class GamePanel extends JPanel implements ActionListener {
    private static final int UNIT_SIZE = 20; // 单元格大小
    private static final int GAME_UNITS = (600 * 600) / (UNIT_SIZE * UNIT_SIZE); // 游戏单元格总数
    private static final int DELAY = 100; // 游戏速度（毫秒）

    private final int[] x = new int[GAME_UNITS]; // 太贪吃的x坐标
    private final int[] y = new int[GAME_UNITS]; // 太贪吃的y坐标
    private int bodyParts = 5; // 太贪吃的初始长度
    private int applesEaten = 0; // 吃掉的苹果数量
    private int appleX; // 苹果的x坐标
    private int appleY; // 苹果的y坐标
    private char direction = 'R'; // 初始方向向右
    private boolean running = false; // 游戏是否运行中
    private Timer timer;
    private Random random;
    private int score = 0; // 得分

    // 大迷糊蛇
    private int[] confusedX = new int[GAME_UNITS];
    private int[] confusedY = new int[GAME_UNITS];
    private int confusedBodyParts = 5;
    private char confusedDirection = 'L';

    public GamePanel() {
        random = new Random();
        setBackground(Color.BLACK);
        setFocusable(true);
        
        // 添加键盘监听器到面板本身
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyCode());
            }
        });
        
        startGame();
    }

    public void startGame() {
        // 初始化太贪吃蛇
        for (int i = 0; i < bodyParts; i++) {
            x[i] = 300 - i * UNIT_SIZE;
            y[i] = 300;
        }

        // 初始化大迷糊蛇
        for (int i = 0; i < confusedBodyParts; i++) {
            confusedX[i] = 300 + i * UNIT_SIZE;
            confusedY[i] = 100;
        }

        // 生成第一个苹果
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            // 绘制网格线
            for (int i = 0; i < 600 / UNIT_SIZE; i++) {
                g.setColor(new Color(50, 50, 50));
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, 600);
                g.drawLine(0, i * UNIT_SIZE, 600, i * UNIT_SIZE);
            }

            // 绘制苹果
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // 绘制太贪吃蛇
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(new Color(45, 180, 0));
                }
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }

            // 绘制大迷糊蛇
            for (int i = 0; i < confusedBodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.BLUE);
                } else {
                    g.setColor(new Color(0, 0, 150));
                }
                g.fillRect(confusedX[i], confusedY[i], UNIT_SIZE, UNIT_SIZE);
            }

            // 绘制分数
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("得分: " + score, (600 - metrics.stringWidth("得分: " + score)) / 2, g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }

    public void newApple() {
        boolean validPosition;
        do {
            validPosition = true;
            appleX = random.nextInt((int) (600 / UNIT_SIZE)) * UNIT_SIZE;
            appleY = random.nextInt((int) (600 / UNIT_SIZE)) * UNIT_SIZE;

            // 确保苹果不会出现在太贪吃蛇身上
            for (int i = 0; i < bodyParts; i++) {
                if (appleX == x[i] && appleY == y[i]) {
                    validPosition = false;
                    break;
                }
            }

            // 确保苹果不会出现在大迷糊蛇身上
            for (int i = 0; i < confusedBodyParts; i++) {
                if (appleX == confusedX[i] && appleY == confusedY[i]) {
                    validPosition = false;
                    break;
                }
            }
        } while (!validPosition);
    }

    public void move() {
        // 移动太贪吃蛇
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

        // 移动大迷糊蛇（随机移动）
        for (int i = confusedBodyParts; i > 0; i--) {
            confusedX[i] = confusedX[i - 1];
            confusedY[i] = confusedY[i - 1];
        }
    
        // 随机改变大迷糊蛇的方向（30%的概率）
        if (random.nextInt(10) < 3) {
            int dir = random.nextInt(4);
            switch (dir) {
                case 0:
                    if (confusedDirection != 'D') confusedDirection = 'U';
                    break;
                case 1:
                    if (confusedDirection != 'U') confusedDirection = 'D';
                    break;
                case 2:
                    if (confusedDirection != 'R') confusedDirection = 'L';
                    break;
                case 3:
                    if (confusedDirection != 'L') confusedDirection = 'R';
                    break;
            }
        }
    
        // 预判下一步位置，检查是否会撞墙
        int nextX = confusedX[0];
        int nextY = confusedY[0];
        
        switch (confusedDirection) {
            case 'U':
                nextY = confusedY[0] - UNIT_SIZE;
                break;
            case 'D':
                nextY = confusedY[0] + UNIT_SIZE;
                break;
            case 'L':
                nextX = confusedX[0] - UNIT_SIZE;
                break;
            case 'R':
                nextX = confusedX[0] + UNIT_SIZE;
                break;
        }
        
        // 如果下一步会撞墙，则改变方向
        if (nextX < 0 || nextX >= 600 || nextY < 0 || nextY >= 600) {
            // 尝试找一个不会撞墙的方向
            char[] possibleDirections = {'U', 'D', 'L', 'R'};
            boolean foundDirection = false;
            
            for (char newDirection : possibleDirections) {
                // 跳过当前方向和相反方向
                if ((confusedDirection == 'U' && newDirection == 'D') ||
                    (confusedDirection == 'D' && newDirection == 'U') ||
                    (confusedDirection == 'L' && newDirection == 'R') ||
                    (confusedDirection == 'R' && newDirection == 'L') ||
                    newDirection == confusedDirection) {
                    continue;
                }
                
                // 检查新方向是否会撞墙
                int testX = confusedX[0];
                int testY = confusedY[0];
                
                switch (newDirection) {
                    case 'U':
                        testY = confusedY[0] - UNIT_SIZE;
                        break;
                    case 'D':
                        testY = confusedY[0] + UNIT_SIZE;
                        break;
                    case 'L':
                        testX = confusedX[0] - UNIT_SIZE;
                        break;
                    case 'R':
                        testX = confusedX[0] + UNIT_SIZE;
                        break;
                }
                
                if (testX >= 0 && testX < 600 && testY >= 0 && testY < 600) {
                    confusedDirection = newDirection;
                    nextX = testX;
                    nextY = testY;
                    foundDirection = true;
                    break;
                }
            }
            
            // 如果所有方向都会撞墙，就保持原位
            if (!foundDirection) {
                nextX = confusedX[0];
                nextY = confusedY[0];
            }
        }
    
        // 更新大迷糊蛇头部位置
        confusedX[0] = nextX;
        confusedY[0] = nextY;
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            score += 10;
            newApple();
        }
    }

    public void checkCollisions() {
        // 检查太贪吃蛇头是否撞到自己的身体
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        // 检查太贪吃蛇头是否撞到边界
        if (x[0] < 0 || x[0] >= 600 || y[0] < 0 || y[0] >= 600) {
            running = false;
        }

        // 检查太贪吃蛇是否撞到大迷糊蛇
        for (int i = 0; i < confusedBodyParts; i++) {
            if ((x[0] == confusedX[i]) && (y[0] == confusedY[i])) {
                running = false;
            }
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        // 游戏结束显示
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("游戏结束", (600 - metrics1.stringWidth("游戏结束")) / 2, 600 / 2);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("得分: " + score, (600 - metrics2.stringWidth("得分: " + score)) / 2, 600 / 2 + 50);
        
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics metrics3 = getFontMetrics(g.getFont());
        g.drawString("按空格键重新开始", (600 - metrics3.stringWidth("按空格键重新开始")) / 2, 600 / 2 + 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public void handleKeyPress(int keyCode) {
        System.out.println("按键代码: " + keyCode); // 添加调试输出
        
        if (running) {
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        } else if (keyCode == KeyEvent.VK_SPACE) {
            // 重新开始游戏
            bodyParts = 5;
            applesEaten = 0;
            score = 0;
            direction = 'R';
            confusedDirection = 'L';
            startGame();
        }
    }
}