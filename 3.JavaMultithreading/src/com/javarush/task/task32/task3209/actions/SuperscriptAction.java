package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * @author Daria Zhuravel
 * @date 30.03.18
 **/
public class SuperscriptAction extends StyledEditorKit.StyledTextAction {

    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
