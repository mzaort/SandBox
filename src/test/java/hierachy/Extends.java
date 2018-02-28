package hierachy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Extends implements Pet{
	int value;
	public Extends(){
		if(this instanceof Pet){
			value = 1;
		}else{
			value = 2;
		}
	}
	
	public static void main(String[] args) {
		Extends e = new Extends();
		System.out.println(e.value);
		System.out.println(System.currentTimeMillis());
		System.out.println(new Date());
		System.out.println(TimeUnit.MILLISECONDS.toDays(new GregorianCalendar().getTimeInMillis()));
		System.out.println(new GregorianCalendar().toZonedDateTime());
		System.out.println(TimeZone.getDefault());
		System.out.println(Calendar.getInstance(new SimpleTimeZone(311312313, "UTC")).getTimeInMillis());
		System.out.println(System.currentTimeMillis());
	}
}

interface Pet{
	
}

class Desk{
	long value = 1;
	Desk(long v){
		value = v;
	}
}

class Desktop extends Desk{
	Desktop(){
		super(System.currentTimeMillis());
	}
}