package luunt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Chihirohaku on 5/28/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;
    Image flane1, flane2;
    int planeX1 = 100;
    int planeY1 = 100;
    int planeX2 = 300;
    int planeY2 = 500;
    int speedX = 0;
    int speedY = 0;
    BufferedImage bufferedImage;

    public GameWindow() {
        this.setSize(480, 700);
        this.setTitle("1945");
        this.setVisible(true);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //vua an phim
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //phim duoc an va giu
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        speedY = -3;
                        break;
                    case KeyEvent.VK_A:
                        speedX = -3;
                        break;
                    case KeyEvent.VK_S:
                        speedY = 3;
                        break;
                    case KeyEvent.VK_D:
                        speedX = 3;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //tha phim ra
                speedX = 0;
                speedY = 0;
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("moved at:" + e.getX() +" "+ e.getY());
                planeX2 = e.getX();
                planeY2 = e.getY();
            }
        });
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            flane1 = ImageIO.read(new File("Resources/PLANE1.png"));
            flane2 = ImageIO.read(new File("Resources/PLANE2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void update(Graphics g) {
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(480, 700, 1);
        }
        Graphics bufferedGraphics = bufferedImage.getGraphics();
        bufferedGraphics.drawImage(background, 0, 0, null);
        bufferedGraphics.drawImage(flane1, planeX1, planeY1, null);
        bufferedGraphics.drawImage(flane2, planeX2, planeY2, null);

        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        long i =0;
        while (true){
            try {
                planeX1 += speedX;
                planeY1 += speedY;
                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
