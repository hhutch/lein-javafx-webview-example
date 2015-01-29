# lein-javafx-webview-example

Examples using Java + Webview built with Leiningen

Note: this build requires JDK 1.8 which has the required JavaFX and Webview support

## Compilation
	lein javac
## Usage

### Run the default example
	lein run

### Run a specific example
	lein run -m lein_javafx_webview_example.WebViewCSSBackground

## Package
	lein uberjar

### run default from JAR
	java -jar target/lein-javafx-webview-example-0.1.0-SNAPSHOT-standalone.jar

### run specific class as main from JAR
	java -cp target/lein-javafx-webview-example-0.1.0-SNAPSHOT-standalone.jar lein_javafx_webview_example.WebViewVersion

```
Java Version:   1.8.0-b132
JavaFX Version: 8.0.0-b132
OS:             Mac OS X, x86_64
User Agent:     Mozilla/5.0 (Macintosh; Intel Mac OS X) AppleWebKit/537.44 (KHTML, like Gecko) JavaFX/8.0 Safari/537.44
Java has been detached already, but someone is still trying to use it at -[GlassRunnable run]:/HUDSON/workspace/8.0/label/macosx-universal-30/rt/modules/graphics/src/main/native-glass/mac/GlassApplication.m:92
Java has been detached already, but someone is still trying to use it at -[GlassRunnable dealloc]:/HUDSON/workspace/8.0/label/macosx-universal-30/rt/modules/graphics/src/main/native-glass/mac/GlassApplication.m:106
```

## License

Copyright © 2015 Hunter Hutchinson

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
