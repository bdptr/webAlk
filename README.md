# Adatbázis
Szükséges egy <b>cinema</b> schema létrehozása. Az alkalmazás induláskor létrehozza és feltölti az adatbázist tesztadatokkal.

### Adatbázis struktúra:
https://goo.gl/EaQ4MZ

# API dokumentáció
### Filmek lekérdezése:
  URL: /movies<br />
  Metódus: GET<br />
  
### Filmek lekérdezése műfaj szerint:
  URL: /movies/{genre}<br />
  Metódus: GET<br />

### Filmek lekérdezése mozi szerint:
  URL: /movies/cinema/{name}<br />
  Metódus: GET<br />

### Adott műsorhoz tartozó helyek lekérdezése:
  URL: /shows/{id}/seats<br />
  Metódus: GET<br />
  
### Adott felhasználtó általi helyfoglalás:
  URL: /buy/seat/{seatid}/user/{userid}<br />
  Metódus: POST<br />

### Műsorok lekérdezése:
  URL: /shows<br />
  Metódus: GET<br />
  
### Adott felhasználó 'userDetails' tulajdonságának módosítása:
  URL: /user/edit/{id}<br />
  Metódus: POST<br />
  
### Felhasználók lekérdezése:
  URL: /users<br />
  Metódus: GET<br />
  
### Bejelentkezett felhasználó kijelentkeztetése:
  URL: /logout<br />
  Metódus: POST<br />
  
# Model-ek
### Cinema:
  - Long id;
  - String name;
  - List<Show> cinemaShows;

### CustomUserDetails extends User implements UserDetails:
  - List<String> userRoles;

### Movie:
  - Long id;
  - String name;
  - String genre;
  - List<Show> upcomingShows;

### Seat:
  - Long id;
  - Boolean isFree;

### Show:
  - Long id;
  - Date showDate;
  - Movie movie;
  - Cinema cinema;
  - List<Seat> seats;

### User:
  - Long id;
  - String name;
  - String password;
  - String userDetails;
  - List<Seat> seats;

### UserRole:
  - Long userroleid;
  - Long userid;
  - String role;
