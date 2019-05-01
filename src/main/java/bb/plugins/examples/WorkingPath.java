package bb.plugins.examples;

import java.io.File;

import org.scijava.command.Command;
import org.scijava.log.LogService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.prefs.PrefService;

@Plugin(type = Command.class, menuPath = "Plugins>BB>Examples>Set/Get Working Path")
public class WorkingPath implements Command {

	private final static String WORKING_PATH_KEY = "Working Path";
	
	@Parameter
	private LogService log;
	
	@Parameter
	private PrefService prefService;
	
	@Parameter(label = "Choose a working path:", style = "directory")
	private static File file;
	
	@Override
	public void run() {
		prefService.put(getClass(), WORKING_PATH_KEY, file.getAbsolutePath());
		log.info("GET PREF= " + prefService.get(getClass(), WORKING_PATH_KEY));
	}
	
}
