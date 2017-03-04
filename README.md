Welcome toEarthQuakeDataAnalysis!
===================


Module QuakeSortDemo 
---------------------------------------

- QuakeEntry class has the info related to single Earth quake such as magnitude, depth, title etc
- QuakeSortDemo class provides example of how earth quake data can be utilized.


Module EarthquakeFilterStarterProgram
-----------------------------------------

This module contains a Filter Interface.

- Classes MagnitudeFilter, DepthFilter, and TitlePhraseFilter implement this filter.
- The data can be filtered using filters such as the Magnitude filter, DepthFilter, TitlePhraseFilter.
##### Eg: Magnitude Filter 
__________________________
Filters all the earth quake data between minMagnitude and maxMagnitude

- MatchAllFilter implements Filter Interface. This is similar to the map function on the list.
#####This filter contains list of filters and all the filters are applied on the data.
	 ```MatchAllFilter maf = new MatchAllFilter();  
         maf.addFilter(new MagnitudeFilter(3.0, 6.0));  
         maf.addFilter(new TitlePhraseFilter("start", "California"));  
         maf.satisfies();  
	 ```  
         This filters the earth quake data that have the magnitude between 3.0 and 6.0 and that have occurred in california.

