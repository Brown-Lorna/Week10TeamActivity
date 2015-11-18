TEAM READINESS ACTIVITY

OBJECTIVE

Consume a simple API using REST and no authentication in Java.

INSTRUCTIONS

For today's team activity, we will create a simple web application to
search for movies, [using the API provided by Open Movie Database
API](http://www.omdbapi.com/). You should have a JSP with a search box,
and, upon submission, have a servlet that processes the search, calls
the API, and displays a list of movies that match. As a stretch
challenge, make each move a link, that if submitted, will query the API
and return more detailed information about the movie.

TEACH ONE ANOTHER

The following Java libraries may come in handy in this exercise:

[Jackson Library for Parsing
JSON](http://wiki.fasterxml.com/JacksonHome)

You can include this as a dependency in your project by adding the
following to your Maven pom.xml file:

&lt;dependency&gt; \
  &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt; \
  &lt;artifactId&gt;jackson-databind&lt;/artifactId&gt; \
  &lt;version&gt;2.5.1&lt;/version&gt; \
&lt;/dependency&gt;

Or, if you are not using Maven, download 3 JARS from: 

<http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.3.2/jackson-core-2.3.2.jar>

<http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.3.2/jackson-databind-2.3.2.jar>

<http://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.3.2/jackson-annotations-2.3.2.jar>

The following examples demonstrate the basics of how the Jackson library
can be used.

import com.fasterxml.jackson.databind.ObjectMapper;

...

URL url = new URL("http://www.omdbapi.com/?t=True%20Grit&y=1969");

ObjectMapper mapper = new ObjectMapper(); \
Map&lt;String, Object&gt; map = mapper.readValue(url, Map.class);

for (String key : map.keySet()) {          \
      System.out.println(key + ": " + map.get(key)); \
}

If your JSON result contains an array, you can then access the list,
which may potentially have a bunch of Maps in it. For example:

URL url = new URL("http://www.omdbapi.com/?s=Park");

ObjectMapper mapper = new ObjectMapper();

Map&lt;String, Object&gt; map = mapper.readValue(url, Map.class);

List list = (List)map.get("Search");

for (Object item : list) { \
      Map&lt;String, Object&gt; innerMap = (Map&lt;String,
Object&gt;)item; \
      for (String key : innerMap.keySet()) { \
            System.out.println(key + ": " + innerMap.get(key)); \
      } \
}

Be aware, there are some potential uncaught exceptions of casting to the
wrong types in this code. It illustrates the basics, but you'll want to
be very careful in your parsing.
