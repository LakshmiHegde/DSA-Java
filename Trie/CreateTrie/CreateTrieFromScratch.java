/*
Insert node into trie, search for target in trie
Insert - Time -O(n), space = O(1)
Search - Time -O(n), space = O(1)
In this implementation you cannot find, if duplicate nodes are inserted, if you want to find it, then instead of endforword as boolean, make it as int, and keep count, number of words ending at that position
 */
package RBR_DSA.Trie;

class TrieNode
{
    TrieNode[] children=new TrieNode[26];
    boolean isEndOfWord = false;
    int prefix_cnt;
    TrieNode()
    {
        for(int i=0;i<26;i++)
            children[i]=null;
        prefix_cnt=1;
    }

}
public class CreateTrieFromScratch {
    public static void insertTrieNode(TrieNode root,String key)
    {
        TrieNode temp= root;
        int n=key.length();
        for(int i=0;i<n;i++)
        {
            if(temp.children[key.charAt(i) - 'a'] == null)
            {
                temp.children[key.charAt(i) - 'a']=new TrieNode();
                temp=temp.children[key.charAt(i) - 'a'];
                if(i==n-1)
                    temp.isEndOfWord=true;
            }
            else if(temp.children[key.charAt(i) - 'a'] != null)
            {
                temp=temp.children[key.charAt(i) - 'a'];
                temp.prefix_cnt++;
                if(i==n-1)
                    temp.isEndOfWord=true;
            }
        }
    }
    static boolean search(TrieNode root, String key)
    {
        // Your code here
        if(root.children[key.charAt(0)-'a'] == null)
            return false;
        root=root.children[key.charAt(0)-'a'];
        int i=1;
        int n=key.length();
        while(i<n)
        {
            if(root.children[key.charAt(i)-'a']!=null)
            {
                root=root.children[key.charAt(i)-'a'];
            }
            else
            {
                return false;
            }
            i++;
        }
        if(root.isEndOfWord == false)
            return false;
        else
            return true;
    }

    public static void main(String[] args)
    {
        String[] keys={"the","a","there","answer","any","by", "bye","their"};
        TrieNode root=new TrieNode();
        for(int i=0;i<keys.length;i++)
        {
            insertTrieNode(root,keys[i]);
        }
        System.out.println(search(root,"there"));
        System.out.println(search(root,"therer"));
        System.out.println(search(root,"th"));
    }

}
