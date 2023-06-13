package view.enviroment;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import core.Time;
import view.WorldHandler;

public class LightHandler {

    WorldHandler gameWindow;
    BufferedImage darknessFilter;
    Area screenArea;
    Area lightArea;

    public LightHandler(WorldHandler gameWindow, Time time) {
        darknessFilter = new BufferedImage(gameWindow.screenWidth, gameWindow.screenHeight,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2d = (Graphics2D) darknessFilter.getGraphics();

        int circleSize;

        switch (time.getMomentOfDay()) {
            case "isNight" -> {
                circleSize = 250;

                calculateAreas(gameWindow, circleSize);

                createLightning(screenArea, lightArea, graphics2d);
            }
            case "isMorning" -> {
                circleSize = 800;

                calculateAreas(gameWindow, circleSize);

                createLightning(screenArea, lightArea, graphics2d);
            }
            case "isSunset" -> {
                circleSize = 700;

                calculateAreas(gameWindow, circleSize);

                createLightning(screenArea, lightArea, graphics2d);
            }
        }

    }

    public void draw(Graphics2D graphics2d) {
        graphics2d.drawImage(darknessFilter, 0, 0, null);

    }

    public void calculateAreas(WorldHandler gameWindow, int circleSize) {
        Area newScreenArea = new Area(new Rectangle2D.Double(0, 0, gameWindow.screenWidth, gameWindow.screenHeight));

        int screenCenterX = (gameWindow.screenWidth / 2) - 15;
        int screenCenterY = (gameWindow.screenHeight / 2) - 10;

        double circleX = screenCenterX - (circleSize / 2);
        double circleY = screenCenterY - (circleSize / 2);

        Shape circleShape = new Ellipse2D.Double(circleX, circleY, circleSize, circleSize);

        Area newLightArea = new Area(circleShape);

        this.screenArea = newScreenArea;
        this.lightArea = newLightArea;
    }

    private void createLightning(Area screenArea, Area lightArea, Graphics2D graphics2d) {

        screenArea.subtract(lightArea);

        graphics2d.setColor(new Color(0, 0, 0, 0.95f));

        graphics2d.fill(screenArea);

        graphics2d.dispose();
    }

}
