//构造二叉树
	/* preOrderStart：前序遍历序列的开始处
	 * preOrderEnd：前序遍历序列的结束处
	 * inOrderStart：中序遍历序列的开始处
	 * inOrderEnd：中序遍历序列的结束处
	 * preOrder：前序遍历数组
	 * inOrder：中序遍历数组
	 * 在递归的时候传入的就是前序、中序的子序列的开始和结束处
	 * */
	public static BinNode constructBinTree(int[] preOrder, int[] inOrder, int preOrderStart, int preOrderEnd, int inOrderStart,int inOrderEnd){
		int rootValue = preOrder[preOrderStart];//根节点是前序遍历的第一个节点
		BinNode root = new BinNode(rootValue);//创建二叉树的根节点
		//1.在中序遍历中寻找根节点
		int i = 0;
		for(i = inOrderStart; i <= inOrderEnd; i++) {
			if(rootValue == inOrder[i]) {
				break;
			}
		}
		//求当前根节点左子树的长度
		int leftLength = i - inOrderStart; //注意
		//2.构造左子树,每次都需要在已有的前序序列和中序序列中拆解出左子树序列进行构造
		if(leftLength > 0) {//当前根节点的左子树不为空
			root.leftNode = constructBinTree(preOrder, inOrder, preOrderStart + 1, preOrderStart + leftLength, inOrderStart, i - 1);
		}
		
		//求当前根节点右子树的长度
		int rightLength = inOrderEnd - i; //注意
		//3.构造右子树,每次都需要在已有的前序序列和中序序列中拆解出子树序列进行构造
		if(rightLength > 0) {//当前根节点的右子树不为空
			root.righNode = constructBinTree(preOrder, inOrder, preOrderStart + leftLength + 1, preOrderEnd, i + 1, inOrderEnd);
		}
		return root;
	}
