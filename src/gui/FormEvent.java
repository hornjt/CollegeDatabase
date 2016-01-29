package gui;

import java.util.ArrayList;
import java.util.EventObject;

import model.Person;

public class FormEvent extends EventObject {
	private Person person;
	private ArrayList<Person> list;
	private int i;
	private String idNumber;
	
	/**
	 * 
	 * @param source of the event object
	 * @param person holds the person object with their information
	 */
	public FormEvent(Object source, Person person) {
		super(source);
		this.person = person;
	}
	/**
	 * @param source of the event object
	 * @param i holds the value from the combobox on the toolbar
	 * 		used to determine which item was selected and which list to display
	 */
	public FormEvent(Object source, int i) {
		super(source);
		this.i = i;
	}
	
	/**
	 * @param source of the event object
	 * @param idNumber holds the value from the search text field in the toolbar
	 */
	public FormEvent(Object source, String idNumber) {
		super(source);
		this.idNumber = idNumber;
	}
	
	// returns the index from the combobox in the toolbar
	public int getComboIndex() {
		return i;
	}
	
	// returns the idNumber from the search text field
	public String getIdNumber() {
		return idNumber;
	}
	
	// returns the arraylist of all people in the database
	public ArrayList<Person> getPersonList() {
		return list;
	}

	// returns the person from the event object
	public Person getPerson() {
		return person;
	}
}
