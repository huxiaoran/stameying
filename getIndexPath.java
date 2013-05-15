import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class getIndexPath {

	private static Map<Integer, String> path;
	
public getIndexPath()
{
	
	path = new HashMap<Integer,String>();
	
	
}

public void  IndexPath(String name, ArrayList<Integer> interest)
{
	String professorInfo = name;
	professorInfo += " ";
	for (int i = 0 ; i< interest.size(); i++)
	{
		professorInfo += interest.get(i);
		professorInfo += ",";
	}
	path.put(name.hashCode(), professorInfo);
}


public Map<Integer, String> getPath()
{
	return path;
}

public void printPath()
{
	Iterator iter = this.path.keySet().iterator();
	while (iter.hasNext())
	{
	int key = (Integer) iter.next();
	String value = this.path.get(key);
	System.out.println(key + " : " + value);
	}
}

	public static void main(String[] args)
	{
		
		/*
		 * 
		 */
		Jedis jedis = new Jedis("localhost",6379);
		getIndexWord giw =new getIndexWord();
		getIndexPath path = new getIndexPath();
		for (int i = 0; i < args.length ; i++)
		{
			String professorname = args[0];
			String interest = jedis.hget(professorname,"interest");	
			ArrayList<Integer> result = giw.indexString(interest);
			path.IndexPath(professorname, result);		
		}
		path.printPath();
		
		/*
		 * test
		 * 
		String professorname1 = "huxiaoran"; 
		String input = "Parallel and distributed computing, data intensive computing, grid computing, compilers";
		
		String professorname2 = "xiaoli"; 
		
		String input2 = "Fault-tolerance, distributed systems, concurrency semantics";
		
		String professorname3 = "stewart"; 
		String input3 = "Real-time computing and communication, network security, distributed systems";
		
		String professorname4 = "mingjun"; 
		String input4 = "Parallel and distributed computing, concurrency semantics, distributed systems";
		
			//String professorname = args[i];
			//String interest = jedis.hget(professorname,"interest");
			getIndexWord giw =new getIndexWord();
			ArrayList<Integer> result = giw.indexString(input);
			System.out.println(result.toString());
			getIndexPath path = new getIndexPath();
			path.IndexPath(professorname1, result);
			ArrayList<Integer> result2 = giw.indexString(input2);
			path.IndexPath(professorname2, result2);
			
			ArrayList<Integer> result3 = giw.indexString(input3);
			path.IndexPath(professorname3, result3);
			ArrayList<Integer> result4 = giw.indexString(input4);
			path.IndexPath(professorname4, result4);
			path.printPath();
		*/
	}
	
	
}
