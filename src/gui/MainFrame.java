package gui;

import interfaces.FormListener;
import interfaces.PersonTableListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import model.Person;
import model.PersonFileFilter;
import controller.Controller;

public class MainFrame extends JFrame  {
	private Toolbar toolbar;
	private FullTimeStudentPanel fullTimeStudentPanel;
	private PartTimeStudentPanel partTimeStudentPanel;
	private FullTimeFacultyPanel fullTimeFacultyPanel;
	private AdjunctFacultyPanel adjunctFacultyPanel;
	private JFileChooser fileChooser;
	private JRadioButtonMenuItem fullTimeStudentItem;
	private JRadioButtonMenuItem partTimeStudentItem;
	private JRadioButtonMenuItem fullTimeFacultyItem;
	private JRadioButtonMenuItem adjunctFacultyItem;
	private TablePanel tablePanel;
	private Controller controller;
	private ButtonGroup bg;
	
	public MainFrame() {
		super("Project 2 MainFrame");
		setSize(1100, 600);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		addPanels();
		addFullTimeStudentEventListener();
		addPartTimeStudentEventListener();
		addFullTimeFacultyEventListener();
		addAdjunctFacultyEventListener();
		addToolbarListener();
		
		add(fullTimeStudentPanel, BorderLayout.WEST);
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		
		setJMenuBar(createMenuBar());
		
		setVisible(true);
	}
	
	public void addPanels() {
		toolbar = new Toolbar();
		tablePanel = new TablePanel();
		fullTimeStudentPanel = new FullTimeStudentPanel();
		partTimeStudentPanel = new PartTimeStudentPanel();
		fullTimeFacultyPanel = new FullTimeFacultyPanel();
		adjunctFacultyPanel = new AdjunctFacultyPanel();
		controller = new Controller();
		
		tablePanel.setPersonTableListener(new PersonTableListener() {
			public void rowDeleted(int row) { // This is to discharge the row number for the row to be deleted 
			controller.removePerson(row); // This is to delete the row
		}
		});
		
		tablePanel.setData(controller.getPeople());
		add(tablePanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		
	}
	
	public void addToolbarListener() {
		toolbar.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {
				int i = e.getComboIndex();
				switch (i) {
				case 0 :
					tablePanel.setData(controller.getPeople());
					tablePanel.refresh();
					break;
				case 1 : 
					tablePanel.setData(controller.getFullTimeStudents());
					tablePanel.refresh();
					break;
				case 2 : 
					tablePanel.setData(controller.getPartTimeStudents());
					tablePanel.refresh();
					break;
				case 3 : 
					tablePanel.setData(controller.getFullTimeFaculty());
					tablePanel.refresh();
					break;
				case 4 :
					tablePanel.setData(controller.getAdjunctFaculty());
					tablePanel.refresh();	
					break;
				}
				if (e.getIdNumber() != null) {
					ArrayList<Person> searchResults = new ArrayList<Person>();
					searchResults = controller.searchAll(e.getIdNumber());
					tablePanel.setData(searchResults);
					tablePanel.refresh();
				}
			}
		});
	}
	
	public void addFullTimeStudentEventListener() {
		fullTimeStudentPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});
	}
	
	public void addPartTimeStudentEventListener() {
		partTimeStudentPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});
	}
	
	public void addFullTimeFacultyEventListener() {
		fullTimeFacultyPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});
	}
	
	public void addAdjunctFacultyEventListener() {
		adjunctFacultyPanel.setFormListener(new FormListener() {
			public void formEventOccured(FormEvent e) {
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportData = new JMenuItem("Export Data...");
		JMenuItem importData = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(exportData);
		fileMenu.add(importData);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		
		bg = new ButtonGroup();
		fullTimeStudentItem = new JRadioButtonMenuItem("Full Time Student");
		partTimeStudentItem = new JRadioButtonMenuItem("Part Time Student");
		fullTimeFacultyItem = new JRadioButtonMenuItem("Full Time Faculty");
		adjunctFacultyItem = new JRadioButtonMenuItem("Adjunct Faculty");
		bg.add(fullTimeStudentItem);
		bg.add(partTimeStudentItem);
		bg.add(fullTimeFacultyItem);
		bg.add(adjunctFacultyItem);
		
		
		fullTimeStudentItem.setSelected(true);
		showMenu.add(fullTimeStudentItem);
		showMenu.add(partTimeStudentItem);
		showMenu.add(fullTimeFacultyItem);
		showMenu.add(adjunctFacultyItem);
		windowMenu.add(showMenu);
		
		fullTimeStudentItem.addActionListener(new ActionListener (){

			@Override
			public void actionPerformed(ActionEvent ev) {
				add(fullTimeStudentPanel, BorderLayout.WEST);
				partTimeStudentPanel.setVisible(false);
				fullTimeFacultyPanel.setVisible(false);
				adjunctFacultyPanel.setVisible(false);
				fullTimeStudentPanel.setVisible(true);
			}	
		});
		
		partTimeStudentItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add(partTimeStudentPanel, BorderLayout.WEST);
				fullTimeStudentPanel.setVisible(false);
				fullTimeFacultyPanel.setVisible(false);
				adjunctFacultyPanel.setVisible(false);
				partTimeStudentPanel.setVisible(true);
			}
		});
		
		fullTimeFacultyItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add(fullTimeFacultyPanel, BorderLayout.WEST);
				fullTimeStudentPanel.setVisible(false);
				partTimeStudentPanel.setVisible(false);
				adjunctFacultyPanel.setVisible(false);
				fullTimeFacultyPanel.setVisible(true);
			}
		});
		
		adjunctFacultyItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add(adjunctFacultyPanel, BorderLayout.WEST);
				fullTimeStudentPanel.setVisible(false);
				partTimeStudentPanel.setVisible(false);
				fullTimeFacultyPanel.setVisible(false);
				adjunctFacultyPanel.setVisible(true);
			}
		});
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		// Action Listener for the Exit Button in File JMenu
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Are you sure you want to quit?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		
		// Action Listener for Import Button in File JMenu
		importData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"Could not load data from file", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		// Action Listener for Export Button in File JMenu
		exportData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"Could not save data from file", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		return menuBar;
	}
	
}

