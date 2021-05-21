import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class frame_2 extends JFrame implements ActionListener{
	
	
	public static final int WIDTH = 1100;
	public static final int HEIGHT = 350;
	public static final int NUMBER_OF_CHAR = 10;
	private JTextField input1, input2;
	private JButton actionButton, escButton, actionButton2, solButton;
	private JLabel nameLabel, arcLabel, par1, par2;
	String part1="";
	String part2 ="";
	List<Arc> arcs = new ArrayList<Arc>();
	List<Node> nodes = new ArrayList<Node>();
	
	
	public frame_2()
	{
		super("Dijkstra Algorithm");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(7,1));
		JPanel Panel_1 = new JPanel();
		Panel_1.setLayout(new BorderLayout());
		input1 = new JTextField(NUMBER_OF_CHAR);
		Panel_1.add(input1, BorderLayout.CENTER);
		nameLabel = new JLabel("Enter Node or press \"ESC\" when you are done:");
		Panel_1.add(nameLabel, BorderLayout.WEST);
		JPanel sub_Panel = new JPanel();
		sub_Panel.add(Panel_1);
		add(sub_Panel);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		actionButton = new JButton("Enter Node");
		actionButton.addActionListener(this);
		buttonPanel.add(actionButton);
		escButton = new JButton("ESC");
		escButton.addActionListener(this);
		buttonPanel.add(escButton);
		add(buttonPanel);
		
		JPanel op1 = new JPanel();
		par1 = new JLabel("");
		op1.add(par1);
		add(op1);
		
		JPanel line = new JPanel();
		JLabel sepLabel = new JLabel("_______________________________________________________________________________________________________________________________________________");
		line.add(sepLabel);
		add(line);
		
		JPanel Panel_2 = new JPanel();
		Panel_2.setLayout(new BorderLayout());
		input2 = new JTextField(NUMBER_OF_CHAR);
		input2.setEnabled(false);
		Panel_2.add(input2, BorderLayout.CENTER);
		arcLabel = new JLabel("Example Input (NamaJalan,TitikAwal,TitikAkhir,Jarak) or Press \"Done\" when you are done:");
		arcLabel.setForeground(Color.GRAY);
		Panel_2.add(arcLabel, BorderLayout.WEST);
		JPanel sub_Panel2 = new JPanel();
		sub_Panel2.add(Panel_2);
		add(sub_Panel2);
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new FlowLayout());
		actionButton2 = new JButton("Enter Input");
		actionButton2.setEnabled(false);
		actionButton2.addActionListener(this);
		buttonPanel2.add(actionButton2);
		solButton = new JButton("Done");
		solButton.setEnabled(false);
		solButton.addActionListener(this);
		buttonPanel2.add(solButton);
		add(buttonPanel2);
		
		JPanel op2 = new JPanel();
		par2 = new JLabel("");
		op2.add(par2);
		add(op2);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("Enter Node"))
			{
			Node location = new Node(input1.getText(), input1.getText());
            nodes.add(location);
            part1+= input1.getText() + ", ";
            par1.setText("You have enterd: "+ part1);
            input1.setText("");
			}
		else if (actionCommand.equals("ESC"))
			{
			input1.setEnabled(false);
			actionButton.setEnabled(false);
			escButton.setEnabled(false);
			nameLabel.setForeground(Color.GRAY);
			par1.setForeground(Color.GRAY);
			
			input2.setEnabled(true);
			actionButton2.setEnabled(true);
			solButton.setEnabled(true);
			arcLabel.setForeground(Color.black);
			}
		else if(actionCommand.equals("Enter Input"))
		{
		String n = input2.getText();
        String[] parts = n.split(",");
		Node s = getNodes(nodes,parts[1]);
		Node d = getNodes(nodes,parts[2]);
		Arc r = new Arc(parts[0], s, d, Integer.parseInt(parts[3]));
		arcs.add(r);
		part2+= "[" + input2.getText() + "], ";
		par2.setText("You have enterd: "+ part2);
        input2.setText("");
		}
	else if (actionCommand.equals("Done"))
		print_shortest_path();
	else 
		System.out.println("unexpected error.");
	}
	
	public static Node getNodes(List<Node> nodes, String s) {
		Node location = new Node("wronge", "wronge");
		for (Node temp : nodes) {
			if (temp.getId().equals(s))
				return temp;
		}
		
		return location;
	}
	
	public void print_shortest_path()
	{   String output="";
		Graph graph = new Graph(nodes, arcs);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        
        dijkstra.execute(nodes.get(0));
        LinkedList<Node> path = dijkstra.getPath(nodes.get(nodes.size()-1));

        System.out.println("the shortest path is:");
        int cost =0;
        if (path!=null) {
        for (Node node : path) {
            output+= node +", ";    
        }
        
        for( int i=0;i<path.size()-1;i++) {
        	cost+=dijkstra.getDistance(path.get(i),path.get(i+1));
 
        }
        System.out.println("Cost: "+cost);
        
        JOptionPane.showMessageDialog(null, "the shortest path is: " + output+"\nthe cost from start node to destination is: "+cost);
        
        }
        else
        	JOptionPane.showMessageDialog(null,"there is no path to the destination");
	}
	
	
	
}

