public class Medlem {

	private string firstName;
	private string lastName;
	private int age;
	private int medlemID;

	public string getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(string firstName) {
		this.firstName = firstName;
	}

	public string getLastName() {
		return this.lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(string lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return this.age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public int getMedlemID() {
		return this.medlemID;
	}

	/**
	 * 
	 * @param medlemID
	 */
	public void setMedlemID(int medlemID) {
		this.medlemID = medlemID;
	}

}