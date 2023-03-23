package graphSearch;

import java.util.ArrayList;
import java.util.List;

public class nQueens {
    public List<List<Integer>> nqueens(int n){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curRow = new ArrayList<>();
        helper(n, curRow, res);
        return  res;
    }
    private void helper (int n, List<Integer> cur, List<List<Integer>> res){
        //base case and answer college
        if (cur.size() == n){
            res.add(new ArrayList(cur));
            return;
        }
        for (int col = 0; col < n; col++){ //check every col is valid to set the queens
            if (valid(col, cur)){
                cur.add(col);
                helper(n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean valid(int col, List<Integer> row){
        int curRow = row.size();
        for (int i = 0; i < row.size(); i++){
            if (row.get(i) == col || Math.abs(col - row.get(i)) == Math.abs(curRow - i)){
                return false;
            }
        }
        return true;
    }}
