package bb.plugins;

import java.io.File;
import java.io.IOException;

import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.util.DigestUtils;
import org.scijava.util.FileUtils;

@Plugin(type = Command.class, headless = true, menuPath = "Plugins>BB>Write Something")
public class WriteSomething implements Command {
	
	@Parameter
	private LogService log;
	
	private static final String FILENAME = System.getProperty("user.home") +
			File.separator + "Desktop" +
			File.separator + "test.txt";
	
	private File outFile = new File(FILENAME);
	private String data = new String("Hello");
	
	@Override
	public void run() {
		try {
			FileUtils.writeFile(outFile, DigestUtils.bytes(data));
			log.info("Wrote \"" + data + "\" to " + FILENAME);
		} catch (final IOException ex) {
			log.error(ex);
		}
	}
	
}
