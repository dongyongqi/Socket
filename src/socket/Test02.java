package socket;

import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {

	public static void main(String[] args) {
		// 创建一个URL实例
		try {
			URL imooc=new URL("http://www.imooc.com");
			//？后面表示参数，#后面表示描点
			URL ur1=new URL(imooc,"/index.html?username=tom#test");
			System.out.println("协议"+ur1.getProtocol());
			System.out.println("主机："+ur1.getHost());
			System.out.println("端口："+ur1.getPort());
			//如果未指定端口号，使用默认端口号，此时返回值为-1
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		

	}

}
