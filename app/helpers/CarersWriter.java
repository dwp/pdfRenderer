package helpers;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class CarersWriter extends BufferedWriter{

    private static final String NEW_LINE_HEIGHT = "line-height: normal;";
    private static final String LINE_HEIGHT = "line-height:";

    public CarersWriter(OutputStream stream) {
        super(new OutputStreamWriter(stream, Charset.forName("UTF-8")));
    }

    public void write (String str) throws IOException {
        if (str.trim().startsWith(LINE_HEIGHT)){
            super.write(str.replace(str, NEW_LINE_HEIGHT));
        }else{
            super.write(str);
        }
    }
}
