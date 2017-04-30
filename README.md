# webalk

Models:
  - Cinema:
    - Long id;
    - String name;
    - List<Show> cinemaShows;
    
  - CustomUserDetails extends User implements UserDetails:
    - List<String> userRoles;

  - Movie:
    - Long id;
    - String name;
    - String genre;
    - List<Show> upcomingShows;
    
  - Seat:
    - Long id;
    - Boolean isFree;

  - Show:
    - Long id;
    - Date showDate;
    - Movie movie;
    - Cinema cinema;
    - List<Seat> seats;
    
  - User:
    - Long id;
    - String name;
    - String password;
    - String userDetails;
    - List<Seat> seats;
    
  - UserRole:
    - Long userroleid;
    - Long userid;
    - String role;
    
