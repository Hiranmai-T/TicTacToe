import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class TicTacToeGUI implements ActionListener {
    private JFrame mainFrame;    // main frame
    private JPanel contentPane;  // content pane used to hold all the panes
    private JPanel gamePanel;    // game panel
    private JPanel sidePanel;    // side panel
    
    private JLabel displayPlayers,currentPlayer;
    
    private JButton [][]tiles;
    private TicTacToe t;
    
    private int [][]tilesMap = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    
    private TicTacToeGUI(){
          String name1 = JOptionPane.showInputDialog("Enter Player One Name");
          String name2 = JOptionPane.showInputDialog("Enter Player Two Name");
          t = new TicTacToe(name1,name2);
          
          gamePanel =new JPanel(new GridLayout(3,3));
          gamePanel.setPreferredSize(new Dimension(762, 762));
          
          tiles = new JButton[3][3];
          int count=0;
          for(int i=0;i<3;i++){
             for(int j=0;j<3;j++){
                JButton button = new JButton();
                button.setName(""+count++);
                button.setPreferredSize(new Dimension(254,254));
                button.addActionListener(this);
                tiles[i][j] = button;
                gamePanel.add(tiles[i][j]);
             }
          }
          
          displayPlayers = new JLabel();
          //displayPlayers.setText("<html>Player X: <br></html>"+t.name1);
          
          sidePanel = new JPanel(new GridLayout(2,1));
          sidePanel.setPreferredSize(new Dimension(266, 762));
          sidePanel.add(displayPlayers);
          
          contentPane = new JPanel(new FlowLayout());
          contentPane.add(gamePanel);
          contentPane.add(sidePanel);
          
          mainFrame = new JFrame();
          mainFrame.setContentPane(contentPane);
          mainFrame.setSize(1028,762);
          mainFrame.pack();
          mainFrame.setVisible(true);
          mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
     }
     
      public static void main(String[] args) {  
        new TicTacToeGUI();
     }
    
     public void actionPerformed(ActionEvent e)
     {
        JButton source = (JButton)e.getSource();
        int i =Integer.parseInt(source.getName());
        int []temp = tilesMap[i];
        if(t.player == t.X){
          source.setIcon(new ImageIcon("images/c.png"));
        }else{
          source.setIcon(new ImageIcon("images/p.png"));
        }
        t.putSign(temp[0],temp[1]);
        System.out.println(t.toString());    //To debug
        System.out.println("_____________________________");
        if(t.isWin(t.X))
        {
		System.out.println("\n X wins...!!");
		JOptionPane.showMessageDialog(mainFrame, t.name1+" wins!!");
		t.isEmpty=false;
        }
	else if(t.isWin(t.O))
	{
		System.out.println("\n O wins...!!");
		JOptionPane.showMessageDialog(mainFrame, t.name2+" wins!!");
		t.isEmpty=false;
	}
	else
	{
		if(!t.isEmpty)
		{
			System.out.println("its a tie");
			JOptionPane.showMessageDialog(mainFrame, "It is a tie");
		}
			
	}
	
        
        
        
     }

} 
