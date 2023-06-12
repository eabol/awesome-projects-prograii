package view.assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageLoader {
    public BufferedImage loadImage(String imagePath) {
        try {
            URL resourceUrl = getClass().getClassLoader().getResource(imagePath);
            if (resourceUrl == null) {
                throw new IllegalArgumentException("Could not find resource on path: " + imagePath);
            }
            return ImageIO.read(resourceUrl);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load image: " + imagePath, e);
        }
    }
}
