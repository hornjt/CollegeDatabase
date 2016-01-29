package controller;

import gui.FormEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Database;
import model.Person;
/**
 * 
 * 
 * @author Jon
 * This controller class handles data exchange between the 
 * database and view sections of the program
 *
 */
public class Controller {
	Database db = new Database();
	
	/**
	 * 
	 * 
	 * @return ArrayList<Person>
	 * This will return an arrayList with all people
	 */
	public List<Person> getPeople() {
		return db.getPeople();
	}
	
	/**
	 * 
	 * @param ev Event Object
	 * adds a new person to the database 
	 * which is held in the event object
	 */
	public void addPerson(FormEvent ev) {
		Person person = ev.getPerson();
		db.addPerson(person);
	}
	
	/**
	 * @return arrayList of only full time students
	 */
	public List<Person> getFullTimeStudents() {
		return db.getFullTimeStudents();
	}
	
	/**
	 * @return arrayList of only part time students
	 */
	public List<Person> getPartTimeStudents() {
		return db.getPartTimeStudents();
	}
	
	/**
	 * @return arrayList of only full time faculty
	 */
	public List<Person> getFullTimeFaculty() {
		return db.getFullTimeFaculty();
	}
	
	/**
	 * @return arrayList of only adjunct faculty
	 */
	public List<Person> getAdjunctFaculty() {
		return db.getAdjunctFaculty();
	}
	
	/**
	 * @param idNumber takes a string id number to be
	 * 		used to search an array for a match
	 * @return ArrayList containing all matches
	 */
	public ArrayList<Person> searchAll(String idNumber) {
		return db.searchAll(idNumber);
	}
	
	/**
	 * @param file takes a file object to be saved to the hard disk
	 * @throws IOException if error writing to hard disk
	 */
	public void saveToFile(File file) throws IOException {
		db.saveToFile(file);
	}
	
	/**
	 * @param file takes a file object to be loaded from the hard disk
	 * @throws IOException if error loading the hard disk
	 */
	public void loadFromFile(File file) throws IOException {
		db.loadFromFile(file);
	}
	
	/**
	 * @param index takes an int value holding the row number to be deleted
	 */
	public void removePerson(int index) {
		db.removePerson(index);  // the middle man Controller uses the removePerson() method from the Database class
	}
}