package memory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;

public class MemoryApp extends JFrame {

	private JPanel contentPane;
	private JLabel lblMemory;
	private static List<ImageIcon> allIcons;
	private static JButton[] button = new JButton[12];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryApp frame = new MemoryApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemoryApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		initAllIcons();
		
		addLabel();
		contentPane.add(lblMemory, BorderLayout.NORTH);
		
		JPanel mainPanel = addMainPanel();
		
		Collections.shuffle(allIcons);
		controlPanel(mainPanel);
		panelSwitch();
		}
	
	private void controlPanel(JPanel mainPanel) {
		for (int i = 0; i < allIcons.size(); i++){
			button[i] = new JButton("");
			mainPanel.add(button[i]);
			button[i].setIcon(null);
			}
	}

	private void panelSwitch() {
		
		for (int i = 0; i <allIcons.size(); i++){
			button[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					for (int i = 0; i < allIcons.size(); i++){
						if (e.getSource() == button[i] && button[i].getIcon() == null){
							button[i].setIcon(allIcons.get(i));
							break;
						}
						else if (e.getSource() == button[i] && button[i].getIcon() != null){
							button[i].setIcon(null);
							break;
						}
					}
				}
			});
		}
	}

	private JPanel addMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.setLayout(new GridLayout(3, 4, 10, 10));
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		return mainPanel;
	}

	private void addLabel() {
		lblMemory = new JLabel("Memory");
		lblMemory.setOpaque(true);
		lblMemory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMemory.setForeground(Color.RED);
		lblMemory.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void initAllIcons(){
		allIcons = new ArrayList<>();//hard coded
		Collections.addAll(allIcons, 
				new ImageIcon(this.getClass().getResource("images/mm01.gif")),
				new ImageIcon(this.getClass().getResource("images/mm02.gif")),
				new ImageIcon(this.getClass().getResource("images/mm03.gif")),
				new ImageIcon(this.getClass().getResource("images/mm04.gif")),
				new ImageIcon(this.getClass().getResource("images/mm05.gif")),
				new ImageIcon(this.getClass().getResource("images/mm06.gif")),
				new ImageIcon(this.getClass().getResource("images/mm01.gif")),
				new ImageIcon(this.getClass().getResource("images/mm02.gif")),
				new ImageIcon(this.getClass().getResource("images/mm03.gif")),
				new ImageIcon(this.getClass().getResource("images/mm04.gif")),
				new ImageIcon(this.getClass().getResource("images/mm05.gif")),
				new ImageIcon(this.getClass().getResource("images/mm06.gif")));
	}//added a comment to show changes in github
}