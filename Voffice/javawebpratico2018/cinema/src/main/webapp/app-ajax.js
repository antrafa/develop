var tableBody = document.getElementById("tableBody");
var btnSave = document.getElementById("btnSave");
var txfTitle = document.getElementById("txfTitle");
var txfBudget = document.getElementById("txfBudget");
var txfPoster = document.getElementById("txfPoster");
var txfReleasedDate = document.getElementById("txfReleasedDate");
var txfId = document.getElementById("txfId");
var divCallBack = document.getElementById("callback");

var endPoint = "http://172.16.200.151:8080/movies/api/html5/movies";

var movies = [];

var init = () => {
  addEventListeners();
  getMovies();
};

var addEventListeners = () => {
  btnSave.addEventListener("click", getAndSaveMovie);
};

var getMovies = () => {
  tableBody.innerHTML = "<tr><td style=\"text-align:center;\" colspan=6><img src=\"img/loading.gif\" width=\"25\" /></td></tr>";
  ajaxExec("GET",endPoint,"",function(e) {
      tableBody.innerHTML = "";
      console.log(e.target.status);
      movies = JSON.parse(e.target.responseText);
      movies.forEach((m, i) => printMovies(m, i));
  });
};

var printMovies = (movie, index) => {
  if (!movie) return;
  var row = "<tr>"+
  "<td>"+index+"</td>"+
  "<td>"+movie.title+"</td>"+
  "<td>"+movie.releasedDate+"</td>"+
  "<td>"+movie.budget+"</td>"+
  "<td style=\"text-align:center;\"><img src=\""+movie.poster+"\" width=\"80\" /></td>"+
  "<td style=\"text-align:center;\">"+
    "<input type=\"button\" onclick=\"deleteMovie("+index+")\" value=\"Delete\" /><br />"+
    "<input type=\"button\" onclick=\"editMovie("+index+")\" value=\"Edit\" />"+
  "</td>"+
  "</tr>";
  tableBody.innerHTML += row;
};

var getAndSaveMovie = (e) => {
  divCallBack.innerHTML = "";
  if(e) e.preventDefault();

  var id = txfId.value;
  var isNew = id == "-1";
  var httpMethod = "PUT";

  if(isNew){
    id = movies.length;
    httpMethod = "POST";
  }

  var params = "title="+txfTitle.value+
  "&releasedDate="+txfReleasedDate.value+
  "&budget="+txfBudget.value+
  "&poster="+txfPoster.value+
  "&id="+movies.length;

  ajaxExec(httpMethod,endPoint,params,function(e) {
    console.log(e.target.status);
    getMovies();
  });

};

var ajaxExec = (httpMethod,endPoint,params,callback) => {
  var xhr = new XMLHttpRequest();
  xhr.open(httpMethod, endPoint, true);
  xhr.addEventListener("load",callback);
  xhr.send(params);
};

var deleteMovie = (index) => {
  console.log("removendo filme "+movies[index].title);
  delete movies[index];
  commitMovies();
  getMovies();
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

var clearForm = () => {
  txfTitle.value = "";
  txfPoster.value = "";
  txfReleasedDate.value = "";
  txfBudget.value = "";
  txfId.value = "";
};

var commitMovies = () => {
  localStorage.setItem("movies", JSON.stringify(movies));
}

window.onload = init();
