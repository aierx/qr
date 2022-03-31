package com.aierx.rebbreaktree;

public class RBTree<T extends Comparable> {

    private RBTNode<T> mRoot;

    private static final boolean RED =false;

    private static final boolean BLACk = true;

    public class RBTNode<T>{
        boolean color;
        T key;
        RBTNode<T> left;
        RBTNode<T> right;
        RBTNode<T> parent;


        public RBTNode(T key, boolean color, RBTNode<T> left, RBTNode<T> right, RBTNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }


    }

    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                        px
     *     /                         /
     *    x                         y
     *   /  \      --(左旋)--       / \
     *  lx   y                    x   ry
     *     /   \                 /  \
     *    ly   ry              lx    ly
     */

    private void leftRotate(RBTNode<T> x){
        // 设置x的右孩子为y
        RBTNode<T> y = x.right;
        // 将ly设置为x的右孩子
        x.right = y.left;
        // 如果ly非空，将x设置为ly的父亲
        if (y.left!=null){
            y.left.parent = x;
        }
        // 将x的父亲设置为y的父亲
        y.parent = x.parent;
        if (x.parent == null){
            this.mRoot = y;
        }else {
            if (x.parent.left==x){
                x.parent.left = y;
            }else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent =y;
    }

    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                          py
     *           /                           /
     *          y                           x
     *         /  \      --(右旋)--        /  \
     *        x   ry                     lx   y
     *       / \                              / \
     *      lx  rx                           rx  ry
     *
     */

    private void rightRotate(RBTNode<T> y){
        RBTNode x = y.left;
        y.left = x.right;
        if (x.right!=null){
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent==null){
            this.mRoot = x;
        }else {
            if (y.parent.left==y){
                y.parent.left = x;
            }else {
                y.parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    private void insert(RBTNode<T> node){
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;
        while (x!=null){
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp<0){
                x = x.left;
            }else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y!=null){
            cmp = node.key.compareTo(y.key);
            if (cmp<0){
                y.left = node;
            }else {
                y.right = node;
            }
        }else {
            this.mRoot = node;
        }
        node.color = RED;
        insertFixUp(node);
    }

    public void insert(T key){
        RBTNode<T> node = new RBTNode<>(key, BLACk, null, null, null);
        if (node!=null){
            insert(node);
        }
    }

    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent,gParent;
        // 若“父节点存在，并且父节点的颜色是红色”
        while ((parent = parentOf(node))!=null&&isRed(parent)){
//            if (parent)
        }
        // 将根节点设为黑色
        setBlack(this.mRoot);
    }

    private void setRed(RBTNode<T> node) {
        node.color = RED;
    }

    private void setBlack(RBTNode<T> node) {
        node.color = BLACk;
    }


    private RBTNode<T> parentOf(RBTNode<T> node){
        return node.parent;
    }

    private boolean isRed(RBTNode<T> node){
        return node.color==RED;
    }

}
