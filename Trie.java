import java.util.*;

public class Trie{
	TrieNode root;
	static int numWord = 0;
	public Trie(){
		this.root = new TrieNode(' ');
	}

	public void insert(String str){
		TrieNode pointer = root;
		if( str == null || str.length() == 0 )	return;
		for( int i=0 ; i<str.length() ; i++ ){
			char c = str.charAt(i);
			if( pointer.children[c-'a'] == null ){
				pointer.children[c-'a'] = new TrieNode(c);
				pointer = pointer.children[c-'a'];
			}	
		}
		pointer.isWord = true;
		pointer.str = str;
		this.numWord += 1;
		// System.out.println( str );
	}

	public String find(String prefix){
		TrieNode pointer = root;
		for( int i=0 ; i<prefix.length() ; i++ ){
			char c = prefix.charAt(i);
			if( pointer.children[c-'a'] == null )	return null;
			else pointer = pointer.children[c-'a'];
		}
		if( pointer.isWord )	return pointer.str;
		// found prefix, then try to find the nearest leaf
		return findLeaf(pointer);
	}

	public String findLeaf(TrieNode node){
		if( node == null )	return null;
		if( node.isWord )	return node.str;

		TrieNode next = null;
		for( TrieNode n : node.children ){
			if( n != null ){
				next = n;
				break;
			}
		}
		if( next == null )	return null;
		else return findLeaf(next);
	}
}