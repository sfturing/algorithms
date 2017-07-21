package cn.sfturing.offer;

/**
 * 2.请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are
 * Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * @author sfturing
 *
 * @date 2017年7月21日
 */
public class ReplaceSpace {
	
	public String soulution(StringBuffer str){
		
		
		 return str.toString().replaceAll("\\s", "%20");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
