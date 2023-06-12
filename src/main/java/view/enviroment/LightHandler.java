package view.enviroment;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import view.WorldHandler;

public class LightHandler {

    WorldHandler gameWindow;
    BufferedImage darknessFilter;

    public LightHandler(WorldHandler gameWindow, int circleSize) {
        darknessFilter = new BufferedImage(gameWindow.screenWidth, gameWindow.screenHeight,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2d = (Graphics2D) darknessFilter.getGraphics();

        Area screenArea = new Area(new Rectangle2D.Double(0, 0, gameWindow.screenWidth, gameWindow.screenHeight));
        int screenCenterX = gameWindow.screenWidth / 2;
        int screenCenterY = gameWindow.screenHeight / 2;

        double circleX = screenCenterX - (circleSize / 2);
        double circleY = screenCenterY - (circleSize / 2);

        Shape circleShape = new Ellipse2D.Double(circleX, circleY, circleSize, circleSize);

        Area lightArea = new Area(circleShape);

        screenArea.subtract(lightArea);

        graphics2d.setColor(new Color(0, 0, 0, 0));

        graphics2d.fill(screenArea);

        graphics2d.dispose();
    }

}
