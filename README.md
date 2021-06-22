# TheMoviesApp
Android app showing list of movies from https://www.themoviedb.org/  

<b>How to run:</b>
Import the project in Android Studio and build.

<b>Packages</b>

  1. <b>adapters:</b>    Containing the MoviesListAdapter class which is responsible for dispatching list of movies to recyclerview.
  2. <b>network:</b>     Containing the NetworkService interface & model classes to handle response from api.
  3. <b>di:</b>          Containing NetworkModule providing network related dependencies
  4. <b>mappers:</b> 	   Containing mapper class responsible for mapping response model to view model with only necessary fields.
  5. <b>ui:</b>		       Containing activities, fragments & viewmodels.
  6. <b>utils:</b>     	 Containing utils class, ConnectionManager and constants.
  7. <b>TheMoviesApp</b> This is not a package. This is application class.

Application Architecture using MVI architecture.

<b>Libraries Used</b>
  1. AndroidX
  2. Glide
  3. Retrofit
  4. Hilt for dependency injection.
  5. NavigationController
  6. MVI architecture
  7. NetworkBoundResource


<b>Flow chart diagram link:</b> https://drive.google.com/file/d/1cBQ3hS1vS6WD1jnqxGhZsVCiCtS0ma1c/view?usp=sharing

<b>Download APK link:</b> https://drive.google.com/file/d/1L0sAhJONbiY_l6wLPLKnkhUF_p70HBcG/view?usp=sharing

<table>
  <tr>
    <td>Movies List</td>
     <td>Movie Detail</td>
  </tr>
  <tr>
    <td><img src="https://firebasestorage.googleapis.com/v0/b/voteonline2018.appspot.com/o/1.png?alt=media&token=acfea76c-7d9a-4dff-a41a-490092d340eb" width=378 height=777></td>
    <td><img src="https://firebasestorage.googleapis.com/v0/b/voteonline2018.appspot.com/o/2.png?alt=media&token=b2757682-cc9c-487e-9832-8de244ce5747" width=378 height=777></td>
  </tr>
  <tr height="50px"></tr>
  <tr>
    <td><img src="https://firebasestorage.googleapis.com/v0/b/voteonline2018.appspot.com/o/3.png?alt=media&token=082d0749-6cdb-49f9-ab9d-d0734fa83a8b" width=378 height=777></td>
    <td><img src="https://firebasestorage.googleapis.com/v0/b/voteonline2018.appspot.com/o/4.png?alt=media&token=4a9802c1-52ba-44e7-941f-2432b6f77fde" width=378 height=777></td>
  </tr>
 </table>

