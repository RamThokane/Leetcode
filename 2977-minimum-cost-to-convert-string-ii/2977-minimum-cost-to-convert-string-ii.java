class Node{
    Node[] c=new Node[26];
    int id=-1;
}
class Solution{
    static final long INF=1L<<60;
    Node root=new Node();
    int idc;
    long[][] g;
    char[] s,t;
    Long[] dp;

    public long minimumCost(String S,String T,String[] o,String[] c,int[] w){
        int n=w.length;
        g=new long[n<<1][n<<1];
        s=S.toCharArray(); t=T.toCharArray();
        for(int i=0;i<g.length;i++){
            Arrays.fill(g[i],INF);
            g[i][i]=0;
        }
        for(int i=0;i<n;i++){
            int a=ins(o[i]), b=ins(c[i]);
            g[a][b]=Math.min(g[a][b],w[i]);
        }
        for(int k=0;k<idc;k++)
            for(int i=0;i<idc;i++)
                if(g[i][k]<INF)
                    for(int j=0;j<idc;j++)
                        g[i][j]=Math.min(g[i][j],g[i][k]+g[k][j]);
        dp=new Long[s.length];
        long r=dfs(0);
        return r>=INF?-1:r;
    }

    int ins(String w){
        Node p=root;
        for(char ch:w.toCharArray()){
            int i=ch-'a';
            if(p.c[i]==null)p.c[i]=new Node();
            p=p.c[i];
        }
        if(p.id<0)p.id=idc++;
        return p.id;
    }

    long dfs(int i){
        if(i==s.length)return 0;
        if(dp[i]!=null)return dp[i];
        long r=s[i]==t[i]?dfs(i+1):INF;
        Node a=root,b=root;
        for(int j=i;j<s.length;j++){
            a=a.c[s[j]-'a'];
            b=b.c[t[j]-'a'];
            if(a==null||b==null)break;
            if(a.id>=0&&b.id>=0&&g[a.id][b.id]<INF)
                r=Math.min(r,g[a.id][b.id]+dfs(j+1));
        }
        return dp[i]=r;
    }
}
