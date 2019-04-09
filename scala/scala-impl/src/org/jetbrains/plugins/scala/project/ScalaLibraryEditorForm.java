package org.jetbrains.plugins.scala.project;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.ui.IdeBorderFactory;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Pavel Fatin
 */
@SuppressWarnings(value = "unchecked")
public class ScalaLibraryEditorForm {
    private JPanel myContentPanel;
    private JPanel myPluginsPanel;

    private JComboBox myLanguageLevel;
    private MyPathEditor myClasspathEditor = new MyPathEditor(
            new FileChooserDescriptor(
                    true,
                    false,
                    true,
                    true,
                    false,
                    true
            )
    );

    public ScalaLibraryEditorForm() {
        myLanguageLevel.setRenderer(new NamedValueRenderer());
        myLanguageLevel.setModel(new DefaultComboBoxModel<>(ScalaLanguageLevel.values()));

        myPluginsPanel.setBorder(IdeBorderFactory.createBorder());
        myPluginsPanel.add(myClasspathEditor.createComponent(), BorderLayout.CENTER);
    }

    public JComponent getComponent() {
        return myContentPanel;
    }

    public ScalaLanguageLevel getLanguageLevel() {
        return (ScalaLanguageLevel) myLanguageLevel.getSelectedItem();
    }

    public void setLanguageLevel(ScalaLanguageLevel languageLevel) {
        myLanguageLevel.setSelectedItem(languageLevel);
    }

    public String[] getClasspath() {
        return myClasspathEditor.getPaths();
    }

    public void setClasspath(String[] classpath) {
        myClasspathEditor.setPaths(classpath);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        myContentPanel = new JPanel();
        myContentPanel.setLayout(new GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Compiler classpath:");
        myContentPanel.add(label1, new GridConstraints(2, 0, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 20), null, null, 1, false));
        myPluginsPanel = new JPanel();
        myPluginsPanel.setLayout(new BorderLayout(0, 0));
        myContentPanel.add(myPluginsPanel, new GridConstraints(3, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Standard library:");
        myContentPanel.add(label2, new GridConstraints(4, 0, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 20), null, null, 1, false));
        final Spacer spacer1 = new Spacer();
        myContentPanel.add(spacer1, new GridConstraints(1, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_FIXED, new Dimension(-1, 5), new Dimension(-1, 5), new Dimension(-1, 5), 0, false));
        myLanguageLevel = new JComboBox();
        myContentPanel.add(myLanguageLevel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        myContentPanel.add(spacer2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return myContentPanel;
    }
}
