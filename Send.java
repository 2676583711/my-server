import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Send extends Socket {

    private static final String SERVER_IP = "192.168.8.52"; // server IP
    private static final int SERVER_PORT = 8899; // server port

    private Socket client;

    private FileInputStream fis;

    private DataOutputStream dos;

    /**
 *      *  connect server
 *           *
 *                * @throws Exception
 *                     */
    public Send() throws Exception {
        super(SERVER_IP, SERVER_PORT);
        this.client = this;
        System.out.println("Cliect[port:" + client.getLocalPort() + "]  connect server success");
   
 }

/**
 *      *  send method
 *           *
 *                * @throws Exception
 *                     */
    public void sendFile() throws Exception {
        try {

            File file = new File("a.txt");
            if (file.exists()) {
                fis = new FileInputStream(file);
                dos = new DataOutputStream(client.getOutputStream());

                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();

                System.out.println("======== send start ========");
                byte[] bytes = new byte[1024];
                int length = 0;
                long progress = 0;
                while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                    progress += length;
                    System.out.print("| " + (100 * progress / file.length()) + "% |");
                }
                System.out.println();
                System.out.println("======== send ok ========");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (dos != null) {
                dos.close();
            }
            client.close();
        }
    }


    public static void main(String[] args) {
        try {
            Send client = new Send();
            client.sendFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
