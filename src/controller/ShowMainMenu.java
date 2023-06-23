/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import view.TabbedPaneMenu;

/**
 *
 * @author anhqu
 */

// Sự kiện hiện menu chính khi chọn Popup Menu
public class ShowMainMenu {

    private JPanel root;

    public ShowMainMenu(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setEvent(List<JMenuItem> menuItems) {

        for (JMenuItem item : menuItems) {
            item.addActionListener(new ChangePanel(item));
        }
    }

    class ChangePanel implements ActionListener {

        private TabbedPaneMenu node;
        private JMenuItem menuItem;

        public ChangePanel(JMenuItem jMenuItem) {
            this.menuItem = jMenuItem;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String src = menuItem.getLabel();
            switch (src) {
                case "Questions":
                    node = new TabbedPaneMenu();
                    node.getTabbedPaneMenu().setSelectedIndex(0);
                    break;
                case "Catagories":
                    node = new TabbedPaneMenu();
                    node.getTabbedPaneMenu().setSelectedIndex(1);
                    break;
                case "Import":
                    node = new TabbedPaneMenu();
                    node.getTabbedPaneMenu().setSelectedIndex(2);
                    break;
                case "Export":
                    node = new TabbedPaneMenu();
                    node.getTabbedPaneMenu().setSelectedIndex(3);
                    break;
                default:
                    node = new TabbedPaneMenu();
                    node.getTabbedPaneMenu().setSelectedIndex(0);
                    break;
            }
            node.setSize(1035, 446);
            node.setLocation(0, 0);
            root.removeAll();
            root.add(node, BorderLayout.CENTER);
            root.validate();
            root.repaint();
        }
    }

}
