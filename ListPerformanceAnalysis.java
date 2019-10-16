import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListPerformanceAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.parallelStream().forEach(a->{
			System.out.println(list.get(0));
		});
		
		List<Integer> list1=new ArrayList<>();
		Map<Integer,Integer> map=new HashMap<>();
		long startTime = System.nanoTime();
		for(int i=0;i<10000;i++) {
			list1.add(i);
		}
		long estimatedTime = System.nanoTime() - startTime;
		
		long startTimeps = System.nanoTime();
		list1.parallelStream().forEach(a->{
			//System.out.println(a);
		});
		long estimatedTimeps = System.nanoTime() - startTimeps;
		
		long startTimes = System.nanoTime();
		list1.stream().forEach(a->{
			//System.out.println(a);
		});
		long estimatedTimes = System.nanoTime() - startTimes;
		
		long startTimeG = System.nanoTime();
		for(int i=0;i<10000;i++) {
			list1.get(i);
		}
		long estimatedTimeG = System.nanoTime() - startTimeG;
		
		long startTimeM = System.nanoTime();
		for(int i=0;i<10000;i++) {
			map.put(i,i);
		}
		long estimatedTimeM = System.nanoTime() - startTimeM;
		
		long startTimeMG = System.nanoTime();
		for(int i=0;i<10000;i++) {
			map.get(i);
		}
		long estimatedTimeMG = System.nanoTime() - startTimeMG;
		
		System.out.println("List add : "+estimatedTime);
		System.out.println("Map put : "+estimatedTimeM);
		System.out.println("List get : "+estimatedTimeG);
		System.out.println("Map get : "+estimatedTimeMG);
		System.out.println("END");
		System.out.println("List get stream : "+estimatedTimes);
		System.out.println("List get pstream: "+estimatedTimeps);
	}
}
