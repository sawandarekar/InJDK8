package jdk8.StreamApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Problem : Find length of the longest line in file
 */
public class FindLongestLineInFile {

  public static void main(String[] args) throws Exception {
    FindLongestLineInFile f = new FindLongestLineInFile();
    URL fileName = FindLongestLineInFile.class.getClassLoader().getResource("testfile.txt");


    f.getLongestLineLength_Simple1(fileName.getFile());
    f.getLongestLineLength_Simple2(fileName.getFile());
    f.getLongestLineLength_Better(fileName.getFile());
    f.getLongestLineLength_Recursion(fileName.getFile());
    f.getLongestLineLength_BetterStream(fileName.getFile());
    f.getLongestLineLength_BetterStream2(fileName.getFile());
  }

  //Simple approach-1
  private int getLongestLineLength_Simple1(String fileName) throws IOException {
    final File fileDir = new File(fileName);
    FileInputStream in = new FileInputStream(fileDir);
    final InputStreamReader reader = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(reader);
    Stream<String> lines = br.lines();
    int longest = lines.mapToInt(String::length).max().getAsInt();
    System.out.println("getLongestLineLength_Simple1 length:"+longest);
    return longest;
  }

  //Simple approach-2
  private int getLongestLineLength_Simple2(String fileName) throws IOException {
    final File fileDir = new File(fileName);
    FileInputStream in = new FileInputStream(fileDir);
    final InputStreamReader reader = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(reader);
    Stream<String> lines1 = br.lines();
    String longestStr = lines1.sorted((x,y)-> y.length() - x.length()).findFirst().orElse("");
    System.out.println("getLongestLineLength_Simple2 length:"+longestStr.length()+" longest-str:"+longestStr);
    return longestStr.length();
  }

  //Better approach
  private int getLongestLineLength_Better(String fileName) throws IOException {
    final File fileDir = new File(fileName);
    FileInputStream in = new FileInputStream(fileDir);
    final InputStreamReader reader = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(reader);
    String longest = "";
    String str;
    while ((str = br.readLine()) != null) {
      if(str.length() > longest.length())
        longest =str;
    }
    System.out.println("getLongestLineLength_Better length:"+longest.length()+" longest-str:"+longest);
    return longest.length();
  }

  //recursion
  private int getLongestLineLength_Recursion(String fileName) throws IOException {
    final File fileDir = new File(fileName);
    FileInputStream in = new FileInputStream(fileDir);
    final InputStreamReader reader = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(reader);
    String longest = findLongestString("", br);
    System.out.println("getLongestLineLength_Recursion length:"+longest.length()+" longest-str:"+longest);
    return longest.length();
  }

  private String findLongestString(String longest, BufferedReader reader) throws IOException {
    String next = reader.readLine();
    if(next == null)
      return longest;
    if(next.length() > longest.length())
      longest = next;
    return findLongestString(longest, reader);
  }

  //Better Stream solution
  private int getLongestLineLength_BetterStream(String fileName) throws IOException {
    final File fileDir = new File(fileName);
    FileInputStream in = new FileInputStream(fileDir);
    final InputStreamReader reader = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(reader);
    String longest = br.lines().reduce((x,y) -> {
      if(x.length() > y.length())
        return  x;
      return y;
    }).get();
    System.out.println("getLongestLineLength_BetterStream length:"+longest.length()+" longest-str:"+longest);
    return longest.length();
  }

  //Simplest stream solution
  private int getLongestLineLength_BetterStream2(String fileName) throws IOException {
    final File fileDir = new File(fileName);
    FileInputStream in = new FileInputStream(fileDir);
    final InputStreamReader reader = new InputStreamReader(in);
    BufferedReader br = new BufferedReader(reader);
    String longest = br.lines().max(Comparator.comparingInt(String::length)).orElse("");
    System.out.println("getLongestLineLength_BetterStream2 length:"+longest.length()+" longest-str:"+longest);
    return  longest.length();
  }
}
