import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class namefix {

	public static String namechange(String name)
	{
		String result=null;
		if (name!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(name);
			result  = m.replaceAll("");

			}
		return result;
	}
}
