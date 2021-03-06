package view;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ShowAllUsersView extends Observable{

	private JFrame frame;
	private JTable showUsersTable;
	ShowAllApartmentView showAllApartmentView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowAllUsersView window = new ShowAllUsersView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowAllUsersView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton deleteUserButton = new JButton("\u05DE\u05D7\u05E7");
		deleteUserButton.setBounds(136, 332, 97, 25);
		frame.getContentPane().add(deleteUserButton);
		
		JButton returnButton = new JButton("\u05D7\u05D6\u05D5\u05E8");
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		returnButton.setBounds(27, 332, 97, 25);
		frame.getContentPane().add(returnButton);
		
		showUsersTable = new JTable();
		showUsersTable.setBounds(72, 51, 696, 239);
		frame.getContentPane().add(showUsersTable);
	}

	
	public void showAllUsersVeiw() {
		
		//frame.setVisible(true);
		
		setChanged();
		notifyObservers(new GetAllUsers()); // request to go to the excel file and give me all the users
	}
	
	public void crateAllUsers(JTable usersTable) {
		
		//create table
		JScrollPane scrollPane = new JScrollPane(usersTable);
		showUsersTable.add(scrollPane);
		showUsersTable.setVisible(true);
		//frame.add(scrollPane);
		
		frame.add(showUsersTable);
		this.frame.setVisible(true);
		
		
		
	}
	

	//inner class for the controller
	public class GetAllUsers {
		// controller notify
	}
	
	
	
}









