package luunt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Chihirohaku on 5/31/2016.
 */
public class Bullet {
    public int posDX;
    public int posDY;
    BufferedImage image;

    public Bullet() {
        try {
            this.image = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(this.image, this.posDX, this.posDY, null);
    }
}
