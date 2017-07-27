# AtmLocator

Spring boot application which exposes two rest api one via Spring and one via Apache camel to get 
the list of AtmLocations in Netherlands and to get the list of Atmlocations based on the city name

Technologies/Libraries Used

    Java (1.8)
    Spring Boot Web --> Web application is hosted along with this application to display in GUI
    Spring Boot Security  --> Added security to restrict only authorized users to use the applications 
                              certain paths (username: user, password: password)
    Spring Boot Thymeleaf  --> used as a template engine to display in GUI
    Apache Camel Swagger,Servlet,Boot Starter --> To configure a RestDSL API from Apache Camel
    jQuery, Datatables, bootstrap
    
Core Classes:

    AtmLocationRetriverController --> exposes a Rest End point /getAtmLocations to get the list of Atm's and its Location
                                      Details provided by the AtmLocatorService
                                      e.g http://localhost:8090/getAtmLocations
                                      
    CityAtmsLocationRetriverContoller --> exposes a Rest Api via Apache camel to get the list of atms based on the city 
                                          provided by the user
                                          Apache camel servlet context path: /camel-rest
                                          Rest end point is /camel-rest/findAtms/{city}
                                          e.g http://localhost:8090/camel-rest/findAtms/amstelveen
    ViewController    ---> Controller to handle  and render views                                    
    AtmLocatorService--> Service implements the Rest template consumption of the Third party Rest service                                                                         
                         Which provides the list of ATM 
                         
                           
Web Flow:
    
    http://localhost:8090/ - home page
    http://localhost:8090/locateAllAtms - find all atm locations in netherlands
    http://localhost:8090/locateCityAtms - find atms based on the search city provided by user
    
P.S:
 I had used apache camel for exposing a Rest service  i learned newly for implementing this 
 code challenge but i was not able to write the junit test only for the rest service exposed by apache camel
 
 
To Run:

mvn spring-boot:run

or

Build using Maven

Import in maven

Run the FindAtmLocationApplication

IDE used:

IntelliJ IDEA 2017.2 x64 
 
 
      
                              
                              
  

