import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EXP2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int year, month, day;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Year: ");
		year = Integer.parseInt(br.readLine());
		System.out.println("Enter the Month: ");			
		month = Integer.parseInt(br.readLine());
		System.out.println("Enter the Day: ");
		day = Integer.parseInt(br.readLine());
		EXP2 exp2 = new EXP2();
		String nextDay = exp2.nextDate(year, month, day);
		System.out.println("The next day is " + nextDay);
	}

	public static String nextDate(int y, int m, int d){
		int year,month,day;
		year = y;
		month = m;
		day = d;
		String result;

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			if (day == 31) { 
				day = 1;
				month = month + 1;
			} 
			else
				day = day + 1;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (day == 30) {
				day = 1;
				month = month + 1;
			} 
			else if(day == 31)
			{
					System.out.println("Invalid day!");
					//result = "Invalid day!";
					//continue;
			}
			else
				day = day + 1;
			break;
		case 12:
			if (day == 31) {
				day = 1;
				month = 1;
				year = year + 1;
			} 
			else if (day < 31) {
				day = day + 1;
			}
			break;
		case 2: {
			if (day == 28) {
				if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0))
				{
					day = 29;
				} 
				else {
					day = 1;
					month = 3;
				}
			}
			else if (day == 29) {
				day = 1;
				month = 3;
			} 
			else if (day < 28) {
				day = day + 1;
			} 
			else{
				//System.out.println("无效输入日期！");
				result = "Invalid day!";
			//continue;
			}
		}
			break;
		default:
		}
		
		if (year >= 1900 && year <= 2050 && month <= 12 && month >= 1
				&& day <= 31 && day >= 1) {
			//System.out.println("下一天是" + year + "年" + month + "月" + day	+ "日!");
			StringBuilder months = new  StringBuilder();
			StringBuilder days = new StringBuilder();
			if(month < 10)
				 months = months.append(0).append(month);
			else
				 months =  months.append(month);
			if(day < 10)
				days = days.append(0).append(day);
			else
				days = days.append(day);
			StringBuilder resultB = new StringBuilder().append(year).append(months).append(days);
			result = resultB.toString();
		} 
		else if (year < 1900 || year > 2050) {
			//System.out.println("年的值不在指定范围内");
			result = "The input year is beyond the valid range!"; 
		} 
		else if (month > 12 || month < 1) {
			//System.out.println("月的值不在指定范围内");
			result = "The input month is beyond the valid range!"; 
		} 
		else if (day > 31 || day < 1) {
			//System.out.println("日的值不在指定范围内");
			result = "The input day is beyond the valid range!"; 
		}
		else 
			result = null;	
		return result;
	}
}

