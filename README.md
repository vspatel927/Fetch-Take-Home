Fetch Android Engineer Apprentice Take Home Project:
- Takes list of items from remote JSON file and displays them in a scrolling list (sorted by listId, then name)
- Retrofit used for network call to retrive data from remote URL (in *FetchAPI* and *FetchAPIService*)
- *Item* model contains structure for each item object
- *FetchViewModel* structures data into List<Item> and filters + sorts based on requirements
- *MainActivity* passes filtered + sorted data into LazyColumn to display 
