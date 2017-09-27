package attendance;

public class Student implements Attendee {

	private String first;
	private String last;
	private boolean studentPresent = false;
	public Student (String firstName, String lastName) {
		this.first = firstName;
		this.last = lastName;
	}
	public boolean isPresent() {
		if(this.studentPresent == true)
		{
			return true;
		}
		return false;
		
	}

	public void setPresent(boolean present) {
		this.studentPresent = true;
		 
	}

	public String getFirstName() {
		return this.first;
	}

	public String getLastName() {
		return this.last;
	}

	
	public boolean mathces(String first, String last) {
		if(this.getFirstName().compareTo(first) == 0 && this.getLastName().compareTo(last) == 0) {
			return true;
		}
		return false;
	}

	public boolean matches(String last) {
		if(this.getLastName().compareTo(last) == 0)
		{
			return true;
		}
		return false;
	}

	public String getReportString() {
		while(this.first.length() < 20)
		{
			this.first += "";
		}
		this.last = this.first + this.last;
		while(this.last.length() < 40)
		{
			this.last += "";
		}
		return this.last;
	}

}
