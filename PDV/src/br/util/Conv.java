package br.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Conv {
    
    
    // Calendar = Data do brasil do tipo  10/10/2013
    // DataBd   = 2013-01-01 
	
	// calendar2dtbrasil
	public static String cal2dtbr(Calendar cal) {
		return new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());
	}
	
	// dtbrasil2calendar
	public static Calendar dtbr2cal(String data) {
		Calendar dt = Calendar.getInstance();
		try {
			dt.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(data));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return dt;
	}
	
	// java.sql.Date2Calendar
	public static Calendar dtbd2cal(java.sql.Date data) {
		Calendar dt = Calendar.getInstance();  // cria objeto Calendar
		dt.setTime(data);  // recebe data do BD
		return dt;
	}
	
	// Calendar2java.sql.Date
	public static java.sql.Date cal2dtbd(Calendar cal) {
		return new java.sql.Date(cal.getTimeInMillis());
	}
	
	
	
	public static String double2moeda(double valor){
		return NumberFormat.getCurrencyInstance(new Locale("pt","BR")).format(valor);
		
	}

  
}
