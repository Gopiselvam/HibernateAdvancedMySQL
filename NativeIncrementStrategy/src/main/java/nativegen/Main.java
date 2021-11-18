package nativegen;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final static String INPUX_XL = "src/main/resources/inputlicense.xlsx";
    public static void main(String[] args) {
        HibernateUtil.initSessionFactory();
        addLicenseFromExcel();
    }

    private static void addLicenseFromExcel() {

        try (FileInputStream fis = new FileInputStream(new File(INPUX_XL))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for(Row row : sheet){
                data.put(i, new ArrayList<String>());
                for(Cell cell : row){
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    data.get(i).add(cell.getRichStringCellValue().getString());

                    /*switch (cell.getCellTypeEnum()){
                        case NUMERIC:
                            data.get(i).add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case STRING:
                            data.get(i).add(cell.getRichStringCellValue().getString());
                            break;
                        default:
                            data.get(i).add("#####");
                    }*/

                }
                i++;
            }
            DrivingLicense dl;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LicenseDao licenseDao = new LicenseDao();
            for(List<String> list: data.values()){
                dl = new DrivingLicense();
                dl.setName(list.get(0));
                dl.setAge(Integer.parseInt(list.get(1)));
                dl.setGender(list.get(2));
                dl.setAddress(list.get(3));
                dl.setLicenseIssueDate(LocalDate.parse(list.get(4), dtf));
                dl.setLicenseExpiryDate(LocalDate.parse(list.get(5), dtf));
                dl.setLicenseIssueZone(list.get(6));
                licenseDao.addRecords(dl);
            }

            data.values().forEach(list -> {
                for (String val : list) {
                    System.out.printf("%-22s", val);
                }
                System.out.println();
            });
        }catch (FileNotFoundException ex){
            System.out.println("File not found = "+INPUX_XL);
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
