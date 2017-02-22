import java.util.*;
import java.io.*;
import java.text.*;
import java.sql.Timestamp;

public class oa2{

	public static void main (String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("log.txt"));
		List<Date> list = new ArrayList<Date>();
		List<String> logs = new ArrayList<String>();

		while( scan.hasNextLine() ){
			try{
				String line = scan.nextLine();
				SimpleDateFormat dateFormat = new SimpleDateFormat("(mm/dd/yyyy-hh:mm:ss)");
			    Date parsedDate = dateFormat.parse(line);
			    list.add(parsedDate);
			    logs.add(line);
			    // System.out.println(parsedDate.getTime());
			}catch(ParseException e){
				System.out.println("exception");
			}
		}
		Date start = null;
		Date connected = null;
		long connectedTime = 0;
		long gameTime  = 0;

		for( int i=0 ; i<list.size() ; i++ ){
			
			if( logs.get(i).indexOf("START") != -1 && start == null){
				start = list.get(i);
			}	
			
			if( logs.get(i).indexOf("CONNECTED") != -1 && connected == null){ 
				connected = list.get(i);
			}	
			
			if( logs.get(i).indexOf("DISCONNECTED") != -1 && connected != null){
				connectedTime += list.get(i).getTime()-connected.getTime();
				// System.out.println( connectedTime/60000 );
				connected = null;
			}
			
			if( logs.get(i).indexOf("SHUTDOWN") != -1 && start != null ){
				gameTime = list.get(i).getTime()-start.getTime();
				if( connected != null )	connectedTime += list.get(i).getTime()-connected.getTime();
				// System.out.println( connectedTime/60000 );
				start = null;
				connected = null;
			}
		}

		
		System.out.println( gameTime/60000 );
		System.out.println( connectedTime/60000 );

	}
}