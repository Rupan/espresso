import java.lang.Runnable;
import java.lang.Thread;

import java.lang.Runtime;
import java.lang.Process;
import java.lang.Exception;

import java.io.InputStream;
import java.io.OutputStream;

public class Run implements Runnable {

    // http://www.java-tips.org/java-se-tips/java.util/from-runtime.exec-to-processbuilder.html
    public void run() {
      try
      {
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("Program.exe");
        InputStream in = p.getInputStream();
        OutputStream out = p.getOutputStream ();
        InputStream err = p.getErrorStream() ;
        //do whatever you want
        p.destroy() ;
      } catch(Exception exc){/*handle exception*/}
    }

    public static void main(String args[]) {
        (new Thread(new Run())).start();
    }
}
