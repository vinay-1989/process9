package test.moxwave.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.testng.annotations.Test;

public class onetest {


// public static void main(String[]tyy) throws IOException {
//   BufferedReader reader =
//   new BufferedReader(new InputStreamReader(System.in));
// String name = reader.readLine();
// System.out.println(name);

// }


 @Test(priority = 0)
  public void set() throws IOException {
    String name;
    java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    name = in.readLine();
    System.out.println("Name =" +name);
    
    }

  
    
}