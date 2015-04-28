# giphy-scala

A scala library to interact with the [Giphy API](https://github.com/Giphy/GiphyAPI).

This library started out trying to get familiar with Scala and learn its basics.

## Dependencies

- [scalaj-http](https://github.com/scalaj/scalaj-http)
  A simple HTTP library for Scala
- [json4s](https://github.com/json4s/json4s)
  A super fast JSON parsing library
  
Update dependencies using `sbt update`

## Usage

```scala
val giphy = new Giphy("<GIPHY API KEY>")
giphy.getGifById("GIF ID")
```

## API

For parameters that can be passed to each method, refer to the [Giphy API Docs](https://github.com/Giphy/GiphyAPI)
All responses are of type `Map[String, Any]`. This is after parsing the JSON string return by the Giphy API

### GIF API

- `search`
  Search all Giphy GIFs for a word or phrase.
  
  Pass in the query parameters as a `Map[String, String]`
  
  ```scala
  val params = Map("q" -> "YOUR QUERY")
  giphy.search(params)
  ```
- `getGifById`
  Returns meta data about a GIF, by GIF id.
  
  Method takes the GIF ID as parameter.
  
  ```scala
  giphy.getGifById("GIF ID")
  ```
- `getGifsById`
  A multiget version of the get GIF by ID endpoint.
  
  Pass in multiple GIF ID's using a `List[String]`
  
  ```scala
  giphy.getGifsById(List("GIF ID 1", "GIF ID 2"))
  ```
- `translate`
  This is prototype endpoint for using Giphy as a translation engine for a GIF dialect. 
  The translate API draws on search, but uses the Giphy "special sauce" to handle translating from one vocabulary to another. 
  In this case, words and phrases to GIFs.
  
  Pass in parameters as a `Map[String, String]`
  
  ```scala
  val params = Map("s" -> "PHRASE")
  giphy.translate(params)
  ```
- `random`
  Returns a random GIF, limited by tag. 
  Excluding the tag parameter will return a random GIF from the Giphy catalog.
  
  Parameter is an `Option[Map[String, String]]`
  You may choose to not pass in parameters, in which case you can pass a `None`
  
  ```scala
  val params = Some(Map("tag" -> "SOME TAG"))
  giphy.translate(params)
  ```
- `trending`
  Fetch GIFs currently trending online.
  
  Parameter is an `Option[Map[String, String]]`
  You may choose to not pass in parameters, in which case you can pass a `None`
  
   ```scala
   val params = Some(Map("limit" -> "2"))
   giphy.trending(params)
   ```
### Stickers API

- `searchStickers`
  Replicates the functionality and requirements of the classic Giphy search, 
  but returns animated stickers rather than gifs.
  
  Pass in the query parameters as a `Map[String, String]`
  
  ```scala
  val params = Map("q" -> "YOUR QUERY")
  giphy.stickerSearch(params)
  ```
- `randomSticker`
  Returns a spotaneously selected sticker from Giphy's sticker collection.
  
  Pass in query parameters as a `Option[Map[String, String]]`
  
  ```scala
  giphy.randomSticker(None)
  ```
- `trendingStickers`
  Get the latest stickers trending on Giphy.
  
  Pass in the query parameters as a `Map[String, String]`
  
  ```scala
  giphy.trendingStickers(Map("s" -> "TERM"))
  ```
- `translateStickers`
  Using the same alogirithm as the GIF translate endpoint, 
  the sticker translate endpoint turns words into stickers.
  
  Pass in parameters as a `Map[String, String]`
  
  ```scala
  val params = Map("s" -> "PHRASE")
  giphy.translateStickers(params)
  ```

## Notes

- If the request is not successful, an `Error` will be thrown along with an explanation.

## TODO

- Write tests
- Check for required parameters
- Use `Either` for failures
- Potentially, include Async versions using `Futures`

  
