import org.apache.commons.cli.*;

/**
 * Created by anonymous on 18.07.2017.
 *
 * '-in' file
 * '-out' file
 * '-transform' - transformation name
 */
public class ConsoleCV {
    public static void main ( String [] arguments ) {
        // parse input parameters
        Options options = new Options();
        options.addRequiredOption("i", "in", true, "source in");
        options.addRequiredOption("o", "out", true, "source out");
        options.addRequiredOption("t", "transform", true, "transformation");
        options.addOption("p1", true, "transformation parameter1");
        options.addOption("p2", true, "transformation parameter2");
        options.addOption("p3", true, "transformation parameter3");
        options.addOption("p4", true, "transformation parameter4");
        options.addOption("p5", true, "transformation parameter5");
        CommandLine commandLine;
        CommandLineParser parser = new DefaultParser();
        try {
            commandLine = parser.parse(options, arguments);
        } catch (ParseException e) {
            throw new RuntimeException("Can't parse command line correctly", e);
        }
        String in = commandLine.getOptionValue("in");
        String out = commandLine.getOptionValue("out");
        String transform = commandLine.getOptionValue("transform");
        String p1 = commandLine.getOptionValue("p1");
        String p2 = commandLine.getOptionValue("p2");
        String p3 = commandLine.getOptionValue("p3");
        String p4 = commandLine.getOptionValue("p4");
        String p5 = commandLine.getOptionValue("p5");



    }
}