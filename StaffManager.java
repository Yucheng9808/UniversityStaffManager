import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class StaffManager {
	private Set<Module> module_Set = new HashSet<>(); //contain all modules
	private Set<Name> studentName_Set = new HashSet<>(); //contain all students name
	private ArrayList<Staff> staff_List = new ArrayList<>(); //contain all staffs information


	public Set<Module> readInModules(String path) {
		//test
		try {
			File modules = new File(path);
			Scanner s = new Scanner(modules);

			//read file
			while(s.hasNext()){
				String[] data = s.nextLine().split(", ");
				Module module = new Module( data[0], data[1],
											Integer.parseInt(data[2]), Integer.parseInt(data[3]));
					module_Set.add(module);
				}
			return module_Set;
		}
		catch(FileNotFoundException e) {
		System.out.println("An error occurred. Cannot find " + path);
			e.printStackTrace();
			return null;
			}
	}


	public Set<Name> readInStudents(String path)   {
		//test
		try {
			File modules = new File(path);
			Scanner s = new Scanner(modules);

			//read file
			while(s.hasNext()){
				String[] data = s.nextLine().split(" ");
				Name name = new Name(data[0], data[1]);
				studentName_Set.add(name);
			}
			return studentName_Set;
		}
		catch(FileNotFoundException e) {
			System.out.println("An error occurred. Cannot find " + path);
			e.printStackTrace();
			return null;
		}

	}


	public int noOfStaff(String type) {
		// identify staff status
		if(type.equals("permanent")) {
			int count =0;
			for (Staff staff : staff_List) {
				if(staff.getStaffType().equals("permanent")){
					count++;
				}
			}
			return count;
		}else if(type.equals("fixed")) {
			int count =0;
			for (Staff staff : staff_List) {
				if(staff.getStaffType().equals("fixed")){
					count++;
				}
			}
			return count;
		}else{
			throw new IllegalArgumentException("Staff type is invalid");
		}
	}



	public boolean addData(StaffID id, Set<Module> modules, Set<Name> students) {
		for(Staff staff : staff_List){
			if(staff.getStaffID().equals(id)){
				//identify staff type
				if(staff instanceof Lecturer){
					if(module_Set.containsAll(modules)){
						for(Module module : modules){
							((Lecturer) staff).setModule(module);
						}
					}else{
						throw new IllegalArgumentException("Some modules in the set are not exist");
					}
					return true;
				}else if(staff instanceof Researcher){
					if(studentName_Set.containsAll(students)){
						for(Name name : students){
							((Researcher) staff).setResearcher(name);
						}
					}else{
						throw new IllegalArgumentException("Some students in the set are not exist");
					}
					return true;
				}
			}
		}
		throw new IllegalArgumentException("StaffID is invalid");
	}


	public Staff employStaff(String firstName, String lastName, Date dob, String staffType, String employmentStatus) {

		// make sure age limit.
		Calendar cal = new GregorianCalendar();
		cal.setTime(dob);
		Calendar currentCal = new GregorianCalendar();
		int age = currentCal.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
		if(currentCal.get(Calendar.MONTH) > cal.get(Calendar.MONTH)){
			age++;
		}
		if(age > 67 || age < 22){
			throw new IllegalArgumentException("Invalid age " + age);
		}
		/**
		  * Make sure the staff is no more than one smart-card and isn't both a researcher and a lecturer.
		  * Although I think it's difficult to recognize whether the staff already exist.
		  * I just assume no anyone have same name and birth.
		  */
		for(Staff staff : staff_List){
			if(staff.getSmartCard().getName().equals(firstName + lastName)
					&& staff.getSmartCard().getBirth().equals(dob)){
				throw new IllegalArgumentException("The staff is existed. " + firstName + " " + lastName);
			}
		}
		SmartCard smartCard = new SmartCard(firstName, lastName, dob, employmentStatus);
		StaffID staffID = StaffID.getInstance();
		Staff staff= StaffFactory.getInstance(staffType, staffID, smartCard);
		staff_List.add(staff);
		return staff;
	}


	public Collection<Staff> getAllStaff() {
		return staff_List;
	}


	public void terminateStaff(StaffID id) {
		for(Staff staff : staff_List){
			if(staff.getStaffID().equals(id)){
				staff_List.remove(staff);
				break;
			}
		}
	}

	/**
	 * test
	 */
	public ArrayList<Staff> getStaff_List() {
		return staff_List;
	}
}
