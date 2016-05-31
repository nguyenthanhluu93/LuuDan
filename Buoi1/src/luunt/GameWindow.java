package luunt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Chihirohaku on 5/28/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;

    Plane player1;
    Plane player2;
    ArrayList<Bullet> listDan = new ArrayList<>();
    BufferedImage bufferedImage;

    public GameWindow() {
        this.setSize(480, 700);
        this.setTitle("1945");
        this.setVisible(true);
        player1 = new Plane(100, 500, "Resources/PLANE2.png");
        player2 = new Plane(300, 500, "Resources/PLANE4.png");

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
                        if (player1.positionY <= 0) {
                            player1.speedY = 0;
                        } else {
                            player1.speedY = -3;
                        }
                        break;
                    case KeyEvent.VK_A:
                        if (player1.positionX <= 0) {
                            player1.speedX = 0;
                        } else {
                            player1.speedX = -3;
                        }
                        break;
                    case KeyEvent.VK_S:
                        if (player1.positionY >= 630) {
                            player1.speedY = 0;
                        } else {
                            player1.speedY = 3;
                        }
                        break;
                    case KeyEvent.VK_D:
                        if (player1.positionX >= 400) {
                            player1.speedX = 0;
                        } else {
                            player1.speedX = 3;
                        }
                        break;
                    case KeyEvent.VK_SPACE:
                        banPlane1();
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
                player2.move(e.getX(), e.getY());
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                banPlane2();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        try {
            background = ImageIO.read(new File("Resources/Background.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public void banPlane1() {
        Bullet bullet = new Bullet();
        bullet.posDX = player1.positionX + 30;
        bullet.posDY = player1.positionY;
        listDan.add(bullet);
    }

    public void banPlane2() {
        Bullet bullet = new Bullet();
        bullet.posDX = player2.positionX + 37;
        bullet.posDY = player2.positionY;
        listDan.add(bullet);
        Bullet bullet1 = new Bullet();
        bullet1.posDX = player2.positionX + 23;
        bullet1.posDY = player2.positionY;
        listDan.add(bullet1);
    }

    public void gameUpdate() {
        player1.update();
        player2.update();
        for (int i=0; i< listDan.size(); i++) {
            listDan.get(i).posDY -= 10;
        }
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
        for (int i = 0; i< listDan.size(); i++) {
            listDan.get(i).draw(bufferedGraphics);
        }


        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        long i =0;
        while (true){
            try {
                gameUpdate();
                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
