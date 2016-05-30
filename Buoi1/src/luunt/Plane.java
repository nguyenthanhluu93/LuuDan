package luunt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Chihirohaku on 5/29/2016.
 */
public class Plane {
    public int positionX;
    public int positionY;
    public BufferedImage image; //sprite
    public int damage;
    public int healthPoint;
    public int speedX;
    public int speedY;

    public Plane() {
        this.positionX = 200;
        this.positionY = 300;
        try {
            this.image = ImageIO.read(new File("Resources/PLANE1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Plane(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File("Resources/PLANE1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(int x, int y) {
        positionX = x;
        positionY = y;
    }

    public void update() {
        positionX += speedX;
        positionY += speedY;
    }

    public void draw(Graphics g) {
        g.drawImage(image, positionX, positionY, null);
    }
}
