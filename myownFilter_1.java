import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.tags.TableRow;
import org.htmlparser.util.NodeList;
//import redis.clients.jedis.Jedis;

public class myownFilter_1 implements NodeFilter{
	public String school;
	public myownFilter_1(String schoolname)
	{
		school = schoolname;
	}
	@Override
	public boolean accept(Node node) {
		String professorname=null;
		String interest=null;
		boolean result = false;
		
		if (node instanceof TableRow)
		{
			TableRow tr = (TableRow)node;
			Node node1 = tr.getChildren().elementAt(1);
			for (int i = 0; i< node1.getChildren().size(); i++)
			{
			//	System.out.println("@"+i+": "+node1.getChildren().elementAt(i).toHtml());
			}
			Node node2= node1.getChildren().elementAt(1);
			if (node2 instanceof Div)
			{
				Div divtag = (Div)node2;
				if (divtag.getAttribute( "class" )!=null && divtag.getAttribute( "class" ).equals("name"))
				{
					
					professorname = divtag.getChildren().elementAt(1).getChildren().elementAt(0).toHtml() ;
				//System.out.println("ProfessorName is :" + professorname);
				}
			}
			
			if (tr.getChildren().size() >=6 )
			{
				Node node3 = tr.getChildren().elementAt(5);
			
				if (node3.getChildren().size() >= 2)
				{
					if (node3.getChildren().elementAt(1) instanceof Div)
					{
						Div node4 = (Div)node3.getChildren().elementAt(1);
						interest =	node4.getChildren().elementAt(0).toHtml();
					}
				}
				
			}
			
		return true;
		}
	
		namefix nf = new namefix();
		String fixname = nf.namechange(professorname);
		String fixint = nf.intchange(interest);
		
		System.out.println(school);
		System.out.println(fixname);
		jedis.sadd(school,fixname);
		jedis.hset(fixname,"interest",fixint);
		
		return false;
	}
}
