package carRentalModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
	
public class CalculatorDate {

	static String m_startDate;
	static int m_days;
	private static String m_endDate;
	
	public CalculatorDate(String i_startDate, int i_days) {
		m_startDate=i_startDate;
		m_days=i_days;
		
		//Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
		   //Setting the date to the given date
		   c.setTime(sdf.parse(m_startDate));
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		   
		//Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, m_days);  
		//Date after adding the days to the given date
		setM_endDate(sdf.format(c.getTime()));  
		//Displaying the new Date after addition of Days
	}

	public static String getM_endDate() {
		return m_endDate;
	}

	public static void setM_endDate(String m_endDate) {
		CalculatorDate.m_endDate = m_endDate;
	}

}
