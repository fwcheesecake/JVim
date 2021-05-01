import darrylbu.util.MenuScroller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;

class JVim extends JFrame implements ActionListener {
    //Public Members
    public JVim(){
        this.setSize(new Dimension(640, 720));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JVim");
        this.setIconImage(new ImageIcon(getClass().getResource("/imgs/logo.png")).getImage());

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        font = new FancyMenu("Font");
        style = new FancyMenu("Style");
        size = new FancyMenu("Size");
        paragraph = new FancyMenu("Paragraph");
        color = new FancyMenu("Color");
        file = new FancyMenu("File");

        new MenuScroller(font);
        new MenuScroller(style);
        new MenuScroller(size);

        String[] fonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String s : fonts)
            addFonts(s, s);

        addSizes();
        addStyles();
        addColors();
        addFileOptions();
        addAlignments();

        menuBar.add(file);
        menuBar.add(font);
        menuBar.add(style);
        menuBar.add(size);
        menuBar.add(color);
        menuBar.add(paragraph);

        textPane = new JTextPane();
        textPane.setContentType("text/html");
        add(textPane);
    }

    public static void main(String[] args) {
        JVim start = new JVim();
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setVisible(true);
    }

    public String getFile(String ruta){
        FileReader fr;
        BufferedReader br = null;
        StringBuilder content = new StringBuilder();
        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            String linea;
            while( ( linea = br.readLine() ) != null ){
                content.append(linea).append("\n");
            }

        } catch(Exception ignored){  }
        finally {
            try{
                assert br != null;
                br.close();
            } catch(Exception ignored){}
        }
        return content.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorPicker)
            pickAColor(e);
        else if(e.getSource() == save)
            saveFile();
        else if(e.getSource()== newFile)
            textPane.setText(null);
        else if(e.getSource()== openFile)
            openFile();
    }


    //Private Members
    private final FancyMenu font;
    private final FancyMenu style;
    private final FancyMenu size;
    private final FancyMenu file;
    private final FancyMenu color;
    private final FancyMenu paragraph;
    private JMenuItem save;
    private JMenuItem newFile;
    private JMenuItem openFile;
    private JMenuItem colorPicker;
    private JMenuItem center;
    private JMenuItem left;
    private JMenuItem right;
    private JMenuItem justified;
    private final JTextPane textPane;

    private void addFonts(String name, String code){
        JMenuItem fontType = new JMenuItem(name);
        fontType.setCursor(new Cursor(Cursor.HAND_CURSOR));
        font.add(fontType);
        fontType.addActionListener(new StyledEditorKit.FontFamilyAction("", code));
    }
    private void addSizes(){
        for(int i=8;i<50;i+=2){
            JMenuItem fontSize = new JMenuItem(Integer.toString(i));
            size.add(fontSize);
            fontSize.addActionListener(new StyledEditorKit.FontSizeAction("", i));
        }
    }
    private void addFileOptions(){
        save = new JMenuItem("Save");
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        file.add(newFile);
        file.add(openFile);
        file.add(save);
        newFile.addActionListener(this);
        save.addActionListener(this);
        openFile.addActionListener(this);
    }
    private void addStyles(){
        JMenuItem bold = new JMenuItem("Bolds");
        JMenuItem italic = new JMenuItem("Italic");
        JMenuItem underline = new JMenuItem("Underline");
        JMenuItem strikethrough = new JMenuItem("Strikethrough");

        style.add(bold);
        style.add(italic);
        style.add(underline);
        style.add(strikethrough);

        bold.addActionListener(new StyledEditorKit.BoldAction());
        italic.addActionListener(new StyledEditorKit.ItalicAction());
        underline.addActionListener(new StyledEditorKit.UnderlineAction());
        strikethrough.addActionListener(new StrikeThroughAction());
    }
    private void addColors(){
        colorPicker = new JMenuItem("Choose Color");
        color.add(colorPicker);
        colorPicker.addActionListener(this);
    }
    private void addAlignments() {
        left = new JMenuItem("Left");
        center = new JMenuItem("Center");
        right = new JMenuItem("Right");
        justified = new JMenuItem("Justify");

        left.addActionListener(new StyledEditorKit.AlignmentAction("Left", StyleConstants.ALIGN_LEFT));
        center.addActionListener(new StyledEditorKit.AlignmentAction("Center",
                StyleConstants.ALIGN_CENTER));
        right.addActionListener(new StyledEditorKit.AlignmentAction("Right",
                StyleConstants.ALIGN_RIGHT));
        justified.addActionListener(new StyledEditorKit.AlignmentAction("Justify",
                StyleConstants.ALIGN_JUSTIFIED));

        paragraph.add(left);
        paragraph.add(center);
        paragraph.add(right);
        paragraph.add(justified);
    }
    private File getSelectedFileName() {
        JFileChooser jf = new JFileChooser("src");
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jf.setMultiSelectionEnabled(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "HTML Files", "html");
        jf.setFileFilter(filter);
        jf.showOpenDialog(this);

        return jf.getSelectedFile();
    }

    private void openFile() {
        File file = getSelectedFileName();
        String path = file.getAbsolutePath();
        String content = getFile(path);
        textPane.setText( content );
    }
    private void saveFile() {
        try {
            File file = getSelectedFileName();
            String fileName = file.getName();
            PrintWriter out = new PrintWriter(new FileWriter(fileName + ".html"));
            textPane.write(out);
            out.close();
        } catch (IOException e1) {
            System.err.println("Error occurred");
            e1.printStackTrace();
        }
    }
    private void pickAColor(ActionEvent e) {
        Color color = JColorChooser.showDialog(this, "Select a Color", Color.white);
        StyledEditorKit.ForegroundAction newFontFamilyAction =
                new StyledEditorKit.ForegroundAction("", color);
        newFontFamilyAction.actionPerformed(e);
    }
}
