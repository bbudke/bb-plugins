package bb.plugins.examples;

/*
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 *     http://creativecommons.org/publicdomain/zero/1.0/
 */

import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.log.LogService;

/**
 * A very simple plugin.
 * <p>
 * The annotation {@code @Plugin} lets ImageJ know that this is a plugin. There
 * are a vast number of possible plugins; {@code Command} plugins are the most
 * common one: they take inputs and produce outputs.
 * </p>
 * <p>
 * A {@link Command} is most useful when it is bound to a menu item; that is
 * what the {@code menuPath} parameter of the {@code @Plugin} annotation does.
 * </p>
 * <p>
 * Each input to the command is specified as a field with the {@code @Parameter}
 * annotation. Each output is specified the same way, but with a
 * {@code @Parameter(type = ItemIO.OUTPUT)} annotation.
 * </p>
 * 
 * @author Johannes Schindelin
 * @author Curtis Rueden
 */
@Plugin(type = Command.class, headless = true, menuPath = "Plugins>BB>Examples>Hello, World!")
public class HelloWorld implements Command {

	@Parameter
	private LogService log;
	
	@Parameter(label = "What's your name?", description = "Your name here")
	private String name = "Brian Budke";

	@Parameter(type = ItemIO.OUTPUT)
	private String greeting;
	
	/**
	 * Produces an output with the well-known "Hello, World!" message. The
	 * {@code run()} method of every {@link Command} is the entry point for
	 * ImageJ: this is what will be called when the user clicks the menu entry,
	 * after the inputs are populated.
	 */
	@Override
	public void run() {
		greeting = "Hello, " + name + "!";
		log.info("Info");
	}

}
