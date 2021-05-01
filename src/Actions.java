import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actions {
    //Action Listeners
    public static ActionListener openOptionActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    public static ActionListener newOptionActionLister = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            FancyTextEditor.getInstance().setDocument(new StyledEditorKit().createDefaultDocument());
        }
    };

    public static ActionListener saveOptionActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser("src");

        }
    };
}

class StrikeThroughAction extends StyledEditorKit.StyledTextAction {
    /**
     * Constructs a new UnderlineAction.
     */
    public StrikeThroughAction() {
        super("font-underline");
    }

    /**
     * Toggles the StrikeThrough attribute.
     *
     * @param e the action event
     */
    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            StyledEditorKit kit = getStyledEditorKit(editor);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean strikethrough = (StyleConstants.isStrikeThrough(attr)) ? false : true;
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setStrikeThrough(sas, strikethrough);
            setCharacterAttributes(editor, sas, false);
        }
    }
}
