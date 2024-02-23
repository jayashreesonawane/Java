import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    private final int screenWidth = 600;
    private final int screenHeight = 600;
    private final int unitSize = 25;
    private final int gameUnits = (screenWidth * screenHeight) / unitSize;
    private final int delay = 140;

    private final ArrayList<Integer> snakeX = new ArrayList<>();
    private final ArrayList<Integer> snakeY = new ArrayList<>();
    private int snakeLength = 3;

    private int foodX;
    private int foodY;

    private boolean running = false;
    private char direction = 'R';
    private Timer timer;

    public SnakeGame() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(this);
        startGame();
    }

    public void startGame() {
        snakeX.clear();
        snakeY.clear();
        snakeX.add(0);
        snakeY.add(0);

        createFood();

        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    public void createFood() {
        Random random = new Random();
        foodX = random.nextInt((screenWidth / unitSize)) * unitSize;
        foodY = random.nextInt((screenHeight / unitSize)) * unitSize;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            g.setColor(Color.red);
            g.fillRect(foodX, foodY, unitSize, unitSize);

            for (int i = 0; i < snakeLength; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(snakeX.get(i), snakeY.get(i), unitSize, unitSize);
                } else {
                    g.setColor(Color.green.darker());
                    g.fillRect(snakeX.get(i), snakeY.get(i), unitSize, unitSize);
                }
            }
        } else {
            gameOver(g);
        }
    }

    public void move() {
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX.set(i, snakeX.get(i - 1));
            snakeY.set(i, snakeY.get(i - 1));
        }

        switch (direction) {
            case 'U':
                snakeY.set(0, snakeY.get(0) - unitSize);
                break;
            case 'D':
                snakeY.set(0, snakeY.get(0) + unitSize);
                break;
            case 'L':
                snakeX.set(0, snakeX.get(0) - unitSize);
                break;
            case 'R':
                snakeX.set(0, snakeX.get(0) + unitSize);
                break;
        }
    }

    public void checkFoodCollision() {
        if (snakeX.get(0).equals(foodX) && snakeY.get(0).equals(foodY)) {
            snakeLength++;
            createFood();
        }
    }

    public void checkCollision() {
        for (int i = snakeLength; i > 0; i--) {
            if (snakeX.get(0).equals(snakeX.get(i)) && snakeY.get(0).equals(snakeY.get(i))) {
                running = false;
            }
        }

        if (snakeX.get(0) < 0 || snakeX.get(0) >= screenWidth || snakeY.get(0) < 0 || snakeY.get(0) >= screenHeight) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Game Over", screenWidth / 6, screenHeight / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFoodCollision();
            checkCollision();
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
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
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame snakeGame = new SnakeGame();
        frame.add(snakeGame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
