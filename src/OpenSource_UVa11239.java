package Capitulo2;

import java.util.*;

public class OpenSource_UVa11239 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while(line.charAt(0)!='0'){
			HashMap<String,String> students = new HashMap();
			HashMap<String,Integer> projects = new HashMap();
			String project="";
			while(line.charAt(0)!='1'){
				if(line.charAt(0)<'a'){
					projects.put(line, 0);
					project = line;}
				else
					if(students.containsKey(line)==false)
						students.put(line,project);
					else if(!students.get(line).equals(project))
						students.put(line, "Invalid");
				line = scan.nextLine();
			}
			Set<String> llaves = students.keySet();
			Iterator<String> it = llaves.iterator();
			while(it.hasNext()){
				String key = it.next();
				if(projects.containsKey(students.get(key))==false)
					projects.put(students.get(key),1);
				else
					projects.put(students.get(key),projects.get(students.get(key))+1);
			}
			projects= sortByValue(projects);
			Set<String> llaves2 = projects.keySet();
			Iterator<String> it2 = llaves2.iterator();
			while(it2.hasNext()){
				String key = it2.next();
				if(key!="Invalid")
				System.out.println(key+" "+projects.get(key));
				}
			line = scan.nextLine();
		}
	}
	public static HashMap<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
                int res=m2.getValue().compareTo(m1.getValue());
                if(res==0)
                	res= m1.getKey().compareTo(m2.getKey());
            	return res;
            }
        });

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return (HashMap<String, Integer>) result;
    }
}
