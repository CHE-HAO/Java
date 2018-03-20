package units.window;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
 
public class AWTDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("AWTDemo");
        frame.addWindowListener(new AdapterDemo());
        frame.setLayout(new FlowLayout());
         
        Button button = new Button("AWT1");
        Checkbox checkbox = new Checkbox("AWT2");
        Choice choice = new Choice();
        choice.add("AWT3");
        Label label = new Label("AWT4");
        List list = new List();
        list.add("AWT5");
        
        
        final TextArea textarea = new TextArea("AWT6");
        TextField textfield = new TextField("AWT7");
        
        ActionListener al = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("123");
				textarea.setText(textarea.getText()+"\n"+"asd");
				URI uri = URI.create("http://www.google.com");
				Desktop desk = Desktop.getDesktop();
				try {
					desk.browse(uri);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
        
		button.addActionListener(al);
		
        frame.add(button);
        frame.add(checkbox);
        frame.add(choice);
        frame.add(label);
        frame.add(list);
        frame.add(textarea);
        frame.add(textfield);
         
        Component c = new Component() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -5555234562570302045L;
			
			Button button = new Button("AWT1");
			
		};
        
		frame.add(c, "");
        
        LayoutManager lm = new LayoutManager() {
			
			public void removeLayoutComponent(Component comp) {
				// TODO Auto-generated method stub
				
			}
			
			public Dimension preferredLayoutSize(Container parent) {
				// TODO Auto-generated method stub
				
				return null;
			}
			
			public Dimension minimumLayoutSize(Container parent) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public void layoutContainer(Container parent) {
				// TODO Auto-generated method stub
				
			}
			
			public void addLayoutComponent(String name, Component comp) {
				// TODO Auto-generated method stub
				
			}
		};
        
        frame.pack();
        frame.setVisible(true);
    }
}
 
class AdapterDemo extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}