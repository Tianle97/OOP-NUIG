package nuig.oop.model;

import java.util.HashSet;

public class Container {
	private HashSet<Films> films = new HashSet<Films>();
	private HashSet<Genre> genres = new HashSet<Genre>();
	private HashSet<People> peoples = new HashSet<People>();
	private HashSet<Profiles> profiles = new HashSet<Profiles>();
	private HashSet<TVseries> tvseries = new HashSet<TVseries>();

	public Container() {

	}

	public void addFilms(Films f) {
		films.add(f);
	}

	public void addGenre(Genre g) {
		genres.add(g);
	}

	public void addPeople(People p) {
		peoples.add(p);
	}

	public void addProfiles(Profiles pr) {
		profiles.add(pr);
	}

	public void addTVseries(TVseries tv) {
		tvseries.add(tv);
	}

	public HashSet<Films> getFilms() {
		return films;
	}

	public void setFilms(HashSet<Films> films) {
		this.films = films;
	}

	public HashSet<Genre> getGenres() {
		return genres;
	}

	public void setGenres(HashSet<Genre> genres) {
		this.genres = genres;
	}

	public HashSet<People> getPeople() {
		return peoples;
	}

	public void setPeople(HashSet<People> peoples) {
		this.peoples = peoples;
	}

	public HashSet<Profiles> getProfiles() {
		return profiles;
	}

	public void setProfiles(HashSet<Profiles> profiles) {
		this.profiles = profiles;
	}

	public HashSet<TVseries> getTvseries() {
		return tvseries;
	}

	public void setTvseries(HashSet<TVseries> tvseries) {
		this.tvseries = tvseries;
	}

}
