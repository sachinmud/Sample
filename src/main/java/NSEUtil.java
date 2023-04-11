import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;
import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;

public class NSEUtil {

    static String optionsURL = "https://www.nseindia.com/get-quotes/derivatives?symbol=TATASTEEL";



    public static void executePython() throws Exception {
        try {
                StringWriter output = new StringWriter();
                ScriptContext context = new SimpleScriptContext();
                context.setWriter(output);

                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("python");
                engine.eval("import sys; sys.path.append(\"/some/path/to/folder/withpylibs\")");
                engine.eval(new FileReader(resolvePythonScriptPath("hello.py")), context);
                System.out.println(output.toString().trim());

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    private static String resolvePythonScriptPath(String filename) {
        File file = new File("src/main/resources/" + filename);
        return file.getAbsolutePath();
    }

    public static void main(String [] args) throws Exception {

        executePython();
    }
}
