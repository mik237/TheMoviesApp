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
