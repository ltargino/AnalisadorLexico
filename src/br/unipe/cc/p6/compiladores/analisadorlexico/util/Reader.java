package br.unipe.cc.p6.compiladores.analisadorlexico.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Reader {

	public static String getSourceFile() throws IOException {
		String sourcer_code = "";

		JFileChooser fc = new JFileChooser();	
		
		int return_value = fc.showOpenDialog(fc);
		
		if (return_value == JFileChooser.APPROVE_OPTION) {
			BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
			
			while(br.ready())
				sourcer_code += br.readLine() + Constants.breakLine;
			
			br.close();		
			return sourcer_code;
		} else {
			System.out.println("Um arquivo não foi selecionado.");
			return null;
		}
	}
	
}
