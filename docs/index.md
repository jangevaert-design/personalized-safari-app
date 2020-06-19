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

   * **Travelers who need additional and easy accessible information.**
        >  As a travel journalist, this app allows me to focus more on my wildlife photography 
        > instead of taking notes because it gives me all the information on the lodges where I
        > will stay at, and the National Parks to visit.
        
   * **First time Africa-travelers.**
        >  This app is great for us, who are going for the first time on safari because it offers us 
        > a packing list plus additional information on the country and makes us feel comfortable 
        > knowing exactly what the activities and the placea we’ll stay at will be at any given day.
        > Furthermore we will be having all our contact information (at home as well for
        > the tour company) stored in the app and ready with one click.
        
## Wireframe Diagram      
        
   [Wireframe diagram](wireframe.md)
     
## Entity-Relationship Diagram (ERD)

   [Entity-relationship diagram](erd.md)
     
## Cloud - or device-based services or data

   * **Persistent device data**
        * name and contact information (to be entered by the client)
        * packing list, general information on the travel (documents, health, do’s-and-dont’s)
        * departure data to and from Tanzania (to be entered by the client)
        * itenerary
        * list of national parks
        * list of lodges
        * information on parks and wildlife (if needed through links) 
        
   * **Device features**
        * [Geo location](https://developer.android.com/training/location)
            > Twendé will use the device geolocation in relation to the POI's or the accomodation. 
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
    
    