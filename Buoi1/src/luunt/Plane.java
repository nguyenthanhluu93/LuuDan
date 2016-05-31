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


    public Plane(int positionX, int positionY, String image) {
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            this.image = ImageIO.read(new File(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public void update() {
        this.positionX += this.speedX;
        this.positionY += this.speedY;
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.positionX, this.positionY, null);
    }
}
