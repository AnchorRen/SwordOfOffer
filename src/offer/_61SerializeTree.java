package offer;
/**
 * 序列化二叉树.
 * 
 * 请实现两个函数，分别用来序列化和反序列化二叉树.
 * 
 * 思路：
 * 		所谓序列化，就是把对象序列化为字符串，
 * 		反序列化，就是把字符串反序列化为对象。
 * 		
 * 
 * @author REN
 * @date 2016年9月9日 下午9:33:34
 */
public class _61SerializeTree {

	public int index = -1;
	/*
	 * 先序遍历序列化
	 */
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
  }
    /*
     * 反序列化，按照序列化顺序
     */
    TreeNode Deserialize(String str) {
        index++;
       int len = str.length();
        if(index >= len){
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
         
        return node;
  }
    
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
