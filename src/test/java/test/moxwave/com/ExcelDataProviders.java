package test.moxwave.com;
import org.testng.annotations.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.util.SystemOutLogger;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.testng.ITestContext;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelDataProviders {
    private static String testresourcespath="/home/adminp901/projects/wave/src/test/resources/";
    
    public static Object[][] getTableArray(String FilePath,int columns) throws Exception {   
      Object[][] tabArray = null;
 
      try 
      {
        
        int startCol = 0;
        int ci,cj;
       
      Workbook workbook = WorkbookFactory.create(new File(FilePath)); 
        Sheet sheet = workbook.getSheetAt(0);
        int rows=sheet.getLastRowNum()+1;
        tabArray=new String[rows-1][columns];
        DataFormatter formatter = new DataFormatter();

        ci=0; 
 
        for (int i=1;i<rows;i++, ci++) 
        {     
         // if (i==0) continue;         
          
          cj=0;
          Row r = sheet.getRow(i);
        
           for (int j=startCol;j<columns;j++, cj++)
          {
            
          
            if (r == null) {
              tabArray[ci][cj]="";
              continue;
            }
            Cell c = r.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
      
            
             if (c == null) {
               // The spreadsheet is empty in this cell
               String d="";
               tabArray[ci][cj]=d;

               
            } 
            else 
            {
              switch (c.getCellType())
              {
                
                case STRING:
                    
                    tabArray[ci][cj]=c.getStringCellValue();
                    

                   
                    break;

                case NUMERIC:

                tabArray[ci][cj]=formatter.formatCellValue(c);  
                    break;
                 // formatter model is used to accept all col value as a string from Excel!   
                   
                default:
                  break;
              }
               // Do something useful with the cell's contents
            }
            //System.out.println(tabArray[ci][cj]);
          }
          
        }
        workbook.close();
      } 
 
      catch (FileNotFoundException e)
      {
          System.out.println("Could not read the Excel sheet");
          e.printStackTrace();
 
      }
 
      catch (IOException e)
      {
          System.out.println("Could not read the Excel sheet");
      }
      return(tabArray);
  }

  @DataProvider(name="exceldatareader")
  
 public static Object[][] getTestData(Method m, ITestContext iTestContext) {

   
   String TEST_XLSX_FILE_PATH=testresourcespath + m.getDeclaringClass(). getSimpleName()+"/";
                      
                      
   Parameter[] parameters = m.getParameters();
   
   int columns=parameters.length;                  
   //int i=field.getInt(callingclass);
   String TEST_XLSX_FILE = TEST_XLSX_FILE_PATH+m.getName()+".xlsx";
   
   try
   {

      Object[][] data= getTableArray(TEST_XLSX_FILE, columns);
      return data;
   }
   catch(Exception e)
   {
     return new Object[][]{{}};
   }
}
  }


