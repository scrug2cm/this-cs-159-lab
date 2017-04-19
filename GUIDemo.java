import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Minimal Java Swing application.
 * 
 * @author Nathan Sprague
 * 
 */
public class GUIDemo extends JFrame
{
    private JPanel panel;
    private JButton biggerButton;
    private JButton smallerButton;
    private JButton moveRight;
    private JButton moveLeft;

    /**
     * Set up the application.
     */
    public GUIDemo()
    {
        setTitle("Bigger/Smaller/Move");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        biggerButton = new JButton("BIGGER");
        smallerButton = new JButton("SMALLER");
        moveRight = new JButton("MOVE RIGHT");
        moveLeft = new JButton("MOVE LEFT");
        biggerButton.addActionListener(new ButtonHandler());
        smallerButton.addActionListener(new ButtonHandler());
        moveRight.addActionListener(new ButtonHandler());
        moveLeft.addActionListener(new ButtonHandler());
        add(panel);
        panel.add(biggerButton);
        panel.add(smallerButton);
        panel.add(moveRight);
        panel.add(moveLeft);
        setVisible(true);
    }

    /**
     * This inner class exists to handle button events. There are other ways
     * this could have been done:
     * 
     * 1. GUIDemo could implement ActionListener itself. 
     * 2. Anonymous inner classes could be used to hand the events.
     */
    private class ButtonHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            Dimension size = getSize();

            if (e.getSource().equals(biggerButton))
            {
                setSize(size.width + 10, size.height + 10);
            }
            else if (e.getSource().equals(smallerButton))
            {
                setSize(size.width - 10, size.height - 10);
            }
            
            else if(e.getSource().equals(moveRight))
            {
                setLocation(getX() + 20, getY());
            }
            
            else if(e.getSource().equals(moveLeft))
            {
                setLocation(getX() - 20, getY());
            }
        }
    }

    /**
     * Start the app by creating a GUIDemo object.
     */
    public static void main(String[] args)
    {
        GUIDemo app = new GUIDemo();
    }
}
