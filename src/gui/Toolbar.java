package gui;

import interfaces.FormListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Toolbar extends JPanel {
	private JButton searchButton;
	private JComboBox<String> comboBox;
	private JTextField searchField;
	private FormListener formListener;
	private String[] comboArray = { "Show All", "Full Time Student",
			"Part Time Student", "Full Time Faculty", "Part Time Faculty" };

	public Toolbar() {
		searchButton = new JButton("Search ID");
		searchField = new JTextField(10);

		buildComboBoxArray();
		setSearchButtonListener();
		setComboListener();
		add(searchField);
		add(searchButton);
		add(comboBox);

	}
	
	public void setComboListener() {
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int combo = comboBox.getSelectedIndex();
				FormEvent ev = new FormEvent(this, combo);
				if (formListener != null) {
					formListener.formEventOccured(ev);
				}
			}
		});
	}

	public void setSearchButtonListener() {
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchID = searchField.getText();
				FormEvent ev = new FormEvent(this, searchID);
				searchField.setText(null);
				if (formListener != null) {
					formListener.formEventOccured(ev);
				}
			}
		});
	}

	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

	// Builds an editable comboBox with Model Style
	public void buildComboBoxModel() {
		comboBox = new JComboBox<String>();
		DefaultComboBoxModel<String> personModel = new DefaultComboBoxModel<String>();
		personModel.addElement("Show All");
		personModel.addElement("FullTime Student");
		personModel.addElement("Part Time Student");
		personModel.addElement("Full Time Faculty");
		personModel.addElement("Adjunct Faculty");
		comboBox.setModel(personModel);
		comboBox.setSelectedIndex(0);
		comboBox.setEditable(false);
	}

	// builds a static comboBox with a string array style
	public void buildComboBoxArray() {
		comboBox = new JComboBox<String>(comboArray);
	}

}
