package SnakeOff;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * 贪吃蛇游戏主类
 * 实现了Snake Off游戏的主要功能
 */
public class SnakeGame extends JFrame {
    private GamePanel gamePanel;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final String TITLE = "Snake Off - 贪吃蛇游戏";

    public SnakeGame() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gamePanel = new GamePanel();
        add(gamePanel);

        // 添加键盘监听器
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gamePanel.handleKeyPress(e.getKeyCode());
            }
        });
        
        // 确保窗口和面板都能获得焦点
        setFocusable(true);
        requestFocus();
        
        setVisible(true);
        
        // 确保窗口显示后获得焦点
        SwingUtilities.invokeLater(() -> {
            requestFocusInWindow();
            gamePanel.requestFocusInWindow();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }
}