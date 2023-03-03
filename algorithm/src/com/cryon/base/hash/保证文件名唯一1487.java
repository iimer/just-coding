package com.cryon.base.hash;

import java.util.*;

/**
 * @author iimer
 * @description 给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，
 *              新建名为 names[i] 的文件夹。
 *
 *              由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，
 *              系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
 *
 *              返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
 * @date 2023-03-03 17:18:01
 */
public class 保证文件名唯一1487 {

    public static void main(String[] args) {
        getFolderNames(new String[]{"wano","wano","wano","wano"});
    }

    public static String[] getFolderNames(String[] names) {
        Map<String,Integer> nameMaxNumCache = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String tmpName = name;
            int maxNum = 0;
            if (nameMaxNumCache.containsKey(tmpName)) {
                maxNum = 1;
                name = tmpName+"("+maxNum+")";
                while (nameMaxNumCache.containsKey(name)) {
                    maxNum +=1;
                    name = tmpName+"("+maxNum+")";
                }
                nameMaxNumCache.put(name,0);
            }
            nameMaxNumCache.put(tmpName,maxNum);
            res[i] = name;
        }
        return res;
    }

    /**
     * 官解
     * @param names
     * @return
     */
    public String[] getFolderNames1(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }
}
