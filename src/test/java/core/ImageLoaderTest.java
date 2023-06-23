package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import view.assets.ImageLoader;

public class ImageLoaderTest {
    @Test
    public void testLoadImageFailure() {
        ImageLoader imageLoader = new ImageLoader();
        Assertions.assertThrows(RuntimeException.class, () -> {
            imageLoader.loadImage("images/nonExistentImage.png");
        });
    }
}
