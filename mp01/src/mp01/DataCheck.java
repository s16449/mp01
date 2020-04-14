package mp01;


import java.time.LocalDate;
import java.util.Calendar;

public class DataCheck {

	//bedzie implementowana do zarzadzania datami;
	
	private Calendar cal = Calendar.getInstance();
	private LocalDate local = LocalDate.now();
	private String tempDate = cal.getTime().toString();
	private LocalDate tempDateAddon;

	public String[] getSplitDate() {
		String[] temp = tempDate.split(" ");
		return temp;

	}

	public String[] getSplitDate(String str) {
		String[] temp = str.split(" ");
		return temp;
	}

	public String getCurrentMonthANG() {
		String tempMonth = getSplitDate()[1];
		return tempMonth;
	}

	public String getCurrentDayNumberANG() {
		String tempDay = getSplitDate()[2];
		return tempDay;

	}

	public String getCurrentDayName() {
		String tempName = getSplitDate()[0];
		return tempName;

	}

	public String getCurrentFullData() {
		String loc = local.toString();
		return loc;
	}

	public String setTempDate(int day, int month, int year) {

		Calendar tempCal = Calendar.getInstance();
		tempCal.set(year, month - 1, day);
		String ret = tempCal.getTime().toString();
		tempDateAddon = LocalDate.of(year, month, day);
		return ret;

	}

	public String getDateAdd() {
		return tempDateAddon.toString();
	}
	
	public LocalDate getLocal()
	{
		return local;
	}

	public LocalDate getLocalAddOn()
	{
		return tempDateAddon;
	}
}
