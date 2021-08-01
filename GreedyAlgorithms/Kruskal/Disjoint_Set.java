package RBR_DSA.GreedyAlgorithms.Kruskal;

public class Disjoint_Set {
    Integer parent,rank;
    public void create_set(int data)
    {
        this.parent=data;
        rank=1;//one node currently
    }

    //since, find and union , i am not calling with particular object / set, therefore i declare it as static
    //it can be called on any normal data.
    public static Integer find(int data,Disjoint_Set[] sets)
    {
        //check recursively in the set, where index is the vertex number and parent is its, parent
        //check till parent==index, i,e till you find root, where parent and root are same

        if(sets[data].parent == data)
            return data;
        return find(sets[data].parent,sets);
    }
    public static void union(int x,int y,Disjoint_Set sets[])
    {
        //find root/ rep of x and y
        int x_rep=find(x,sets);
        int y_rep=find(y,sets);

        //check which set has minimum elements, and unite smaller to bigger one
        if(sets[x_rep].rank < sets[y_rep].rank)
        {
            //change parent of rep of y's set, as x's rep.thereby, u have united them
            sets[y_rep].parent=x_rep;
        }
        else
        {
            sets[x_rep].parent=y_rep;
        }
    }

}
