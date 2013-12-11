package net.temerity.espresso;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Espresso extends Activity
{
    private static final String ABI1 = Build.CPU_ABI;
    private static final String ABI2 = Build.CPU_ABI2;
    private static final String TAG = "Espresso";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Context.getFilesDir():
        // Returns the absolute path to the directory on the filesystem
        // where files created with openFileOutput(String, int) are stored.
        extract();
    }

    // extracts one of the embedded espresso binaries to the Files directory
    private void extract() {
      Context ctx = this.getApplicationContext();
      InputStream input = null;
      FileOutputStream output = null;
      File exe = new File(ctx.getFilesDir(), "/espresso");
      if( ! exe.exists() ) {
        try {
          input = ctx.getAssets().open(ABI1 + "/espresso");
          output = ctx.openFileOutput("espresso", Context.MODE_PRIVATE);
          byte[] buffer = new byte[1024];
          int bytesRead;
          while( (bytesRead = input.read(buffer)) != -1 )
            output.write(buffer, 0, bytesRead);
          exe.setExecutable(true);
        } catch( IOException ioe ) {
          Log.w(TAG, "Failed to extract espresso executble", ioe);
        } finally {
          try {
            if( input != null ) input.close();
            if( output != null ) output.close();
          } catch(IOException ioe) {
            Log.w(TAG, "Failed to close stream", ioe);
          }
        } // try
      } // if
    } // extract()

}
