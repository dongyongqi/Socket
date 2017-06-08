package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用URL读取网页内容
 * @author Administrator
 *
 */

public class Test03 {

	public static void main(String[] args) {
		try {
			URL url=new URL("https://www.baidu.com");
			//通过URL的openStream方法获取URL对象所表示的资源的字节输入流
				InputStream is =url.openStream();
				//将字节输入流转化成字符输入流
				InputStreamReader isr=new InputStreamReader(is);
				//位字符输入流添加缓冲
				BufferedReader br=new BufferedReader(isr);
				String data=br.readLine();
				while (data!=null) {
					System.out.println(data);
					data=br.readLine();
				}
				br.close();
				isr.close();
				is.close();
	      } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
