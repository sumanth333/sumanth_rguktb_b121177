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
		this.students=students;
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
		if(student == null || index<0 || index>=students.length)
			throw new IllegalArgumentException();
		else
			students[index] = student;

	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException
	{
		if(student == null)
			throw new IllegalArgumentException();
		else
			add(student,0);
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException
	{
		if(student == null)
			throw new IllegalArgumentException();
		else
		{
			Student student1[] = new Student[students.length+1];
			for(int i=0;i<students.length;++i)
				student1[i] = students[i];
			student1[student1.length-1] = student;

			students = student1;
		}
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException
	{
		if(student == null || index<0 || index>=students.length)
			throw new IllegalArgumentException();
		else
		{
			Student student1[] = new Student[students.length+1];
			student1[index] = student;

			for(int i=0;i<index;++i)
				student1[i] = students[i];
			for(int i=index;i<students.length;++i)
				student1[i+1] = students[i];

			students = student1;
		}
	}

	@Override
	public void remove(int index) throws IllegalArgumentException
	{
		if(index<0 || index>=students.length)throw new IllegalArgumentException();
		int length = students.length,j=0;
		Student[] students1 = new Student[length-1];
		
		for(int i=0;i<length ;++i)
		{
			if(i==index)
				continue;

			students1[j++] = students[i];
		}

		students = students1;
	}

	@Override
	public void remove(Student student)  throws IllegalArgumentException
	{
		if(student == null)
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
		if(index<0 || index >=students.length)
			throw new IllegalArgumentException();

		Student student1[] = new Student[students.length-index];
		int j=0;
		for(int i=index;i<students.length;++i)
			student1[j++] = students[i];

		students = student1;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
			throw new IllegalArgumentException();
		int index=-1;
		for(int i=0;i<students.length;++i)
			if(students[i].equals(student))
			{
				index = i;break;
			}
		if(index!=-1)
			removeToIndex(index);
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for (int i=0;i<students.length ;++i ) {
			for (int j=0;j<students.length-i-1 ;++j )
			{
				if(students[j].compareTo(students[j+1])>0)
				{
				Student temp=students[j];
				students[j]=students[j+1];
				students[j+1]=temp;
			}
			}	
			
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) throws IllegalArgumentException{
		// Add your implementation here
		if(date==null)throw new IllegalArgumentException();
		int count=0;
		for (int i=0;i<students.length ;++i ) {
			if(students[i].getBirthDate().before(date) || students[i].getBirthDate().equals(date))
				count++;
		}
		Student s1[]=new Student[count];
		int j=0;
		for (int i=0;i<students.length ;++i ) {
			if(students[i].getBirthDate().before(date) || students[i].getBirthDate().equals(date))
				s1[j++]=students[i];
		}
		return s1;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate)throws IllegalArgumentException {
		// Add your implementation here
		if(firstDate==null || lastDate==null)throw new IllegalArgumentException();
		int count=0;
		for (int i=0;i<students.length ;++i ) {
			if(students[i].getBirthDate().before(lastDate)&&students[i].getBirthDate().after(firstDate) || students[i].getBirthDate().equals(firstDate) ||students[i].getBirthDate().equals(lastDate))
				count++;
		}
		Student s1[]=new Student[count];
		int j=0;
		for (int i=0;i<students.length ;++i ) {
			if(students[i].getBirthDate().before(lastDate)&&students[i].getBirthDate().after(firstDate) || students[i].getBirthDate().equals(firstDate) ||students[i].getBirthDate().equals(lastDate))
				s1[j++]=students[i];
		}
		return s1;
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
	public Student getNextStudent(Student student) throws IllegalArgumentException{
		// Add your implementation here
		if(student==null) throw new IllegalArgumentException();
		for(int i=0;i<students.length;++i)
			if(students[i].equals(student))
				return students[i+1];
		return null;
	}
}
