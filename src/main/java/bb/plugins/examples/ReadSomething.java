package bb.plugins.examples;

import java.io.File;
import java.io.IOException;

import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.ui.DialogPrompt;
import org.scijava.ui.UIService;
import org.scijava.util.DigestUtils;
import org.scijava.util.FileUtils;

@Plugin(type = Command.class, headless = true, menuPath = "Plugins>BB>Examples>Read Something")
public class ReadSomething implements Command {

	@Parameter
	private LogService logService;
	
	@Parameter
	private UIService uiService;
	
	private static final String FILENAME = System.getProperty("user.home") +
			File.separator + "Desktop" +
			File.separator + "test.txt";
	
	private File inFile = new File(FILENAME);
	
	private String data;
	
	@Override
	public void run() {
		try {
			data = DigestUtils.string(FileUtils.readFile(inFile));
			logService.info("Read \"" + data + "\" from " + FILENAME);
		} catch (final IOException ex) {
			logService.error(ex);
			uiService.showDialog("Couldn't find 'test.txt' on the Windows desktop.",
					DialogPrompt.MessageType.ERROR_MESSAGE);
		}
	}
	
}
