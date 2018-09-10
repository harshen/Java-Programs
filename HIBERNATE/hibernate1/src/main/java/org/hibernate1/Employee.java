/**
 * 
 */
package org.hibernate1;

/**
 * @author harshenpandey
 *
 */
public class Employee {

	/**
	 * @param args
	 */
	private int id;
	private String firstName, lastName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
