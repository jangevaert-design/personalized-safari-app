# Twendé

## Design description

>Twendé - which means 'Let's go' in Tanzania's language Kiswahili - is a personalized safari app
for the guests of [Ajabu Adventures](https://ajabu-adventures.com/) and will guide them through 
every step of their pre- and actual travel.

>During the safari all general information will be available on the navigation screen and with one 
click either the itinerary for the day, the information on the national parks or the fauna & flora, 
the list of accommodations, the POI's (Points of Interest), or the general information can be 
reached.

>The itineraries, accommodations and POI's will be linked to the respective date of the journey so
that the appropriate information comes up on every particular day. Future and previous information 
on any given screen will be available with a scrollbar above and under the chosen information of
that date.

>At this stage the app will use the most popular six days safari as the only itinerary with a fixed 
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

        
## [Wireframe Diagram](wireframe.md)   
     
## [Entity-Relationship Diagram (ERD)](erd.md)
                                                                                                 
### [Entity classes](https://github.com/jangevaert-design/personalized-safari-app/tree/master/app/src/main/java/edu/cnm/deepdive/personalizedsafariapp/model/entity)
        
### [DAO interfaces](https://github.com/jangevaert-design/personalized-safari-app/tree/master/app/src/main/java/edu/cnm/deepdive/personalizedsafariapp/model/dao)
   
### [Database & Repository classes](https://github.com/jangevaert-design/personalized-safari-app/tree/master/app/src/main/java/edu/cnm/deepdive/personalizedsafariapp/model/service) 

### [DDL](https://github.com/jangevaert-design/personalized-safari-app/tree/master/docs/sql)                                                                                             
                                                                                                 
## Technical requirements, dependencies and permissions

   * **Tested hardware, minimum Android API required, restrictions**
        >Tested hardware: Pixel 2 emulator and own physical device Samsung Galaxy J7 Star
         (SM-J737T, 2019).
        >Minimum Android API required: Android 9 (API level 28) as per [Target API level 
         requirements](https://support.google.com/googleplay/android-developer/answer/113469#targetsdk)  
        >Language: This app has not been designed to support multiple locales and will fall back on
         the default en_US (US English) as per [Android Developers' language and locale resolution
         overview](https://developer.android.com/guide/topics/resources/multilingual-support)  
        >Orientation: the app has been only designed for portrait mode due to time restrictions.
                              
   * **List of 3<sup>rd</sup>-party libraries**
        >Androidx, ReactiveX, Room, SQLite, Stetho, junit and Gson as per "Module library is set via 
         Project Structure\Project Settings\Modules\Dependencies".
      
   * **List of Android permissions**
        >No normal permissions listed in the manifest, no dangerous - or user sensitive permissions
         required as per [Android Developers' permission information](https://developer.android.com/guide/topics/permissions/overview). 

## [Copyrights & licenses](https://github.com/jangevaert-design/personalized-safari-app/blob/master/docs/notice.md)
                                                                                         