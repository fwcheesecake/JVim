import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FancyMenu extends JMenu implements MouseListener {
    private ArrayList<JMenuItem> menuItems;

    public FancyMenu(String name) {
        super(name);
        menuItems = new ArrayList<>();
        this.addMouseListener(this);
    }

    public void addItem(JMenuItem menuItem) {
        menuItems.add(menuItem);
        this.add(menuItem);
    }

    public Collection<JMenuItem> getMenuItemsCollection() {
        return Collections.unmodifiableCollection(menuItems);
    }

    public ArrayList<JMenuItem> getMenuItemsArrayList() {
        return menuItems;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(new Color(0x2A7BB7));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setBackground(new Color(0xACACAC));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(new Color(0x2A7BB7));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(new Color(0xACACAC));
    }
}