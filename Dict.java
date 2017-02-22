import java.util.*;

public class Dict{
	public static void main(String[] args) {
		Trie tree = new Trie();
		tree.insert("abc");
		tree.insert("car");
		tree.insert("race");
		// System.out.println(tree.numWord);
		System.out.println(tree.find("ca"));
		System.out.println(tree.find("ra"));
		System.out.println(tree.find("a"));
	}
}