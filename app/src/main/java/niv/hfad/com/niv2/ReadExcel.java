package niv.hfad.com.niv2;

/**
 * Created by yoav on 2/11/2018.
 */

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.IOException;
import java.io.InputStream;

class ReadExcel {

    static void fillStock(InputStream inputStream) {
        Workbook workbook = null;
        try {

            workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(0);

            for(int i = 1 ; i < sheet.getRows() ; i++){
                String name = sheet.getCell(0,i).getContents();
                String wholesale = sheet.getCell(1,i).getContents();
                if(wholesale.equals(""))
                    wholesale = "0";
                String retail = sheet.getCell(2,i).getContents();
                if (retail.equals(""))
                    retail = "0";
                if(name.charAt(0) == 'B'){
                    BraceletsActivity.addToList(name , Integer.valueOf(wholesale) , Integer.valueOf(retail));
                } else if (name.charAt(0) == 'N'){
                    NecklacesActivity.addToList(name,Integer.valueOf(wholesale) , Integer.valueOf(retail));
                } else if(name.charAt(0) == 'E'){
                    EarringsActivity.addToList(name,Integer.valueOf(wholesale) , Integer.valueOf(retail));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }
    }
}
