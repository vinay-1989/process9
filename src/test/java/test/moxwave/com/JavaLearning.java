package test.moxwave.com;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.RegexConversion;

class box{

  static public int i;
  public void display() 
        {
            System.out.println(i);
        }    

  }
 
public  class JavaLearning extends Thread  {
  static int number;
  static char[] ch=new char[3];
  Random rand = new Random();

  public static void main(String[] args) {
  
     
  
    String blogName = "howtodoinjava";
        char[] chars = blogName.toCharArray();
         
        Map<Character, Integer> map = new HashMap<>();
        int cou=1;
        //String d="lop";
           map.put('c', cou);
           map.put('d', 1);
           map.put('c', ++cou);
 System.out.println(map);

        // for(char c : chars) 
        // {
        //     if(map.containsKey(c)) {
        //         int counter = map.get(c);
        //         map.put(c, ++counter);
        //     } else {
        //         map.put(c, 1);
        //     }
        // }
         
        // System.out.println("Duplicate characters:");
         
        // //Print duplicate characters
        // for(char c : map.keySet()) {
        //     if(map.get(c) > 1) {
        //         System.out.println(c);
        //     }
        // }
   
//     StringBuilder sb=new StringBuilder(str);
//     String[]a=str.split("");
//     for(int i=0;i<a.length;i++){
//      //System.out.println("a["+i+"]==="+a[i]);
//     for(int j=i+1;j<a.length;j++){

//       if(a[i].equals(a[j])){

//     System.out.println(a[j]);

//     }
// }

    }
    

   

   
       

      
  //}

//     Random r = new Random();

//     int low = 65;
//     int high = 90;
//     for(int k=1; k<=100;k++){
//     for (int lp = 0; lp <= 2; lp++) 
//     {
//       int result = r.nextInt(high - low) + low;

//       char c = (char) result;
//       ch[lp] = c;
      
//     }
//     String st=new String(ch);
//     System.out.println(st);
//   }
 
 
          


//       Random random = new Random();
// int rand = 0;
// while (true){
//     rand = random.nextInt(9);
//     if(rand !=0) break;
// }
// System.out.println(rand);
     
      // ArrayList<Character> al=new ArrayList<>();

      // for(int j=65;j<=90;j++){

      //        char val=(char)j;

      //        System.out.println(val);
      // }
           
    
    //  for(int i=1;i<=20;i++){
    //  int actno=("%04d%n", rand.nextInt(10000));
    //   System.out.printf("%04d%n", rand.nextInt(10000));;
    //    LinkedList<Integer> stack = new LinkedList<Integer>();
    //    while (number > 0) {
    //        stack.push( number % 10 );
    //        number = number / 10;
    //    }
       
    //    while (!stack.isEmpty()) {
    //        System.out.println(stack.pop());
 
    //    }
    //}
      
     


      
    //  String s="454fggf656";
    //   Pattern p= Pattern.compile("\\d+");
    //  Matcher m= p.matcher(s);
    //  while(m.find()){
    //   System.out.println(m.group());
    //  }
       



//       Map<String,Integer> hm =  
//       new HashMap< String,Integer>(); 
// hm.put("a", new Integer(100)); 
// hm.put("b", new Integer(200)); 
// hm.put("c", new Integer(300)); 
// hm.put("d", new Integer(400)); 

// Set< Map.Entry< String,Integer> > st = hm.entrySet();    
  
//        for (Map.Entry< String,Integer> me:st) 
//        { 
//            System.out.print(me.getKey()+":"); 
//            System.out.println(me.getValue()); 
//        } 
// System.out.println(hm);




    // Scanner scan=new Scanner(System.in);
    //     int s=scan.nextInt();
    //     boolean flag=false;
    //  for(int n=2;n<=s/2;n++){
    //    if(s%n==0){
    //      flag=true;
    //      break;
    //    }
    //  }
    //  if(!flag){
    //    System.out.println("prime");

    //  }
    //  else{
    //    System.out.println("not prime");

    //  }
   
    
    // int num = 3;
    //     boolean flag = false;
    //     for(int i = 2; i <= num/2; ++i)
    //     {
    //         // condition for nonprime number
    //         if(num % i == 0)
    //         {
    //             flag = true;
    //             break;
    //         }
    //     }
    //     if (!flag){
    //         System.out.println(num + " is a prime number.");
    //     }
    //     else{
    //         System.out.println(num + " is not a prime number.");
    // }
  

      




    //  String name="ym eman si yaniv oar";
    //     StringBuilder s=new StringBuilder(name).reverse();
    //      String[] act=s.toString().split(" ");  
        
         
    //      String[] n=new String[act.length];
    //      int j=0;
    //      for(int i=act.length-1;i>=0; i--,j++){
    //                 n[j]= act[i];
    //                 System.out.print(n[j]+" ");
                   

    //      }
         


      

     
        // for(int i=0;i<split.length;i++){
        // System.out.print(sb.append(split[i]).reverse());
        // System.out.print(" ");
            

        // }

     // System.out.println(i=89);
      ArrayList<String> list = new ArrayList<String>(); 
  
      // list.add("A"); 
      // list.add("B"); 
      // list.add("C"); 
      // list.add("D"); 
      // list.add("E");
        Iterator <String> ir=   list.iterator();
        // System.out.println(ir.next());
        // System.out.println(ir.next());

  //}



  
      
        
   

    // public static String StrConcat(String str1) 
    // { 
    //     str1 = str1 +  "Edureka";
    //     return str1; 
    //   // System.out.println(str1);
        
    // } 
    

       
     

//             StringBuilder sb=new StringBuilder();
//             System.out.println(sb.append(name).reverse());
//   String reverse="";
//           for(int i=name.length()-1;i>=0;i--){
//            reverse=reverse+name.charAt(i);
//           }
//           System.out.println(reverse);

//           char[] ch=name.toCharArray();
//          // ch[0]=ch[1];
//            System.out.println(ch[1]+""+ch[0]+""+ch[2]);
//            String a="abc";
//            String b="abc";
//            //String c="pl";

//           String s1 = new String("abc");
//          String s2 = new String("abc");
//         System.out.println(a.trim());
//        //System.out.println(a.equals(s1));
  //  }

  //*******program for finding  max and min number***/

  // int io[]={3, 223,431,45,23,55,23,9,10,34};
  // int maxSoFar = io[0];
  // int min=io[0];
  // for(int a:io){
  //   if(a>maxSoFar){
  //     maxSoFar=a; 
  //   }
  //   else if(a<min){
  //     min=a; 
  //   }
  // }
  // System.out.println("maximum number="+maxSoFar);
  // System.out.println("min number="+min);


  }


