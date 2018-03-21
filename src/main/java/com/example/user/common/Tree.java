package com.example.user.common;

import com.example.user.po.Menu;
import com.example.user.service.UserService;
import lombok.Data;

import java.util.*;

/**
 * Provides static methods for convert list to tree.
 *
 * @author wangzunhui
 */
@Data
public class Tree<E> {
    private E node;
    private List<Tree> children;

    public void add(Tree o){
        this.children.add(o);
    }

    /**
     * Tree node interface.
     */
    public interface Comparable{
        /**
         * get node's id.
         * @return
         */
        Integer getId();

        /**
         * get node's parent id.
         *
         * @return
         */
        Integer getPid();
    }

    /**
     * convert list to tree.
     *
     * @param list
     * @return
     */
    public static Tree toTree(List<Tree.Comparable> list){
        Map<Integer, Tree> map = new HashMap<>(list.size() * 2);

        for (Tree.Comparable t : list) {
            // child
            int id = t.getId();
            Tree child = map.get(id);
            if (child == null){
                child = new Tree();
                map.put(id, child);
            }

            if (child.getNode() == null){
                child.setNode(t);
            }

            // parent
            int pid = t.getPid();
            Tree parent = map.get(pid);
            if (parent == null){
                parent = new Tree();
                map.put(pid, parent);
            }

            parent.add(child);
        }
        Tree root = map.get(0);
        map.clear();

        return root;
    }
}
