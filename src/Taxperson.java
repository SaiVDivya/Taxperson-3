import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Taxperson {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String workingDir = System.getProperty("user.dir");
		String inputFileName = workingDir + "/src/inputFile.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputFileName))));
		String line;
		String[] fields;
		Float cost;
		HashMap<String, Float> hm = new HashMap<String, Float>();
		int intRate;
		
		while((line = br.readLine()) != null) {
			fields = line.split(",");
			if(fields[1].compareTo("basic") == 0) {
				intRate = 1;
			} else if(fields[1].compareTo("luxury") == 0) {
				intRate = 9;
			} else {
				try {
					throw new Exception("Ivalid type of item for " + fields[0] + ". Should be basic or luxury");
				} catch (Exception e) {	
					e.printStackTrace();
				} finally {
					continue;
				}
			}
			cost = new Float(fields[3]) * new Float(fields[2]) * (100 + intRate) /100;
			hm.put(fields[0], cost);
 		}
		br.close();
		System.out.println("\n Individual total cost:");
		System.out.println(hm);
	}
	

}
