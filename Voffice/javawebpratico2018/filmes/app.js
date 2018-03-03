var ironman = {
  title: "Iron Man",
  releasedDate: "20/08/2013",
  budget: 200000,
  poster:"http://www.impawards.com/2010/posters/iron_man_two_ver6.jpg"
};

var thor = {
  title: "Thor",
  releasedDate: "08/11/2014",
  budget: 150000,
  poster:"http://www.impawards.com/2017/posters/thor_ragnarok.jpg"
};

var captainAmerica = {
  title: "Captain America",
  releasedDate: "01/05/2015",
  budget: 215000,
  poster:"http://www.impawards.com/2016/posters/captain_america_civil_war.jpg"
};

var tableBody = document.getElementById("tableBody");
var btnSave = document.getElementById("btnSave");
var txfTitle = document.getElementById("txfTitle");
var txfBudget = document.getElementById("txfBudget");
var txfPoster = document.getElementById("txfPoster");
var txfReleasedDate = document.getElementById("txfReleasedDate");
var txfId = document.getElementById("txfId");

var movies = [];

var init = () => {
  //localStorage.removeItem("movies");
  addEventListeners();
  loadMovies();
}

var loadMovies = () => {
  tableBody.innerHTML = "";
  movies = localStorage.getItem("movies");
  movies = JSON.parse(movies);
  var marvel = [ironman, thor, captainAmerica];
  movies = movies ? movies : marvel;
  movies.forEach((m, i) => printMovies(m, i));
}

var addEventListeners = () => {
  btnSave.addEventListener("click", getAndSaveMovie);
}

var printMovies = (movie, index) => {
  if (!movie) return;
  var row = "<tr>"+
  "<td>"+index+"</td>"+
  "<td>"+movie.title+"</td>"+
  "<td>"+movie.releasedDate+"</td>"+
  "<td>"+movie.budget+"</td>"+
  "<td><img src=\""+movie.poster+"\" width=\"80\" /></td>"+
  "<td>"+
  "<input type=\"button\" onclick=\"deleteMovie("+index+")\" value=\"Delete\" />"+
  "<input type=\"button\" onclick=\"editMovie("+index+")\" value=\"Edit\" />"+
  "</td>"+
  "</tr>";
  tableBody.innerHTML += row;
}

var getAndSaveMovie = (e) => {
  if(e) e.preventDefault();
  var title = txfTitle.value;
  var poster = txfPoster.value;
  var releasedDate = txfReleasedDate.value;
  var budget = txfBudget.value;
  var id = txfId.value;
  var isNew = id == "-1";
  id = isNew? movies.length: id;
  var movie = {id: id, title: title, "poster": poster, releasedDate: releasedDate, "budget": budget};
  if (isNew) movies.push(movie);
  else movies[id] = movie;
  commitMovies();
  loadMovies();
}

var deleteMovie = (index) => {
  console.log("removendo filme "+movies[index].title);
  delete movies[index];
  commitMovies();
  loadMovies();
};

var editMovie = (index) => {
  console.log("editando filme "+movies[index].title);
  var movie = movies[index];
  txfTitle.value = movie.title;
  txfPoster.value = movie.poster;
  txfReleasedDate.value = movie.releasedDate;
  txfBudget.value = movie.budget;
  txfId.value = index;
};

var commitMovies = () => {
  localStorage.setItem("movies", JSON.stringify(movies));
}

window.onload = init();
