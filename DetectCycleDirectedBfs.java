import java.util.*;
public class Solution {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
        ArrayList<TreeSet<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new TreeSet<Integer>());
        }

        for(int j=0;j<edges.size();j++){
            adjList.get(edges.get(j).get(0)).add(edges.get(j).get(1));
        }
        boolean[] visited = new boolean[n+1];
        boolean[] dfsVisited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!visited[i] && dfs(visited,dfsVisited, i,adjList) ){
                return true;
            }
        }
        return false;
    }
    public static boolean dfs(boolean[] visited,boolean[] dfsVisited, int node,ArrayList<TreeSet<Integer>> adjList){
        visited[node] = true;
        dfsVisited[node] = true;
        for(Integer x : adjList.get(node)){
            if(!visited[x]) {
                if (dfs(visited,dfsVisited,x,adjList))  return true;
            }else if(dfsVisited[x]){
                return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }
}