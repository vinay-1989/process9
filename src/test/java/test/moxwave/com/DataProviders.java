package test.moxwave.com;
import org.testng.annotations.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class DataProviders {

    public static Object[][] getTableArray(String FilePath,int columns) throws Exception {   
      String[][] tabArray = null;
 
      try 
      {

        int startCol = 0;
        int ci,cj;
        Workbook workbook = WorkbookFactory.create(new File(FilePath));
        Sheet sheet = workbook.getSheetAt(0);
        //String sheetname=sheet.getSheetName();
        int rows=sheet.getLastRowNum()+1;
        
        tabArray=new String[rows-1][columns];
        ci=0;
 
        for (int i=1;i<rows;i++, ci++) 
        {     
         // if (i==0) continue;         
          //System.out.println("@@@@");
          cj=0;
          Row r = sheet.getRow(i);

          for (int j=startCol;j<columns;j++, cj++)
          {
            tabArray[ci][cj]="";
            if (r == null) {
              continue;
            }
            Cell c = r.getCell(j, MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (c == null) {
               // The spreadsheet is empty in this cell
            } else 
            {
              switch (c.getCellType())
              {
                case STRING:
                    //System.out.println(cell.getRichStringCellValue().getString());
                    tabArray[ci][cj]=c.getStringCellValue();
                    break;
                default:
                  break;
              }
               // Do something useful with the cell's contents
            }
            //System.out.println(tabArray[ci][cj]);
          }
          
        }
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

  @DataProvider(name="taggingtestdata")
  public static Object[][] createData() {
    String TEST_XLSX_FILE_PATH=WebConfig.BASE_CONFIG.getTaggingExcel();
    try
    {

       Object[][] data= getTableArray(TEST_XLSX_FILE_PATH,2);
       return data;
    }
    catch(Exception e)
    {
      return new Object[][]{{}}; 
    }
  }

  @DataProvider(name="enhi_terminology")
  public static Object[][] get_en_hi_TerminologyData() {
    String TEST_XLSX_FILE_PATH="d:\\qa\\en_hi_paytm_terminology.xlsx";
    try
    {
       Object[][] data= getTableArray(TEST_XLSX_FILE_PATH,6);
       return data;
    }
    catch(Exception e)
    {
      return new Object[][]{{}}; 
    }
  }

  @DataProvider(name="hi_gu_map")
  public static Object[][] get_hi_gu_mapdata() {
    String FILE_PATH="d:\\qa\\hi_gu_mapfile.xlsx";
    try
    {
       Object[][] data= getTableArray(FILE_PATH,4);
       return data;
    }
    catch(Exception e)
    {
      return new Object[][]{{}}; 
    }
  }

  @DataProvider(name="sentence_break_input")
  public static Object[][] getSentence_break_input() {
    String FILE_PATH="d:\\qa\\sentence_break.xlsx";
    try
    {
       Object[][] data= getTableArray(FILE_PATH,4);
       return data;
    }
    catch(Exception e)
    {
      return new Object[][]{{}}; 
    }
  }


}