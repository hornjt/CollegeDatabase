package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
	private ArrayList<Person> peopleList;
	
	public Database() {
		
		peopleList = new ArrayList<Person>();
		
		// This method will add 2 default people for testing purposes
		buildDefaultPeople();
	}
	
	public void buildDefaultPeople()  {
		try {
			FullTimeStudent student1 = new FullTimeStudent(
					"Jon Horn", "10000457", "6317935041", "6 Eva Ln", "11738",
					"Male", "CS", "3.8", "Ammerman", "1600");
			PartTimeStudent student2 = new PartTimeStudent(
					"Dave Horn", "10000367", "6313387653", "74 Eastville Ave", "11963",
					"Male", "Math", "2.8", "Eastern", "800");
			FullTimeFaculty faculty1 = new FullTimeFaculty(
					"Terry Horn", "10000764", "63173353954", "871 Brick Kiln Rd",
					"11963", "Female", "Grant", "Math", "$68,000");
			AdjunctFaculty faculty2 = new AdjunctFaculty(
					"Steve Horn", "10000276", "6317268415", "14 Waterwood St", 
					"11937", "Male", "Ammerman", "CS", "36");
			peopleList.add(student1);
			peopleList.add(student2);
			peopleList.add(faculty1);
			peopleList.add(faculty2);
		} catch (IllegalInput e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addPerson(Person person) {
		peopleList.add(person);
	}
	
	public ArrayList<Person> searchAll(String idNumber) {
		ArrayList<Person> searchList = new ArrayList<Person>();
		for (int i = 0; i < peopleList.size(); i++) {
			if (idNumber.equals(peopleList.get(i).getIdNumber())) {
				searchList.add(peopleList.get(i));
			}
		}
		return searchList;
	}
	
	public List<Person> getFullTimeStudents() {
		ArrayList<Person> list = new ArrayList<>();
		for (int i = 0; i < peopleList.size(); i++) {
			if (peopleList.get(i) instanceof FullTimeStudent) {
				list.add(peopleList.get(i));
			}
		}
		return list;
	}
	
	public List<Person> getPartTimeStudents() {
		ArrayList<Person> list = new ArrayList<>();
		for (int i = 0; i < peopleList.size(); i++) {
			if (peopleList.get(i) instanceof PartTimeStudent) {
				list.add(peopleList.get(i));
			}
		}
		return list;
	}
	
	public List<Person> getFullTimeFaculty() {
		ArrayList<Person> list = new ArrayList<>();
		for (int i = 0; i < peopleList.size(); i++) {
			if (peopleList.get(i) instanceof FullTimeFaculty) {
				list.add(peopleList.get(i));
			}
		}
		return list;
	}
	
	public List<Person> getAdjunctFaculty() {
		ArrayList<Person> list = new ArrayList<>();
		for (int i = 0; i < peopleList.size(); i++) {
			if (peopleList.get(i) instanceof AdjunctFaculty) {
				list.add(peopleList.get(i));
			}
		}
		return list;
	}
	
	public List<Person> getPeople() {
		return peopleList;
	}
	
	public void saveToFile(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person[] persons = (Person[]) peopleList.toArray(new Person[peopleList.size()]);
		oos.writeObject(persons);
		oos.close();
	}
	
	public void loadFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			Person[] persons = (Person[])ois.readObject();
			peopleList.clear();
			peopleList.addAll(Arrays.asList(persons));
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ois.close();
	}
	
	public void removePerson(int index) {
		peopleList.remove(index); // this is the removePerson() method in the Database class.
	}
}
