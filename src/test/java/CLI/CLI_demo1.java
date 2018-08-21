package CLI;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Command;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;

import java.io.IOException;
import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import automationCore.DriverFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** This examples demonstrates how a remote command can be executed. */
public class CLI_demo1 extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Test CLI");
	private static SSHClient ssh;
    @Test
    public static void testCLI() throws IOException {
        ssh = new SSHClient();
        //ssh.loadKnownHosts();
        ssh.addHostKeyVerifier(new HostKeyVerifier() {
            @Override
			public boolean verify(String arg0, int arg1, PublicKey arg2) {
                return true; // don't bother verifying
            }
        });
        ssh.connect("11.11.254.249");
        Session session = null;
        ssh.authPassword("root", "hitachi");
/*        try {
            ssh.authPassword("root", "hitachi");
            session = ssh.startSession();
            String output = runCmd(ssh, "systemctl status myapi");
            logger.info(output);
            if (output.contains("active (running)")) {
            	output = runCmd(ssh, "systemctl stop myapi");
            }
            else {
            	output = runCmd(ssh, "systemctl start myapi");
            }
            
            logger.info("DONE!!!!!");
            
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (IOException e) {
                // Do Nothing   
            }
            
            ssh.disconnect();
        }*/
        
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new CLIWorker(ssh, "systemctl status myapi"));
        executor.execute(new CLIWorker(ssh, "systemctl start myapi"));
        executor.execute(new CLIWorker(ssh, "systemctl status myapi"));
        executor.execute(new CLIWorker(ssh, "date"));
        executor.execute(new CLIWorker(ssh, "pwd"));
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    
    }
    
    public static String runCmd(SSHClient sshClient, String command) throws IOException  {
        String response = "";

        try (Session session = sshClient.startSession()) {
            final Command cmd = session.exec(command);
            response = (IOUtils.readFully(cmd.getInputStream()).toString());
            cmd.join(5, TimeUnit.SECONDS);
            // System.out.println("\n** exit status: " + cmd.getExitStatus());
        } 
        return response;
    }

}