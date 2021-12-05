package criteriaAPI;

import criteriaAPI.movieEntity.MovieEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieUtils {

    public static List<MovieEntity> getMovieListFromExcel(String fileName){
        List<MovieEntity> movieEntityList = null;
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet firstSheet = workbook.getSheetAt(0);
            Map<Integer, List<String>> data = new HashMap<>();
            int index = 0;

            for(Row row : firstSheet){
                data.put(index, new ArrayList<>());
                for(Cell cell : row){
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    data.get(index).add(cell.getRichStringCellValue().getString());
                }
                index++;
            }

            movieEntityList = createMovieEntitiesList(data);


        } catch (FileNotFoundException e) {
            System.err.println("EXCEL file NOT FOUND : "+fileName);
            e.printStackTrace();

        } catch (IOException e) {
            System.err.println("Unable to create Excel work book from input file");
            e.printStackTrace();
        }
        return movieEntityList;
    }

    private static List<MovieEntity> createMovieEntitiesList(Map<Integer, List<String>> data) {
        List<MovieEntity> movieEntityList = new ArrayList<>();
        MovieEntity movie = null;
        for(List<String> list : data.values()){
            movie = new MovieEntity();
            movie.setMovieId(list.get(0));
            movie.setMovieName(list.get(1));
            movie.setLanguage(list.get(2));
            movie.setReleasedIn(Integer.parseInt(list.get(3)));
            movie.setRevenueInDollars(Integer.parseInt(list.get(4)));
            movieEntityList.add(movie);
        }
        return movieEntityList;
    }
}
