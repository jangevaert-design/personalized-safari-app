# Twendé

## Design description

Twendé - which means 'Let's go' in Tanzania's language Kiswahili - is a personalized safari app
for the guests of [Ajabu Adventures](https://ajabu-adventures.com/) and will guide them through 
every step of their pre- and actual travel.
Guests will be prompted to download the app one week prior to their departure and will fill out 
their names, contacts and departure date and time.
During the safari all general information will be available on the home screen and with one click
either the national parks, the list of lodges, the POI's (Points of Interest), or the general
information can be reached.
At this stage the app will use the most popular six days safari as the only itinerary with a fixed 
list of accommodations. 

## Intended users & user stories

   * **A travel journalist**
        >  As a travel journalist who writes for high end travel magazines I need up-to-date and
           correct information about the country, the national parks and the accommodations so that
           I can share meaningful travel updates to our readers.  
        
   * **First time Africa-travelers.**
        > As a first time Africa traveler I need to understand how our itineraries and 
          accommodations will look and what we need to bring so that we can get the maximum 
          out of our holiday.

        
## Wireframe Diagram      
        
   [Wireframe diagram](wireframe.md)
     
## Entity-Relationship Diagram (ERD)

   [Entity-relationship diagram](erd.md)
     
## Cloud - or device-based services or data

   * **Persistent device data**
        * name and contact information (to be entered by the client)
        * packing list, general information on the travel (documents, health, do’s-and-dont’s)
        * departure data to and from Tanzania (to be entered by the client)
        * itinerary
        * list of national parks
        * list of lodges
        * information on parks and wildlife (if needed through links) 
        
   * **Device features**
        * [Geo location](https://developer.android.com/training/location)
            > Twendé will use the device geolocation in relation to the POI's or the accommodation. 
            > When no network available, this part of the app will not be accessible but this will
            > not affect the rest of the app.
        * [Clock](https://developer.android.com/reference/android/os/SystemClock)
            > The clock and calendar will be linked to the daily trips in a way that the relevant
            > day shows up on the home screen. Since the clock and calendar run independtly of the
            > available network, these data will be accessible at all times. 
       
   * **Cloud based services**
        * [Google maps](https://developers.google.com/maps/documentation/android-sdk/intro)
            > Google Maps will be used as a means to restore the safari through Google Maps' 
            > history. When out of range of network, the app will work fine but this cloud based
            > feature will not be available.
                                                                                                 
### [Entity classes](https://github.com/jangevaert-design/personalized-safari-app/tree/master/app/src/main/java/edu/cnm/deepdive/personalizedsafariapp/model/entity)
        
### [DAO interfaces](https://github.com/jangevaert-design/personalized-safari-app/tree/master/app/src/main/java/edu/cnm/deepdive/personalizedsafariapp/model/dao)
   
### [Database & Repository classes](https://github.com/jangevaert-design/personalized-safari-app/tree/master/app/src/main/java/edu/cnm/deepdive/personalizedsafariapp/model/service)                                                                                              
                                                                                                 
    
    