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
		return first;
	}

	public String getLastName() {
		return last;
	}

	
	public boolean mathces(String first, String last) {
		if(getFirstName().toLowerCase().compareTo(first.toLowerCase()) == 0 && getLastName().toLowerCase().compareTo(last.toLowerCase()) == 0) {
			return true;
		}
		return false;
	}

	public boolean matches(String last) {
		if(getLastName().toLowerCase().compareTo(last.toLowerCase()) == 0)
		{
			return true;
			//you can use .equals to compare
		}
		return false;
	}
 
	public String getReportString() {
		String finalString = last;
		while(finalString.length() < 20)
		{
			finalString += " ";
		}
		finalString = finalString + first;
		while(finalString.length() < 40)
		{
			finalString += " ";
		}
		if(this.isPresent())
		{
			return finalString += "Present";
		}
		return finalString += "Absent";
	
	}

}
