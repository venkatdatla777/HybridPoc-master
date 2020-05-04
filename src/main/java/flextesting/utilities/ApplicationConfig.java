package flextesting.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ApplicationConfig {

	public static void convertFileToMap(List<String> fileNames) throws IOException {
		HashMap<String, List<String>> pairs = new HashMap<String, List<String>>();
		String[] clientNames = {"CBA", "FFB", "FFE", "GSC", "KFS", "MME", "PLA", "PLB", "RBC", "SLM", "UCO"};
		int i=0;
		for (String fileName: fileNames) {
			List<String> lines = Utils.readFromFile(fileName);
			for (String line: lines) {
				String[] pair = line.split(",");
				if (pair.length != 2) //ignore appconfig that only has either the key or the value
					break;
				String key = pair[0];
				String value = pair[1];
				if (!pairs.containsKey(key)) {
					pairs.put(pair[0], new ArrayList<String>());
				}
				pairs.get(key).add("("+clientNames[i]+")"+value);
			}
			i++;
		}
		System.out.println(Arrays.asList(pairs));	

		StringBuilder sb = new StringBuilder();
		for (String key: pairs.keySet()) {
            String value = pairs.get(key).toString();  
            sb.append(key + " " + value + "\n");  
		}
		System.out.println(sb);
		Utils.writeToFile("./appconfig/configComparison.txt", sb.toString());
	}
	public static void main(String[] args) throws IOException {
		convertFileToMap(Arrays.asList("./appconfig/CBAQA.csv",
				"./appconfig/FFBQA.csv",
				"./appconfig/FFEPerf.csv",
				"./appconfig/GSCQA.csv",
				"./appconfig/KFSQA.csv",
				"./appconfig/MMEQA.csv",
				"./appconfig/PLAQA.csv",
				"./appconfig/PLBQA.csv",
				"./appconfig/RBCQA.csv",
				"./appconfig/SLMQA.csv",
				"./appconfig/UCOQA.csv"));
	}
}
