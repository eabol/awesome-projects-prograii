package src.main.interfaces;
import src.main.interfaces.Game;
import src.main.interfaces.KeyHandler;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity{
    //Game is referenced as GamePanel in the tutorial
    Game gp;
    KeyHandler keyH;
    public Player(Game gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValue();
        getPlayerImage();
    }
    public void setDefaultValue(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "right1";
    }
    public void getPlayerImage(){
        try{
            // If error occurs, check if the path is correct or delete require nonnull
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/up1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/up2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/left1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/left2.png")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/left3.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/right1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/right2.png")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/right3.png")));
            upLeft = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/upLeft.png")));
            upRight = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("src/main/resources/Player/upRight.png")));


        }   catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(){
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed) {
                direction = "up";
                y -= speed;
            }
            else if (keyH.downPressed) {
                direction = "down";
                y += speed;
            }
            else if (keyH.leftPressed) {
                direction = "left";
                x -= speed;
            }
            else if (keyH.rightPressed) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 40){
                if (spriteNum == 1){
                    spriteNum = 2;
                } else if (spriteNum == 2){
                    spriteNum = 3;
                } else if (spriteNum == 3){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2d){
        /*
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, gp.originalSize, gp.originalSize);
         */
        BufferedImage image = right1;
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2)
                {image = up2;
                    spriteNum = 1;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = right1;
                    spriteNum = 1;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                } else if (spriteNum == 3) {
                    image = left3;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                } else if (spriteNum == 3){
                    image = right3;
                }
            }
        }
        g2d.drawImage(image, x, y, gp.originalSize,gp.originalSize,null) ;
    }
}