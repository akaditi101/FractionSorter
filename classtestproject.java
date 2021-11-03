package packagetestproject;

import java.io.File;
import java.util.*;

public class classtestproject {

	public static void main(String[] args) throws Throwable {
		Scanner  in = new Scanner(new File("src/packagetestproject/input.dat"));
		HashMap<Double, String>  map = new HashMap();
		//System.out.println(in.nextLine());
		while(in.hasNextLine())
		{
			String line = in.nextLine();
			int slashIndex = line.indexOf("/");
			int num = Integer.parseInt(line.substring(0,slashIndex));
			int denom = Integer.parseInt(line.substring(slashIndex+1));
			int g = gcd(num, denom);
			num /= g;
			denom /= g;
			double d = (double) num/denom;
			String simplified = num + "/" + denom;
			map.put(d, simplified);
		}
		ArrayList<Double> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		for (Double fraction : list)
		{
			System.out.println(map.get(fraction));
		}
	}
	
	public static int gcd(int a, int b)
	{
		int smaller = Math.min(a,  b);
		for (int d = smaller; d>=1; d--)
		{
			if (a % d == 0 && b% d ==0)
			{
				return d;
			}
		}
		return -1;
	}
	
	//other gcd uses euclid algorithm for gcf
}
