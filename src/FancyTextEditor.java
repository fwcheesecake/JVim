import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FancyTextEditor extends JTextPane implements KeyListener {
    //Public Members
    public static FancyTextEditor getInstance() {
        return instance;
    }

    public FancyTextEditor() {
        this.setPreferredSize(new Dimension(640, 640));
        this.addKeyListener(this);

        this.setText("XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD no puede ser es neta que esto es un" +
                " texto con formato??");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(mode == Modes.NORMAL) {

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //Private Members
    private final static FancyTextEditor instance = new FancyTextEditor();

    private final Modes mode = Modes.NORMAL;
}
