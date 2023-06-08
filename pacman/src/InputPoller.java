import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputPoller{

    private Character character;

    private KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            character = e.getKeyChar();
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    };

    public InputPoller(Terminal terminal){
        ((JFrame) terminal).getContentPane().getComponents()[0].addKeyListener(keyListener);
    }

    public Character get(){
        return character;
    }

}
