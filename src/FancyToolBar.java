import javax.swing.*;
import java.awt.*;

public class FancyToolBar extends JToolBar {
    //Public Members
    public FancyToolBar() {
        this.setPreferredSize(new Dimension(640, 50));

        openFileButton = new JButton();
        saveButton = new JButton();
        saveAllButton = new JButton();

        undoButton = new JButton();
        redoButton = new JButton();

        cutButton = new JButton();
        copyButton = new JButton();
        pasteButton = new JButton();

        this.add(openFileButton);
        this.add(saveButton);
        this.add(saveAllButton);
        this.add(undoButton);
        this.add(redoButton);
        this.add(cutButton);
        this.add(copyButton);
        this.add(pasteButton);
    }

    //Private Members
    private final JButton openFileButton;
    private final JButton saveButton;
    private final JButton saveAllButton;

    private final JButton undoButton;
    private final JButton redoButton;

    private final JButton cutButton;
    private final JButton copyButton;
    private final JButton pasteButton;
}
