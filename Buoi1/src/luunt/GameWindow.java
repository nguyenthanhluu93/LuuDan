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

    Plane player1;
    Plane player2;
    Plane player3;
    BufferedImage bufferedImage;

    public GameWindow() {
        this.setSize(480, 700);
        this.setTitle("1945");
        this.setVisible(true);
        player1 = new Plane(100, 200);
        player3 = player1;
        player2 = new Plane();

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
                        player1.speedY = -3;
                        break;
                    case KeyEvent.VK_A:
                        player1.speedX = -3;
                        break;
                    case KeyEvent.VK_S:
                        player1.speedY = 3;
                        break;
                    case KeyEvent.VK_D:
                        player1.speedX = 3;
                        break;
                    case KeyEvent.VK_SPACE:

                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //tha phim ra
                player1.speedX = 0;
                player1.speedY = 0;
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("moved at:" + e.getX() +" "+ e.getY());
//                player2.positionX = e.getX();
//                player2.positionY = e.getY();
                player2.move(e.getX(), e.getY());
            }
        });
        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            player1.image = ImageIO.read(new File("Resources/PLANE1.png"));
            player2.image = ImageIO.read(new File("Resources/PLANE2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public void gameUpdate() {
        player1.update();
        player2.update();
    }

    @Override
    public void update(Graphics g) { //de ve (draw)
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(480, 700, 1);
        }
        Graphics bufferedGraphics = bufferedImage.getGraphics();
        bufferedGraphics.drawImage(background, 0, 0, null);
        player1.draw(bufferedGraphics);
        player2.draw(bufferedGraphics);
//        bufferedGraphics.drawImage(player1.image, player1.positionX, player1.positionY, null);
//        bufferedGraphics.drawImage(player2.image, player2.positionX, player2.positionY, null);

        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        long i =0;
        while (true){
            try {
//                player1.positionX += player1.speedX;
//                player1.positionY += player1.speedY;
                gameUpdate();
                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
