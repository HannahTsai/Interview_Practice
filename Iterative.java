import java.util.*;

public class Iterative{

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l2.add(4);
		l2.add(5);
		l2.add(6);
		l2.add(7);
		input.add(l1);
		input.add(l2);
		List<List<Integer>> result = getComb(input);
		for( List<Integer> list : result ){
			StringBuilder sb = new StringBuilder();
			for( Integer num : list )	sb.append(num);
			System.out.println(sb.toString());
		}
	}

	public static List<List<Integer>> getComb(List<List<Integer>> list){
		List<List<Integer>> result = new ArrayList<>();
		return helper(list,0);
	}

	public static List<List<Integer>> helper(List<List<Integer>> list, int start){
		
		List<List<Integer>>	result = new ArrayList<>();
		
		if( start == list.size() ){
			for( int i=0 ; i<list.get(start-1).size() ; i++ )	result.add(new ArrayList<Integer>());
			return	result;
		}
		// if( start == list.size()-1 ){
		// 	for( Integer num : list.get(start) ){
		// 		List<Integer> temp = new ArrayList<>();
		// 		temp.add(num);
		// 		result.add(temp);		
		// 	}
		// 	return result;
		// }

		List<List<Integer>> subList = helper(list,start+1);
		List<Integer> currList = list.get(start);
		for( Integer num : currList ){
			for( List<Integer> l : subList ){
				List<Integer> temp = new ArrayList<>();
				temp.add(num);
				temp.addAll(l);
				result.add(temp);
			}
		}
		return result;
	}
}