package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test01 {

	public static void main(String[] args)throws UnknownHostException {
		//获取本机的InetAddress实例
		InetAddress address=InetAddress.getLocalHost();
		System.out.println("计算机名:"+address.getHostName());
		System.out.println("ip地址"+address.getHostAddress());
		byte[]bytes=address.getAddress();//获取字节型的数组
		System.out.println("字节数组中的内容"+Arrays.toString(bytes));
		System.out.println(address);
		//根据机器名获取InetAddress实例
	
	}

}
