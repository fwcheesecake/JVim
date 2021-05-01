import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FancyMenuBar extends JMenuBar {
    //Public Members
    public FancyMenuBar() {
        fileMenu = new FancyMenu("File");
        addFileItems();

        editMenu = new FancyMenu("Edit");
        addEditItems();

        buffersMenu = new FancyMenu("Buffers");
        addBuffersItems();

        windowMenu = new FancyMenu("Window");
        addWindowItems();

        helpMenu = new FancyMenu("Help");
        addHelpItems();

        formatMenu = new FancyMenu("Format");
        addFormatItems();

        this.add(fileMenu);
        this.add(editMenu);
        this.add(buffersMenu);
        this.add(windowMenu);
        this.add(helpMenu);
        this.add(formatMenu);
    }


    //Private Members
    private final FancyMenu fileMenu;
    private final FancyMenu editMenu;
    private final FancyMenu buffersMenu;
    private final FancyMenu windowMenu;
    private final FancyMenu helpMenu;
    private final FancyMenu formatMenu;

    private void addHelpItems() {
        helpMenu.addItem(new JMenuItem("About"));
    }

    private void addWindowItems() {
        windowMenu.addItem(new JMenuItem("New"));
        windowMenu.addItem(new JMenuItem("Split"));
        windowMenu.addSeparator();
        windowMenu.addItem(new JMenuItem("Close"));
        windowMenu.addItem(new JMenuItem("Close Other(s)"));

        ArrayList<JMenuItem> items = windowMenu.getMenuItemsArrayList();
    }

    private void addBuffersItems() {
        buffersMenu.addItem(new JMenuItem("Delete"));
        buffersMenu.addItem(new JMenuItem("Next"));
        buffersMenu.addItem(new JMenuItem("Previous"));
        buffersMenu.addSeparator();
        buffersMenu.addItem(new JMenuItem("[No Name] (1)"));
    }

    private void addEditItems() {
        editMenu.addItem(new JMenuItem("Undo"));
        editMenu.addItem(new JMenuItem("Redo"));
        editMenu.addItem(new JMenuItem("Repeat"));
        editMenu.addSeparator();
        editMenu.addItem(new JMenuItem("Cut"));
        editMenu.addItem(new JMenuItem("Copy"));
        editMenu.addItem(new JMenuItem("Paste"));
        editMenu.addItem(new JMenuItem("Put Before"));
        editMenu.addItem(new JMenuItem("Put After"));
        editMenu.addItem(new JMenuItem("Delete"));
        editMenu.addItem(new JMenuItem("Select All"));
    }

    private void addFileItems() {
        fileMenu.addItem(new JMenuItem("Open"));
        fileMenu.addItem(new JMenuItem("New"));
        //fileMenu.addItem(new JMenuItem("Close"));
        fileMenu.addSeparator();
        fileMenu.addItem(new JMenuItem("Save"));
        fileMenu.addItem(new JMenuItem("Save As..."));
        fileMenu.addSeparator();
        fileMenu.addItem(new JMenuItem("Save & Exit"));
        fileMenu.addItem(new JMenuItem("Exit"));

        ArrayList<JMenuItem> items = fileMenu.getMenuItemsArrayList();

        items.get(0).addActionListener(Actions.openOptionActionListener);
        items.get(1).addActionListener(Actions.newOptionActionLister);
        items.get(2).addActionListener(Actions.saveOptionActionListener);
    }

    private void addFormatItems() {
        formatMenu.addItem(new JMenuItem("Plane"));
        formatMenu.addItem(new JMenuItem("Bold"));
        formatMenu.addItem(new JMenuItem("Italic"));

        ArrayList<JMenuItem> items = formatMenu.getMenuItemsArrayList();
        items.get(0).addActionListener(new StyledEditorKit.BoldAction());
        items.get(1).addActionListener(new StyledEditorKit.ItalicAction());
        items.get(2).addActionListener(new StyledEditorKit.UnderlineAction());
    }
}