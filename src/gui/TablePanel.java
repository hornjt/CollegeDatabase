package gui;

import interfaces.PersonTableListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.FullTimeStudent;
import model.Person;


public class TablePanel extends JPanel {
	private JTable table;
	private PersonTableModel tableModel;
	private JPopupMenu popup;
	private JMenuItem removeItem;
	private PersonTableListener personTableListener;
	
	public TablePanel() {
		tableModel = new PersonTableModel();
		table = new JTable(tableModel);
		popup = new JPopupMenu();
		
		removeItem = new JMenuItem("Delete Row");
		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if(personTableListener != null) {
					personTableListener.rowDeleted(row); 
					tableModel.fireTableRowsDeleted(row, row);
				}
			}
		});
		
		JMenuItem editItem = new JMenuItem("Edit Row");
		editItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		popup.add(removeItem);
		
		setPersonTableListener(personTableListener);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}
		});
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<Person> db) {
		tableModel.setData(db);
	}
	
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
	
	public void setPersonTableListener(PersonTableListener personTableListener) {
		this.personTableListener = personTableListener;
	}
}
