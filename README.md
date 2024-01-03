# Team 4
<h1> Online Movie Database Management System </h1>

[Video Presentation](https://youtu.be/NfJF680DHa8)

<h2>Movie class </h2>

Movie class has attributes such as: 

<ul>
    <li><strong><em>Title</em></strong></li>
    <li><strong><em>Director</em></strong></li>
    <li><strong><em>Release Year</em></strong></li>
    <li><strong><em>Running Time</em></strong></li>

</ul>

All of these attributes have Getters and Setter. Movie class also has a _toString_ method.

<h2>User class </h2>

User class has username and password fields, getters and setter for 
those fields and methods for retrieving and writing User data: 

<ul>
    <li><strong><em>Register method, which uses ObjectOutputStream to write new Users into UserDatabase file</em></strong></li>
    <li><strong><em>LogIn method, which uses ObjectInputStream to read Users credentials from UserDatabase file</em></strong></li>
</ul>

<h2>MovieDatabase class </h2>

MovieDatabase is an ArrayList of Movies. On top of the methods that are inherited from the Collection Class, 
MovieDatabase has:

<ul>
    <li><strong><em>Print Method that prints all the movies in a Database</em></strong></li>
    <li><strong><em>Print Method that prints a selected movie from the list by index </em></strong></li>
</ul>

<h2>User Interface</h2>
All  the before mentioned methods come to use in GUI interface build on Swing. User interface has

<ul>
    <li><strong><em>User Authentication screen with LogIn and Register options</em></strong></li>
    <li><strong><em> MovieDatabase screen, which shows all movies available</em></strong></li>
    <li><strong><em> Add New Movie screen, which allows users to create new movies in a MovieDatabase</em></strong></li>
</ul>

## Sorting and Filtering 

Movies in MovieDatabase can be sorted by Title, Director, Release Year and Running Time


