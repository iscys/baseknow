package com.baseknow.cli;

import org.apache.commons.cli.*;

public class CliTest {

    public static void main(String[] args)throws Exception {
        Options options =new Options();
        Option opt = new Option("h", "help", false, "Print help");
        opt.setRequired(false);
        options.addOption(opt);

        opt =
                new Option("n", "namesrvAddr", true,
                        "Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876");
        opt.setRequired(false);
        options.addOption(opt);
        opt = new Option("c", "configFile", true, "Name server config properties file");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("p", "printConfigItem", false, "Print all config item");
        opt.setRequired(false);
        options.addOption(opt);
        HelpFormatter hf =new HelpFormatter();
        hf.printHelp("nameSrv", options, true);

        CommandLine commandLine = null;
         PosixParser posixParser = new PosixParser();
        commandLine = posixParser.parse(options,args);
        System.out.println(commandLine);
        if(commandLine.hasOption("n")){
            final String c = commandLine.getOptionValue("n");
            System.out.println(c);
        }

    }
}
