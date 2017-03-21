package com.succez.demo;


/**
 * 遍历二叉树，输入树的层数返回该层的所有节点
 * <p>Copyright: Copyright (c) 2017<p>
 * <p>succez<p>
 * @author candy
 * @createdate 2017年3月21日
 */
public class TreeDemo
{
    int size; //树长度
    char[] data; //树的数据
    private TNode root;	//树的根节点
	
    
    
    public TNode getRoot() {
		return root;
	}


	public void setRoot(TNode root) {
		this.root = root;
	}


	public TreeDemo(char[] data) {
        this.data = data;
        size = data.length;
        root = createTree(0);
    }
    /**
	 * 创建节点对象TNode
	 * left为左节点，right为右节点,value为节点的值
	 * 数的节点类中，类部类在修饰的时候可以进行使用默认的，但是在外部的话需要用private进行修饰
	 */
    class TNode
    {
    	String value;
        TNode left;
        TNode right;
		
		public TNode(String value) {
	        this.value = value;
	    }
        
    }
    /**
     * 采用递归的方法生成二叉树
     * index为char数组的索引，从而生成节点的索引创建节点
     * 
     */
    public TNode createTree(int index) { 
    	// 数据索引大于数组大小时结束
        if(index >= size){
            return null;
        }
        TNode node = new TNode(String.valueOf(data[index]));
        // 生成左节点
        node.left = createTree(2 * index + 1);
        // 生成右节点
        node.right = createTree(2 * index + 2);
        return node;
    }

  
    /**
     * 采用递归方法层序遍历二叉树
     * 传入的n表示第n层
     */
    public void treeLevel(TNode tree, int n) {
    	
        if (tree == null || n < 1) {
            return;
        }
        if (n == 1) {
            System.out.print(tree.value + "  ");
            return;
        }
        // 左子树
        treeLevel(tree.left, n - 1);
        // 右子树
        treeLevel(tree.right, n - 1);
    }

}
