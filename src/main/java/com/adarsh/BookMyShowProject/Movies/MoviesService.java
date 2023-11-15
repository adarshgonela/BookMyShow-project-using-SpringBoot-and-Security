package com.adarsh.BookMyShowProject.Movies;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adarsh.BookMyShowProject.Config.ResponseStucture;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.IdNotFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.NoSuchElementToDeleteException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.NoUserFoundException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.SaveException;
import com.adarsh.BookMyShowProject.ExceptionsHandlers.UpdateException;

@Service
public class MoviesService {
@Autowired
	private MoviesDao dao;
	
	public ResponseEntity<ResponseStucture<Movies>> ADDUserService(Movies movies) {
		//return dao.AddMovie(movies);
		
		ResponseStucture<Movies> responseStucture=new ResponseStucture<Movies>();
		responseStucture.setStatus(HttpStatus.CREATED.value());
		responseStucture.setMessage("Successsfully Inserted");
				
		
		 try {
	            responseStucture.setData(dao.AddMovie(movies));
	            return new ResponseEntity<ResponseStucture<Movies>>(responseStucture,HttpStatus.CREATED);
	        	
	        } catch (Exception e) {
	            throw new SaveException();
	        }
		
	}
	public ResponseStucture<Movies> GetAllMovie() {
		//return dao.GetAllMovie();
		ResponseStucture<Movies> responseStucture=new ResponseStucture<Movies>();
		//responseStucture.setStatus(HttpStatus.FOUND.value());
		responseStucture.setMessage("Successsfully Fetched");
		 List<Movies> list = dao.GetAllMovie();
		try {
			responseStucture.setDataAll(list);
			return responseStucture;
		} catch (Exception e) {
			throw new NoUserFoundException();
			
		}
		
	}
	
	public ResponseStucture<Movies> DeleteMovieService(int id) {
		//return dao.DeleteMovieDao(id);
		ResponseStucture<Movies> responseStucture=new ResponseStucture<Movies>();
		responseStucture.setStatus(HttpStatus.FOUND.value());
		responseStucture.setMessage("Successsfully Deleted");
		try {
			responseStucture.setData(dao.DeleteMovieDao(id));
			return responseStucture;

		} catch (Exception e) {
			throw new NoSuchElementToDeleteException();
		}
				
	}
	
	public ResponseStucture<Movies>  UpdateMovieService(Movies movies) {
	//	return dao.UpdateMoviesDao(movies);
		ResponseStucture<Movies> responseStucture=new ResponseStucture<Movies>();
		
		try {
			responseStucture.setStatus(HttpStatus.FOUND.value());
			responseStucture.setMessage("Successsfully Update");
			
			responseStucture.setData(dao.UpdateMoviesDao(movies));
			return responseStucture;
		} catch (Exception e) {
			throw new UpdateException();
		}
		
		
	}
	
	public ResponseStucture<Movies> GETbyIDService(int id) {
		ResponseStucture<Movies> responseStucture=new ResponseStucture<Movies>();
		
	 try {
		 responseStucture.setStatus(HttpStatus.FOUND.value());
			responseStucture.setMessage("Successsfully Update");
			 Movies movies	= dao.GetBYIDDao(id);
			responseStucture.setData(movies);
			return responseStucture;
		
		
  
     } catch (Exception e) {
         throw new IdNotFoundException();
     }		
	}
	
}
