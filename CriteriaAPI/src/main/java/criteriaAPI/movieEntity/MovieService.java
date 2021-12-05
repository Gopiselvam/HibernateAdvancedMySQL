package criteriaAPI.movieEntity;

import criteriaAPI.MovieUtils;

import java.util.List;
import java.util.Scanner;

import static criteriaAPI.MovieUtils.getMovieListFromExcel;

public class MovieService {

    private static final String MOVIE_EXCEL_FILE = "src\\main\\resources\\movieDetails.xlsx";

    private MovieDao dao = new MovieDao();

    Scanner sc = new Scanner(System.in);

    public void movieServices() {
//        populateMovieTableFromExcel();
//        getAllMovies();
        getMoviesInbetween();
    }

    private void getMoviesInbetween() {
        System.out.println("Enter Start year");
        Integer startYear = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter End year");
        Integer endYear = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter movie id prefix. Eg. M10");
        String prefix = sc.nextLine();
        List<MovieEntity> list = dao.getMoviesInBetweenWithPrefix(startYear, endYear, prefix);
        if(null!=list && !list.isEmpty()){
            for(MovieEntity movie : list){
                System.out.println(movie);
            }
        }else{
            System.out.println("No movies found Inbetween "+startYear+" , "+endYear);
        }
    }

    private void getAllMovies() {
        List<MovieEntity> list = dao.getAllMovies();
        if(null!=list && !list.isEmpty()){
            for(MovieEntity movie : list){
                System.out.println(movie);
            }
        }else{
            System.out.println("No movies found");
        }
    }

    private void populateMovieTableFromExcel() {
        List<MovieEntity> movieList =  MovieUtils.getMovieListFromExcel(MOVIE_EXCEL_FILE);
        dao.addMovies(movieList);
    }
}
