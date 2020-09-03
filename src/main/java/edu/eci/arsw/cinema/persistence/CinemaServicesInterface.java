package edu.eci.arsw.cinema.persistence;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import edu.eci.arsw.cinema.model.Cinema;
import edu.eci.arsw.cinema.model.CinemaFunction;

@Service
public interface CinemaServicesInterface {

	List<CinemaFunction> filtroDisponibilida(String name, String fecha, String asientos) throws CinemaFilterException;

	List<CinemaFunction> filtroGenero(String fecha, String cinema, String genero) throws CinemaFilterException;

	List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date);

	void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException;

	Cinema getCinemaByName(String name);

	Set<Cinema> getAllCinemas() throws CinemaException;

	void addNewCinema(Cinema c) throws CinemaPersistenceException;

}
