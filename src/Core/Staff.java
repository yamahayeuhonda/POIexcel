/**
 * 
 */
package Core;

/**
 * @author neo
 *
 */
public class Staff {
	
	private String first_Name;
	private String last_Name;
	private int the_age;
	private String the_sex;
	private String the_address;
	private String the_phoneNumber;
	private long the_identificationnumber;
	
	public void showStaff(){
		System.out.println("Name: "+ first_Name +" "+ last_Name +"\n"
				+"Age: "+ the_age + "\n"
				+"Sex: "+ the_sex + "\n"
				+"Adress: "+ the_address + "\n"
				+"Phone: "+ the_phoneNumber + "\n"
				+"ID: "+ the_identificationnumber + "\n"
				);
	}
	
	public Staff(){
		return;
	}
	public Staff(String firstname, String lastname, int age, String sex, String address, String phone, long id){
		this.first_Name = firstname;
		this.last_Name = lastname;
		this.the_age = age;
		this.the_sex = sex;
		this.the_address = address;
		this.the_phoneNumber = phone;
		this.the_identificationnumber = id;
	}
	
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public int getThe_age() {
		return the_age;
	}
	public void setThe_age(int the_age) {
		this.the_age = the_age;
	}
	public String getThe_sex() {
		return the_sex;
	}
	public void setThe_sex(String the_sex) {
		this.the_sex = the_sex;
	}
	public String getThe_address() {
		return the_address;
	}
	public void setThe_address(String the_address) {
		this.the_address = the_address;
	}
	public String getThe_phoneNumber() {
		return the_phoneNumber;
	}
	public void setThe_phoneNumber(String d) {
		this.the_phoneNumber = d;
	}
	public long getThe_identificationnumber() {
		return the_identificationnumber;
	}
	public void setThe_identificationnumber(long d) {
		this.the_identificationnumber = d;
	}
	

}
