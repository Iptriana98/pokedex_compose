![ic_pokedex_launcherRecurso 2](https://user-images.githubusercontent.com/78894683/209907864-62913aa9-1879-4c46-9831-a42d0534c836.png)

<h1>Pokedex Compose</h1>

A Pokedex app using Compose based on MVVM Architecture.

Download
------------

Screenshots
------------

Tech stack & Open-source libraries
----------------------------------
* Minimum SDK level 21
* 100% Kotlin based + Coroutines + Flow for asynchronous.
* JetPack
  * Lifecycle - dispose observing data when lifecycle state changes.
  * ViewModel - UI related data holder, lifecycle aware.
  * Room Persistence - construct database.
* Architecture
  * MVVM Architecture (View - DataBinding - ViewModel - Model)
  * Repository pattern
  * Koin - dependency injection
* Material Design & Animations
* Retrofit2 & Gson - constructing the REST API
* OkHttp3 - implementing interceptor, logging and mocking web server
* Coil - loading images
