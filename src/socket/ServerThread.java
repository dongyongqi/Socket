package socket;
/**
 * 服务器线程处理类
 * @author Administrator
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
//和本线程相关的Socket
	Socket socket=null;
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	//线程执行的操作，响应客户端的请求
	public void run(){
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		OutputStream os=null;
		PrintWriter pw=null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info=null ;
			while ((info=br.readLine())!=null) {//循环读取客户端的信息
				System.out.println("我是服务器，客户端说："+info);
				
			}
			socket.shutdownInput();//关闭输入流
			//4.获取输出流，相应客户端的请求
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("欢迎你！");
			pw.flush();//调用该方法将缓冲输出
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//5.关闭资源
	try {
		if (pw!=null) 
			pw.close();
		if (os!=null)
			os.close();
		if (br!=null) 
			br.close();
		if (isr!=null) 
			isr.close();
		if (is!=null) 
			is.close();
		if (socket!=null) 
			socket.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
}
