package gui;
import interfaces.FormListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.AdjunctFaculty;
import model.IllegalInput;

public class AdjunctFacultyPanel extends JPanel {
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel idNumberLabel;
	private JLabel phoneNumLabel;
	private JLabel addressLabel;
	private JLabel zipCodeLabel;
	private JLabel campusLabel;
	private JLabel departmentLabel;
	private JLabel creditsLabel;
	
	private JTextField nameField;
	private JTextField idNumberField;
	private JTextField phoneNumField;
	private JTextField addressField;
	private JTextField zipCodeField;
	private JTextField creditsField;
	private JButton okButton;
	private JButton cancelButton;
	private FormListener formListener;
	private JList<DepartmentCategory> departmentList;
	private JList<CampusCategory> campusList;
	private AdjunctFaculty adjunctFaculty;
	
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;
	
	/**
	 * Constructor for the adjunct faculty panel
	 */
	public AdjunctFacultyPanel() {
		Dimension dim = getPreferredSize();
		dim.width =  300;
		setPreferredSize(dim);
		
		// Creates a border with 'add person' title
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		createLabelsAndFields();
		buildGridBag();
		buildDepartmentList();
		buildCampusList();
		
		okButton.addActionListener(new ActionListener() {
			
			// Captures all the strings from the text fields
			public void actionPerformed(ActionEvent arg0) {
				String name = nameField.getText();
				String idNumber = idNumberField.getText();
				String phoneNum = phoneNumField.getText();
				String address = addressField.getText();
				String zipCode = zipCodeField.getText();
				String department = departmentList.getSelectedValue().toString();
				String credits = creditsField.getText();
				String campus = campusList.getSelectedValue().toString();
				String gender = genderGroup.getSelection().getActionCommand();
				
				// creates a Adjunct Faculty object based on text fields from panel
				try {
					adjunctFaculty = new AdjunctFaculty(
							name, idNumber, phoneNum, address, zipCode, gender, campus, department, credits);
				} catch (IllegalInput e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// creates an event object holding the panel and person
				FormEvent eV = new FormEvent(this, adjunctFaculty);
				
				if (formListener != null) {
					formListener.formEventOccured(eV);
				}
				/*		Clears all text fields after input
				nameField.setText(null);
				idNumberField.setText(null);
				phoneNumField.setText(null);
				addressField.setText(null);
				zipCodeField.setText(null);
				*/
			}
			
		});
		
		cancelButton.addActionListener(new ActionListener() {

			// clears all the text fields to make inputting the next person easier
			public void actionPerformed(ActionEvent arg0) {
				nameField.setText(null);
				idNumberField.setText(null);
				phoneNumField.setText(null);
				addressField.setText(null);
				zipCodeField.setText(null);
			}
		});
	}
	
	// builds the department model list with given elements
	public void buildDepartmentList() {
		DefaultListModel<DepartmentCategory> departmentModel = new DefaultListModel<DepartmentCategory>();
		departmentModel.addElement(new DepartmentCategory("CS"));
		departmentModel.addElement(new DepartmentCategory("Math"));
		departmentModel.addElement(new DepartmentCategory("IT"));
		departmentList.setModel(departmentModel);
		
		departmentList.setPreferredSize(new Dimension(90, 70));
		departmentList.setBorder(BorderFactory.createEtchedBorder());
		departmentList.setSelectedIndex(0);
	}
	
	// builds the campus list with listed elements
	public void buildCampusList() {
		DefaultListModel<CampusCategory> campusModel = new DefaultListModel<CampusCategory>();
		campusModel.addElement(new CampusCategory("Ammerman"));
		campusModel.addElement(new CampusCategory("Grant"));
		campusModel.addElement(new CampusCategory("Eastern"));
		campusList.setModel(campusModel);
		campusList.setPreferredSize(new Dimension(90, 70));
		campusList.setBorder(BorderFactory.createEtchedBorder());
		campusList.setSelectedIndex(0);
	}
	
	// beginning of the method that adds elements using grid bag
	public void buildGridBag() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		////////////////First Row //////////////////
				
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(titleLabel, gc);
		
		
		
		////////////// Next Row ///////////////////////
		
		gc.weightx = .5;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		
		////////////// Second Row //////////////
		//gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(idNumberLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(idNumberField, gc);
		
		
		//////////// Third Row ///////////////
		//gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(phoneNumLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(phoneNumField, gc);
		
		/////////////// Fourth Row ////////////////
		
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(addressLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(addressField, gc);
		
		/////////////// Fifth Row /////////////////
		
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(zipCodeLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(zipCodeField, gc);
		
	/////////////// Next Row ////////////////	
	/*	
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(rankLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(rankField, gc);
	*/	
	/////////////// Next Row ////////////////	
			
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(creditsLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(creditsField, gc);
		
	/////////////// Next Row ////////////////
			
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 50, 0, 0);
		add(campusLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 45, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(departmentLabel, gc);
		
	/////////////// Next Row /////////////////
			
		gc.weightx = 1;
		gc.weighty = .05;
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = new Insets(0, 35, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(campusList, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 35);
		gc.anchor = GridBagConstraints.LINE_END;
		add(departmentList, gc);
		
	///// next Row /////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.05;
		
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Gender"), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);		
		add(maleRadio, gc);
		
		/// next Row /////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.05;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);		
		add(femaleRadio, gc);
		
		//////////////// Bottom Row ///////////////
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridy++;
		gc.gridx = 0;
		gc.insets = new Insets(0, 35, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okButton, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 35);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(cancelButton, gc);
	}
	
	// All label and field declarations together for organization
	public void createLabelsAndFields() {
		nameLabel = new JLabel("Name:");
		idNumberLabel = new JLabel("ID Number:");
		phoneNumLabel = new JLabel("Phone:");
		addressLabel = new JLabel("Address:");
		zipCodeLabel = new JLabel("Zip Code:");
		campusLabel = new JLabel("Campus");
		departmentLabel = new JLabel("Department");
		creditsLabel = new JLabel("Credits");
		titleLabel = new JLabel("ADJUNCT FACULTY");
		titleLabel.setFont(new Font("Summit", Font.BOLD,  12));
	    titleLabel.setForeground(Color.BLUE);
		
		
		nameField = new JTextField(10);
		idNumberField = new JTextField(10);
		phoneNumField = new JTextField(10);
		//phoneNumField.setText("(   )   -    ");		***  	Experimenting with pre formatting phone number
		addressField = new JTextField(10);
		zipCodeField = new JTextField(10);
		departmentList = new JList();
		campusList = new JList<CampusCategory>();
		creditsField = new JTextField(10);
		
		
		setTextTesting();
		
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");
		
		maleRadio.setSelected(true);
		maleRadio.setActionCommand("Male");
		femaleRadio.setActionCommand("Female");
		
		genderGroup = new ButtonGroup();
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
	}
	
	/**
	 * 
	 * @param formListener sets the form listener
	 */ 
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}
	
	// default values filled in for testing and demonstration purposes
	public void setTextTesting() {
		nameField.setText("Adjunct Faculty");
		idNumberField.setText("10000457");
		phoneNumField.setText("6317935041");
		addressField.setText("6 Eva Ln");
		zipCodeField.setText("11738");
		creditsField.setText("40");
	}
	
}