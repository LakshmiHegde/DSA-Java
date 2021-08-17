/*
Find shortest unique prefix of every word
findPrefix, for each word, in worst case, you need to scan trie till word end, to find its unique prefix, O(n), n-length of string
Space = O(1)
 */
package RBR_DSA.Trie;
import static RBR_DSA.Trie.CreateTrieFromScratch.*;

public class UniquePrefixForWord {
    public static void findPrefix(TrieNode root,String[] keys)
    {
        TrieNode temp= root;
        String[] res=new String[keys.length];
        int n=keys.length;
        for(int i=0;i<n;i++)
        {
            temp=root;
            String key=keys[i];
            int j=0;
            int n1=key.length();
            StringBuilder prefix=new StringBuilder();
            while(j<n1)
            {
                if(root.children[key.charAt(j)-'a']!=null)
                {
                    root=root.children[key.charAt(j)-'a'];
                    prefix.append(key.charAt(j));
                    if(root.prefix_cnt == 1)
                        break;
                }
                j++;
            }
            root=temp;
            System.out.println(key+" : "+prefix);
        }
    }
    public static void main(String[] args)
    {
        TrieNode root=new TrieNode();
        String[] keys={"the","a","there","answer","any","by", "bye","their"};
        for(int i=0;i<keys.length;i++)
        {
            insertTrieNode(root,keys[i]);
        }
        System.out.println("Shortest Unique prefix");
        findPrefix(root,keys);

        String arr[] = {"zebra", "dog", "duck", "dove"};
        for(int i=0;i<arr.length;i++)
        {
            insertTrieNode(root,arr[i]);
        }
        System.out.println("Shortest Unique prefix");
        findPrefix(root,arr);
    }
}
