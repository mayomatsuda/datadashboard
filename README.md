# datadashboard

### Description:

Java software for retrieval and processing of information from World Bank Database.
User can select analysis type, country, range of years, and different graphs to display data.

### Database Auxillary Files:

##### analysis_database.txt

  file which associates the proper name of every country with the available analysis types for that country.
  format:

    "Proper country name";analysis1,analysis2, ... 

  Where "Proper country name" is retrieved directly from the country_list.csv and the analysis
  types are denoted by their "type", ie. analysisj where j is the number for the analysis type.
  Available analyses may not exist for some countries and are thus denoted as:

    "Proper, unsupported country name";N/A

##### analysis_key.txt

  file which associates the proper name of an analysis to its "type", ex: analysis5 = education expenditure %.
  as well as a year period for which that analysis type is supported. format:

    analysisj,"Proper analysis name",startYear;endYear

  Where j is some number associated with the analysis, and the start and end years form a supported
  year range for that analysis.

##### ISO3_key.txt

  File which maps the proper name of all countries to their respective ISO3 code. format:

    "Proper country name",ISO3

  Where the ISO3 value corresponds to the proper name of the country preceding it.

##### login_database.txt

  File which associates recognized combinations of user credentials. format:

    username,password

  where "username" is recognized by the system and "password" is associated with the username
  preceding it.

##### views_database.txt

  File which associates each analysis type to the supported views for that analysis. format:

    analysisj;view1,view2, ...

  Where j is some number associated with the analysis, and the list of view following the ';'
  are the supported viuew types for that analysis type.
