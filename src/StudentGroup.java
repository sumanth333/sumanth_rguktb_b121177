import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException
	{
		if(students==null)
			throw new IllegalArgumentException();
	}

	@Override
	public Student getStudent(int index)
	{
		
		if(index<0 || index >=students.length)
			throw new IllegalArgumentException();

		return null;
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException
	{
		if(students == null || index<0 || index>=students.length)
			throw new IllegalArgumentException();
		else
			students[index] = student;

	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException
	{
		if(students == null)
			throw new IllegalArgumentException();
		else
			students[0] = student;
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException
	{
		if(students == null)
			throw new IllegalArgumentException();
		else
			students[students.length-1] = student;
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException
	{
		if(students == null || index<0 || index>=students.length)
			throw new IllegalArgumentException();
		else
			students[index] = student;
	}

	@Override
	public void remove(int index) throws IllegalArgumentException
	{
		int length = students.length-1,i=0,j=0;
		Student[] students1 = new Student[length];
		while(i<length)
		{
			if(j==index)
			{
				j++;
				continue;
			}
			students1[i] = students[j];
			i++;j++;
		}
		students = students1;
	}

	@Override
	public void remove(Student student)  throws IllegalArgumentException
	{
		if(students == null)
			throw new IllegalArgumentException();

		int length = students.length,index = length;
		for(int i=0;i<length;++i)
			if(students[i].equals(student))
			{
				index = i;break;
			}

		if(index == length)
			throw new IllegalArgumentException("Student not exist");
		else
			remove(index);

	}

	@Override
	public void removeFromIndex(int index) throws IllegalArgumentException
	{
		if(index<0 || index >=students.length)
			throw new IllegalArgumentException();

		Student student1[] = new Student[index+1];

		for(int i=0;i<=index;++i)
			student1[i] = students[i];

		students = student1;
	

	}

	@Override
	public void removeFromElement(Student student) throws IllegalArgumentException
	{
		if(student==null)throw new IllegalArgumentException();
	
		int index=-1;
		for(int i=0;i<students.length;++i)
			if(students[i].equals(student))
			{
				index = i;break;
			}
		if(index!=-1)
			removeFromIndex(index);
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
