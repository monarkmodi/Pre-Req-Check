public interface ConsoleColorPrint
{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";

	public static String retColorString(String color, String given)
	{
		if(color.toLowerCase().equals("red")) return (ANSI_RED+given+ANSI_RESET);
		else if(color.toLowerCase().equals("black")) return (ANSI_BLACK+given+ANSI_RESET);
		else if(color.toLowerCase().equals("green")) return (ANSI_GREEN+given+ANSI_RESET);
		else if(color.toLowerCase().equals("yellow")) return (ANSI_YELLOW+given+ANSI_RESET);
		else if(color.toLowerCase().equals("blue")) return (ANSI_BLUE+given+ANSI_RESET);
		else if(color.toLowerCase().equals("purple")) return (ANSI_PURPLE+given+ANSI_RESET);
		else if(color.toLowerCase().equals("cyan")) return (ANSI_CYAN+given+ANSI_RESET);
		else return given;
	}
}