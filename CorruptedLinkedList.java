import java.util.*;

public class CorruptedLinkedList{

	public static void main(String[] args) {
		System.out.println("change");
	}

	static int findIndex (ListNode node1, ListNode node2){
		if( node1 == null )	return 0;
		int len1 = 0;
		int len2 = 0;
		int index = 0;

		while( node1 != null ){
			len1 += 1;
			node1 = node.next;
		}

		while( node2 != null ){
			len2 += 1;
			node2 = node.next;
		}

		if( len1 > len2 ){
			for( int i=0 ; i<(len1-len2); i++ ){
				index += 1;
				node1 = node1.next;
			}
		}

		if( len2 > len1 )	for( int i=0 ; i<(len2-len1) ; i++ )	node2 = node2.next;

		while( node1 != null && node2 != null && node1 != node2 ){
			node1 = node1.next;
			node2 = node2.next;
			index += 1;
		}

		if( node1 == node2 )	return index;
		else return -1;
		
	}
}