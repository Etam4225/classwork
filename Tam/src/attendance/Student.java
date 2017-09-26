package attendance;

public class Student implements Attendee {

	private String first;
	private String last;
	private String studentPresent;
	public Student (String firstName, String lastName) {
		this.first = firstName;
		this.last = lastName;
	}
	public boolean isPresent() {
		if(Student.studentPresent == "present")
		{
			return true;
		}
		return false;
	}

	public void setPresent(boolean present) {
		
	}

	public String getFirstName() {
		return null;
	}

	public String getLastName() {
		return null;
	}

	
	public boolean mathces(String first, String last) {
		return false;
	}

	public boolean matches(String last) {
		return false;
	}

	public String getReportString() {
		return null;
	}

}
