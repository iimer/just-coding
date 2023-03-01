package com.cryon.base.hash;

import java.util.*;

/**
 * @author iimer
 * @date 2023-02-28 14:52:03
 */
public class 合并相似的物品2263 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> v2wCache = new HashMap<>();
        for (int[] item : items1) {
            v2wCache.put(item[0],item[1]+v2wCache.getOrDefault(item[0],0));
        }
        for (int[] item : items2) {
            v2wCache.put(item[0],item[1]+v2wCache.getOrDefault(item[0],0));
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : v2wCache.entrySet()) {
            List<Integer> tmpList = new ArrayList<>(2);
            res.add(tmpList);
            tmpList.add(e.getKey());
            tmpList.add(e.getValue());
        }
        res.sort(Comparator.comparingInt(l->l.get(0)));
        return res;
    }
}
