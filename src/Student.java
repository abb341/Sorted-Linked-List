/**
 * 
 * A student that has an id and a name. The compareTo method
 * compares 2 students by their ids.
 *
 */
public class Student implements Comparable {
	
	private int id;
	private String name;
	
	public Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	// Accessors
	/**
	 * returns the student id
	 * @return
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * returns the name of the student
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * compares student id to another student id
	 * @return a number > 0 if id > the other student's id, 0 if id = other student's id,
	 * 		a number < 0 if id < other student's id
	 */
	public int compareTo(Object otherStudent)
	{
		Student tempStudent = (Student) otherStudent;
		int tempId = tempStudent.getId();
		return id - tempId;
	}
	
	/**
	 * returns the id and the name separated by a space
	 */
	public String toString()
	{
		return id + " " + name;
	}
}
