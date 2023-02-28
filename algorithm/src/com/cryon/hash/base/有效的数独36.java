package com.cryon.hash.base;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author iimer
 * @date 2023-02-28 16:19:42
 */
public class 有效的数独36 {
    //可以利用题目特殊性用数组，省去部分Hash类的各动作时间复杂度，和本身的空间复杂度
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> rawCache = new HashMap<>();
        HashMap<Integer,HashSet<Character>> columnCache = new HashMap<>();
        HashMap<Integer,HashSet<Character>> smallBoardCache = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            if (!rawCache.containsKey(i)) {
                rawCache.put(i,new HashSet<>());
            }
            for (int j = 0; j < 9; j++) {
                char tmpChar = board[i][j];
                if ('.' == tmpChar) {
                    continue;
                }
                if (!columnCache.containsKey(j)) {
                    columnCache.put(j,new HashSet<>());
                }
                if (!smallBoardCache.containsKey(getSmBKey(i,j))) {
                    smallBoardCache.put(getSmBKey(i,j),new HashSet<>());
                }
                if (rawCache.get(i).contains(tmpChar) || columnCache.get(j).contains(tmpChar) || smallBoardCache.get(getSmBKey(i,j)).contains(tmpChar)) {
                    System.out.println(i);
                    System.out.println(j);
                    return false;
                }
                rawCache.get(i).add(tmpChar);
                columnCache.get(j).add(tmpChar);
                smallBoardCache.get(getSmBKey(i,j)).add(tmpChar);
            }
        }
        return true;
    }

    private Integer getSmBKey(int i, int j) {
        return j/3*3+(i+1)/3;
    }

}
