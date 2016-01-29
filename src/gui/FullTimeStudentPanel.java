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

import model.FullTimeStudent;
import model.IllegalInput;
import model.Person;



public class FullTimeStudentPanel extends JPanel {
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel idNumberLabel;
	private JLabel phoneNumLabel;
	private JLabel addressLabel;
	private JLabel zipCodeLabel;
	private JLabel campusLabel;
	private JLabel majorLabel;
	private JLabel gpaLabel;
	private JLabel tuitionLabel;
	
	private JTextField nameField;
	private JTextField idNumberField;
	private JTextField phoneNumField;
	private JTextField addressField;
	private JTextField zipCodeField;
	private JTextField gpaField;
	private JTextField tuitionField;
	private JButton okButton;
	private JButton cancelButton;
	private FormListener formListener;
	private JList<MajorCategory> majorList;
	private JList<CampusCategory> campusList;
	
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;
	private Person fullTimeStudent;
	
	public FullTimeStudentPanel() {
		Dimension dim = getPreferredSize();
		dim.width =  300;
		setPreferredSize(dim);
		
		// creates the border with add person title
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		createLabelsAndFields();
		buildGridBag();
		buildMajorList();
		buildCampusList();
		
		okButton.addActionListener(new ActionListener() {
			
			// captures all text fields input
			public void actionPerformed(ActionEvent arg0) {
				String name = nameField.getText();
				String idNumber = idNumberField.getText();
				String phoneNum = phoneNumField.getText();
				String address = addressField.getText();
				String zipCode = zipCodeField.getText();
				String major = majorList.getSelectedValue().toString();
				String gpa = gpaField.getText();
				String tuition = tuitionField.getText();
				String campus = campusList.getSelectedValue().toString();
				String gender = genderGroup.getSelection().getActionCommand();
				
				// create a full time student from the fields
				try {
					fullTimeStudent = new FullTimeStudent(
							name, idNumber, phoneNum, address, zipCode, gender, 
							major, gpa, campus, tuition);
				} catch (IllegalInput e) {
					e.printStackTrace();
				}

				// creates a form even with source and full time student
				FormEvent eV = new FormEvent(this, fullTimeStudent);
				
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

			// clears all the text fields
			public void actionPerformed(ActionEvent arg0) {
				nameField.setText(null);
				idNumberField.setText(null);
				phoneNumField.setText(null);
				addressField.setText(null);
				zipCodeField.setText(null);
			}
		});
	}
	
	// builds the major list model
	public void buildMajorList() {
		DefaultListModel<MajorCategory> majorModel = new DefaultListModel<MajorCategory>();
		majorModel.addElement(new MajorCategory("CS"));
		majorModel.addElement(new MajorCategory("Math"));
		majorModel.addElement(new MajorCategory("IT"));
		majorList.setModel(majorModel);
		
		majorList.setPreferredSize(new Dimension(90, 70));
		majorList.setBorder(BorderFactory.createEtchedBorder());
		majorList.setSelectedIndex(0);
	}
	
	// builds the campus list model
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
	
	// adds all the elements with grid bag layout
	public void buildGridBag() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		//////////////// First Row //////////////////
		
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
		
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(gpaLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(gpaField, gc);
		
	/////////////// Next Row ////////////////	
			
		gc.weightx = 1;
		gc.weighty = .1;
		gc.gridx = 0;
		gc.gridy++;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);
		add(tuitionLabel, gc);
		
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(tuitionField, gc);
		
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
		add(majorLabel, gc);
		
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
		add(majorList, gc);
		
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
	
	// separates the label and field constructors for organization
	public void createLabelsAndFields() {
		nameLabel = new JLabel("Name:");
		idNumberLabel = new JLabel("ID Number:");
		phoneNumLabel = new JLabel("Phone:");
		addressLabel = new JLabel("Address:");
		zipCodeLabel = new JLabel("Zip Code:");
		campusLabel = new JLabel("Campus");
		majorLabel = new JLabel("Major");
		gpaLabel = new JLabel("GPA:");
		tuitionLabel = new JLabel("Tuition");
		titleLabel = new JLabel("FULL TIME STUDENT");
		titleLabel.setFont(new Font("Summit", Font.BOLD,  12));
	    titleLabel.setForeground(Color.BLUE);
	    
		nameField = new JTextField(10);
		idNumberField = new JTextField(10);
		phoneNumField = new JTextField(10);
		//phoneNumField.setText("(   )   -    ");		***  	Experimenting with pre formatting phone number
		addressField = new JTextField(10);
		zipCodeField = new JTextField(10);
		gpaField = new JTextField(2);
		majorList = new JList();
		campusList = new JList<CampusCategory>();
		tuitionField = new JTextField(10);
		
		
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
	
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}
	
	// adds default values for testing and demonstration
	public void setTextTesting() {
		nameField.setText("Full Time Student");
		idNumberField.setText("10000457");
		phoneNumField.setText("6317935041");
		addressField.setText("6 Eva Ln");
		zipCodeField.setText("11738");
		gpaField.setText("3.8");
		tuitionField.setText("2800");
	}
}

class MajorCategory {
	 private String major;
	 
	 public MajorCategory (String major) {
		 this.major = major;
	 }
	 
	 public String getMajor() {
		 return major;
	 }
	 
	 public String toString() {
		 return major;
	 }
}

class CampusCategory {
	private String campus;
	
	public CampusCategory(String campus) {
		this.campus = campus;
	}
	
	public String getCampus() {
		return campus;
	}
	
	public String toString() {
		return campus;
	}
}
