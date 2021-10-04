package br.ce.wcaquino.taskbackend.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreramsServiceTest {
	
	/*
	 * @Test public void deveTestarStreams() { List<Integer> lista =
	 * Arrays.asList(1,2,3,4,4,5,6,10,12,23,45,45,48,50,85);
	 * 
	 * lista.stream().forEach(System.out::println);
	 * 
	 * Integer[] intArray = new Integer[] {1,2,3,4,5};
	 * Arrays.stream(intArray).forEach(System.out::println);
	 * 
	 * Stream.of("Se", "casa", "segura"). forEach(System.out::println);
	 * 
	 * IntStream.range(50, 71).forEach(System.out::println);
	 * 
	 * Stream.iterate(5, n -> n*2) .limit(10) .forEach(System.out::println);; }
	 */
	/*
	 * @Test public void deveTestarStreamsArquivos() throws IOException { File teste
	 * = new File("c:/temp/teste.txt"); FileReader in = new FileReader(teste);
	 * BufferedReader bf = new BufferedReader(in);
	 * bf.lines().forEach(System.out::println);
	 * 
	 * Path p = Paths.get("c:/temp"); Files.list(p).forEach(System.out::println); }
	 */
	
	@Test
	public void deveTestarStreamsRegex() throws IOException  {
		String s = "aprendendo a usar regex com Stream";
		Pattern pa = Pattern.compile(" ");
		pa.splitAsStream(s).forEach(System.out::println);
	}
	

}
