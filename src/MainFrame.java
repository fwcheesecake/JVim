import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //Public members
    public MainFrame() {
        this.setSize(new Dimension(640, 720));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new FancyMenuBar();
        this.setJMenuBar(menuBar);

        toolBar = new FancyToolBar();
        this.getContentPane().add(toolBar);

        this.getContentPane().add(FancyTextEditor.getInstance());
    }

    //Private member
    private final FancyMenuBar menuBar;
    private final JToolBar toolBar;
}
