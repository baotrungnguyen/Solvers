package CLI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;

public class CLIWorker implements Runnable {
	  
    private String command;
    private SSHClient ssh;
    private String output;
    
    public CLIWorker(SSHClient ssh, String command){
        this.ssh = ssh;
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        try {
			output = runCmd(ssh, command);
			System.out.println(Thread.currentThread().getName()+" Get out put: " + output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private static String runCmd(SSHClient sshClient, String command) throws IOException  {
        String response = "";

        try (Session session = sshClient.startSession()) {
            final Command cmd = session.exec(command);
            response = (IOUtils.readFully(cmd.getInputStream()).toString());
            cmd.join(5, TimeUnit.SECONDS);
            // System.out.println("\n** exit status: " + cmd.getExitStatus());
        } 
        return response;
    }

    @Override
    public String toString(){
        return this.command;
    }
    
    public String getOutput() {
    	return this.output;
    }
    
    
}