package vn.edu.cit.model;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.Session;

public class Power {
	public boolean Shutdown(){
		Server sv = new Server();;
		sv.setIp("192.168.2.10");
		sv.setUsername("root");
		sv.setPassword("root");
		
		Session ss = sv.Connect(sv);
		
		try{
		Channel channel=ss.openChannel("exec");
        ((ChannelExec)channel).setCommand("reboot");
        channel.setInputStream(null);
        ((ChannelExec)channel).setErrStream(System.err);
        InputStream in=channel.getInputStream();
        channel.connect();
        byte[] tmp=new byte[1024];
        while(true){
          while(in.available()>0){
            int i=in.read(tmp, 0, 1024);
            if(i<0)break;
            System.out.print(new String(tmp, 0, i));
          }
          if(channel.isClosed()){
            System.out.println("exit-status: "+channel.getExitStatus());
            break;
          }
          try{Thread.sleep(1000);}catch(Exception ee){}
        }
        channel.disconnect();
        return true;
		}catch(Exception e){
			return false;
		}
	}
}
