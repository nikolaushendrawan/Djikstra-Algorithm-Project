import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class frame_1 extends JFrame implements ActionListener{
	
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 200;
	frame_2 f2 = new frame_2();


	public frame_1()
	{
		super("Dijkstra Algorithm");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		JPanel Panel_1 = new JPanel();
		Panel_1.setLayout(new BorderLayout());
		JPanel sub_Panel_1 = new JPanel();
        JLabel Label_1 = new JLabel("Dijkstra Algorithm Visualization Tool!");
        sub_Panel_1.add(Label_1);
		Panel_1.add(sub_Panel_1, BorderLayout.CENTER);
		JPanel sub_Panel_2 = new JPanel();
		JLabel Label_2 = new JLabel("Enter the nodes starting from the start node to the destination node \" in order please \"");
        sub_Panel_2.add(Label_2);
		Panel_1.add(sub_Panel_2, BorderLayout.SOUTH);
		add(Panel_1);
		JPanel Panel_2 = new JPanel();
		Panel_2.setLayout(new FlowLayout());
		JButton startButton = new JButton("Lets Start!");
		startButton.addActionListener(this);
		Panel_2.add(startButton);
		add(Panel_2);

	}
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Lets Start!"))
		{	f2.setVisible(true);
		    this.setVisible(false);
		}
		
		else
			System.out.println("unexpected error.");
	}
}

