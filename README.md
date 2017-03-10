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
	 ```
	 MatchAllFilter maf = new MatchAllFilter();  
         maf.addFilter(new MagnitudeFilter(3.0, 6.0));  
         maf.addFilter(new TitlePhraseFilter("start", "California"));  
         maf.satisfies();  
	 ```   
This filters the earth quake data that have the magnitude between 3.0 and 6.0 and that have occurred in california.

Module InterfaceAbstractStarter Program
-----------------------------------------
This module is different from the above mentioned project. Here, we are building simple prediction based on the Markov prediction.

This module contains the interface IMarkovModel which has setTraining, setRandom, getRandomText as the abstract methods.
This module also introduces abstract class called AbstractMarkovModel  which implements ImarkovModel interface.
There is generic MokovN which can run n-gram for any n.
MarkovN extends from AbstractMarkovModel.

Module WordGramClassStarter Program
-----------------------------------------

This is the final piece of the Markov Prediction, WordGram class, a class that will make it easier to extend Markov word prediction. Here, you will add more functionality to the WordGram class. 
In simple terms, the text prediction is based on the training text. We collect th existing words and get the probabilities for the next possible word. Select the most occuring one as the next one.
