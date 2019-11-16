package com.solid_design_principles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal{
	private final List<String> entries = new ArrayList<>();
	private static int count = 0;
	
	public void addEntry(String text) {
		entries.add("" + (++count) + ": " + text);
	}
	
	public void removeEntry(int index) {
		entries.remove(index);
	}
	
    @Override
    public String toString() {
    	return String.join(System.lineSeparator(), entries);
    }
    
    
//    public void save(String filename) throws FileNotFoundException {
//    	try(PrintStream out = new PrintStream(filename)) 
//    	{
//    		out.println(toString());
//    		
//    	}
//    }
//    
//    
//    public void load(String filename) {}
//    public void load(URL url) {}
//	
	
}


class Persistence{
	
	public void saveToFile(Journal journal,
			               String filename,
			               boolean overwrite) throws FileNotFoundException {
		if(overwrite || new File(filename).exists() ) {
			try(PrintStream out = new PrintStream(filename)) 
	    	{
	    		out.println(journal.toString());
	    		
	    	}
		}
	}
	
	
	public void load(String filename) {}
    public void load(URL url) {}
	
}




public class SingleResponsibilityPrinciple {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Journal jnal = new Journal();
		jnal.addEntry("It is raining here.");
		jnal.addEntry("Today is childrens' day");
		System.out.println(jnal);
		
		Persistence persist = new Persistence();
		String filename = "C:\\Users\\pbs99\\Desktop\\temp.txt";

		persist.saveToFile(jnal, filename, true);

		Runtime.getRuntime().exec("notepad.exe " + filename);
		
		

	}

}
