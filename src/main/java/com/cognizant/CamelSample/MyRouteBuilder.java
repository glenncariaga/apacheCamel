package com.cognizant.CamelSample;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {
	private final static String COPY = "c";
	private final static String ARCHIVE = "a";
	private final static String MOVE = "m";
	private final static String INPUT_DIRECTORY = "file:C:\\datafiles\\input";
	private final static String OUTPUT_DIRECTORY = "file:C:\\datafiles\\output";
			
	private String startEndpoint;
	private String destination;
	private String startArgs;
	
    public MyRouteBuilder(String[] args) {
    	this.startEndpoint = INPUT_DIRECTORY;
		this.destination = OUTPUT_DIRECTORY;
		
		if(args.length != 0) {
			switch(args[0]) {
			case COPY:
				this.startArgs = "?noop=true";
				break;
			case MOVE:
				this.startArgs = "?delete=true";
				break;
			case ARCHIVE:
				this.startArgs = "";
				break;
			default:
				this.startArgs = "?noop=true";			
			}
		}
		else {
			this.startArgs = "?noop=true";
		}
	}

	/**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {
        from(this.startEndpoint+this.startArgs)
        	.to(this.destination);
    }
}
